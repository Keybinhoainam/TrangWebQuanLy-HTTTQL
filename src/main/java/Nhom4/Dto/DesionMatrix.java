package Nhom4.Dto;

import java.util.Date;

public class DesionMatrix {
	String ten;
	String loai;
	String thoiGianRaMat;
	int soLuongBan;
	int soLuongTonKho;
	Long gtTG;
	Double gtsales;
	Double gtTonKho;
	

	public String getThoiGianRaMat() {
		return thoiGianRaMat;
	}

	public void setThoiGianRaMat(String thoiGianRaMat) {
		this.thoiGianRaMat = thoiGianRaMat;
	}

	public int getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}

	public DesionMatrix() {
		super();
	}

	public DesionMatrix(String ten, String loai, String thoiGianRaMat, int soLuongBan, int soLuongTonKho) {
		super();
		this.ten = ten;
		this.loai = loai;
		this.thoiGianRaMat = thoiGianRaMat;
		this.soLuongBan = soLuongBan;
		this.soLuongTonKho = soLuongTonKho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public DesionMatrix(String ten, String loai, String thoiGianRaMat, int soLuongBan, int soLuongTonKho, Long gtTG,
			Double gtsales, Double gtTonKho) {
		super();
		this.ten = ten;
		this.loai = loai;
		this.thoiGianRaMat = thoiGianRaMat;
		this.soLuongBan = soLuongBan;
		this.soLuongTonKho = soLuongTonKho;
		this.gtTG = gtTG;
		this.gtsales = gtsales;
		this.gtTonKho = gtTonKho;
	}

	public Long getGtTG() {
		return gtTG;
	}

	public void setGtTG(Long gtTG) {
		this.gtTG = gtTG;
	}

	public Double getGtsales() {
		return gtsales;
	}

	public void setGtsales(Double gtsales) {
		this.gtsales = gtsales;
	}

	public Double getGtTonKho() {
		return gtTonKho;
	}

	public void setGtTonKho(Double gtTonKho) {
		this.gtTonKho = gtTonKho;
	}

	
	
	
	
}
