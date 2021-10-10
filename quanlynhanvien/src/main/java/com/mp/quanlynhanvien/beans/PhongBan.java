
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class PhongBan implements Serializable {
    
    private String maPB;
    private String tenPB;
    public PhongBan() {
        
    }
    
    public PhongBan(String maPB, String tenPB){
        this.maPB = maPB;
        this.tenPB = tenPB;
    }
    public PhongBan(PhongBan phongban) {
        this.maPB = phongban.maPB;
        this.tenPB = phongban.tenPB;
    }
    
    public String getMaPB(){
        return maPB;
    }
    public String getTenPB(){
        return tenPB;
    }
    public void setMaPB(String maPB){
        this.maPB = maPB;
    }
    public void setTenPB(String tenPB){
        this.tenPB = tenPB;
    }
    
}
