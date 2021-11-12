
package com.mp.quanlynhanvien.beans;

public class TrinhDoHocVan {
    private int ma;
    private String ten;
    public TrinhDoHocVan() {
        
    }
    
    public TrinhDoHocVan(int ma, String ten){
        this.ma = ma;
        this.ten = ten;
    }
    public TrinhDoHocVan(TrinhDoHocVan trinhdo) {
        this.ma = trinhdo.ma;
        this.ten = trinhdo.ten;
    }
    
    public int getMa(){
        return ma;
    }
    public String getTen(){
        return ten;
    }
    public void setMa(int ma){
        this.ma = ma;
    }
    public void setTen(String ten){
        this.ten = ten;
    }
}
