package Nhom4.ServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import Nhom4.Dto.ItemReport;
import Nhom4.Model.ChiTietHDNhap;
import Nhom4.Model.ChiTietHoaDonBan;
import Nhom4.Model.DanhMucSanPham;
import Nhom4.Model.HoaDonBan;
import Nhom4.Model.HoaDonNhap;
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.ChiTietHoaDonBanRespository;
import Nhom4.Responsitory.ChiTietHoaDonNhapRespository;
import Nhom4.Responsitory.DanhMucSanPhamResponsitory;
import Nhom4.Responsitory.HoaDonBanRespository;
import Nhom4.Responsitory.HoaDonNhapRespository;
import Nhom4.Responsitory.SanPhamResponsitory;
import Nhom4.Service.DanhMucSanPhamService;
import Nhom4.Service.ReportService;
import Nhom4.Service.SanPhamService;
@Service
public class DanhMucSanPhamServiceImpl implements DanhMucSanPhamService{
	
	@Autowired
	DanhMucSanPhamResponsitory danhMucSanPhamResponsitory;

	public DanhMucSanPhamServiceImpl() {
		super();
	}

	@Override
	public <S extends DanhMucSanPham> S save(S entity) {
		return danhMucSanPhamResponsitory.save(entity);
	}

	@Override
	public <S extends DanhMucSanPham> Optional<S> findOne(Example<S> example) {
		return danhMucSanPhamResponsitory.findOne(example);
	}

	@Override
	public List<DanhMucSanPham> findAll() {
		return danhMucSanPhamResponsitory.findAll();
	}

	@Override
	public Page<DanhMucSanPham> findAll(Pageable pageable) {
		return danhMucSanPhamResponsitory.findAll(pageable);
	}

	@Override
	public List<DanhMucSanPham> findAll(Sort sort) {
		return danhMucSanPhamResponsitory.findAll(sort);
	}

	@Override
	public List<DanhMucSanPham> findAllById(Iterable<Long> ids) {
		return danhMucSanPhamResponsitory.findAllById(ids);
	}

	@Override
	public <S extends DanhMucSanPham> List<S> saveAll(Iterable<S> entities) {
		return danhMucSanPhamResponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		danhMucSanPhamResponsitory.flush();
	}

	@Override
	public <S extends DanhMucSanPham> S saveAndFlush(S entity) {
		return danhMucSanPhamResponsitory.saveAndFlush(entity);
	}

	@Override
	public <S extends DanhMucSanPham> List<S> saveAllAndFlush(Iterable<S> entities) {
		return danhMucSanPhamResponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends DanhMucSanPham> Page<S> findAll(Example<S> example, Pageable pageable) {
		return danhMucSanPhamResponsitory.findAll(example, pageable);
	}

	@Override
	public Optional<DanhMucSanPham> findById(Long id) {
		return danhMucSanPhamResponsitory.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<DanhMucSanPham> entities) {
		danhMucSanPhamResponsitory.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return danhMucSanPhamResponsitory.existsById(id);
	}

	@Override
	public <S extends DanhMucSanPham> long count(Example<S> example) {
		return danhMucSanPhamResponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<DanhMucSanPham> entities) {
		danhMucSanPhamResponsitory.deleteAllInBatch(entities);
	}

	@Override
	public <S extends DanhMucSanPham> boolean exists(Example<S> example) {
		return danhMucSanPhamResponsitory.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		danhMucSanPhamResponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends DanhMucSanPham, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return danhMucSanPhamResponsitory.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return danhMucSanPhamResponsitory.count();
	}

	@Override
	public void deleteAllInBatch() {
		danhMucSanPhamResponsitory.deleteAllInBatch();
	}

	@Override
	public void deleteById(Long id) {
		danhMucSanPhamResponsitory.deleteById(id);
	}

	@Override
	public DanhMucSanPham getOne(Long id) {
		return danhMucSanPhamResponsitory.getOne(id);
	}

	@Override
	public void delete(DanhMucSanPham entity) {
		danhMucSanPhamResponsitory.delete(entity);
	}

	@Override
	public DanhMucSanPham getById(Long id) {
		return danhMucSanPhamResponsitory.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		danhMucSanPhamResponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends DanhMucSanPham> entities) {
		danhMucSanPhamResponsitory.deleteAll(entities);
	}

	@Override
	public DanhMucSanPham getReferenceById(Long id) {
		return danhMucSanPhamResponsitory.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		danhMucSanPhamResponsitory.deleteAll();
	}

	@Override
	public <S extends DanhMucSanPham> List<S> findAll(Example<S> example) {
		return danhMucSanPhamResponsitory.findAll(example);
	}

	@Override
	public <S extends DanhMucSanPham> List<S> findAll(Example<S> example, Sort sort) {
		return danhMucSanPhamResponsitory.findAll(example, sort);
	}

	@Override
	public List<DanhMucSanPham> findByNameContaining(String name) {
		return danhMucSanPhamResponsitory.findByNameContaining(name);
	}
	
	
}
