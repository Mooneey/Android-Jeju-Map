//--------자전거 대여소 페이지 by 송희
package com.example.afinal;

import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import androidx.appcompat.app.AppCompatActivity;

//-------------------구글맵

public class SecondActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("자전거 대여소");
        setContentView(R.layout.activity_second);
        //구글맵
        FragmentManager fragmentManager = getFragmentManager();
        //구글맵
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }



    @Override//구글맵이 준비가 되면 호출
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        //구글맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(33.506109, 126.510333))//위도 경도(제주도 보물섬)위치설정
                .title("제주도 보물섬")
                .snippet("자전거 대여소. 주소 : ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));//마커 이미지 변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.516262, 126.505955))//
                .title("여행길잡이 바이크 트립")
                .snippet("자전거 대여소. 주소: ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bike));

        mMap.addMarker(markerOptions);//마커 생성
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.510497, 126.505210), 14));
        //카메라가 보이는 위치
    }
}