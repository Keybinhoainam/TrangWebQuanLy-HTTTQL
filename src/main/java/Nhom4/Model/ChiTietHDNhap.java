package Nhom4.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class ChiTietHDNhap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	int soLuong;
	float donGiaNhap;
	@ManyToOne
	@JoinColumn(name="hoaDonNhapId")
	private HoaDonNhap hoaDonNhap;
	@ManyToOne
	@JoinColumn(name="sanPhamId")
	private SanPham sanPham;
	public ChiTietHDNhap() {
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
	public HoaDonNhap getHoaDonNhap() {
		return hoaDonNhap;
	}
	public void setHoaDonNhap(HoaDonNhap hoaDonNhap) {
		this.hoaDonNhap = hoaDonNhap;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	
}
