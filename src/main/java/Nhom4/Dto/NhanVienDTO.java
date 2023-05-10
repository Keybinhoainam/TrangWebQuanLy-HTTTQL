package Nhom4.Dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class NhanVienDTO {
	Long id;
	Boolean gioiTinh;
	String ten;
	String ngaySinh;
	String sdt;
	String diaChi;
	String role;
	String about;
	Boolean isEdit=false;
	private Set<LuongThangDTO> listLuongThang;
	private Set<HoaDonNhapDTO> listHoaDonNhap;
	private Set<HoaDonBanDTO> listHoaDonBan;
	public NhanVienDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Set<LuongThangDTO> getListLuongThang() {
		return listLuongThang;
	}
	public void setListLuongThang(Set<LuongThangDTO> listLuongThang) {
		this.listLuongThang = listLuongThang;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Set<HoaDonNhapDTO> getListHoaDonNhap() {
		return listHoaDonNhap;
	}
	public void setListHoaDonNhap(Set<HoaDonNhapDTO> listHoaDonNhap) {
		this.listHoaDonNhap = listHoaDonNhap;
	}
	public Set<HoaDonBanDTO> getListHoaDonBan() {
		return listHoaDonBan;
	}
	public void setListHoaDonBan(Set<HoaDonBanDTO> listHoaDonBan) {
		this.listHoaDonBan = listHoaDonBan;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	
	
	
}
