
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

public class CongViec implements Serializable {
    private String maCV;
    private String maNV;
    private String ngayGiao;
    private String noidung;
    private String ngayHH;
    private String gioHH;
    private String trangthai;
    
    public CongViec(String maCV, String maNV, String ngayGiao, String noidung, String ngayHH, String gioHH,
            String trangthai){
        this.maCV = maCV;
        this.maNV = maNV;
        this.ngayGiao = ngayGiao;
        this.noidung = noidung;
        this.ngayHH = ngayHH;
        this.gioHH = gioHH;
        this.trangthai = trangthai;
    }
    public String getmaCV(){
        return maCV;
    }
    public String getmaNV(){
        return maNV;
    }
    public String getNgayGiao(){
        return ngayGiao;
    }
    public String getNoidung(){
        return noidung;
    }
    public String getNgayHH(){
        return ngayHH;
    }
    public String getGioHH(){
        return gioHH;
    }
    public String getTrangthai(){
        return trangthai;
    }
    public void setMaCV(String maCV){
        this.maCV = maCV;
    }
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }
    public void setNgayGiao(String ngayGiao){
        this.ngayGiao = ngayGiao;
    }
    public void setNoidung(String noidung ){
        this.noidung = noidung;
    }
    public void setNgayHH(String ngayHH){
        this.ngayHH = ngayHH;
    }
    public void setGioHH(String gioHH){
        this.gioHH = gioHH;
    }
    public void setTrangthai(String trangthai){
        this.trangthai = trangthai;
    }
}
