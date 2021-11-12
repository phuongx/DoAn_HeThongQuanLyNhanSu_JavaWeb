
package com.mp.quanlynhanvien.beans;
import java.beans.*;
public class HopDongLaoDong {
    private int maHD;
    private String maNV;
    private String ngayKy;
    private String ngayHetHan;
    private String url;
    public HopDongLaoDong (){
        
    }
    public HopDongLaoDong(int maHD, String maNV, String ngayKy, String ngayHH, String url){
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngayKy = ngayKy;
        this.ngayHetHan = ngayHH;
        this.url = url;
    }
    public int getMaHD(){
        return maHD;
    }
    public String getMaNV(){
        return maNV;
    }
    public String getNgayKy(){
        return ngayKy;
    }
    public String getNgayHetHan(){
        return ngayHetHan;
    }
    public String getUrl(){
        return url;
    }
    
    public void setMaHD(int maHD){
        this.maHD = maHD;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    public void setNgayKy(String ngayKy){
        this.ngayKy = ngayKy;
    }
    public void setNgayHetHan(String ngayHH){
        this.ngayHetHan = ngayHH;
    }
    public void setUrl(String url){
        this.url = url;
    }
}
