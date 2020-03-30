package com.example.mysnitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginAndRegisterActivity extends AppCompatActivity
{

    EditText username;
    EditText password;

    Button login;
    Button register;

    TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        errorMessage = findViewById(R.id.errorMessage);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String usernameInput = username.getText().toString();
                String passwordInput = password.getText().toString();

                if( User.userExists(usernameInput) )
                {
                    if( User.getUser(usernameInput).getPassword().equals(passwordInput) )
                    {
                        User.setLoggedInUser(User.getUser(usernameInput));
                        startActivity(new Intent(loginAndRegisterActivity.this, MenuActivity.class));
                    }
                    else
                    {
                        errorMessage.setText("password incorrect");
                    }
                }
                else
                {
                    errorMessage.setText("username does not exist");
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String usernameInput = username.getText().toString();
                String passwordInput = password.getText().toString();

                if( !User.userExists( usernameInput ) )
                {
                    if( passwordInput.length() >= 6 )
                    {
                        User.addUser( new User( usernameInput, passwordInput, "" ) );
                        errorMessage.setText( "successfully registered. You can now login" );
                    }
                    else
                    {
                        errorMessage.setText( "password must be at least 6 characters" );
                    }
                }
                else
                {
                    errorMessage.setText( "username already exists" );
                }
            }
        });
    }
}
