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

import Nhom4.Model.DanhMucSanPham;
import Nhom4.Model.SanPham;
import Nhom4.Model.TaiKhoan;
import Nhom4.Responsitory.TaiKhoanRespository;

public interface DanhMucSanPhamService {

	<S extends DanhMucSanPham> List<S> findAll(Example<S> example, Sort sort);

	<S extends DanhMucSanPham> List<S> findAll(Example<S> example);

	void deleteAll();

	DanhMucSanPham getReferenceById(Long id);

	void deleteAll(Iterable<? extends DanhMucSanPham> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	DanhMucSanPham getById(Long id);

	void delete(DanhMucSanPham entity);

	DanhMucSanPham getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends DanhMucSanPham, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends DanhMucSanPham> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<DanhMucSanPham> entities);

	<S extends DanhMucSanPham> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(Iterable<DanhMucSanPham> entities);

	Optional<DanhMucSanPham> findById(Long id);

	<S extends DanhMucSanPham> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends DanhMucSanPham> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends DanhMucSanPham> S saveAndFlush(S entity);

	void flush();

	<S extends DanhMucSanPham> List<S> saveAll(Iterable<S> entities);

	List<DanhMucSanPham> findAllById(Iterable<Long> ids);

	List<DanhMucSanPham> findAll(Sort sort);

	Page<DanhMucSanPham> findAll(Pageable pageable);

	List<DanhMucSanPham> findAll();

	<S extends DanhMucSanPham> Optional<S> findOne(Example<S> example);

	<S extends DanhMucSanPham> S save(S entity);

	List<DanhMucSanPham> findByNameContaining(String name);

	
	


}
