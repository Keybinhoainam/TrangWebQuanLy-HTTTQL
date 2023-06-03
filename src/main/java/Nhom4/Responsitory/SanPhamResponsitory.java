package Nhom4.Responsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Nhom4.Model.HoaDonBan;
import Nhom4.Model.SanPham;
import Nhom4.Model.ChiTietHoaDonBan;
@Repository
public interface SanPhamResponsitory extends JpaRepository<SanPham, Long>{
	@Query("select p from SanPham p where p.ten like %?1%")
	List<SanPham> findByNameContaining(String name);
	@Query("select p from SanPham p where p.soLuong > 0")
	List<SanPham> findProductInStock();
	@Query("select p from SanPham p where p.soLuong <= 0")
	List<SanPham> findProductOutStock();
	
}
