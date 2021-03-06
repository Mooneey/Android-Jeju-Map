/* **********************************************
 * 프로그램명 : MemberInfo_Personal.java
 * 작성자 : 2018038041 김서빈
 * 작성일 : 2020.06.19
 * 프로그램 설명 : 살어리랏다 in Jeju의 개인 회원용 회원정보 입력 받아 Firebase에 저장
 ************************************************/
package com.example.afinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MemberInitActivity_Personal extends AppCompatActivity {
    private static final String TAG = "MemberInitActivity_Personal";
    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_init_personal);


        // 회원가입 이미지 삽입
        imageview = (ImageView)findViewById(R.id.imageView);
        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });

        findViewById(R.id.completeBtn).setOnClickListener(onClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);

        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.completeBtn:
                    profileUpdate();
                    myStartActivity(LoginActivity.class);
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
            MemberInfo_Personal memberInfoPersonal = new MemberInfo_Personal(name, birth, age, gender, phone, address);

            db.collection("users").document(user.getUid()).set(memberInfoPersonal)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            startToast("회원정보 등록을 성공하였습니다.");
                            finish();
                        }

                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @SuppressLint("LongLogTag")
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


