// Copyright 2020. 문재식 All rights reserved //

package com.example.afinal.RecuritBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;

import com.example.afinal.R;
import com.example.afinal.hamburger;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


public class boardActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap mMap;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        FragmentManager fragmentManager = getFragmentManager();
        //구글맵
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(33.436542, 126.451561))//
                .title("프젝 게스트하우스")
                .snippet("주소 : 제주 프젝시 지데이로 3")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house));

        mMap.addMarker(markerOptions);//마커 생성
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.436542, 126.451561), 10));
        //카메라가 보이는 위치
    }
}