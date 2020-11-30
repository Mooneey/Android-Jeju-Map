// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.RecuritBoard;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.afinal.MenuActivity;
import com.example.afinal.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RecruitPostListActivity extends AppCompatActivity implements OnMapReadyCallback  {

    GoogleMap mMap;

    @Override
    public void onBackPressed() { // 뒤로가기 버튼 클릭했을 때 홈으로 이동하기
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardtaps_after);

        findViewById(R.id.projectgh).setOnClickListener(onClickListener);
        findViewById(R.id.fab).setOnClickListener(onClickListener);
        //구글맵
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        //탭호스트
        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("목록으로 보기") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("한눈에 보기") ;
        tabHost1.addTab(ts2) ;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.projectgh:
                    myStartActivity(boardActivity.class);
                    break;
                case R.id.fab:
                  //  myStartActivity(RecruitPostActivity.class);
                    Toast.makeText(RecruitPostListActivity.this, "개인 회원은 등록할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(33.436542, 126.451561))//
                .title("프젝 게스트하우스")
                .snippet("주소 : 제주 프젝시 지데이로 3")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house));
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.457455, 126.608617))//
                .title("과제 게스트하우스")
                .snippet("주소 : 제주 과제시 A+로 405")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house));

        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.410400, 126.412240))//
                .title("시험 게스트하우스")
                .snippet("주소 : 제주 시험시 백점으로 100")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house));
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.390400, 126.817240))//
                .title("기말 게스트하우스")
                .snippet("주소 : 제주 기말시 올백으로 8282")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house));

        mMap.addMarker(markerOptions);//마커 생성
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.436542, 126.451561), 10));
    }
}