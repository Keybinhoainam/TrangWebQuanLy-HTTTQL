package Nhom4.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Boolean gioiTinh;
	@Column(columnDefinition = "nvarchar(100) not null")
	String ten;
	@Temporal(TemporalType.DATE)
	Date ngaySinh;
	String hinhAnh;
	String sdt;
	@Column(columnDefinition = "nvarchar(100) not null")
	String diaChi;
	String role;
	String about;
	@OneToMany(mappedBy = "nhanVien",cascade = CascadeType.ALL)
	private Set<TaiKhoan> taiKhoan;
	@OneToMany(mappedBy = "nhanVien",cascade = CascadeType.ALL)
	private Set<LuongThang> listLuongThang;
	@OneToMany(mappedBy = "nhanVien",cascade = CascadeType.ALL)
	private Set<HoaDonNhap> listHoaDonNhap;
	@OneToMany(mappedBy = "nhanVien",cascade = CascadeType.ALL)
	private Set<HoaDonBan> listHoaDonBan;
	public NhanVien() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@JsonIgnore
	public Set<TaiKhoan> getTaiKhoan() {
		return taiKhoan;
	}
	@JsonIgnore
	public void setTaiKhoan(Set<TaiKhoan> taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	@JsonIgnore
	public Set<LuongThang> getListLuongThang() {
		return listLuongThang;
	}
	@JsonIgnore
	public void setListLuongThang(Set<LuongThang> listLuongThang) {
		this.listLuongThang = listLuongThang;
	}
	@JsonIgnore
	public Set<HoaDonNhap> getListHoaDonNhap() {
		return listHoaDonNhap;
	}
	@JsonIgnore
	public void setListHoaDonNhap(Set<HoaDonNhap> listHoaDonNhap) {
		this.listHoaDonNhap = listHoaDonNhap;
	}
	@JsonIgnore
	public Set<HoaDonBan> getListHoaDonBan() {
		return listHoaDonBan;
	}
	@JsonIgnore
	public void setListHoaDonBan(Set<HoaDonBan> listHoaDonBan) {
		this.listHoaDonBan = listHoaDonBan;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	
	
}
