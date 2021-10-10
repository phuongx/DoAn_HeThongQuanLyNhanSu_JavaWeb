
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class HSUngTuyen implements Serializable {
    
    String maHS;
    String hoten;
    String sdt;
    String email;
    String tenVT; //vi tri ung tuyen
    String tenPB; //phong ban ung tuyen
    String urlCV;
    String ketqua;
    String ngayduyet;
    public HSUngTuyen(){
        
    }
    public HSUngTuyen(String maHS, String hoten,String sdt,String email,String tenVT,
    String tenPB, String urlCV,String ketqua,String ngayduyet){
        this.maHS = maHS;
        this.hoten = hoten;
        this.sdt = sdt;
        this.email = email;
        this.tenVT = tenVT;
        this.tenPB = tenPB;
        this.urlCV = urlCV;
        this.ketqua = ketqua;
        this.ngayduyet = ngayduyet;
        
    }
    public String getMaHS(){
        return maHS;
    }
    public String getHoten(){
        return hoten;
    }
    public String getSdt(){
        return sdt;
    }
    public String getEmail(){
        return email;
    }
    public String getTenVT(){
        return tenVT;
    }
    public String getTenPB(){
        return tenPB;
    }
    public String getUrlCV(){
        return urlCV;
    }
    public String getKetqua(){
        return ketqua;
    }
    public String getNgayduyet(){
        return ngayduyet;
    }
    
    public void setMaHS(String maHS){
        this.maHS = maHS;
    }
    public void setHoten(String hoten){
        this.hoten = hoten;
    }
    public void setSdt(String sdt){
        this.sdt = sdt;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTenVT(String tenVT){
        this.tenVT = tenVT;
    }
    public void setTenPB(String tenPB){
        this.tenPB = tenPB;
    }
    public void setUrlCV(String urlCV){
        this.urlCV = urlCV;
    }
    public void setKetqua(String ketqua){
        this.ketqua = ketqua;
    }
    public void setNgayduyet(String ngayduyet){
        this.ngayduyet = ngayduyet;
    }
    
    
}
