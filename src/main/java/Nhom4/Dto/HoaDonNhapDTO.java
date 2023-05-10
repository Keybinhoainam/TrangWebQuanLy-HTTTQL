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

public class HoaDonNhapDTO {
	Long id;
	String trangThai;
	Date ngayNhap;
	float tongTien;
	private NhanVienDTO nhanVienDTO;
	private NhaCungCapDTO nhaCungCapDTO;
	private Set<ChiTietHDNhapDTO> listChiTietHoaDonNhap;
	public HoaDonNhapDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
	public NhanVienDTO getNhanVien() {
		return nhanVienDTO;
	}
	public void setNhanVien(NhanVienDTO nhanVienDTO) {
		this.nhanVienDTO = nhanVienDTO;
	}
	public NhaCungCapDTO getNhaCungCap() {
		return nhaCungCapDTO;
	}
	public void setNhaCungCap(NhaCungCapDTO nhaCungCapDTO) {
		this.nhaCungCapDTO = nhaCungCapDTO;
	}
	public Set<ChiTietHDNhapDTO> getListChiTietHoaDonNhap() {
		return listChiTietHoaDonNhap;
	}
	public void setListChiTietHoaDonNhap(Set<ChiTietHDNhapDTO> listChiTietHoaDonNhap) {
		this.listChiTietHoaDonNhap = listChiTietHoaDonNhap;
	}
	
	
}
