package Nhom4.ServiceImpl;

import java.beans.Beans;
import java.lang.StackWalker.Option;
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
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import Nhom4.Dto.DesionMatrix;
import Nhom4.Dto.ItemReport;
import Nhom4.Dto.SanPhamDTO;
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
import Nhom4.Service.ReportService;
import Nhom4.Service.SanPhamService;

@Service
public class ReportServiceImpl implements ReportService {
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
	@Autowired
	SanPhamService sanPhamService;
//	@Autowired
//	HoaDonNhapR
	public ReportServiceImpl() {
		super();
	}
	@Override
	public List<DesionMatrix> getDesionMatrixs(Date from,Date to){
		List<DesionMatrix> list=new ArrayList<DesionMatrix>();
		List<SanPham> lsp=sanPhamResponsitory.findAll();
		Long TongGtsales=getTongGtsales(from,to);
		Long TongGTTonKho=getTongGtTonKho();
		for(SanPham sp: lsp) {
			SanPhamDTO spdto=new SanPhamDTO();
			BeanUtils.copyProperties(sp, spdto);
			spdto.setLoai(sp.getDanhMucSanPham().getTen());
//			System.out.println(spdto.getTen()+" ///"+spdto.getLoai());
			Long gtTG=(-from.getTime()+to.getTime())/ (1000 * 60 * 60 * 24);
			double gtsales=(TongGtsales>0)?getQuantityBySalesDay(sp,from,to)/TongGtsales*100:0;
			double gtTonKho=(TongGTTonKho>0)?getQuantityTonKho(sp)/TongGTTonKho *100:0;
			DesionMatrix desionMatrix= new DesionMatrix(spdto.getTen(),spdto.getLoai(),getTgRaMat(sp.getId()),getQuantityBySalesDay(sp,from,to),getTonKho(sp),gtTG,gtsales,gtTonKho);
			list.add(desionMatrix);
		}
		return list;
	}
	public String getTgRaMat(Long idSp) {
		List<HoaDonNhap> hdbs=hoaDonNhapRespository.findAllDesc();
		for(HoaDonNhap hdb:hdbs) {
			Optional<ChiTietHDNhap> ct=chiTietHoaDonNhapRespository.findBySanPhamHoaDonNhap(idSp, hdb.getId());
			if(ct.isPresent()) {
				DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
				return df.format(hdb.getNgayNhap());
			}
			
		}
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		return df.format(new Date());
		
	}
	public int getQuantityBySalesDay(SanPham sp,Date from,Date to) {
		return sanPhamService.getQuantityBySalesDay(sp,from,to);
	}
	public int getQuantityTonKho(SanPham sp) {
		return sanPhamService.getQuantityTonKhoByDay(sp);
	}
	public int getTonKho(SanPham sp) {
		return sanPhamService.findById(sp.getId()).get().getSoLuong();
	}	
	
	public Long getTongGtsales(Date from,Date to) {
		List<SanPham> list1=sanPhamService.findAll();
		Long tong=(long) 0;
		for(SanPham sp:list1) {
			tong+=getQuantityBySalesDay(sp,from,to);
		}
		return tong;
	}
	public Long getTongGtTonKho() {
		List<SanPham> list1=sanPhamService.findAll();
		Long tong=(long) 0;
		for(SanPham sp:list1) {
			tong+=getQuantityTonKho(sp);
		}
		return tong;
	}
	// lấy số lượng sp của từng nhanvien bán
	
	@Override
	public Map<String, Integer> reportNhanVien1() {
		List<NhanVien> listnv = nhanVienResponsitory.findAll();
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		for (NhanVien nv : listnv) {
			List<HoaDonBan> hoaDonBans = hoaDonBanRespository.findByNhanVien(nv.getId());
			for (HoaDonBan hoaDonBan : hoaDonBans) {
				List<ChiTietHoaDonBan> chiTietHoaDonBans = chiTietHoaDonBanRespository
						.findByHoadonban(hoaDonBan.getId());
				for (ChiTietHoaDonBan chiTietHoaDonBan : chiTietHoaDonBans) {
					SanPham sp = sanPhamResponsitory.findById(chiTietHoaDonBan.getSanPham().getId()).get();
					if (data.containsKey(sp.getTen())) {
						data.put(nv.getTen(), data.get(nv.getTen()) + chiTietHoaDonBan.getSoLuong());
					} else {
						data.put(nv.getTen(), chiTietHoaDonBan.getSoLuong());
					}
				}

			}
		}

		return data;

	}

	// lấy số lượng của từng item bán

	@Override
	public Map<String, Integer> reportSalesQuantity() {
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		List<HoaDonBan> hoaDonBans = hoaDonBanRespository.findAll();
		for (HoaDonBan hoaDonBan : hoaDonBans) {
			List<ChiTietHoaDonBan> chiTietHoaDonBans = chiTietHoaDonBanRespository.findByHoadonban(hoaDonBan.getId());
			for (ChiTietHoaDonBan chiTietHoaDonBan : chiTietHoaDonBans) {
				SanPham sp = sanPhamResponsitory.findById(chiTietHoaDonBan.getSanPham().getId()).get();
				if (data.containsKey(sp.getTen())) {
					data.put(sp.getTen(), data.get(sp.getTen()) + chiTietHoaDonBan.getSoLuong());
				} else {
					data.put(sp.getTen(), chiTietHoaDonBan.getSoLuong());
				}
			}

		}
		return data;

	}

	// lấy số lượng của item bán theo ngay
	@Override
	public Map<String, Integer> reportTotalSalesAmountByDate(Date d, int limit) {
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		for (int i = limit - 1; i >= 0; i--) {
			Date date = subDays(d, i);
			data.put(covertD2S(date), countTotalSalesAmountByDate(date));
		}
		return data;

	}

	public int countTotalSalesAmountByDate(Date d) {
		List<ItemReport> list = new ArrayList<>();
		List<HoaDonBan> hoaDonBans = hoaDonBanRespository.findByDate(d);
		int count = 0;
		for (HoaDonBan hoaDonBan : hoaDonBans) {

			count += hoaDonBan.getTongTien();

		}
		return count;
	}

	// thống kê tổng tiền bán theo ngày
	@Override
	public Map<String, Integer> reportRecentDailySalesQuantity(Date d, int limit) {
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		for (int i = limit - 1; i >= 0; i--) {
			Date date = subDays(d, i);
			data.put(covertD2S(date), countDailySalesQuantity(date));
		}
		return data;

	}

	public int countDailySalesQuantity(Date d) {

		List<ItemReport> list = new ArrayList<>();
		List<HoaDonBan> hoaDonBans = hoaDonBanRespository.findByDate(d);
		int count = 0;
		for (HoaDonBan hoaDonBan : hoaDonBans) {

			List<ChiTietHoaDonBan> chiTietHoaDonBans = chiTietHoaDonBanRespository.findByHoadonban(hoaDonBan.getId());
			for (ChiTietHoaDonBan chiTietHoaDonBan : chiTietHoaDonBans) {
				count += chiTietHoaDonBan.getSoLuong();
			}

		}
		return count;
	}

	@Override
	public List<String> getData0SalesByMonth(Date d, int limit) {
		List<String> data = new ArrayList<String>();
		int i = 0;
		for (; i < limit;) {
//			System.out.println(i);
			int i0 = i;
			Date start0 = subMonths(d, i0).get(0);
			Date start = subMonths(d, i).get(0);
			Date end = subMonths(d, i).get(1);
			boolean check = false;
//			System.out.println(start+"//// "+end);
			while (i < limit && countTotalSalesAmountByMonth(start, end) == 0) {
				i++;
				start = subMonths(d, i).get(0);
				end = subMonths(d, i).get(1);
//				System.out.println(start+"//// "+end);
				check = true;
			}
			if (check && i - i0 >= 3) {
				DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
				String date = dateFormat.format(subMonths(d, i - 1).get(0)) + " - " + dateFormat.format(start0);
				data.add(date);
			}
			if (!check)
				i++;
		}
		return data;

	}

	@Override
	public List<String> getData0SalesByDate(Date d, int limit) {
		List<String> data = new ArrayList<String>();
		int i = 0;
		for (; i < limit;) {
			int i0 = i;
//			System.out.println(i);
			Date start = subDays(d, i);
			boolean check = false;
			while (i < limit && countTotalSalesAmountByDate(start) == 0) {
				i++;
				start = subDays(d, i);
				check = true;
			}
			if (check && i - i0 >= 3) {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String date = dateFormat.format(subDays(d, i - 1)) + " - " + dateFormat.format(subDays(d, i0));
				data.add(date);
			}
			if (check == false) {
				i++;
			}
		}
		return data;

	}
	// lấy số lượng của item bán theo tháng

	@Override
	public Map<String, Integer> reportTotalSalesAmountByMonth(Date d, int limit) {
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		for (int i = limit - 1; i >= 0; i--) {
			Date start = subMonths(d, i).get(0);
			Date end = subMonths(d, i).get(1);
			data.put(covertM2S(start), countTotalSalesAmountByMonth(start, end));
		}
		return data;

	}

	public int countTotalSalesAmountByMonth(Date start, Date end) {
		List<ItemReport> list = new ArrayList<>();
		List<HoaDonBan> hoaDonBans = hoaDonBanRespository.findByMonth(start, end);
		int count = 0;
		for (HoaDonBan hoaDonBan : hoaDonBans) {

			count += hoaDonBan.getTongTien();

		}
		return count;
	}
	// thống kê tổng tiền bán theo tháng

	@Override
	public Map<String, Integer> reportRecentMonthlySalesQuantity(Date d, int limit) {
		Map<String, Integer> data = new LinkedHashMap<String, Integer>();
		for (int i = limit - 1; i >= 0; i--) {
			Date start = subMonths(d, i).get(0);
			Date end = subMonths(d, i).get(1);
			data.put(covertM2S(start), countRecentMonthlySalesQuantity(start, end));
		}
		return data;

	}

	public int countRecentMonthlySalesQuantity(Date start, Date end) {

		List<ItemReport> list = new ArrayList<>();

		List<HoaDonBan> hoaDonBans = hoaDonBanRespository.findByMonth(start, end);
		int count = 0;
		for (HoaDonBan hoaDonBan : hoaDonBans) {

			List<ChiTietHoaDonBan> chiTietHoaDonBans = chiTietHoaDonBanRespository.findByHoadonban(hoaDonBan.getId());
			for (ChiTietHoaDonBan chiTietHoaDonBan : chiTietHoaDonBans) {
				count += chiTietHoaDonBan.getSoLuong();
			}

		}
		return count;
	}

	// thống kê số lượng sản phẩm nhập hàng
	@Override
	public List<ItemReport> reportQuantityProductImportsByDate(Date d, int limit) {
		List<ItemReport> list = new ArrayList<ItemReport>();
		for (int i = limit - 1; i >= 0; i--) {
			Date date = subDays(d, i);
			ItemReport itemReport = new ItemReport();
			itemReport.setTime(covertD2S(date));
			itemReport.setValue(countQuantityProductImportsByDate(date));
			list.add(itemReport);
		}
		return list;

	}

	public int countQuantityProductImportsByDate(Date d) {
		List<ItemReport> list = new ArrayList<>();
		List<HoaDonNhap> hoaDonNhaps = hoaDonNhapRespository.findByDate(d);
		int count = 0;
		for (HoaDonNhap hoaDonNhap : hoaDonNhaps) {

			List<ChiTietHDNhap> chiTietHDNhaps = chiTietHoaDonNhapRespository.findByHoadonnhap(hoaDonNhap.getId());
			for (ChiTietHDNhap chiTietHDNhap : chiTietHDNhaps) {
				count += chiTietHDNhap.getSoLuong();
			}

		}
		return count;
	}

	// thống kê tổng tiền nhập hàng theo ngày
	@Override
	public List<ItemReport> reportTotalPurchaseAmountByDate(Date d, int limit) {
		List<ItemReport> list = new ArrayList<ItemReport>();
		for (int i = limit - 1; i >= 0; i--) {
			Date date = subDays(d, i);
			ItemReport itemReport = new ItemReport();
			itemReport.setTime(covertD2S(date));
			itemReport.setValue(countTotalPurchaseAmountByDate(date));
			list.add(itemReport);
		}
		return list;

	}

	public int countTotalPurchaseAmountByDate(Date d) {
		List<ItemReport> list = new ArrayList<>();
		List<HoaDonNhap> hoaDonNhaps = hoaDonNhapRespository.findByDate(d);
		int count = 0;
		for (HoaDonNhap hoaDonNhap : hoaDonNhaps) {

			count += hoaDonNhap.getTongTien();

		}
		return count;
	}

	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date subDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
		return cal.getTime();
	}

	private String covertD2S(Date date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyy");
		return df.format(date);
	}

	public static List<Date> subMonths(Date date, int months) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -months);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date start = c.getTime();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date end = c.getTime();
		List<Date> list = new ArrayList<Date>();
		list.add(start);
		list.add(end);
		return list;
	}

	private String covertM2S(Date date) {
		DateFormat df = new SimpleDateFormat("MM/yyy");
		return df.format(date);
	}

}
