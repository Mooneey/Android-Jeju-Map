/* **********************************************
 * 프로그램명 : MemberInfo_Business.java
 * 작성자 : 2018038041 김서빈
 * 작성일 : 2020.06.04
 * 프로그램 설명 : 살어리랏다 in Jeju의 비밀번호 재설정 관련 코드 (firebase 제공)
 ************************************************/
package com.example.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


// 비밀번호 재설정
public class PasswordResetActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.sendBtn).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sendBtn:
                    send();
                    break;
            }
        }
    };

    private void send() {
        String email = ((EditText) findViewById(R.id.emaileditText)).getText().toString();

        if (email.length() > 0) {
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                startToast("이메일을 보냈습니다.");
                            }
                        }
                    });
        } else {
            startToast("이메일을 입력해 주세요.");
        }
    }

    private void startToast(String msg) {   // 토스트 문장 출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}


