package Nhom4.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity 
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(columnDefinition = "nvarchar(100) not null")
	String ten;
	String hinhAnh;
	@Column(columnDefinition = "nvarchar(500)")
	String moTa;
	boolean baoHanh;
	int soLuong;
	float donGia;
	
	@OneToMany(mappedBy = "sanPham",cascade = CascadeType.ALL)
	private Set<ChiTietHDNhap> listHoaDonNhap;
	@OneToMany(mappedBy = "sanPham",cascade = CascadeType.ALL)
	private Set<ChiTietHoaDonBan> listChiTietHoaDonBan;
	@ManyToOne
	@JoinColumn(name="danhMucId")
	private DanhMucSanPham danhMucSanPham;
	public SanPham() {
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
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public boolean isBaoHanh() {
		return baoHanh;
	}
	public void setBaoHanh(boolean baoHanh) {
		this.baoHanh = baoHanh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public Set<ChiTietHDNhap> getListHoaDonNhap() {
		return listHoaDonNhap;
	}
	public void setListHoaDonNhap(Set<ChiTietHDNhap> listHoaDonNhap) {
		this.listHoaDonNhap = listHoaDonNhap;
	}
	public Set<ChiTietHoaDonBan> getListChiTietHoaDonBan() {
		return listChiTietHoaDonBan;
	}
	public void setListChiTietHoaDonBan(Set<ChiTietHoaDonBan> listChiTietHoaDonBan) {
		this.listChiTietHoaDonBan = listChiTietHoaDonBan;
	}
	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}
	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}
}
