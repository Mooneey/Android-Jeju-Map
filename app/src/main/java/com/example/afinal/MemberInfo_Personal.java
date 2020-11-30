/* **********************************************
 * 프로그램명 : MemberInfo_Personal.java
 * 작성자 : 2018038041 김서빈
 * 작성일 : 2020.06.19
 * 프로그램 설명 : 살어리랏다 in Jeju의 개인 회원용 회원정보 입력 받아 저장하는 코드
 ************************************************/
package com.example.afinal;

public class MemberInfo_Personal {

    private String name;
    private String phone;
    private String birth;
    private String address;
    private String age;
    private String gender;

    public MemberInfo_Personal(String name, String birth, String age, String gender, String phone, String address ) {
        this.name = name;
        this.birth = birth;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
