package Nhom4.Responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Nhom4.Model.SanPham;
import Nhom4.Model.TaiKhoan;
@Repository
public interface TaiKhoanRespository extends JpaRepository<TaiKhoan, String>{
	@Query("select p from TaiKhoan p where p.nhanVien.id =?1")
	List<TaiKhoan> findByNhanVien(Long id);
}
