
package com.mp.quanlynhanvien.beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ms Phuong
 */
public class ViTri implements Serializable {
    
    private String maVT;
    private String tenVT;
    public ViTri() {
        
    }
    
    public ViTri(String maVT, String tenVT){
        this.maVT = maVT;
        this.tenVT = tenVT;
    }
    public ViTri(ViTri vt) {
        this.maVT = vt.maVT;
        this.tenVT = vt.tenVT;
    }
    
    public String getMaVT(){
        return maVT;
    }
    public String getTenVT(){
        return tenVT;
    }
    public void setMaVT(String maVT){
        this.maVT = maVT;
    }
    public void setTenVT(String tenVT){
        this.tenVT = tenVT;
    }
    
}
