/*
작성자: 2015023025 배나영
역할: 차송희 팀원이 디자인한 로딩 페이지 구현-Loading.java, manifest 파일 수정, res-values-styles 수정
     (주석 시 실행에 문제 있어 Activity에 주석 작성)
 */
package com.example.afinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Loading extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
