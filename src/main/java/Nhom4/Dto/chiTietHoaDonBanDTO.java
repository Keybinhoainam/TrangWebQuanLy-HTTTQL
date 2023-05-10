package Nhom4.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




public class chiTietHoaDonBanDTO {
	Long id;
	int soLuong;
	private HoaDonBanDTO hoaDonBanDTO;
	private SanPhamDTO sanPhamDTO;
	public chiTietHoaDonBanDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public HoaDonBanDTO getHoaDonBan() {
		return hoaDonBanDTO;
	}
	public void setHoaDonBan(HoaDonBanDTO hoaDonBanDTO) {
		this.hoaDonBanDTO = hoaDonBanDTO;
	}
	public SanPhamDTO getSanPham() {
		return sanPhamDTO;
	}
	public void setSanPham(SanPhamDTO sanPhamDTO) {
		this.sanPhamDTO = sanPhamDTO;
	}
	
	
}
