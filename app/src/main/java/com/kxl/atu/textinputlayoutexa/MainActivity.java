package com.kxl.atu.textinputlayoutexa;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout til_phone,til_nick,til_pwd;
    private EditText et_phone,et_nick,et_pwd;
    private Button btn_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        til_phone = (TextInputLayout) findViewById(R.id.til_phone);
        til_phone.setHint("请输入手机号");
        til_nick = (TextInputLayout) findViewById(R.id.til_nick);
        til_nick.setHint("请输入用户名");
        til_pwd = (TextInputLayout) findViewById(R.id.til_password);
        til_pwd.setHint("请输入密码");

        et_phone = til_phone.getEditText();
        et_phone.addTextChangedListener(new CustomTextWatcher(til_phone));
        et_nick = til_nick.getEditText();
        et_nick.addTextChangedListener(new CustomTextWatcher(til_nick));
        et_pwd = til_pwd.getEditText();
        et_pwd.addTextChangedListener(new CustomTextWatcher(til_pwd));

        btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone =et_phone.getText().toString().trim();
                String nick = til_nick.getEditText().getText().toString().trim();
                String pwd = til_pwd.getEditText().getText().toString().trim();

                if (TextUtils.isEmpty(phone)){
                    til_phone.setErrorEnabled(true);
                    til_phone.setError("手机号码不能为空");
                }
                else if (TextUtils.isEmpty(nick)){
                    til_phone.setErrorEnabled(false);
                    til_nick.setErrorEnabled(true);
                    til_nick.setError("用户名不能为空");
                }
                else if (TextUtils.isEmpty(pwd)){
                    til_nick.setErrorEnabled(false);
                    til_pwd.setErrorEnabled(true);
                    til_pwd.setError("密码不能为空");
                }
                else{
                    til_pwd.setErrorEnabled(false);
                    Toast.makeText(getApplicationContext(),"恭喜！注册成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class CustomTextWatcher implements TextWatcher{

        private TextInputLayout textInputLayout;

        public CustomTextWatcher(TextInputLayout textInputLayout) {
            this.textInputLayout = textInputLayout;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
