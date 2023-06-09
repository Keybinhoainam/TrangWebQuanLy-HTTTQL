package Nhom4.Responsitory;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Nhom4.Model.HoaDonBan;
@Repository
public interface HoaDonBanRespository extends JpaRepository<HoaDonBan, Long> {
	@Query("Select a from HoaDonBan a where a.ngayBan = ?1")
    List<HoaDonBan> findByDate(Date ngayBan);
	@Query("Select a from HoaDonBan a where a.ngayBan >= ?1 and a.ngayBan < ?2")
	List<HoaDonBan> findByMonth(Date start,Date end);
	@Query("Select a from HoaDonBan a where a.nhanVien.id = ?1")
	List<HoaDonBan> findByNhanVien(Long id);
	@Query("Select a from HoaDonBan a where a.ngayBan >= ?1 and a.ngayBan <= ?2")
	List<HoaDonBan> findByNgayBan(Date start,Date end);
	@Query("Select a from HoaDonBan a where a.nhanVien.id = ?1 and a.ngayBan >= ?2 and a.ngayBan <= ?3")
	List<HoaDonBan> findByNhanVienDay(Long id, Date from, Date to);
	@Query("Select a from HoaDonBan a ORDER BY a.ngayBan DESC")
    List<HoaDonBan> findAllDesc();
}
