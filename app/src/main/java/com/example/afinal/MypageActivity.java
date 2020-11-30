/*
작성자: 2015023025 배나영
역할: 마이페이지 UI, 회원탈퇴, 대화박스
 */

package com.example.afinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MypageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        FirebaseAuth mAuth;
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser=mAuth.getCurrentUser();

        if(currentUser==null){
            Toast.makeText(MypageActivity.this, "로그인이 되어있지 않습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void changeMemInfo(View v){
        startToast("회원정보를 수정합니다.");
        Intent intent = new Intent(getApplicationContext(), membermodify.class);
        // 회원정보 화면으로 이동
        startActivity(intent);

    }

    public void memOut(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MypageActivity.this);
        builder.setTitle("탈퇴하시겠습니까?");
        builder.setMessage("회원 정보가 삭제되며 해당 계정으로 로그인이 불가능합니다.");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                user.delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(MypageActivity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });


            }
        });
        builder.setNeutralButton("취소", null);
        builder.create().show();
    }
    private void startToast(String msg) {   // 토스트 문장 출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}


