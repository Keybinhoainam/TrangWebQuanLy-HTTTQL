package Nhom4.Dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


public class LuongThangDTO {
	Long id;
	int thang;
	int nam;
	float thuong;
	float tongLuong;
	private Set<NgayCongDTO> listNgayCong;
	private NhanVienDTO nhanVienDTO;
	public LuongThangDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public float getThuong() {
		return thuong;
	}
	public void setThuong(float thuong) {
		this.thuong = thuong;
	}
	public float getTongLuong() {
		return tongLuong;
	}
	public void setTongLuong(float tongLuong) {
		this.tongLuong = tongLuong;
	}
	public Set<NgayCongDTO> getListNgayCong() {
		return listNgayCong;
	}
	public void setListNgayCong(Set<NgayCongDTO> listNgayCong) {
		this.listNgayCong = listNgayCong;
	}
	public NhanVienDTO getNhanVien() {
		return nhanVienDTO;
	}
	public void setNhanVien(NhanVienDTO nhanVienDTO) {
		this.nhanVienDTO = nhanVienDTO;
	}
	
}
