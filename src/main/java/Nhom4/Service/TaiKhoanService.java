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

import Nhom4.Model.TaiKhoan;
import Nhom4.Responsitory.TaiKhoanRespository;

public interface TaiKhoanService {

	<S extends TaiKhoan> List<S> findAll(Example<S> example, Sort sort);

	<S extends TaiKhoan> List<S> findAll(Example<S> example);

	void deleteAll();

	TaiKhoan getReferenceById(String id);

	void deleteAll(Iterable<? extends TaiKhoan> entities);

	void deleteAllById(Iterable<? extends String> ids);

	TaiKhoan getById(String id);

	void delete(TaiKhoan entity);

	TaiKhoan getOne(String id);

	void deleteById(String id);

	void deleteAllInBatch();

	long count();

	<S extends TaiKhoan, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<String> ids);

	<S extends TaiKhoan> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<TaiKhoan> entities);

	<S extends TaiKhoan> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(Iterable<TaiKhoan> entities);

	Optional<TaiKhoan> findById(String id);

	<S extends TaiKhoan> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends TaiKhoan> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends TaiKhoan> S saveAndFlush(S entity);

	void flush();

	<S extends TaiKhoan> List<S> saveAll(Iterable<S> entities);

	List<TaiKhoan> findAllById(Iterable<String> ids);

	List<TaiKhoan> findAll(Sort sort);

	Page<TaiKhoan> findAll(Pageable pageable);

	List<TaiKhoan> findAll();

	<S extends TaiKhoan> Optional<S> findOne(Example<S> example);

	<S extends TaiKhoan> S save(S entity);

	

	


}
