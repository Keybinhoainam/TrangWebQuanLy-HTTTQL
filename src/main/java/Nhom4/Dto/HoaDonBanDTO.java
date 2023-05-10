package Nhom4.Dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class HoaDonBanDTO {
	Long id;
	float tongTien;
	String trangThai;
	float discount;
	Date ngayBan;
	private NhanVienDTO nhanVienDTO;
	private KhachHangDTO khachHangDTO;
	private Set<chiTietHoaDonBanDTO> listChiTietHoaDonBan;
	public HoaDonBanDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Date getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	
	public NhanVienDTO getNhanVien() {
		return nhanVienDTO;
	}
	public void setNhanVien(NhanVienDTO nhanVienDTO) {
		this.nhanVienDTO = nhanVienDTO;
	}
	public KhachHangDTO getKhachHang() {
		return khachHangDTO;
	}
	public void setKhachHang(KhachHangDTO khachHangDTO) {
		this.khachHangDTO = khachHangDTO;
	}
	public Set<chiTietHoaDonBanDTO> getListChiTietHoaDonBan() {
		return listChiTietHoaDonBan;
	}
	public void setListChiTietHoaDonBan(Set<chiTietHoaDonBanDTO> listChiTietHoaDonBan) {
		this.listChiTietHoaDonBan = listChiTietHoaDonBan;
	}
	
}
