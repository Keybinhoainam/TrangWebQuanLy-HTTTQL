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
import Nhom4.Model.HoaDonBan;
import Nhom4.Model.HoaDonNhap;
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.ChiTietHoaDonBanRespository;
import Nhom4.Responsitory.ChiTietHoaDonNhapRespository;
import Nhom4.Responsitory.HoaDonBanRespository;
import Nhom4.Responsitory.HoaDonNhapRespository;
import Nhom4.Responsitory.SanPhamResponsitory;
import Nhom4.Service.ReportService;
import Nhom4.Service.SanPhamService;
@Service
public class SanPhamServiceImpl implements SanPhamService{
	
	@Autowired
	SanPhamResponsitory sanPhamResponsitory;
	@Autowired
	ChiTietHoaDonBanRespository chiTietHoaDonBanRespository;
//	@Autowired
//	HoaDonNhapR
	public SanPhamServiceImpl() {
		super();
	}
	@Override
	public int getQuantityBySales(SanPham sp) {
		List<ChiTietHoaDonBan> list=chiTietHoaDonBanRespository.findBySanPham(sp.getId());
		int count=0;
		for(ChiTietHoaDonBan t: list) {
			count+=t.getSoLuong();
		}
		return count;
	}
	@Override
	public int getQuantityBySalesDay(SanPham sp,Date from,Date to) {
		List<ChiTietHoaDonBan> list=chiTietHoaDonBanRespository.findBySanPhamDay(sp.getId(),from,to);
		int count=0;
		for(ChiTietHoaDonBan t: list) {
			count+=t.getSoLuong();
		}
		return count;
	}
@Override
public <S extends SanPham> S save(S entity) {
	return sanPhamResponsitory.save(entity);
}
@Override
public <S extends SanPham> Optional<S> findOne(Example<S> example) {
	return sanPhamResponsitory.findOne(example);
}
@Override
public List<SanPham> findAll() {
	return sanPhamResponsitory.findAll();
}
@Override
public Page<SanPham> findAll(Pageable pageable) {
	return sanPhamResponsitory.findAll(pageable);
}
@Override
public List<SanPham> findAll(Sort sort) {
	return sanPhamResponsitory.findAll(sort);
}
@Override
public List<SanPham> findAllById(Iterable<Long> ids) {
	return sanPhamResponsitory.findAllById(ids);
}
@Override
public <S extends SanPham> List<S> saveAll(Iterable<S> entities) {
	return sanPhamResponsitory.saveAll(entities);
}
@Override
public void flush() {
	sanPhamResponsitory.flush();
}
@Override
public <S extends SanPham> S saveAndFlush(S entity) {
	return sanPhamResponsitory.saveAndFlush(entity);
}
@Override
public <S extends SanPham> List<S> saveAllAndFlush(Iterable<S> entities) {
	return sanPhamResponsitory.saveAllAndFlush(entities);
}
@Override
public <S extends SanPham> Page<S> findAll(Example<S> example, Pageable pageable) {
	return sanPhamResponsitory.findAll(example, pageable);
}
@Override
public Optional<SanPham> findById(Long id) {
	return sanPhamResponsitory.findById(id);
}
@Override
public void deleteInBatch(Iterable<SanPham> entities) {
	sanPhamResponsitory.deleteInBatch(entities);
}
@Override
public boolean existsById(Long id) {
	return sanPhamResponsitory.existsById(id);
}
@Override
public <S extends SanPham> long count(Example<S> example) {
	return sanPhamResponsitory.count(example);
}
@Override
public void deleteAllInBatch(Iterable<SanPham> entities) {
	sanPhamResponsitory.deleteAllInBatch(entities);
}
@Override
public <S extends SanPham> boolean exists(Example<S> example) {
	return sanPhamResponsitory.exists(example);
}
@Override
public void deleteAllByIdInBatch(Iterable<Long> ids) {
	sanPhamResponsitory.deleteAllByIdInBatch(ids);
}
@Override
public <S extends SanPham, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return sanPhamResponsitory.findBy(example, queryFunction);
}
@Override
public long count() {
	return sanPhamResponsitory.count();
}
@Override
public void deleteAllInBatch() {
	sanPhamResponsitory.deleteAllInBatch();
}
@Override
public void deleteById(Long id) {
	sanPhamResponsitory.deleteById(id);
}
@Override
public SanPham getOne(Long id) {
	return sanPhamResponsitory.getOne(id);
}
@Override
public void delete(SanPham entity) {
	sanPhamResponsitory.delete(entity);
}
@Override
public SanPham getById(Long id) {
	return sanPhamResponsitory.getById(id);
}
@Override
public void deleteAllById(Iterable<? extends Long> ids) {
	sanPhamResponsitory.deleteAllById(ids);
}
@Override
public void deleteAll(Iterable<? extends SanPham> entities) {
	sanPhamResponsitory.deleteAll(entities);
}
@Override
public SanPham getReferenceById(Long id) {
	return sanPhamResponsitory.getReferenceById(id);
}
@Override
public void deleteAll() {
	sanPhamResponsitory.deleteAll();
}
@Override
public <S extends SanPham> List<S> findAll(Example<S> example) {
	return sanPhamResponsitory.findAll(example);
}
@Override
public <S extends SanPham> List<S> findAll(Example<S> example, Sort sort) {
	return sanPhamResponsitory.findAll(example, sort);
}
@Override
public List<SanPham> findByNameContaining(String name) {
	return sanPhamResponsitory.findByNameContaining(name);
}
@Override
public List<SanPham> findProductInStock() {
	return sanPhamResponsitory.findProductInStock();
}
@Override
public List<SanPham> findProductOutStock() {
	return sanPhamResponsitory.findProductOutStock();
}
	
	
	
}
