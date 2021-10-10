
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class DonXinNghi implements Serializable {
    String maNV;
    String ngayBD;
    int songay;
    String duyet;
    public DonXinNghi(){
        
    }
    public DonXinNghi(String maNV, String ngayBD,int songay, String duyet){
        this.maNV = maNV;
        this.ngayBD = ngayBD;
        this.songay = songay;
        this.duyet = duyet;
    }
    public String getMaNV(){
        return maNV;
    }
    public String getNgayBD(){
        return ngayBD;
        
    }
    public int getSoNgay(){
        return songay;
    }
    public String getDuyet(){
        return duyet;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    public void setNgayBD(String ngayBD){
        this.ngayBD = ngayBD;
    }
    public void setSongay(int songay){
        this.songay = songay;
    }
    public void setDuyet(String duyet){
        this.duyet = duyet;
    }
    
}
