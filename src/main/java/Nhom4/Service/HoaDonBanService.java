package Nhom4.Service;

import java.util.List;

import Nhom4.Model.HoaDonBan;

public interface HoaDonBanService {
	HoaDonBan getById(Long id);
	void deleteById(Long id);
	List<HoaDonBan> findAll();
	<S extends HoaDonBan> S save(S entity);
}
