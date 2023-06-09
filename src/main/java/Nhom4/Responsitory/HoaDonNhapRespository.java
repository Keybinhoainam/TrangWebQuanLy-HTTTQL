package Nhom4.Responsitory;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Nhom4.Model.HoaDonBan;
import Nhom4.Model.HoaDonNhap;
@Repository
public interface HoaDonNhapRespository extends JpaRepository<HoaDonNhap, Long> {
	@Query("Select a from HoaDonNhap a where a.ngayNhap = ?1")
    List<HoaDonNhap> findByDate(Date ngayNhap);
	@Query("Select a from HoaDonNhap a ORDER BY a.ngayNhap DESC")
    List<HoaDonNhap> findAllDesc();
}
