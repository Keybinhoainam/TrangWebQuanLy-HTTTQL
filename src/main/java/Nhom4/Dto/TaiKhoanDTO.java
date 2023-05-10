package Nhom4.Dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


public class TaiKhoanDTO {
	
	String userName;
	String password;
	String confirmPassword;
	String vaiTro;
	NhanVienDTO nhanVienDTO;
	public TaiKhoanDTO() {
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
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	public NhanVienDTO getNhanVien() {
		return nhanVienDTO;
	}
	public void setNhanVien(NhanVienDTO nhanVienDTO) {
		this.nhanVienDTO = nhanVienDTO;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public NhanVienDTO getNhanVienDTO() {
		return nhanVienDTO;
	}
	public void setNhanVienDTO(NhanVienDTO nhanVienDTO) {
		this.nhanVienDTO = nhanVienDTO;
	}
	
}
