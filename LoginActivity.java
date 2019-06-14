package com.example.eva.bats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    EditText etUsername,etPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        etUsername =(EditText) findViewById(R.id.etUsername);
        etPassword =(EditText) findViewById(R.id.etPassword);
        btnLogin=(Button)findViewById(R.id.bnLogin);
        btnLogin.setOnClickListener(this);
        // PostResponseAsyncTask task =new PostResponseAsyncTask(this);

    }

    @Override
    public void processFinish(String result) {
        Toast.makeText(this, result,
                Toast.LENGTH_LONG).show();
        if(result.equals("driver"))
        {
            Intent intent = new Intent(LoginActivity.this,Driver.class);
            intent.putExtra("NAME", etUsername.getText().toString());
            startActivity(intent);
        }
        else if(result.equals("user"))
        {
            Intent intent = new Intent(LoginActivity.this,User.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, result,
                    Toast.LENGTH_LONG).show();

        }

    }


    @Override
    public void onClick(View v) {

        HashMap postData = new HashMap();
        //   postData.put("btnLogin", "Login");
        postData.put("mobile", "android");
        postData.put("txtUsername", etUsername.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString() );

        PostResponseAsyncTask task = new PostResponseAsyncTask(this,postData);
        task.execute("https://stockernet.000webhostapp.com/client/login.php");
    }
}
