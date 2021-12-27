
package com.mp.quanlynhanvien.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mp.quanlynhanvien.beans.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
/**
 *
 * @author Ms Phuong
 */
public class DBUtils {
    public static UserAccount findUser(Connection conn, //
            String maNV, String password) throws SQLException {
 
        String sql = "Select * from user_account a " //
                + " where a.ma_nv = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, maNV);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String hoten = rs.getString("hoten");
            String cmnd = rs.getString("cmnd");
            String email = rs.getString("email");
            String sdt = rs.getString("sdt");
            String ngaysinh = rs.getString("ngay_sinh");
            String gioitinh = rs.getString("gioitinh");
            String diachi = rs.getString("diachi");
            String tenPB = rs.getString("ten_pb");
            String tenVT = rs.getString("ten_vt");
            String tenTT = rs.getString("ten_tt");
            int quyen = rs.getInt("quyen");

            UserAccount user = new UserAccount(maNV,password,hoten,cmnd,email,sdt,
                ngaysinh,gioitinh,diachi,tenPB,tenVT,tenTT,quyen);

            return user;
        }
        return null;
    }
    
    public static UserAccount findUser(Connection conn, String maNV) throws SQLException {
 
        String sql = "Select * from user_account a " //
                + " where a.ma_nv = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, maNV);
        
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("password");
            String hoten = rs.getString("hoten");
            String cmnd = rs.getString("cmnd");
            String email = rs.getString("email");
            String sdt = rs.getString("sdt");
            String ngaysinh = rs.getString("ngay_sinh");
            String gioitinh = rs.getString("gioitinh");
            String diachi = rs.getString("diachi");
            String tenPB = rs.getString("ten_pb");
            String tenVT = rs.getString("ten_vt");
            String tenTT = rs.getString("ten_tt");
            int quyen = rs.getInt("quyen");

            UserAccount user = new UserAccount(maNV,password,hoten,cmnd,email,sdt,
                ngaysinh,gioitinh,diachi,tenPB,tenVT,tenTT,quyen);
            return user;
        }
        return null;
    }
    
    public static List<UserAccount> findUsers(Connection conn, String name, String trangthai) throws SQLException {
        
        String sql = null ;
        if (trangthai.equals("Tat ca"))
            sql = "Select * from user_account where hoten like '%"+name+"%'";
        else if (trangthai.equals("Hoat dong"))
            sql = "Select * from user_account where ten_tt = 'Hoat dong' and hoten like '%"+name+"%'";
        else sql = "Select * from user_account where ten_tt = 'Thoi viec' and hoten like '%"+name+"%'";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List <UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            String maNV = rs.getString("ma_nv");
            String password = rs.getString("password");
            String hoten = rs.getString("hoten");
            String cmnd = rs.getString("cmnd");
            String email = rs.getString("email");
            String sdt = rs.getString("sdt");
            String ngaysinh = rs.getString("ngay_sinh");
            String gioitinh = rs.getString("gioitinh");
            String diachi = rs.getString("diachi");
            String tenPB = rs.getString("ten_pb");
            String tenVT = rs.getString("ten_vt");
            String tenTT = rs.getString("ten_tt");
            int quyen = rs.getInt("quyen");

            UserAccount user = new UserAccount(maNV,password,hoten,cmnd,email,sdt,
                ngaysinh,gioitinh,diachi,tenPB,tenVT,tenTT,quyen);
            
            list.add(user);
        }
        return list;
    }
    
    public static List<ThanhTich> findThanhTich(Connection conn, String maNV) throws SQLException{
        
        String sql = "Select a.ma_nv, a.noidung, a.ngay from thanhtich a "
                + "where a.ma_nv=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, maNV);
        ResultSet rs = pstm.executeQuery();
        List<ThanhTich> list = new ArrayList<ThanhTich>();
        while (rs.next()) {
            
            String noidung = rs.getString("noidung");
            String ngay = rs.getString("ngay");
            ThanhTich thanhtich = new ThanhTich(maNV,noidung,ngay);
            
            list.add(thanhtich);
        }
        return list;
        
    }
    
    public static List<ViPham> findViPham(Connection conn, String maNV) throws SQLException{
        
        String sql = "Select a.ma_nv, a.noidung, a.ngay from vipham a "
                + "where a.ma_nv=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, maNV);
        ResultSet rs = pstm.executeQuery();
        List<ViPham> list = new ArrayList<ViPham>();
        while (rs.next()) {
            
            String noidung = rs.getString("noidung");
            String ngay = rs.getString("ngay");
            
            ViPham vipham = new ViPham(maNV,noidung,ngay);
            
            list.add(vipham);
        }
        return list;
        
    }
    public static List<UserAccount> dsNhanVien(Connection conn)throws SQLException{
        String sql = "Select ma_nv from user_account where ten_tt = 'Hoat dong' order by ma_nv ASC";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
 
        List<UserAccount> list = new ArrayList<UserAccount>();
        
        while (rs.next()) {
            String maNV = rs.getString("ma_nv");
            
            UserAccount user = findUser(conn,maNV);
            
            list.add(user);
            
        }
        return list;
        
    }
    public static List<UserAccount> dsNhanVien(Connection conn, int quyen)throws SQLException{
        String sql = "Select ma_nv from user_account where ten_tt = 'Hoat dong' and quyen=? order by ma_nv ASC";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, quyen);
        ResultSet rs = pstm.executeQuery();
 
        List<UserAccount> list = new ArrayList<UserAccount>();
        
        while (rs.next()) {
            String maNV = rs.getString("ma_nv");
            
            UserAccount user = findUser(conn,maNV);
            
            list.add(user);
            
        }
        return list;
        
    }
    public static void insertThanhTich(Connection conn, ThanhTich tt) throws SQLException {
        String sql = "Insert into thanhtich (ma_nv, noidung, ngay)"
                + " values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, tt.getMaNV());
        pstm.setString(2, tt.getNoidung());
        pstm.setString(3, tt.getNgay());
        
 
        pstm.executeUpdate();
    }
    public static void insertViPham(Connection conn, ViPham vp) throws SQLException {
        String sql = "Insert into vipham (ma_nv, noidung, ngay)"
                + " values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, vp.getMaNV());
        pstm.setString(2, vp.getNoidung());
        pstm.setString(3, vp.getNgay());
        
 
        pstm.executeUpdate();
    }
    public static void insertNhanVien(Connection conn, UserAccount userAccount) throws SQLException {
        
        String sql = "Insert into user_account "
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, userAccount.getMaNV());
        pstm.setString(2, userAccount.getPassword());
        pstm.setString(3, userAccount.getHoten());
        pstm.setString(4, userAccount.getCmnd());
        pstm.setString(5, userAccount.getEmail());
        pstm.setString(6, userAccount.getSdt());
        pstm.setString(7, userAccount.getNgaysinh());
        pstm.setString(8, userAccount.getGioitinh());
        pstm.setString(9, userAccount.getDiachi());
        pstm.setString(10, userAccount.getTenPB());
        pstm.setString(11, userAccount.getTenVT());
        pstm.setString(12, userAccount.getTenTT());
        pstm.setInt(13, userAccount.getQuyen());
 
        pstm.executeUpdate();
    }
    public static void insertNVThoiViec(Connection conn, String maNV,String ngay) throws SQLException {
        
        String sql = "Insert into nhanvien_thoiviec (ma_nv, ngay)"
                + " values (?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, maNV);
        pstm.setString(2, ngay);
       
 
        pstm.executeUpdate();
    }
    
    public static List<PhongBan> dsPhongBan(Connection conn) throws SQLException{
        
        String sql = "Select * from phong_ban order by ma_pb ASC";
                
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        List<PhongBan> list = new ArrayList<PhongBan>();
        while (rs.next()) {
            
            String maPB = rs.getString("ma_pb");
            String tenPB = rs.getString("ten_pb");
            
            PhongBan phongban = new PhongBan(maPB,tenPB);
            
            list.add(phongban);
        }
        return list;
        
    }
    public static Map<PhongBan,String> ds_PhongBan(Connection conn) throws SQLException{
        
        String sql = "Select * from phong_ban order by ma_pb ASC";
                
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        Map <PhongBan,String> listPB = new LinkedHashMap<PhongBan,String>();
        while (rs.next()) {
            
            String maPB = rs.getString("ma_pb");
            String tenPB = rs.getString("ten_pb");
            
            PhongBan phongban = new PhongBan(maPB,tenPB);
            List <UserAccount> list;
            list = getUsersPhongBanX(conn,phongban.getTenPB());
            listPB.put(phongban, String.valueOf(list.size()));
        }
        return listPB;
        
    }
    public static Map<TrinhDoHocVan,String> ds_TrinhDoHocVan(Connection conn) throws SQLException{
        
        String sql = "Select * from trinhdo order by ma_td ASC";
                
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        Map <TrinhDoHocVan,String> listPB = new LinkedHashMap<TrinhDoHocVan,String>();
        while (rs.next()) {
            
            int ma = rs.getInt("ma_td");
            String ten = rs.getString("ten_td");
            
            TrinhDoHocVan td = new TrinhDoHocVan(ma,ten);
            List <UserAccount> list;
            list = getUsersTrinhDoX(conn,td.getMa());
            listPB.put(td, String.valueOf(list.size()));
        }
        return listPB;
        
    }
    public static List<ViTri> dsViTri(Connection conn) throws SQLException{
        
        String sql = "Select * from vi_tri order by ma_vt ASC";
                
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        List<ViTri> list = new ArrayList<ViTri>();
        while (rs.next()) {
            
            String maVT = rs.getString("ma_vt");
            String tenVT = rs.getString("ten_vt");
            
            ViTri vitri = new ViTri(maVT,tenVT);
            
            list.add(vitri);
        }
        return list;
        
    }
    public static List<TrangThai> dsTrangThai(Connection conn) throws SQLException{
        
        String sql = "Select * from trang_thai order by ma_tt ASC";
                
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        List<TrangThai> list = new ArrayList<TrangThai>();
        while (rs.next()) {
            
            String maTT = rs.getString("ma_tt");
            String tenTT = rs.getString("ten_tt");
            
            TrangThai trangthai = new TrangThai(maTT, tenTT);
            
            list.add(trangthai);
        }
        return list;
        
    }
    public static List<MucLuong> dsMucLuong(Connection conn) throws SQLException{
        
        String sql = "Select * from muc_luong order by muc ASC";
                
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        List<MucLuong> list = new ArrayList<MucLuong>();
        while (rs.next()) {
            
            int muc = rs.getInt("muc");
            int soTien = rs.getInt("so_tien");
            
            MucLuong luong = new MucLuong(muc, soTien);
            
            list.add(luong);
        }
        return list;
        
    }
    public static String maxMaNV(Connection conn) throws SQLException{
        String sql = "select MAX(ma_nv) as maNV from user_account ";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        String maNV = null;
        
        if (rs.next()){
            maNV = rs.getString("maNV");
            
        }
        return maNV;
    }
    public static String maxMaPB(Connection conn) throws SQLException{
        String sql = "select MAX(ma_pb) as maPB from phong_ban ";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        String maPB = null;
        
        if (rs.next()){
            maPB = rs.getString("maPB");
            
        }
        return maPB;
    }
    public static String maxMaVT(Connection conn) throws SQLException{
        String sql = "select MAX(ma_vt) as mavt from vi_tri ";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        String maVT = null;
        
        if (rs.next()){
            maVT = rs.getString("mavt");
        }
        return maVT;
    }
    public static String maxMaHS(Connection conn) throws SQLException{
        String sql = "select MAX(ma_hoso) as maHS from ungtuyen ";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        String maHS = null;
        
        if (rs.next()){
            maHS = rs.getString("maHS");
            
        }
        return maHS;
    }
    public static List<TrinhDoHocVan> dsTrinhDoHocVan(Connection conn) throws SQLException{
        
        String sql = "Select * from trinhdo order by ma_td ASC";
                
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        List<TrinhDoHocVan> list = new ArrayList<TrinhDoHocVan>();
        while (rs.next()) {
            
            int maTD = rs.getInt("ma_td");
            String tenTD = rs.getString("ten_td");
            
            TrinhDoHocVan trinhdo = new TrinhDoHocVan(maTD,tenTD);
            
            list.add(trinhdo);
        }
        return list;
        
    }
    public static void insertTrinhDoHocVan(Connection conn, TrinhDoHocVan td) throws SQLException {
        String sql = "Insert into trinhdo(ten_td)"
                + " values (?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, td.getTen());

        pstm.executeUpdate();
        
    }
    public static List<TrinhDoNgoaiNgu> dsTrinhDoNgoaiNgu(Connection conn) throws SQLException{
        
        String sql = "Select * from trinhdo_nn order by ma_td ASC";

        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        List<TrinhDoNgoaiNgu> list = new ArrayList<TrinhDoNgoaiNgu>();
        while (rs.next()) {
            
            int maTD = rs.getInt("ma_td");
            String ngonngu = rs.getString("ngon_ngu");
            String tenTD = rs.getString("ten_td");
            
            TrinhDoNgoaiNgu trinhdo = new TrinhDoNgoaiNgu(maTD,ngonngu,tenTD);
            
            list.add(trinhdo);
        }
        return list;
        
    }
    public static void insertTrinhDoNgoaiNgu(Connection conn, TrinhDoNgoaiNgu td) throws SQLException {
        String sql = "Insert into trinhdo_nn (ngon_ngu, ten_td)"
                + " values (?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, td.getNgonngu());
        pstm.setString(2, td.getTen());

        pstm.executeUpdate();
        
    }
    public static void insertPhongBan(Connection conn, PhongBan pb) throws SQLException {
        String sql = "Insert into phong_ban (ma_pb, ten_pb)"
                + " values (?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, pb.getMaPB());
        pstm.setString(2, pb.getTenPB());
        
        
 
        pstm.executeUpdate();
        
    }
    
    public static void insertViTri(Connection conn, ViTri VT) throws SQLException {
        String sql = "Insert into vi_tri (ma_vt, ten_vt)"
                + " values (?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, VT.getMaVT());
        pstm.setString(2, VT.getTenVT());

        pstm.executeUpdate();
    }
    public static void updateNhanVien(Connection conn, UserAccount user) throws SQLException {
        String sql = "Update user_account set cmnd=?, email=?, sdt=?,  diachi =?, ten_pb=?, ten_vt=? "
                + "  where ma_nv=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, user.getCmnd());
        pstm.setString(2, user.getEmail());
        pstm.setString(3, user.getSdt());
        pstm.setString(4, user.getDiachi());
        pstm.setString(5, user.getTenPB());
        pstm.setString(6, user.getTenVT());
        pstm.setString(7, user.getMaNV());
        pstm.executeUpdate();
        
    }
    public static List<NVThoiViec> dsNhanVien_ThoiViec(Connection conn)throws SQLException{
        String sql = "Select * from nhanvien_thoiviec" ;
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        ResultSet rs = pstm.executeQuery();
        
       List <NVThoiViec> list = new ArrayList<NVThoiViec>();
        while (rs.next()) {
            String maNV = rs.getString("ma_nv");
            String ngay = rs.getString("ngay");
            UserAccount user = findUser(conn,maNV);
            
            NVThoiViec nv = new NVThoiViec(user, ngay);
            
            list.add(nv);
        }
        return list;
    }
    public static void NhanVien_ThoiViec(Connection conn, String maNV, String ngay)throws SQLException{
        String sql = "Update user_account set  ten_tt =? where ma_nv=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, "Thoi viec");
        pstm.setString(2, maNV);
        
        pstm.executeUpdate();
 
        String sql1 = "Insert into nhanvien_thoiviec (ma_nv, ngay) values (?,?)";
 
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
 
        pstm1.setString(1, maNV);
        pstm1.setString(2, ngay);
        
        
 
        pstm1.executeUpdate();
    }
    
    public static void insertHoSoUT(Connection conn, HSUngTuyen hoso) throws SQLException {
        String sql = "Insert into ungtuyen (ma_hoso, hoten, sdt, email, ten_vt, ten_pb,"
                + "cv,ketqua,ngayduyet)"
                + " values (?,?,?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, hoso.getMaHS());
        pstm.setString(2, hoso.getHoten());
        pstm.setString(3, hoso.getSdt());
        pstm.setString(4, hoso.getEmail());
        pstm.setString(5, hoso.getTenVT());
        pstm.setString(6, hoso.getTenPB());
        pstm.setString(7, hoso.getUrlCV());
        pstm.setString(8, hoso.getKetqua());
        pstm.setString(9, hoso.getNgayduyet());
        
        pstm.executeUpdate();
    }
    public static List<HSUngTuyen> dsHSUT(Connection conn, String trangthai) throws SQLException{
        String sql = null;
        if (trangthai.equals("Tat ca"))
            sql = "select * from ungtuyen";
        else if (trangthai.equals("Chua duyet"))
            sql = "select * from ungtuyen where ketqua is null";
        else sql = "select * from ungtuyen where ketqua is not null";
        
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<HSUngTuyen> list = new ArrayList<HSUngTuyen>();
        while (rs.next()){
            String maHS = rs.getString("ma_hoso");
            String hoten = rs.getString("hoten");
            String sdt = rs.getString("sdt");
            String email = rs.getString("email");
            String tenVT = rs.getString("ten_vt");
            String tenPB = rs.getString("ten_pb");
            String urlCV = rs.getString("cv");
            String ketqua = rs.getString("ketqua");
            String ngayduyet = rs.getString("ngayduyet");
            HSUngTuyen hoso = new HSUngTuyen(maHS,hoten,sdt,email,tenVT,tenPB,urlCV,ketqua,ngayduyet);
            list.add(hoso);
        }
        return list;
    }
    public static void insertCongViec(Connection conn, CongViec cv) throws SQLException{
        String sql = "insert into congviec(ma_nv, ngaygiao, noidung, ngayhethan, giohethan, trangthai)"
                + " values(?,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, cv.getmaNV());
        pstm.setString(2, cv.getNgayGiao());
        pstm.setString(3, cv.getNoidung());
        pstm.setString(4, cv.getNgayHH());
        pstm.setString(5, cv.getGioHH());
        pstm.setString(6, cv.getTrangthai());
        pstm.executeUpdate();
    }
    public static List<CongViec> getCongViec(Connection conn, String maNV, String trangthai) throws SQLException{
        
        String sql = "select * from congviec where ma_nv=? and trangthai=? order by ngayhethan DESC";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, maNV);
        pstm.setString(2, trangthai);
        List<CongViec> list = new ArrayList<CongViec>();
        
        ResultSet rs =  pstm.executeQuery();
        while (rs.next()){
            String maCV = rs.getString("ma_cv");
            String ngayGiao = rs.getString("ngaygiao");
            String noidung = rs.getString("noidung");
            String ngayHH = rs.getString("ngayhethan");
            String gioHH = rs.getString("giohethan");
            CongViec cv = new CongViec(maCV,maNV,ngayGiao,noidung,ngayHH,gioHH,trangthai);
            
            list.add(cv);
        }
        return list;
    }
    public static boolean updateTrangThaiCV(Connection conn, String maCV, String maNV) throws SQLException{
        String sql1 = "select * from congviec where ma_cv=? and ma_nv=?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, maCV);
        pstm1.setString(2, maNV);
        ResultSet rs = pstm1.executeQuery();
        if (rs.next()) {
            String sql = "update congviec set  trangthai = ? where ma_cv=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, "Hoan thanh");
            pstm.setString(2, maCV);
            pstm.executeUpdate();
            return true;
        }
        return false;
    }
    public static boolean updateTrangThaiHSUT(Connection conn, HSUngTuyen hoso ) throws SQLException{
        String sql1 = "select * from ungtuyen where ma_hoso=?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, hoso.getMaHS());

        ResultSet rs = pstm1.executeQuery();
        if (rs.next()) {
            String sql = "update ungtuyen set ketqua = ?, ngayduyet=? where ma_hoso=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, hoso.getKetqua());
            pstm.setString(2, hoso.getNgayduyet());
            pstm.setString(3, hoso.getMaHS());
            pstm.executeUpdate();
            return true;
        }
        return false;
    }
    public static HSUngTuyen findHSUT(Connection conn, String maHS) throws SQLException{
        String sql = "select * from ungtuyen where ma_hoso=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, maHS);
        ResultSet rs = pstm.executeQuery();
        HSUngTuyen hoso = new HSUngTuyen();
        if (rs.next()){
            String hoten = rs.getString("hoten");
            String sdt = rs.getString("sdt");
            String email = rs.getString("email");
            String tenVT = rs.getString("ten_vt");
            String tenPB = rs.getString("ten_pb");
            String urlCV = rs.getString("cv");
            String ketqua = rs.getString("ketqua");
            String ngayduyet = rs.getString("ngayduyet");
            hoso = new HSUngTuyen(maHS,hoten,sdt,email,tenVT,tenPB,urlCV,ketqua,ngayduyet);
        }
        return hoso;
    }
    public static TinTuyenDung getTinTuyenDung(Connection conn, int maTin) throws SQLException{

        String sql = "SELECT * FROM tin_tuyen_dung WHERE ma_tin=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, maTin);
        TinTuyenDung tin = new TinTuyenDung();
        
        ResultSet rs =  pstm.executeQuery();
        while (rs.next()){
            String tenPB = rs.getString("ten_pb");
            String tenVT = rs.getString("ten_vt");
            int soluong = rs.getInt("so_luong");
            String mota = rs.getString("mo_ta");
            String ngayBD = rs.getString("ngay_bd");
            String ngayKT = rs.getString("ngay_kt");
            tin = new TinTuyenDung(maTin,tenPB,tenVT,soluong,mota,ngayBD,ngayKT);
        }
        return tin;
    }
    
    public static List<TinTuyenDung> getTinTuyenDung(Connection conn) throws SQLException{

        String sql = "SELECT ma_tin FROM tin_tuyen_dung order by ma_tin DESC";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        List<TinTuyenDung> list = new ArrayList<TinTuyenDung>();
        
        ResultSet rs =  pstm.executeQuery();
        while (rs.next()){
            int maTin = rs.getInt("ma_tin");
            TinTuyenDung tin = getTinTuyenDung(conn, maTin);
            list.add(tin);
        }
        return list;
    }
    public static List<TinTuyenDung> getTinTuyenDung(Connection conn, String name, String col_name) throws SQLException {

        String sql = "Select ma_tin from tin_tuyen_dung where "+col_name+" like '%"+name+"%'";

        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<TinTuyenDung> list = new ArrayList<TinTuyenDung>();
        while (rs.next()){
            int maTin = rs.getInt("ma_tin");
            TinTuyenDung tin = getTinTuyenDung(conn, maTin);
            list.add(tin);
        }
        return list;
    }
    public static void insertTinTuyenDung (Connection conn, TinTuyenDung tin) throws SQLException{

        String sql = "insert into tin_tuyen_dung(ten_pb, ten_vt, so_luong, mo_ta, ngay_bd, ngay_kt)"
                + "values(?,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tin.getTenPB());
        pstm.setString(2, tin.gettenVT());
        pstm.setInt(3, tin.getSoluong());
        pstm.setString(4, tin.getMota());
        pstm.setString(5, tin.getNgayBD());
        pstm.setString(6, tin.getNgayKT());
        
        pstm.executeUpdate();

    }
    public static void editTinTuyenDung (Connection conn, TinTuyenDung tin) throws SQLException{

        String sql = "update tin_tuyen_dung set ten_pb= ?, ten_vt=?, so_luong=?,"
                + " mo_ta=?, ngay_bd=?, ngay_kt=? where ma_tin=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tin.getTenPB());
        pstm.setString(2, tin.gettenVT());
        pstm.setInt(3, tin.getSoluong());
        pstm.setString(4, tin.getMota());
        pstm.setString(5, tin.getNgayBD());
        pstm.setString(6, tin.getNgayKT());
        pstm.setInt(7, tin.getMaTin());
        pstm.executeUpdate();
    }
    public static void deleteTinTuyenDung (Connection conn, TinTuyenDung tin) throws SQLException{

        String sql = "delete from tin_tuyen_dung where ma_tin=?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(8, tin.getMaTin());
        pstm.executeUpdate();
    }
    public static void changePassword(Connection conn, String maNV, String newPass) throws SQLException {
        String sql = "Update user_account set password=? where ma_nv=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, newPass);
        pstm.setString(2, maNV);
        pstm.executeUpdate();
    }
    public static HopDongLaoDong getHopDongLaoDong(Connection conn, int maHD) throws SQLException{

        String sql = "SELECT * FROM hopdong_laodong WHERE ma_hd=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, maHD);
        HopDongLaoDong hd = new HopDongLaoDong();
        
        ResultSet rs =  pstm.executeQuery();
        while (rs.next()){
            String maNV = rs.getString("ma_nv");
            String ngayKy = rs.getString("ngay_ky");
            String ngayHH = rs.getString("ngay_het_han");
            String url = rs.getString("link");
            hd = new HopDongLaoDong(maHD,maNV,ngayKy,ngayHH,url);
        }
        return hd;
    }
    public static List<HopDongLaoDong> getHopDongLaoDong(Connection conn, String maNV) throws SQLException{

        String sql = "SELECT ma_hd FROM hopdong_laodong WHERE ma_nv like '%"+maNV+"%'";
        PreparedStatement pstm = conn.prepareStatement(sql);
        List<HopDongLaoDong> list = new ArrayList<HopDongLaoDong>();
        ResultSet rs =  pstm.executeQuery();
        while (rs.next()){
            int maHD = rs.getInt("ma_hd");
            HopDongLaoDong hd = getHopDongLaoDong(conn,maHD);
            list.add(hd);
        }
        return list;
    }
    public static List<HopDongLaoDong> getHopDongLaoDong(Connection conn) throws SQLException {

        String sql = "SELECT * FROM hopdong_laodong order by ma_hd DESC";

        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<HopDongLaoDong> list = new ArrayList<HopDongLaoDong>();
        while (rs.next()){
            int maHD = rs.getInt("ma_hd");
            HopDongLaoDong hd = getHopDongLaoDong(conn, maHD);
            list.add(hd);
        }
        return list;
    }
    public static void insertHopDongLaoDong (Connection conn, HopDongLaoDong hd) throws SQLException{

        String sql = "insert into hopdong_laodong(ma_nv, ngay_ky, ngay_het_han, link)"
                + "values(?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, hd.getMaNV());
        pstm.setString(2, hd.getNgayKy());
        pstm.setString(3, hd.getNgayHetHan());
        pstm.setString(4, hd.getUrl());
        
        pstm.executeUpdate();

    }
    public static List<UserAccount> getUsersQuyenX(Connection conn, int quyen) throws SQLException {

        String sql = "SELECT ma_nv FROM user_account where quyen="+quyen;

        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()){
            String maNV = rs.getString("ma_nv");
            UserAccount user = findUser(conn, maNV);
            list.add(user);
        }
        return list;
    }
    public static List<UserAccount> getUsersPhongBanX(Connection conn, String tenPB) throws SQLException {

        String sql = "SELECT ma_nv FROM user_account where ten_pb=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tenPB);
        ResultSet rs = pstm.executeQuery();
        List<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()){
            String maNV = rs.getString("ma_nv");
            UserAccount user = findUser(conn, maNV);
            list.add(user);
        }
        return list;
    }
    public static List<UserAccount> getUsersTrinhDoX(Connection conn, int maTD) throws SQLException {
        
        
        String sql = "SELECT ma_nv FROM trinhdo_nv where ma_td="+maTD;

        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()){
            String maNV = rs.getString("ma_nv");
            UserAccount user = findUser(conn, maNV);
            list.add(user);
        }
        return list;
    }
    public static void changeQuyen(Connection conn, String maNV, int quyen) throws SQLException {
        String sql = "Update user_account set quyen=? where ma_nv=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, quyen);
        pstm.setString(2, maNV);
        pstm.executeUpdate();
    }
}
