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

import Nhom4.Model.KhachHang;
import Nhom4.Responsitory.KhachHangRespository;
import Nhom4.Service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{

	@Autowired
	KhachHangRespository khachHangRespository;
	
	@Override
	public <S extends KhachHang> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return khachHangRespository.findAll(example, sort);
	}

	@Override
	public <S extends KhachHang> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return khachHangRespository.findAll(example);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		khachHangRespository.deleteAll();
	}

	@Override
	public KhachHang getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return khachHangRespository.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends KhachHang> entities) {
		// TODO Auto-generated method stub
		khachHangRespository.deleteAll(entities);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		khachHangRespository.deleteAllById(ids);
	}

	@Override
	public KhachHang getById(Long id) {
		// TODO Auto-generated method stub
		return khachHangRespository.getById(id);
	}

	@Override
	public void delete(KhachHang entity) {
		// TODO Auto-generated method stub
		khachHangRespository.delete(entity);
	}

	@Override
	public KhachHang getOne(Long id) {
		// TODO Auto-generated method stub
		return khachHangRespository.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		khachHangRespository.deleteById(id);
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		khachHangRespository.deleteAllByIdInBatch(null);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return khachHangRespository.count();
	}

	@Override
	public <S extends KhachHang, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return khachHangRespository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		khachHangRespository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends KhachHang> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return khachHangRespository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<KhachHang> entities) {
		// TODO Auto-generated method stub
		khachHangRespository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends KhachHang> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return khachHangRespository.count();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return khachHangRespository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<KhachHang> entities) {
		// TODO Auto-generated method stub
		khachHangRespository.deleteInBatch(entities);
	}

	@Override
	public Optional<KhachHang> findById(Long id) {
		// TODO Auto-generated method stub
		return khachHangRespository.findById(id);
	}

	@Override
	public <S extends KhachHang> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return khachHangRespository.findAll(example, pageable);
	}

	@Override
	public <S extends KhachHang> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return khachHangRespository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends KhachHang> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return khachHangRespository.saveAndFlush(entity);
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		khachHangRespository.flush();
	}

	@Override
	public <S extends KhachHang> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return khachHangRespository.saveAll(entities);
	}

	@Override
	public List<KhachHang> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return khachHangRespository.findAllById(ids);
	}

	@Override
	public List<KhachHang> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return khachHangRespository.findAll(sort);
	}

	@Override
	public Page<KhachHang> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return khachHangRespository.findAll(pageable);
	}

	@Override
	public List<KhachHang> findAll() {
		// TODO Auto-generated method stub
		return khachHangRespository.findAll();
	}

	@Override
	public <S extends KhachHang> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return khachHangRespository.findOne(example);
	}

	@Override
	public <S extends KhachHang> S save(S entity) {
		// TODO Auto-generated method stub
		return khachHangRespository.save(entity);
	}

}
