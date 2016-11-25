package com.example.lijiang.login;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private Button mRegisterButton;
    private Button mForgetPasswordButton;
    private Button mLoginButton;
    private Button mBackButton;
    private EditText mLoginUserEditText;
    private EditText mLoginPassWordEditText;
    private String loginUserName;
    private String loginPassWord;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mRegisterButton = (Button) findViewById(R.id.register_button);
        mForgetPasswordButton = (Button) findViewById(R.id.forget_password_button);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mBackButton = (Button) findViewById(R.id.back_button);
        mLoginUserEditText = (EditText) findViewById(R.id.login_user_name_edit_text);
        mLoginPassWordEditText = (EditText) findViewById(R.id.login_password_edit_text);


        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        mForgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ForgetPassWordActivity.class);
                startActivity(intent);
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserName = mLoginUserEditText.getText().toString();
                loginPassWord = mLoginPassWordEditText.getText().toString();
                loadData(LoginActivity.this, loginUserName, loginPassWord);
            }
        });
    }

    private void loadData(Context context, String userName, String passWord) {
        sharedPreferences = context.getSharedPreferences("register_preference", context.MODE_PRIVATE);
        if (passWord.equals(sharedPreferences.getString(userName, "")) && passWord.length() >= 6) {
            Toast.makeText(LoginActivity.this, R.string.login_true, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(LoginActivity.this, R.string.login_false, Toast.LENGTH_SHORT).show();
    }
}
