package com.example.splashtrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {
    private EditText passwordemail;
    private Button passwordreset;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        passwordemail = (EditText)findViewById(R.id.etPasswordEmail);
        passwordreset = (Button) findViewById(R.id.btnPasswordReset);
        firebaseAuth = FirebaseAuth.getInstance();

        passwordreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = passwordemail.getText().toString().trim();

                if(useremail.equals("")){
                    Toast.makeText(PasswordActivity.this,"Enter registered email ID",Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(PasswordActivity.this,"Password Resent Email sent to Registered Email ID",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(PasswordActivity.this, Main2Activity.class));
                            }else {
                                Toast.makeText(PasswordActivity.this,"Kindly enter a Registered Email ID",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
}
