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
public class UserAccount implements Serializable {
    
    
    private String maNV;
    private String password;
    private String hoten;
    private String cmnd;
    private String email;
    private String gioitinh;
    private String diachi;
    private String hinhanh;
    private String tenPB;
    private String tenVT;
    private String ngayBD;
    private String tenTT;
    private String ghichu;
    
    
    public UserAccount() {
        
    }
    public UserAccount(String maNV, String password, String hoten, String cmnd, 
            String email, String gioitinh, String diachi, String hinhanh, 
            String tenPB, String tenVT, String ngayBD, String tenTT, String ghichu) {
        this.maNV = maNV;
        this.password = password;
        this.hoten = hoten;
        this.cmnd = cmnd;
        this.email = email;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.hinhanh = hinhanh;
        this.tenPB = tenPB;
        this.tenVT = tenVT;
        this.ngayBD = ngayBD;
        this.tenTT = tenTT;
        this.ghichu = ghichu;
    }
    public UserAccount (UserAccount user){
        this.maNV = user.maNV;
        this.password = user.password;
        this.hoten = user.hoten;
        this.cmnd = user.cmnd;
        this.email = user.email;
        this.gioitinh = user.gioitinh;
        this.diachi = user.diachi;
        this.hinhanh = user.hinhanh;
        this.tenPB = user.tenPB;
        this.tenVT = user.tenVT;
        this.ngayBD = user.ngayBD;
        this.tenTT = user.tenTT;
        this.ghichu = user.ghichu;
    }
    public String getMaNV() {
       return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public String getCmnd() {
        return cmnd;
    }
    
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }
    public String getTenVT() {
        return tenVT;
    }
    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }
    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }
    public String getNgayBD() {
        return ngayBD;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    public String getGhichu(){
        return ghichu;
    }
    public String getTenTT() {
        return tenTT;
    }

    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }
    
    
    
    
    
}
