package Nhom4.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import Nhom4.Model.NhanVien;
import Nhom4.Model.SanPham;
import Nhom4.Model.TaiKhoan;
import Nhom4.Responsitory.TaiKhoanRespository;

public interface NhanVienService {

	<S extends NhanVien> List<S> findAll(Example<S> example, Sort sort);

	<S extends NhanVien> List<S> findAll(Example<S> example);

	void deleteAll();

	NhanVien getReferenceById(Long id);

	void deleteAll(Iterable<? extends NhanVien> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	NhanVien getById(Long id);

	void delete(NhanVien entity);

	NhanVien getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends NhanVien, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends NhanVien> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<NhanVien> entities);

	<S extends NhanVien> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(Iterable<NhanVien> entities);

	Optional<NhanVien> findById(Long id);

	<S extends NhanVien> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends NhanVien> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends NhanVien> S saveAndFlush(S entity);

	void flush();

	<S extends NhanVien> List<S> saveAll(Iterable<S> entities);

	List<NhanVien> findAllById(Iterable<Long> ids);

	List<NhanVien> findAll(Sort sort);

	Page<NhanVien> findAll(Pageable pageable);

	List<NhanVien> findAll();

	<S extends NhanVien> Optional<S> findOne(Example<S> example);

	<S extends NhanVien> S save(S entity);

	List<NhanVien> findByNameContaining(String name);

	

	


}
