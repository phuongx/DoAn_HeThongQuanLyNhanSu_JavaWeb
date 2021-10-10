
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class Luong implements Serializable {
    
    String maNV;
    MucLuong mucluong;
    int phucap;
    String ngayAD;
    
    public Luong(){
        
    }
    public Luong(String maNV, MucLuong mucluong, int phucap, String ngayAD){
        this.maNV = maNV;
        this.mucluong = mucluong;
        this.phucap = phucap;
        this.ngayAD = ngayAD;
    }
    public String getMaNV(){
        return maNV;
    }
    public MucLuong getMucLuong(){
        return mucluong;
    }
    public int getPhucap(){
        return phucap;
    }
    public String getNgayAD(){
        return ngayAD;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    public void setMucLuong(MucLuong mucluong){
        this.mucluong = mucluong;
    }
    public void setPhucap(int phucap){
        this.phucap = phucap;
    }
    public void setNgayAD(String ngayAD){
        this.ngayAD = ngayAD;
    }
}
