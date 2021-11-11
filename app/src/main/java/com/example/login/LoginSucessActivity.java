package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginSucessActivity extends AppCompatActivity {
    Button btnRevoke, btnLogout;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_sucess);

        btnLogout = (Button)findViewById(R.id.btn_logout);
        btnRevoke = (Button)findViewById(R.id.btn_revoke);



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                //Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                //setResult(RESULT_OK,outIntent);
                finish();
                //finishAffinity();
            }
        });

        btnRevoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revokeAccess();
                //finish();
                finishAffinity();
            }
        });
    }

    private void signOut(){
        mAuth.signOut();
        Toast.makeText(getApplicationContext(), "로그아웃 완료되었습니다.", Toast.LENGTH_SHORT).show();

    }
    private void revokeAccess(){
        mAuth.getCurrentUser().delete();
    }

}
