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
    private String sdt;
    private String ngaysinh;
    private String gioitinh;
    private String diachi;
    private String tenPB;
    private String tenVT;
    private String tenTT;
    private int quyen;
    
    
    public UserAccount() {
        
    }
    public UserAccount(String maNV, String password, String hoten, String cmnd, 
            String email, String sdt, String ngaysinh, String gioitinh, String diachi,  
            String tenPB, String tenVT,  String tenTT, int quyen) {
        this.maNV = maNV;
        this.password = password;
        this.hoten = hoten;
        this.cmnd = cmnd;
        this.email = email;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.tenPB = tenPB;
        this.tenVT = tenVT;
        this.tenTT = tenTT;
        this.quyen = quyen;
    }
    public UserAccount (UserAccount user){
        this.maNV = user.maNV;
        this.password = user.password;
        this.hoten = user.hoten;
        this.cmnd = user.cmnd;
        this.email = user.email;
        this.sdt = user.sdt;
        this.ngaysinh = user.ngaysinh;
        this.gioitinh = user.gioitinh;
        this.diachi = user.diachi;
        this.tenPB = user.tenPB;
        this.tenVT = user.tenVT;
        this.tenTT = user.tenTT;
        this.quyen = user.quyen;
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
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
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

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }
    public int getQuyen(){
        return quyen;
    }
    public String getTenTT() {
        return tenTT;
    }

    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }

}
