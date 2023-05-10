package Nhom4.Dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class KhachHangDTO {
	Long id;
	String ten;
	String sdt;
	boolean gioiTinh;
	String email;
	String diaChi;
	String ngaySinh;
	private Set<ThongBaoDTO> listThongBao;
	private Set<HoaDonBanDTO> listHoaDonBan ;
	public KhachHangDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Set<ThongBaoDTO> getListThongBao() {
		return listThongBao;
	}
	public void setListThongBao(Set<ThongBaoDTO> listThongBao) {
		this.listThongBao = listThongBao;
	}
	public Set<HoaDonBanDTO> getListHoaDonBan() {
		return listHoaDonBan;
	}
	public void setListHoaDonBan(Set<HoaDonBanDTO> listHoaDonBan) {
		this.listHoaDonBan = listHoaDonBan;
	}
	
	
}
