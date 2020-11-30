package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.afinal.ApplyBoard.Features.ShowPostList.ApplyPostListActivity;
import com.example.afinal.RecuritBoard.RecruitPostListActivity;
import com.example.afinal.RecuritBoard.boardtapsActivity;
import com.example.afinal.SocialBoard.Features.ShowPostList.SocialPostListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";

    @Override
    public void onBackPressed() { // 뒤로가기 버튼 클릭했을 때 홈으로 이동하기
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user == null) { // 만약 로그인이 안되어있으면 로그인화면으로
           myStartActivity(LoginActivity.class);
        }

        else {
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            final DocumentReference docRef = db.collection("users").document(user.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if(document != null) {
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d(TAG, "No such document");
                                Toast.makeText(getApplicationContext(),"회원정보가 미등록되어있습니다.",Toast.LENGTH_LONG).show();
                                myStartActivity(MemberInitActivity.class);
                            }
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });
        }
        findViewById(R.id.imageButton2).setOnClickListener(onClickListener);
        findViewById(R.id.recruitBotton).setOnClickListener(onClickListener);
        findViewById(R.id.applyButton).setOnClickListener(onClickListener);
        findViewById(R.id.socialBotton).setOnClickListener(onClickListener);
        findViewById(R.id.lookAroundButton).setOnClickListener(onClickListener);
    }



    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.recruitBotton:
                    myStartActivity(RecruitPostListActivity.class);
                    break;
                case R.id.applyButton:
                    myStartActivity(ApplyPostListActivity.class);
                    break;
                case R.id.socialBotton:
                    myStartActivity(SocialPostListActivity.class);
                    break;
                case R.id.lookAroundButton:
                    myStartActivity(menuActivity2.class);
                    break;
                case R.id.imageButton2:
                    myStartActivity(hamburger.class);
                    break;

            }
        }
    };

    private void startToast(String msg) {   // 토스트 문장 출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private void myStartActivity(Class c) {
        Intent intent = new Intent (this, c);
        startActivity(intent);
    }
}
