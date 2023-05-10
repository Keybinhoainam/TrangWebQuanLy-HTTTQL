package Nhom4.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




public class ChiTietHDNhapDTO {
	
	Long id;
	int soLuong;
	float donGiaNhap;
	private HoaDonNhapDTO hoaDonNhapDTO;
	private SanPhamDTO sanPhamDTO;
	public ChiTietHDNhapDTO() {
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
	public float getDonGiaNhap() {
		return donGiaNhap;
	}
	public void setDonGiaNhap(float donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}
	public HoaDonNhapDTO getHoaDonNhap() {
		return hoaDonNhapDTO;
	}
	public void setHoaDonNhap(HoaDonNhapDTO hoaDonNhapDTO) {
		this.hoaDonNhapDTO = hoaDonNhapDTO;
	}
	public SanPhamDTO getSanPham() {
		return sanPhamDTO;
	}
	public void setSanPham(SanPhamDTO sanPhamDTO) {
		this.sanPhamDTO = sanPhamDTO;
	}
	
	
}
