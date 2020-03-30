package com.example.mysnitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginAndRegisterActivity extends AppCompatActivity
{

    EditText username;
    EditText password;
    EditText email;

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
        email = findViewById(R.id.email);
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
                String emailInput = email.getText().toString();
            }
        });

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String usernameInput = username.getText().toString();
                String passwordInput = password.getText().toString();
                String emailInput = email.getText().toString();

                if( !User.userExists( usernameInput ) )
                {
                    if( passwordInput.length() >= 6 )
                    {
                        User.addUser( new User( usernameInput, passwordInput, emailInput ) );
                    }
                    else
                    {
                        errorMessage.setText( "password must be 6 characters at least! " );
                    }
                }
                else
                {
                    errorMessage.setText( "username already exists! " );
                }
            }
        });
    }
}
