package Nhom4.Dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class NhaCungCapDTO {
	Long id;
	String ten;
	String sdt;
	String diaChi;
	private Set<HoaDonNhapDTO> listHoaDonNhap;
	public NhaCungCapDTO() {
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Set<HoaDonNhapDTO> getListHoaDonNhap() {
		return listHoaDonNhap;
	}
	public void setListHoaDonNhap(Set<HoaDonNhapDTO> listHoaDonNhap) {
		this.listHoaDonNhap = listHoaDonNhap;
	}
	
}
