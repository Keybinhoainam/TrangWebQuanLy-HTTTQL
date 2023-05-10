package Nhom4.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import Nhom4.Model.KhachHang;

public interface KhachHangService {
	<S extends KhachHang> List<S> findAll(Example<S> example, Sort sort);

	<S extends KhachHang> List<S> findAll(Example<S> example);

	void deleteAll();

	KhachHang getReferenceById(Long id);

	void deleteAll(Iterable<? extends KhachHang> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	KhachHang getById(Long id);

	void delete(KhachHang entity);

	KhachHang getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends KhachHang, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends KhachHang> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<KhachHang> entities);

	<S extends KhachHang> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(Iterable<KhachHang> entities);

	Optional<KhachHang> findById(Long id);

	<S extends KhachHang> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends KhachHang> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends KhachHang> S saveAndFlush(S entity);

	void flush();

	<S extends KhachHang> List<S> saveAll(Iterable<S> entities);

	List<KhachHang> findAllById(Iterable<Long> ids);

	List<KhachHang> findAll(Sort sort);

	Page<KhachHang> findAll(Pageable pageable);

	List<KhachHang> findAll();

	<S extends KhachHang> Optional<S> findOne(Example<S> example);

	<S extends KhachHang> S save(S entity);
}
