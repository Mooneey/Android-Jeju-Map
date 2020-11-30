/* **********************************************
 * 프로그램명 : MemberInfo_Business.java
 * 작성자 : 2018038041 김서빈
 * 작성일 : 2020.06.09
 * 프로그램 설명 : 살어리랏다 in Jeju의 회원가입 시 이메일과 비밀번호 입력해서 firbase에 저장
 ************************************************/

package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signUpButton).setOnClickListener(onClickListener);
    }



    View.OnClickListener onClickListener = new View.OnClickListener() {
             public void onClick(View v) {
                 switch (v.getId()){
                 case R.id.signUpButton:
                     singUP();

                     break;
             }
         }
    };

    private void singUP() {
        String email = ((EditText)findViewById(R.id.emaileditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.pweditText)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.pwCheckeditText)).getText().toString();


        if(email.length() > 0  && password.length() > 0 && passwordCheck.length() > 0) {
            if(password.equals(passwordCheck)) {    // 비밀번호 체크 이후 일치하면 회원가입 진행
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    FirebaseAuth.getInstance().signOut();
                                    startToast("회원가입에 성공했습니다.");
                                    myStartActivity(MemberInitActivity.class);
                                }
                                else {
                                    if(task.getException() != null) {
                                        startToast(task.getException().toString());
                                    }
                                }
                            }
                        });
            }

            else { // 일치하지 않으면 토스트 전달
                startToast("비밀번호가 일치하지 않습니다.");
                myStartActivity(SignUpActivity.class);
            }
        }

        else {
            startToast("이메일 또는 비밀번호를 입력해 주세요.");
        }
    }

    private void startToast(String msg) {   // 토스트 문장 출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent (this, c);
        startActivity(intent);
    }
}


