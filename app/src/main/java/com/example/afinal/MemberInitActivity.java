/* **********************************************
 * 프로그램명 : MemberInfo_Business.java
 * 작성자 : 2018038041 김서빈
 * 작성일 : 2020.06.09
 * 프로그램 설명 : 살어리랏다 in Jeju의  회원정보 입력 받아 Firebase에 저장
 ************************************************/
package com.example.afinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MemberInitActivity extends AppCompatActivity {
    private static final String TAG = "MemberInitActivity";
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_init);

        // 라디오그룹 설정
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGrupButtonChangeListner);

        findViewById(R.id.completeBtn).setOnClickListener(onClickListener);
    }

    //라디오 버튼 클릭 리스너
    RadioGroup.OnCheckedChangeListener radioGrupButtonChangeListner = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(i == R.id.business_mem) {
                Toast.makeText(MemberInitActivity.this, "사업자 회원을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
            }
            else if(i == R.id.personal_mem) {
                Toast.makeText(MemberInitActivity.this, "개인 회원을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.completeBtn:
                    profileUpdate();
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void profileUpdate() {
        final String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        final String birth = ((EditText) findViewById(R.id.birthEditText)).getText().toString();
        final String age = ((EditText) findViewById(R.id.ageEditText)).getText().toString();
        final String gender = ((EditText) findViewById(R.id.genderEditText)).getText().toString();
        final String phone = ((EditText) findViewById(R.id.phoneEditText)).getText().toString();
        final String address = ((EditText) findViewById(R.id.addressEditText)).getText().toString();


        if (name.length() > 0 && phone.length() > 0 && birth.length() > 0 && address.length() > 0 && age.length() > 0 && gender.length() > 0) {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            MemberInfo memberInfo = new MemberInfo(name, birth, age, gender, phone, address);

            db.collection("users").document(user.getUid()).set(memberInfo)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            startToast("회원정보 등록을 성공하였습니다.");
                            finish();
                        }

                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            startToast("회원정보에 등록에 실패하였습니다.");
                            Log.w(TAG, "Error writing document", e);
                        }
                    });

        }
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent (this, c);
        startActivityForResult(intent, 0);
    }

    private void startToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}


