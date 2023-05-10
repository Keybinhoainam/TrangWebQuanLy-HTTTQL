package Nhom4.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class HoaDonNhap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String trangThai;
	@Temporal(TemporalType.DATE)
	Date ngayNhap;
	float tongTien;
	@ManyToOne
	@JoinColumn(name="nhanVienId")
	private NhanVien nhanVien;
	@ManyToOne
	@JoinColumn(name="nhaCungCapId")
	private NhaCungCap nhaCungCap;
	@OneToMany(mappedBy = "hoaDonNhap",cascade = CascadeType.ALL)
	private Set<ChiTietHDNhap> listChiTietHoaDonNhap;
	public HoaDonNhap() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public Set<ChiTietHDNhap> getListChiTietHoaDonNhap() {
		return listChiTietHoaDonNhap;
	}
	public void setListChiTietHoaDonNhap(Set<ChiTietHDNhap> listChiTietHoaDonNhap) {
		this.listChiTietHoaDonNhap = listChiTietHoaDonNhap;
	}
	
	
}
