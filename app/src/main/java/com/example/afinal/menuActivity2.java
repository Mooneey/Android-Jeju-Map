//-----------------제주둘러보기 선택- 메뉴페이지2by송희
package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class menuActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        ImageButton imagebutton2=(ImageButton)findViewById(R.id.imageButton2);//햄버거메뉴
        imagebutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent0=new Intent(menuActivity2.this,hamburger.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent0);
            }
        });

        Button mappage=(Button)findViewById(R.id.mappage);//자전거 대여소 맵으로 이동
        mappage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"자전거 대여소 페이지 입니다.",Toast.LENGTH_LONG).show();
                //페이지 넘길때 안내말말
                Intent myintent=new Intent(menuActivity2.this,SecondActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent);
            }
        });

        Button mappage2=(Button)findViewById(R.id.mappage2);//산책로 맵으로 이동
        mappage2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"산책로 페이지 입니다.",Toast.LENGTH_LONG).show();
                //페이지 넘길때 안내말말
                Intent myintent2=new Intent(menuActivity2.this,ThirdActivity.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent2);
            }
        });

    }


}