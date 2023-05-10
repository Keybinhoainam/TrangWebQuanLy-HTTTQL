package Nhom4.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="NgayCong")
public class NgayCong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Temporal(TemporalType.DATE)
	Date ngay;
	float heSo;
	@Temporal(TemporalType.DATE)
	Date gioKetThuc;
	@Temporal(TemporalType.DATE)
	Date gioBatDau;
	@ManyToOne
	@JoinColumn(name="luongThangId")
	private LuongThang luongThang;
	public NgayCong() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public float getHeSo() {
		return heSo;
	}
	public void setHeSo(float heSo) {
		this.heSo = heSo;
	}
	public Date getGioKetThuc() {
		return gioKetThuc;
	}
	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	public Date getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(Date gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	public LuongThang getLuongThang() {
		return luongThang;
	}
	public void setLuongThang(LuongThang luongThang) {
		this.luongThang = luongThang;
	}
	
	
}
