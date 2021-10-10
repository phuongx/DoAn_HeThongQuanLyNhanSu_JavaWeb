
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class MucLuong implements Serializable {
    
    int muc;
    int soTien;
    public MucLuong() {
        
    }
    
    public MucLuong(int muc, int soTien){
        this.muc = muc;
        this.soTien = soTien;
    }
    public MucLuong(MucLuong mucluong){
        this.muc = mucluong.muc;
        this.soTien = mucluong.soTien;
    }
    
    public int getMuc(){
        return muc;
    }
    public int getSoTien(){
        return soTien;
    }
    public void setMuc(int muc){
        this.muc = muc;
    }
    public void setSoTien(int soTien){
        this.soTien = soTien;
    }
}
