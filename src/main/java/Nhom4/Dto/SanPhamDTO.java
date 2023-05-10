package Nhom4.Dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;


public class SanPhamDTO {
	Long id;
	String ten;
	String hinhAnh;
	String moTa;
	boolean baoHanh;
	int soLuong;
	float donGia;
	private Set<ChiTietHDNhapDTO> listHoaDonNhap;
	private Set<chiTietHoaDonBanDTO> listChiTietHoaDonBan;
	
	private Long danhMucSanPhamId;
	Boolean isEdit=false;
	private MultipartFile imageFile;
	public SanPhamDTO() {
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
	public Set<ChiTietHDNhapDTO> getListHoaDonNhap() {
		return listHoaDonNhap;
	}
	public void setListHoaDonNhap(Set<ChiTietHDNhapDTO> listHoaDonNhap) {
		this.listHoaDonNhap = listHoaDonNhap;
	}
	public Set<chiTietHoaDonBanDTO> getListChiTietHoaDonBan() {
		return listChiTietHoaDonBan;
	}
	public void setListChiTietHoaDonBan(Set<chiTietHoaDonBanDTO> listChiTietHoaDonBan) {
		this.listChiTietHoaDonBan = listChiTietHoaDonBan;
	}
	public Long getDanhMucSanPhamId() {
		return danhMucSanPhamId;
	}
	public void setDanhMucSanPhamId(Long danhMucSanPhamId) {
		this.danhMucSanPhamId = danhMucSanPhamId;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
	
}
