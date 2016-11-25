package com.example.lijiang.login;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ForgetPassWordActivity extends AppCompatActivity {
    private Button mBackButton;
    private Button mFindPassWordButton;
    private EditText mUserNameEditText;
    private SharedPreferences mSharedPreferences;
    private String userName;
    private String passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_word);
        mUserNameEditText = (EditText) findViewById(R.id.find_user_name);
        mBackButton = (Button) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgetPassWordActivity.this.finish();
            }
        });
        mFindPassWordButton = (Button) findViewById(R.id.find_password_button);
        mSharedPreferences = this.getSharedPreferences("register_preference", MODE_PRIVATE);
        mFindPassWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = mUserNameEditText.getText().toString();
                if (mSharedPreferences.contains(userName)) {
                    passWord = mSharedPreferences.getString(userName, "");
                    Toast.makeText(ForgetPassWordActivity.this, "你以前的密码是：" + passWord, Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(ForgetPassWordActivity.this,R.string.no_username,Toast.LENGTH_LONG).show();
            }
        });
    }
}
