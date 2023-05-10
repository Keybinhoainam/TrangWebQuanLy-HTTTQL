package Nhom4.Dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class ThongBaoDTO {
	Long id;
	String noiDung;
	Date ngayGui;
	private KhachHangDTO khachHangDTO;
	public ThongBaoDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public Date getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}
	public KhachHangDTO getKhachHang() {
		return khachHangDTO;
	}
	public void setKhachHang(KhachHangDTO khachHangDTO) {
		this.khachHangDTO = khachHangDTO;
	}
	
}
