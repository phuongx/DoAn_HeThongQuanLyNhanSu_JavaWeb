/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp.quanlynhanvien.utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.beans.PhongBan;
import com.mp.quanlynhanvien.beans.ViTri;
import com.mp.quanlynhanvien.beans.TrangThai;

/**
 *
 * @author Ms Phuong
 */
public class AutoFillUtils {
    
    public static String getMaNV(Connection conn) {
        String maNV = null;
        try{
            
            maNV = DBUtils.maxMaNV(conn);
        } catch (SQLException e){
            e.printStackTrace();
           
        }
        String NVMoi = maNV.substring(2);
        int temp = Integer.parseInt(NVMoi) + 1;
        if (temp < 10)
            maNV = "E000" + temp;
        else if (temp < 100)
                maNV = "E00" + temp;
            else if (temp < 1000)
                    maNV = "E0" + temp;
                  else
                       maNV = "E" + temp;
        return maNV;
    }
    public static String getMaPB(Connection conn) {
        String maPB = null;
        try{
            
            maPB = DBUtils.maxMaPB(conn);
        } catch (SQLException e){
            e.printStackTrace();
           
        }
        String PBMoi = maPB.substring(2);
        int temp = Integer.parseInt(PBMoi) + 1;
        if (temp < 10)
            maPB = "P00" + temp;
        else if (temp < 100)
                maPB = "P0" + temp;
            else 
                maPB = "P" + temp;
                  
        return maPB;
    }
    public static String getMaHSUT(Connection conn) {
        String maHS = null;
        try{
            
            maHS = DBUtils.maxMaHS(conn);
        } catch (SQLException e){
            e.printStackTrace();
           
        }
        if (maHS != null){
         
            String HSMoi = maHS.substring(3);
            int temp = Integer.parseInt(HSMoi) + 1;
            if (temp < 10)
                maHS = "HS0000" + temp;
            else if (temp < 100)
                    maHS = "HS000" + temp;
                else if (temp < 1000)
                        maHS = "HS00" + temp;
                    else if (temp < 10000)
                            maHS = "HS0" + temp;
                        else 
                            maHS = "HS" + temp;
        } else {
            maHS = "HS00001";
        }
                  
        return maHS;
    }
    public static List<PhongBan> getListPB(Connection conn){
        List<PhongBan> listPB = new ArrayList<PhongBan>();
        try{
            listPB = DBUtils.dsPhongBan(conn);
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
        return listPB;
    }
    public static List<ViTri> getListVT(Connection conn){
        List<ViTri> listVT = new ArrayList<ViTri>();
        try{
            listVT = DBUtils.dsViTri(conn);
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
        return listVT;
    }
    public static List<TrangThai> getListTT(Connection conn){
        List<TrangThai> listTT = new ArrayList<TrangThai>();
        try{
            listTT = DBUtils.dsTrangThai(conn);
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
        return listTT;
    }
}
