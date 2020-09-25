package com.example.splashtrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText userName, userEmail, userPassword;
    private Button userReg;
    private TextView userAlreadyReg;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();

        userReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String email = userEmail.getText().toString().trim();
                    String password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Register.this,"Successfully Registered!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this,Main2Activity.class));
                            }else{
                                Toast.makeText(Register.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                };
            }
        });

        userAlreadyReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                startActivity(new Intent(Register.this,Main2Activity.class));
            }
        });
    }

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUser);
        userEmail = (EditText)findViewById(R.id.etEmailAddress);
        userPassword = (EditText)findViewById(R.id.etPass);
        userReg = (Button)findViewById(R.id.btnRegister);
        userAlreadyReg = (TextView)findViewById(R.id.tvAlreadyRegistered);
    }

    private boolean validate() {
        boolean result = false;
        String user = userName.getText().toString();
        String email = userEmail.getText().toString();
        String pass = userPassword.getText().toString();

        if (user.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Kindly Enter all the details.", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }

}
