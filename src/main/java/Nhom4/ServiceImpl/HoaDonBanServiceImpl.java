package Nhom4.ServiceImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nhom4.Model.HoaDonBan;
import Nhom4.Model.NhanVien;
import Nhom4.Responsitory.HoaDonBanRespository;
import Nhom4.Service.HoaDonBanService;

@Service
public class HoaDonBanServiceImpl implements HoaDonBanService{

	@Autowired
	HoaDonBanRespository hoaDonBanRepository;
	
	
	@Override
	public Float getDoanhThuByNhanVien(NhanVien nv) {
		List<HoaDonBan> list= hoaDonBanRepository.findByNhanVien(nv.getId());
		Float tong=(float) 0;
		for(HoaDonBan hdb : list) {
			tong+=hdb.getTongTien();
		}
		return tong;
	}
	@Override
	public Float getDoanhThuByNhanVienDay(NhanVien nv,Date from,Date to) {
		List<HoaDonBan> list= hoaDonBanRepository.findByNhanVienDay(nv.getId(),from,to);
		Float tong=(float) 0;
		for(HoaDonBan hdb : list) {
			tong+=hdb.getTongTien();
		}
		return tong;
	}
	@Override
	public HoaDonBan getById(Long id) {
		return hoaDonBanRepository.getById(id);
	}

	@Override
	public void deleteById(Long id) {
		hoaDonBanRepository.deleteById(id);
	}

	@Override
	public List<HoaDonBan> findAll() {
		return hoaDonBanRepository.findAll();
	}

	@Override
	public <S extends HoaDonBan> S save(S entity) {
		// TODO Auto-generated method stub
		return hoaDonBanRepository.save(entity);
	}

}
