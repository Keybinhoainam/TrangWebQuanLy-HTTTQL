package Nhom4.Responsitory;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Nhom4.Model.HoaDonBan;
import Nhom4.Model.ChiTietHDNhap;
import Nhom4.Model.ChiTietHoaDonBan;
@Repository
public interface ChiTietHoaDonNhapRespository extends JpaRepository<ChiTietHDNhap, Long>{
	@Query("Select a from ChiTietHDNhap a where a.hoaDonNhap.id = ?1")
    List<ChiTietHDNhap> findByHoadonnhap(Long id);
	@Query("select p from ChiTietHDNhap p where p.sanPham.id = ?1 and p.hoaDonNhap.id = ?2")
	Optional<ChiTietHDNhap> findBySanPhamHoaDonNhap(Long id,Long id2);
	@Query("select p from ChiTietHDNhap p where p.sanPham.id = ?1")
	List<ChiTietHDNhap> findBySanPham(Long id);
}
