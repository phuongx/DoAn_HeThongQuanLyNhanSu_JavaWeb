
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class TinTuyenDung implements Serializable {
    
    int maTin;
    String tenPB;
    String tenVT;
    int soluong;
    String mota;
    String ngayBD;
    String ngayKT;
    public TinTuyenDung(){
        
    }
    public TinTuyenDung(int maTin, String phongban,String vitri, int soluong,
    String mota, String ngayBD, String ngayKT){
        this.maTin = maTin;
        this.tenPB = phongban;
        this.tenVT = vitri;
        this.soluong = soluong;
        this.mota = mota;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }
    public int getMaTin(){
        return maTin;
    }
    public String getTenPB(){
        return tenPB;
    }
    public String gettenVT(){
        return tenVT;
    }
    public int getSoluong(){
        return soluong;
    }
    public String getMota(){
        return mota;
    }
    public String getNgayBD(){
        return ngayBD;
    }
    public String getNgayKT(){
        return ngayKT;
    }
    
    public void setMaTin(int maTin){
        this.maTin = maTin;
    }
    public void setTenPB(String phongban){
        this.tenPB = phongban;
    }
    public void setTenVT(String vitri){
        this.tenVT = vitri;
    }
    public void setSoluong(int soluong){
        this.soluong = soluong;
    }
    public void setMota(String mota){
        this.mota = mota;
    }
    public void setNgayBD(String ngayBD){
        this.ngayBD = ngayBD;
    }
    public void setNgayKT(String ngayKT){
        this.ngayKT = ngayKT;
    }
}
