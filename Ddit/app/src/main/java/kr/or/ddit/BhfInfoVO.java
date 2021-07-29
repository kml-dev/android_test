package kr.or.ddit;

import androidx.annotation.NonNull;

import java.util.List;

public class BhfInfoVO {
    private int BHF_NO;
    private String BHF_NAME;

    public BhfInfoVO(int BHF_NO, String BHF_NAME) {
        this.BHF_NO = BHF_NO;
        this.BHF_NAME = BHF_NAME;
    }

    public int getBHF_NO() {
        return BHF_NO;
    }

    public void setBHF_NO(int BHF_NO) {
        this.BHF_NO = BHF_NO;
    }

    public String getBHF_NAME() {
        return BHF_NAME;
    }

    public void setBHF_NAME(String BHF_NAME) {
        this.BHF_NAME = BHF_NAME;
    }

    @Override
    public String toString() {
        return "BhfInfoVO{" +
                "BHF_NO=" + BHF_NO +
                ", BHF_NAME='" + BHF_NAME + '\'' +
                '}';
    }
}

