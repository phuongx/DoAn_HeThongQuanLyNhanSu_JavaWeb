
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class NVThoiViec implements Serializable {
    
    private UserAccount user;
    private String ngay;
    public NVThoiViec(){
        
    }
    public NVThoiViec(UserAccount user, String ngay){
        this.user = new UserAccount(user);
        this.ngay = ngay;
    }
    public UserAccount getUser(){
        return user;
    }
    public String getNgay(){
        return ngay;
    }
    public void setUser(UserAccount user){
        this.user = new UserAccount(user);
    }
    public void setNgay(String ngay){
        this.ngay = ngay;
    }
    
    
}
