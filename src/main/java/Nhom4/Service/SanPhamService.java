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

import Nhom4.Model.SanPham;
import Nhom4.Model.TaiKhoan;
import Nhom4.Responsitory.TaiKhoanRespository;

public interface SanPhamService {

	<S extends SanPham> List<S> findAll(Example<S> example, Sort sort);

	<S extends SanPham> List<S> findAll(Example<S> example);

	void deleteAll();

	SanPham getReferenceById(Long id);

	void deleteAll(Iterable<? extends SanPham> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	SanPham getById(Long id);

	void delete(SanPham entity);

	SanPham getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends SanPham, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends SanPham> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<SanPham> entities);

	<S extends SanPham> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(Iterable<SanPham> entities);

	Optional<SanPham> findById(Long id);

	<S extends SanPham> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends SanPham> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends SanPham> S saveAndFlush(S entity);

	void flush();

	<S extends SanPham> List<S> saveAll(Iterable<S> entities);

	List<SanPham> findAllById(Iterable<Long> ids);

	List<SanPham> findAll(Sort sort);

	Page<SanPham> findAll(Pageable pageable);

	List<SanPham> findAll();

	<S extends SanPham> Optional<S> findOne(Example<S> example);

	<S extends SanPham> S save(S entity);

	List<SanPham> findByNameContaining(String name);

	List<SanPham> findProductOutStock();

	List<SanPham> findProductInStock();

	


}
