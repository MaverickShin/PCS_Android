package com.example.petsystemtest4.Data;


import java.sql.Date;

public class PetVO {
    //펫 종류
    private int PK_CD;		   //펫 종류 코드
    private String PK_KIND;    //펫 종류
    private String PK_DETAIL;  //펫 세부 분류

    //펫 테이블
    private int PET_CD;        //펫 코드 시퀀스
    private String CUST_ID;	   //고객 아이디
    private int PET_AGE;	   //펫 나이
    private String PET_NM;     //펫 이름
    private String PET_CON;    //펫 특이사항
    private byte[] PET_IMG;    //펫 프로필 사진 - SQLite때문에 byte로 바꿈. 오라클로 사용할때 String으로 바꿀것
    private Date PET_DT;	   //펫 등록일

    //시터 서비스 요금 테이블
    private int SF_CD;		   //서비스 요금 번호
    private int SF_FEE;		   //서비스 요금

    public int getPK_CD() {
        return PK_CD;
    }

    public void setPK_CD(int PK_CD) {
        this.PK_CD = PK_CD;
    }

    public String getPK_KIND() {
        return PK_KIND;
    }

    public void setPK_KIND(String PK_KIND) {
        this.PK_KIND = PK_KIND;
    }

    public String getPK_DETAIL() {
        return PK_DETAIL;
    }

    public void setPK_DETAIL(String PK_DETAIL) {
        this.PK_DETAIL = PK_DETAIL;
    }

    public int getPET_CD() {
        return PET_CD;
    }

    public void setPET_CD(int PET_CD) {
        this.PET_CD = PET_CD;
    }

    public String getCUST_ID() {
        return CUST_ID;
    }

    public void setCUST_ID(String CUST_ID) {
        this.CUST_ID = CUST_ID;
    }

    public int getPET_AGE() {
        return PET_AGE;
    }

    public void setPET_AGE(int PET_AGE) {
        this.PET_AGE = PET_AGE;
    }

    public String getPET_NM() {
        return PET_NM;
    }

    public void setPET_NM(String PET_NM) {
        this.PET_NM = PET_NM;
    }

    public String getPET_CON() {
        return PET_CON;
    }

    public void setPET_CON(String PET_CON) {
        this.PET_CON = PET_CON;
    }

    public byte[] getPET_IMG() {
        return PET_IMG;
    }

    public void setPET_IMG(byte[] PET_IMG) {
        this.PET_IMG = PET_IMG;
    }

    public Date getPET_DT() {
        return PET_DT;
    }

    public void setPET_DT(Date PET_DT) {
        this.PET_DT = PET_DT;
    }

    public int getSF_CD() {
        return SF_CD;
    }

    public void setSF_CD(int SF_CD) {
        this.SF_CD = SF_CD;
    }

    public int getSF_FEE() {
        return SF_FEE;
    }

    public void setSF_FEE(int SF_FEE) {
        this.SF_FEE = SF_FEE;
    }
}
