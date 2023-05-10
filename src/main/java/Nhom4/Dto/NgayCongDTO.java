package Nhom4.Dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



public class NgayCongDTO {
	Long id;
	Date ngay;
	float heSo;
	Date gioKetThuc;
	Date gioBatDau;
	private LuongThangDTO luongThangDTO;
	public NgayCongDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public float getHeSo() {
		return heSo;
	}
	public void setHeSo(float heSo) {
		this.heSo = heSo;
	}
	public Date getGioKetThuc() {
		return gioKetThuc;
	}
	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	public Date getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(Date gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	public LuongThangDTO getLuongThang() {
		return luongThangDTO;
	}
	public void setLuongThang(LuongThangDTO luongThangDTO) {
		this.luongThangDTO = luongThangDTO;
	}
	
	
}
