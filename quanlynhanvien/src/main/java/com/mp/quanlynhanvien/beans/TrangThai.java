
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class TrangThai implements Serializable {
    
    private String maTT;
    private String tenTT;
    public TrangThai() {
        
    }
    
    public TrangThai(String maTT, String tenTT){
        this.maTT = maTT;
        this.tenTT = tenTT;
    }
    public TrangThai(TrangThai trangthai) {
        this.maTT = trangthai.maTT;
        this.tenTT = trangthai.tenTT;
    }
    
    public String getMaTT(){
        return maTT;
    }
    public String getTenTT(){
        return tenTT;
    }
    public void setMaTT(String maTT){
        this.maTT = maTT;
    }
    public void setTenTT(String tenTT){
        this.tenTT = tenTT;
    }
}
