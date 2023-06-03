package Nhom4.Dto;

public class DashboardNV {
	String tenNV;
	Float doanhThu;
	public DashboardNV() {
		super();
	}
	
	public DashboardNV(String tenNV, Float doanhThu) {
		super();
		this.tenNV = tenNV;
		this.doanhThu = doanhThu;
	}

	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Float getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(Float doanhThu) {
		this.doanhThu = doanhThu;
	}
	
}
