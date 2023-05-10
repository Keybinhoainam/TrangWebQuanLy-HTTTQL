package Nhom4.Responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Nhom4.Model.TaiKhoan;
@Repository
public interface TaiKhoanRespository extends JpaRepository<TaiKhoan, String>{

}
