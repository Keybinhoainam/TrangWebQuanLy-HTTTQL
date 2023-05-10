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
public class HoaDonBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	float tongTien;
	String trangThai;
	float discount;
	@Temporal(TemporalType.DATE)
	Date ngayBan;
	
	@ManyToOne
	@JoinColumn(name="nhanVienId")
	private NhanVien nhanVien;
	@ManyToOne
	@JoinColumn(name="khachHangId")
	private KhachHang khachHang;
	@OneToMany(mappedBy = "hoaDonBan",cascade = CascadeType.ALL)
	private Set<ChiTietHoaDonBan> listChiTietHoaDonBan;
	public HoaDonBan() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Date getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(Date ngayBan) {
		this.ngayBan = ngayBan;
	}
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public Set<ChiTietHoaDonBan> getListChiTietHoaDonBan() {
		return listChiTietHoaDonBan;
	}
	public void setListChiTietHoaDonBan(Set<ChiTietHoaDonBan> listChiTietHoaDonBan) {
		this.listChiTietHoaDonBan = listChiTietHoaDonBan;
	}
	
}
