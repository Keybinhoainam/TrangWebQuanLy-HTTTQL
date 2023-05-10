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
import Nhom4.Model.NhanVien;
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.ChiTietHoaDonBanRespository;
import Nhom4.Responsitory.ChiTietHoaDonNhapRespository;
import Nhom4.Responsitory.HoaDonBanRespository;
import Nhom4.Responsitory.HoaDonNhapRespository;
import Nhom4.Responsitory.NhanVienResponsitory;
import Nhom4.Responsitory.SanPhamResponsitory;
import Nhom4.Service.NhanVienService;
import Nhom4.Service.ReportService;
@Service
public class NhanVienServiceImpl implements NhanVienService{
	
	@Autowired
	NhanVienResponsitory nhanVienResponsitory;
//	@Autowired
//	HoaDonNhapR

	@Override
	public <S extends NhanVien> S save(S entity) {
		return nhanVienResponsitory.save(entity);
	}

	@Override
	public <S extends NhanVien> Optional<S> findOne(Example<S> example) {
		return nhanVienResponsitory.findOne(example);
	}

	@Override
	public List<NhanVien> findAll() {
		return nhanVienResponsitory.findAll();
	}

	@Override
	public Page<NhanVien> findAll(Pageable pageable) {
		return nhanVienResponsitory.findAll(pageable);
	}

	@Override
	public List<NhanVien> findAll(Sort sort) {
		return nhanVienResponsitory.findAll(sort);
	}

	@Override
	public List<NhanVien> findAllById(Iterable<Long> ids) {
		return nhanVienResponsitory.findAllById(ids);
	}

	@Override
	public <S extends NhanVien> List<S> saveAll(Iterable<S> entities) {
		return nhanVienResponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		nhanVienResponsitory.flush();
	}

	@Override
	public <S extends NhanVien> S saveAndFlush(S entity) {
		return nhanVienResponsitory.saveAndFlush(entity);
	}

	@Override
	public <S extends NhanVien> List<S> saveAllAndFlush(Iterable<S> entities) {
		return nhanVienResponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends NhanVien> Page<S> findAll(Example<S> example, Pageable pageable) {
		return nhanVienResponsitory.findAll(example, pageable);
	}

	@Override
	public Optional<NhanVien> findById(Long id) {
		return nhanVienResponsitory.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<NhanVien> entities) {
		nhanVienResponsitory.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return nhanVienResponsitory.existsById(id);
	}

	@Override
	public <S extends NhanVien> long count(Example<S> example) {
		return nhanVienResponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<NhanVien> entities) {
		nhanVienResponsitory.deleteAllInBatch(entities);
	}

	@Override
	public <S extends NhanVien> boolean exists(Example<S> example) {
		return nhanVienResponsitory.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		nhanVienResponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends NhanVien, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return nhanVienResponsitory.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return nhanVienResponsitory.count();
	}

	@Override
	public void deleteAllInBatch() {
		nhanVienResponsitory.deleteAllInBatch();
	}

	@Override
	public List<NhanVien> findByNameContaining(String name) {
		return nhanVienResponsitory.findByNameContaining(name);
	}

	@Override
	public void deleteById(Long id) {
		nhanVienResponsitory.deleteById(id);
	}

	@Override
	public NhanVien getOne(Long id) {
		return nhanVienResponsitory.getOne(id);
	}

	@Override
	public void delete(NhanVien entity) {
		nhanVienResponsitory.delete(entity);
	}

	@Override
	public NhanVien getById(Long id) {
		return nhanVienResponsitory.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		nhanVienResponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends NhanVien> entities) {
		nhanVienResponsitory.deleteAll(entities);
	}

	@Override
	public NhanVien getReferenceById(Long id) {
		return nhanVienResponsitory.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		nhanVienResponsitory.deleteAll();
	}

	@Override
	public <S extends NhanVien> List<S> findAll(Example<S> example) {
		return nhanVienResponsitory.findAll(example);
	}

	@Override
	public <S extends NhanVien> List<S> findAll(Example<S> example, Sort sort) {
		return nhanVienResponsitory.findAll(example, sort);
	}

	
	
	
	
	
}
