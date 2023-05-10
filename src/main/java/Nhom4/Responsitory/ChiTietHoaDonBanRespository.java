package Nhom4.Responsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Nhom4.Model.HoaDonBan;
import Nhom4.Model.ChiTietHoaDonBan;
@Repository
public interface ChiTietHoaDonBanRespository extends JpaRepository<ChiTietHoaDonBan, Long>{
	@Query("Select a from ChiTietHoaDonBan a where a.hoaDonBan.id = ?1")
    List<ChiTietHoaDonBan> findByHoadonban(Long id);
}
