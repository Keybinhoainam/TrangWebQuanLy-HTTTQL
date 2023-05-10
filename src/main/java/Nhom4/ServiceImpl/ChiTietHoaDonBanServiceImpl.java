package Nhom4.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nhom4.Model.ChiTietHoaDonBan;
import Nhom4.Responsitory.ChiTietHoaDonBanRespository;
import Nhom4.Service.ChiTietHoaDonBanService;

@Service
public class ChiTietHoaDonBanServiceImpl implements ChiTietHoaDonBanService{

	@Autowired
	ChiTietHoaDonBanRespository chiTietHoaDonBanRepository;
	
	@Override
	public ChiTietHoaDonBan getById(Long id) {
		// TODO Auto-generated method stub
		return chiTietHoaDonBanRepository.getById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		chiTietHoaDonBanRepository.deleteById(id);
	}

	@Override
	public List<ChiTietHoaDonBan> findAll() {
		// TODO Auto-generated method stub
		return chiTietHoaDonBanRepository.findAll();
	}

	@Override
	public <S extends ChiTietHoaDonBan> S save(S entity) {
		// TODO Auto-generated method stub
		return chiTietHoaDonBanRepository.save(entity);
	}

}
