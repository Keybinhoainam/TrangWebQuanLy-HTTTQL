package Nhom4.Responsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import Nhom4.Model.HoaDonBan;
import Nhom4.Model.SanPham;
import Nhom4.Model.ChiTietHoaDonBan;
import Nhom4.Model.DanhMucSanPham;
@Repository
public interface DanhMucSanPhamResponsitory extends JpaRepository<DanhMucSanPham, Long>{
	@Query("select c from DanhMucSanPham c where c.ten like %?1%")
	List<DanhMucSanPham> findByNameContaining(String name);
}
