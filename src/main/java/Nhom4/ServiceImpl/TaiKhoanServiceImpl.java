package Nhom4.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import Nhom4.Model.TaiKhoan;
import Nhom4.Responsitory.TaiKhoanRespository;
import Nhom4.Service.TaiKhoanService;
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
	@Autowired
	TaiKhoanRespository taiKhoanRespository;

	public TaiKhoanServiceImpl(TaiKhoanRespository taiKhoanRespository) {
		super();
		this.taiKhoanRespository = taiKhoanRespository;
	}

	@Override
	public <S extends TaiKhoan> S save(S entity) {
		return taiKhoanRespository.save(entity);
	}

	@Override
	public <S extends TaiKhoan> Optional<S> findOne(Example<S> example) {
		return taiKhoanRespository.findOne(example);
	}

	@Override
	public List<TaiKhoan> findAll() {
		return taiKhoanRespository.findAll();
	}

	@Override
	public Page<TaiKhoan> findAll(Pageable pageable) {
		return taiKhoanRespository.findAll(pageable);
	}

	@Override
	public List<TaiKhoan> findAll(Sort sort) {
		return taiKhoanRespository.findAll(sort);
	}

	@Override
	public List<TaiKhoan> findAllById(Iterable<String> ids) {
		return taiKhoanRespository.findAllById(ids);
	}

	@Override
	public <S extends TaiKhoan> List<S> saveAll(Iterable<S> entities) {
		return taiKhoanRespository.saveAll(entities);
	}

	@Override
	public void flush() {
		taiKhoanRespository.flush();
	}

	@Override
	public <S extends TaiKhoan> S saveAndFlush(S entity) {
		return taiKhoanRespository.saveAndFlush(entity);
	}

	@Override
	public <S extends TaiKhoan> List<S> saveAllAndFlush(Iterable<S> entities) {
		return taiKhoanRespository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends TaiKhoan> Page<S> findAll(Example<S> example, Pageable pageable) {
		return taiKhoanRespository.findAll(example, pageable);
	}

	@Override
	public Optional<TaiKhoan> findById(String id) {
		return taiKhoanRespository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<TaiKhoan> entities) {
		taiKhoanRespository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return taiKhoanRespository.existsById(id);
	}

	@Override
	public <S extends TaiKhoan> long count(Example<S> example) {
		return taiKhoanRespository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<TaiKhoan> entities) {
		taiKhoanRespository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends TaiKhoan> boolean exists(Example<S> example) {
		return taiKhoanRespository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		taiKhoanRespository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends TaiKhoan, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return taiKhoanRespository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return taiKhoanRespository.count();
	}

	@Override
	public void deleteAllInBatch() {
		taiKhoanRespository.deleteAllInBatch();
	}

	@Override
	public void deleteById(String id) {
		taiKhoanRespository.deleteById(id);
	}

	@Override
	public TaiKhoan getOne(String id) {
		return taiKhoanRespository.getOne(id);
	}

	@Override
	public void delete(TaiKhoan entity) {
		taiKhoanRespository.delete(entity);
	}

	@Override
	public TaiKhoan getById(String id) {
		return taiKhoanRespository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		taiKhoanRespository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends TaiKhoan> entities) {
		taiKhoanRespository.deleteAll(entities);
	}

	@Override
	public TaiKhoan getReferenceById(String id) {
		return taiKhoanRespository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		taiKhoanRespository.deleteAll();
	}

	@Override
	public <S extends TaiKhoan> List<S> findAll(Example<S> example) {
		return taiKhoanRespository.findAll(example);
	}

	@Override
	public <S extends TaiKhoan> List<S> findAll(Example<S> example, Sort sort) {
		return taiKhoanRespository.findAll(example, sort);
	}

	
	
}
