
package com.mp.quanlynhanvien.beans;


public class TrinhDoNgoaiNgu {
    private int ma;
    private String ngonngu;
    private String ten;
    public TrinhDoNgoaiNgu() {
        
    }
    
    public TrinhDoNgoaiNgu(int ma,String ngonngu, String ten){
        this.ma = ma;
        this.ngonngu = ngonngu;
        this.ten = ten;
    }
    public TrinhDoNgoaiNgu(TrinhDoNgoaiNgu trinhdo) {
        this.ma = trinhdo.ma;
        this.ngonngu = trinhdo.ngonngu;
        this.ten = trinhdo.ten;
    }
    
    public int getMa(){
        return ma;
    }
    public String getNgonngu(){
        return ngonngu;
    }
    public String getTen(){
        return ten;
    }
    public void setMa(int ma){
        this.ma = ma;
    }
    public void setNgonngu(String ngonngu){
        this.ngonngu = ngonngu;
    }
    public void setTen(String ten){
        this.ten = ten;
    }
}
