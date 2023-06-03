package Nhom4.Service;

import java.util.Date;
import java.util.List;

import Nhom4.Model.HoaDonBan;
import Nhom4.Model.NhanVien;

public interface HoaDonBanService {
	HoaDonBan getById(Long id);
	void deleteById(Long id);
	List<HoaDonBan> findAll();
	<S extends HoaDonBan> S save(S entity);
	Float getDoanhThuByNhanVien(NhanVien nv);
	Float getDoanhThuByNhanVienDay(NhanVien nv, Date from, Date to);
}
