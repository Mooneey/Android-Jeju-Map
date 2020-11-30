//---------------------산책로 페이지
package com.example.afinal;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("산책로");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //구글맵
        FragmentManager fragmentManager = getFragmentManager();
        //구글맵
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //구글맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(33.389713, 126.235304))//위도 경도(고살리숲길)위치설정
                .title("금능으뜸원해변")
                .snippet("제주도 산책로 : 해변")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성
       // mMap.addPolyline(new PolylineOptions().add(new LatLng(33.389183, 126.234025), new LatLng(33.390723, 126.237072)).width(5).color(Color.BLUE));

        markerOptions.position(new LatLng(33.262630, 126.624799))//위도 경도(효돈천)위치설정
                .title("효돈천 캐녀닝")
                .snippet("제주도 산책로 : 자연보호구역")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.244003, 126.618580))//위도 경도
                .title("게우지코지")
                .snippet("제주도 산책로 : 카페")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성


        markerOptions.position(new LatLng(33.316496, 126.597400))//
                .title("고살리숲길")
                .snippet("제주도 산책로 : 자연보호구역")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.251696, 126.623353))//
                .title("하효쇠소깍해변")
                .snippet("제주도 산책로 : 해변(관광명소)")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.428466, 126.624130))//
                .title("제주 삼나무숲길")
                .snippet("제주도 산책로 : 숲길(관광명소)")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.417235, 126.265355))//
                .title("천주교 한림성당")
                .snippet("제주도 산책로 : 천주교 성당")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.377770, 126.214860))//
                .title("월령 선인장 군락지")
                .snippet("제주도 산책로 : 선인장 군락지")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.517150, 126.717601))//
                .title("동백동산(선흘곶자왈)")
                .snippet("제주도 산책로 : 자연보호구역")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.477530, 126.823207))//
                .title("아끈다랑쉬오름")
                .snippet("제주도 산책로 : 산봉우리")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.448680, 126.777002))//
                .title("아부오름")
                .snippet("제주도 산책로 : 산봉우리")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.377770, 126.214860))//
                .title("월령 선인장 군락지")
                .snippet("제주도 산책로 : 선인장 군락지")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.466887, 126.777693))//
                .title("당오름")
                .snippet("제주도 산책로 : 관광명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.466232, 126.775147))//
                .title("송당 본향당")
                .snippet("제주도 산책로 : 박물관")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.250097, 126.278306))//
                .title("추사관")
                .snippet("제주도 산책로 : 역사적 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성
//////////////////////////////////////////////////////////////////////

        markerOptions.position(new LatLng(33.226722, 126.257385))//
                .title("강병대교회")
                .snippet("제주도 산책로 : 장로교회")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.204578, 126.271710))//
                .title("알뜨르 비행장")
                .snippet("제주도 산책로 : 역사적 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.286611, 126.270605))//
                .title("제주 곶자왈 도립공원")
                .snippet("제주도 산책로 : 관광 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.274276, 126.278764))//
                .title("구억리 옹기 체험관")
                .snippet("제주도 산책로 : 박물관")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        ////////////////////////////////////////////////////////////////////////

        markerOptions.position(new LatLng(33.533557, 126.614378))//
                .title("남생이못")
                .snippet("제주도 산책로 : 자연보호구역")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.250415, 126.278393))//
                .title("닭머르 해안")
                .snippet("제주도 산책로 : 관광 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.540047, 126.636159))//
                .title("연북정")
                .snippet("제주도 산책로 : 역사적 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.546029, 126.688700))//
                .title("너븐숭이기념관")
                .snippet("제주도 산책로 : 역사 박물관관")
               .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.539094, 126.689295))//
                .title("돌하르방 공원")
                .snippet("제주도 산책로 : 공원")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

///////////////////////////////////////////////////////

        markerOptions.position(new LatLng(33.294908, 126.162598))//
                .title("수월봉 해안도로")
                .snippet("제주도 산책로 : 해안도로")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.343596, 126.173909))//
                .title("싱계물해변")
                .snippet("제주도 산책로 : 해변")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.399412, 126.262994))//
                .title("명월성지")
                .snippet("제주도 산책로 : 요새")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.389830, 126.235365))//
                .title("금능으뜸해변과 모래숲길")
                .snippet("제주도 산책로 : 해변")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.343987, 126.175957))//
                .title("싱계물 풍차해안")
                .snippet("제주도 산책로 : 관광 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

///////////////////////////////////////////////////////////////////////////////////

        markerOptions.position(new LatLng(33.442435, 126.289502))//
                .title("궤물동산")
                .snippet("제주도 산책로 : 공원")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.446604, 126.291406))//
                .title("거북등대")
                .snippet("제주도 산책로 : 낚시터")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성


        markerOptions.position(new LatLng(33.445593, 126.294673))//
                .title("복덕개 포구")
                .snippet("제주도 산책로 : 관광 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.388781, 126.266347))//
                .title("명월대 팽나무군락지")
                .snippet("제주도 산책로 : 역사적 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.399423, 126.262982))//
                .title("명월성")
                .snippet("제주도 산책로 : 요새새")
               .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        /////////////////////////////////////////////////////////////////////

        markerOptions.position(new LatLng(33.376763, 126.876904))//
                .title("신산리 녹차밭")
                .snippet("제주도 산책로 : 역사적 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.404868, 126.797714))//
                .title("영주산")
                .snippet("제주도 산책로 : 산봉우리")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.372003, 126.854304))//
                .title("김영갑갤러리 두모악")
                .snippet("제주도 산책로 : 아트 센터")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.460030, 126.831498))//
                .title("용눈이오름")
                .snippet("제주도 산책로 : 산봉우리")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.333645, 126.844124))//
                .title("하천리 소금막 해변")
                .snippet("제주도 산책로 : 관광 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        markerOptions.position(new LatLng(33.245216, 126.577042))//
                .title("소라의성")
                .snippet("제주도 산책로 : 관광 명소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.human));//마커이미지변경
        mMap.addMarker(markerOptions);//마커 생성

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(33.395990, 126.528903), 9));
        //카메라가 보이는 위치
    }

    @Override
    public void onClick(View view) {

    }
}