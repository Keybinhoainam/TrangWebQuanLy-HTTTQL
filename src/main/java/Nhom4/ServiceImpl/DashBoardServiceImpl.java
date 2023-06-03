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

import org.springframework.beans.factory.annotation.Autowired;
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
import Nhom4.Service.DashBoardService;
import Nhom4.Service.ReportService;
@Service
public class DashBoardServiceImpl implements DashBoardService{
	@Autowired
	ChiTietHoaDonBanRespository chiTietHoaDonBanRespository;
	@Autowired
	HoaDonBanRespository hoaDonBanRespository;
	@Autowired
	HoaDonNhapRespository hoaDonNhapRespository;
	@Autowired
	ChiTietHoaDonNhapRespository chiTietHoaDonNhapRespository;
	@Autowired
	SanPhamResponsitory sanPhamResponsitory;
	@Autowired
	NhanVienResponsitory nhanVienResponsitory;
//	@Autowired
//	HoaDonNhapR
	public DashBoardServiceImpl() {
		super();
	}
	
	
	@Override
	public Float getRevenue(Date from, Date to) {
		List<HoaDonBan> lhdb= hoaDonBanRespository.findByNgayBan(from, to);
		Float tong=(float) (0.0);
		for(HoaDonBan hdb: lhdb) {
			tong+=hdb.getTongTien();
		}
		return tong;
	}
	@Override
	public int getOrder(Date from, Date to) {
		List<HoaDonBan> lhdb= hoaDonBanRespository.findByNgayBan(from, to);
		int tong=lhdb.size();
		return tong;
	}
	@Override
	public int getCustomer(Date from, Date to) {
		List<HoaDonBan> lhdb= hoaDonBanRespository.findByNgayBan(from, to);
		List<Long> lnv=new ArrayList<Long>();
		for(HoaDonBan hdb:lhdb) {
			
			if(!lnv.contains(hdb.getKhachHang().getId()) ) {
				lnv.add(hdb.getKhachHang().getId());
			}
		}
		return lnv.size();
	}
	
	
	@Override
	public int comparedRevenue(Date from1, Date to1,Date from2, Date to2) {
		List<HoaDonBan> lhdb1= hoaDonBanRespository.findByNgayBan(from1, to1);
		Float tong1=(float) (0.0);
		for(HoaDonBan hdb: lhdb1) {
			tong1+=hdb.getTongTien();
		}
		List<HoaDonBan> lhdb2= hoaDonBanRespository.findByNgayBan(from2, to2);
		Float tong2=(float) (0.0);
		for(HoaDonBan hdb: lhdb2) {
			tong2+=hdb.getTongTien();
		}
		if(tong1==0) {
			return 100;
		}
		return Math.round((tong2-tong1)/tong1 *100);
	}
	@Override
	public int comparedOrder(Date from1, Date to1,Date from2, Date to2) {
		List<HoaDonBan> lhdb1= hoaDonBanRespository.findByNgayBan(from1, to1);
		int tong1=lhdb1.size();
		List<HoaDonBan> lhdb2= hoaDonBanRespository.findByNgayBan(from2, to2);
		int tong2=lhdb2.size();
		if(tong1==0) {
			return 100;
		}
		else return Math.round((tong2-tong1)/tong1 *100);
	}
	@Override
	public int comparedCustomer(Date from1, Date to1,Date from2, Date to2) {
		List<HoaDonBan> lhdb1= hoaDonBanRespository.findByNgayBan(from1, to1);
		List<Long> lnv1=new ArrayList<Long>();
		for(HoaDonBan hdb:lhdb1) {
			
			if(!lnv1.contains(hdb.getKhachHang().getId()) ) {
				lnv1.add(hdb.getKhachHang().getId());
			}
		}
		List<HoaDonBan> lhdb2= hoaDonBanRespository.findByNgayBan(from2, to2);
		List<Long> lnv2=new ArrayList<Long>();
		for(HoaDonBan hdb:lhdb2) {
			
			if(!lnv2.contains(hdb.getKhachHang().getId()) ) {
				lnv2.add(hdb.getKhachHang().getId());
			}
		}
		int tong1=lnv1.size();
		int tong2=lnv2.size();
		if(tong1==0) {
			return 100;
		}
		return Math.round((tong2-tong1)/tong1 *100);
	}
	
}
