package com.example.lijiang.login;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private Button mBackButton;
    private Button mRegisterButton;
    private EditText mUserNameEditText;
    private EditText mPassWordEditText;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String registerUserName;
    private String registerPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mRegisterButton = (Button) findViewById(R.id.register_button);
        mBackButton = (Button) findViewById(R.id.back_button);
        mUserNameEditText = (EditText) findViewById(R.id.register_user_name_edit_text);
        mPassWordEditText = (EditText) findViewById(R.id.register_password_edit_text);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUserName = mUserNameEditText.getText().toString();
                registerPassWord = mPassWordEditText.getText().toString();
                    if (registerPassWord.length() >= 6) {
                        saveData(RegisterActivity.this, registerUserName, registerPassWord);
                        Toast.makeText(RegisterActivity.this, R.string.register_true, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        RegisterActivity.this.finish();
                    } else
                        Toast.makeText(RegisterActivity.this, R.string.register_false, Toast.LENGTH_SHORT).show();
                }
        });
    }

    private void saveData(Context context, String userName, String passWord) {
        sharedPreferences = context.getSharedPreferences("register_preference", MODE_PRIVATE);
        mEditor = sharedPreferences.edit();
        mEditor.putString(userName, passWord);
        mEditor.commit();
    }
}
