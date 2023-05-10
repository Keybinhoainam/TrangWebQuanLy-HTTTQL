package Nhom4.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String ten;
	String sdt;
	boolean gioiTinh;
	String email;
	String diaChi;
	@Temporal(TemporalType.DATE)
	Date ngaySinh;
	@OneToMany(mappedBy = "khachHang",cascade = CascadeType.ALL)
	private Set<ThongBao> listThongBao;
	@OneToMany(mappedBy = "khachHang",cascade = CascadeType.ALL)
	private Set<HoaDonBan> listHoaDonBan ;
	public KhachHang() {
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Set<ThongBao> getListThongBao() {
		return listThongBao;
	}
	public void setListThongBao(Set<ThongBao> listThongBao) {
		this.listThongBao = listThongBao;
	}
	public Set<HoaDonBan> getListHoaDonBan() {
		return listHoaDonBan;
	}
	public void setListHoaDonBan(Set<HoaDonBan> listHoaDonBan) {
		this.listHoaDonBan = listHoaDonBan;
	}
	
	
}
