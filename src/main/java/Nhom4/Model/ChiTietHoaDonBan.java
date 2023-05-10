package Nhom4.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class ChiTietHoaDonBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	int soLuong;
	@ManyToOne
	@JoinColumn(name="hoaDonBanId")
	private HoaDonBan hoaDonBan;
	@ManyToOne
	@JoinColumn(name="sanPhamId")
	private SanPham sanPham;
	public ChiTietHoaDonBan() {
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
	public HoaDonBan getHoaDonBan() {
		return hoaDonBan;
	}
	public void setHoaDonBan(HoaDonBan hoaDonBan) {
		this.hoaDonBan = hoaDonBan;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	
}
