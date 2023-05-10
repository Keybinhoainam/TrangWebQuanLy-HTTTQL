package Nhom4.Responsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Nhom4.Model.HoaDonBan;
import Nhom4.Model.NhanVien;
import Nhom4.Model.SanPham;
import Nhom4.Model.ChiTietHoaDonBan;
@Repository
public interface NhanVienResponsitory extends JpaRepository<NhanVien, Long>{
	@Query("select p from NhanVien p where p.ten like %?1%")
	List<NhanVien> findByNameContaining(String name);
}
