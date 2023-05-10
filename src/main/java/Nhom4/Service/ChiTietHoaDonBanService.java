package Nhom4.Service;

import java.util.List;

import Nhom4.Model.ChiTietHoaDonBan;

public interface ChiTietHoaDonBanService {
	ChiTietHoaDonBan getById(Long id);
	void deleteById(Long id);
	List<ChiTietHoaDonBan> findAll();
	<S extends ChiTietHoaDonBan> S save(S entity);
}
