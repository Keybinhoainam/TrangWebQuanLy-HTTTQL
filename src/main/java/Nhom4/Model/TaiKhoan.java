package Nhom4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TaiKhoan {
	@Id
	String userName;
	String password;
	Boolean vaiTro;
	@ManyToOne
	@JoinColumn(name="nhanVienId")
	private NhanVien nhanVien;
	public TaiKhoan() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(Boolean vaiTro) {
		this.vaiTro = vaiTro;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
