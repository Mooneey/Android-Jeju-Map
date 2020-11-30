//-------------------hamburger by 송희---------------------------------------
package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.afinal.ApplyBoard.Features.ShowPostList.ApplyPostListActivity;
import com.example.afinal.RecuritBoard.RecruitActivity;
import com.example.afinal.SocialBoard.Features.ShowPostList.SocialPostListActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class hamburger extends AppCompatActivity {
    private FirebaseAuth mAuth ;
    private void signOut() {
        FirebaseAuth.getInstance().signOut();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger);

        //마이페이지--------------------------------------------------------------------------------------------------
        ImageButton mypage=(ImageButton)findViewById(R.id.mypage);//마이페이지로 이동


        mypage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"마이페이지 입니다.",Toast.LENGTH_LONG).show();;
                //페이지 넘길때 안내말말
                Intent myintent=new Intent(hamburger.this,MypageActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent);


            }
        });
        //--------------------------------스태프구인----------------------------------------------------
        ImageButton staff=(ImageButton)findViewById(R.id.staff);


        staff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"스태프 구인 게시판입니다.",Toast.LENGTH_LONG).show();;
                //페이지 넘길때 안내말말
                Intent myintent1=new Intent(hamburger.this, RecruitActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent1);


            }
        });
        //--------------------------------스태프지원----------------------------------------------------
        ImageButton staffwant=(ImageButton)findViewById(R.id.staffwant);


        staffwant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"스태프 지원 게시판입니다.",Toast.LENGTH_LONG).show();;
                //페이지 넘길때 안내말말
                Intent myintent2=new Intent(hamburger.this, ApplyPostListActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent2);


            }
        });

        //--------------------------------스태프친목----------------------------------------------------
        ImageButton staffplay=(ImageButton)findViewById(R.id.staffplay);


        staffplay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"스태프 친목 게시판입니다.",Toast.LENGTH_LONG).show();;
                //페이지 넘길때 안내말말
                Intent myintent3=new Intent(hamburger.this, SocialPostListActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent3);


            }
        });
        //--------------------------------제주둘러보기----------------------------------------------------
        ImageButton lookaround=(ImageButton)findViewById(R.id.lookaround);


        lookaround.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"제주둘러보기 메뉴입니다.",Toast.LENGTH_LONG).show();;
                //페이지 넘길때 안내말말
                Intent myintent4=new Intent(hamburger.this,menuActivity2.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent4);


            }
        });
        //--------------------------------로그아웃---------------------------------------------------
        ImageButton logoutbutton=(ImageButton)findViewById(R.id.logoutBtn);


        logoutbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                signOut();
                Toast.makeText(getApplicationContext(),"로그아웃되었습니다.",Toast.LENGTH_LONG).show();;
                //페이지 넘길때 안내말말
                Intent myintent5=new Intent(hamburger.this,LoginActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent5);
            }
        });
    }

    private void startToast(String msg) {   // 토스트 문장 출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

}