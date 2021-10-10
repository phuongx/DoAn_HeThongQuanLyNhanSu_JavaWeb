/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class ViPham implements Serializable {
    
    private String maNV;
    private String noidung;
    private String ngay;
    
    public ViPham() {
        
    }
    public ViPham(String maNV, String noidung, String ngay) {
        this.maNV = maNV;
        this.noidung = noidung;
        this.ngay = ngay;
    }
    
    public String getMaNV(){
        return maNV;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    public String getNoidung(){
        return noidung;
    }
    public void setNoidung(String noidung){
        this.noidung = noidung;
    }
    public String getNgay(){
        return ngay;
    }
    public void setNgay( String ngay){
        this.ngay = ngay;
    }
}
