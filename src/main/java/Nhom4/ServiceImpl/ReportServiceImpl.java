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
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.ChiTietHoaDonBanRespository;
import Nhom4.Responsitory.ChiTietHoaDonNhapRespository;
import Nhom4.Responsitory.HoaDonBanRespository;
import Nhom4.Responsitory.HoaDonNhapRespository;
import Nhom4.Responsitory.SanPhamResponsitory;
import Nhom4.Service.ReportService;
@Service
public class ReportServiceImpl implements ReportService{
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
//	@Autowired
//	HoaDonNhapR
	public ReportServiceImpl() {
		super();
	}
	
	
	
	// lấy số lượng của từng item bán
		
		@Override
		public Map<String, Integer> reportSalesQuantity() {
			Map<String, Integer> data= new LinkedHashMap<String, Integer>();
			List<HoaDonBan> hoaDonBans=hoaDonBanRespository.findAll();
			for(HoaDonBan hoaDonBan: hoaDonBans) {
				List<ChiTietHoaDonBan> chiTietHoaDonBans=chiTietHoaDonBanRespository.findByHoadonban(hoaDonBan.getId());
				for(ChiTietHoaDonBan chiTietHoaDonBan: chiTietHoaDonBans) {
					SanPham sp= sanPhamResponsitory.findById(chiTietHoaDonBan.getSanPham().getId()).get();
					if(data.containsKey(sp.getTen())) {
						data.put(sp.getTen(), data.get(sp.getTen())+chiTietHoaDonBan.getSoLuong());
					}
					else {
						data.put(sp.getTen(), chiTietHoaDonBan.getSoLuong());
					}
				}
				
				
			}
			return data;
			
		}
		
		
		
	// lấy số lượng của item bán theo ngay
	@Override
	public Map<String, Integer> reportTotalSalesAmountByDate(Date d, int limit) {
		Map<String, Integer> data= new LinkedHashMap<String, Integer>();
		for(int i=limit-1;i>=0;i--) {
			Date date= subDays(d, i);
			data.put(covertD2S(date), countTotalSalesAmountByDate(date));
		}
		return data;
		
	}
	public int countTotalSalesAmountByDate(Date d) {
		List<ItemReport> list= new ArrayList<>();
		List<HoaDonBan> hoaDonBans=hoaDonBanRespository.findByDate(d);
		int count=0;
		for(HoaDonBan hoaDonBan: hoaDonBans) {
			
			count+=hoaDonBan.getTongTien();
			
		}
		return count;
	}
	//thống kê tổng tiền bán theo ngày
	@Override
	public Map<String, Integer> reportRecentDailySalesQuantity(Date d, int limit) {
		Map<String, Integer> data= new LinkedHashMap<String, Integer>();
		for(int i=limit-1;i>=0;i--) {
			Date date= subDays(d, i);
			data.put(covertD2S(date), countDailySalesQuantity(date));
		}
		return data;
		
	}
	public int countDailySalesQuantity(Date d) {
		
		List<ItemReport> list= new ArrayList<>();
		List<HoaDonBan> hoaDonBans=hoaDonBanRespository.findByDate(d);
		int count=0;
		for(HoaDonBan hoaDonBan: hoaDonBans) {
			
			List<ChiTietHoaDonBan> chiTietHoaDonBans=chiTietHoaDonBanRespository.findByHoadonban(hoaDonBan.getId());
			for(ChiTietHoaDonBan chiTietHoaDonBan: chiTietHoaDonBans) {
				count+=chiTietHoaDonBan.getSoLuong();
			}
			
		}
		return count;
	}
	
	
	// lấy số lượng của item bán theo tháng
		
		@Override
		public Map<String, Integer> reportTotalSalesAmountByMonth(Date d, int limit) {
			Map<String, Integer> data= new LinkedHashMap<String, Integer>();
			for(int i=limit-1;i>=0;i--) {
				Date start= subMonths(d,i).get(0);
				Date end=subMonths(d,i).get(1);
				data.put(covertM2S(start), countTotalSalesAmountByMonth(start,end));
			}
			return data;
			
		}
		public int countTotalSalesAmountByMonth(Date start,Date end) {
			List<ItemReport> list= new ArrayList<>();
			List<HoaDonBan> hoaDonBans=hoaDonBanRespository.findByMonth(start,end);
			int count=0;
			for(HoaDonBan hoaDonBan: hoaDonBans) {
				
				count+=hoaDonBan.getTongTien();
				
			}
			return count;
		}
		//thống kê tổng tiền bán theo tháng
		
		@Override
		public Map<String, Integer> reportRecentMonthlySalesQuantity(Date d, int limit) {
			Map<String, Integer> data= new LinkedHashMap<String, Integer>();
			for(int i=limit-1;i>=0;i--) {
				Date start= subMonths(d,i).get(0);
				Date end=subMonths(d,i).get(1);
				data.put(covertM2S(start), countRecentMonthlySalesQuantity(start, end));
			}
			return data;
			
		}
		public int countRecentMonthlySalesQuantity(Date start, Date end) {
			
			
			List<ItemReport> list= new ArrayList<>();
			
			List<HoaDonBan> hoaDonBans=hoaDonBanRespository.findByMonth(start,end);
			int count=0;
			for(HoaDonBan hoaDonBan: hoaDonBans) {
				
				List<ChiTietHoaDonBan> chiTietHoaDonBans=chiTietHoaDonBanRespository.findByHoadonban(hoaDonBan.getId());
				for(ChiTietHoaDonBan chiTietHoaDonBan: chiTietHoaDonBans) {
					count+=chiTietHoaDonBan.getSoLuong();
				}
				
			}
			return count;
		}
	
	
	
	
	
	
	
	
	//thống kê số lượng sản phẩm nhập hàng
	@Override
	public List<ItemReport> reportQuantityProductImportsByDate(Date d, int limit) {
		List<ItemReport> list= new ArrayList<ItemReport>();
		for(int i=limit-1;i>=0;i--) {
			Date date= subDays(d, i);
			ItemReport itemReport=new ItemReport();
			itemReport.setTime(covertD2S(date));
			itemReport.setValue(countQuantityProductImportsByDate(date));
			list.add(itemReport);
		}
		return list;
		
	}
	public int countQuantityProductImportsByDate(Date d) {
		List<ItemReport> list= new ArrayList<>();
		List<HoaDonNhap> hoaDonNhaps=hoaDonNhapRespository.findByDate(d);
		int count=0;
		for(HoaDonNhap hoaDonNhap: hoaDonNhaps) {
			
			List<ChiTietHDNhap> chiTietHDNhaps=chiTietHoaDonNhapRespository.findByHoadonnhap(hoaDonNhap.getId());
			for(ChiTietHDNhap chiTietHDNhap: chiTietHDNhaps) {
				count+=chiTietHDNhap.getSoLuong();
			}
			
		}
		return count;
	}
	
	//thống kê tổng tiền nhập hàng theo ngày
		@Override
		public List<ItemReport> reportTotalPurchaseAmountByDate(Date d, int limit) {
			List<ItemReport> list= new ArrayList<ItemReport>();
			for(int i=limit-1;i>=0;i--) {
				Date date= subDays(d, i);
				ItemReport itemReport=new ItemReport();
				itemReport.setTime(covertD2S(date));
				itemReport.setValue(countTotalPurchaseAmountByDate(date));
				list.add(itemReport);
			}
			return list;
			
		}
		public int countTotalPurchaseAmountByDate(Date d) {
			List<ItemReport> list= new ArrayList<>();
			List<HoaDonNhap> hoaDonNhaps=hoaDonNhapRespository.findByDate(d);
			int count=0;
			for(HoaDonNhap hoaDonNhap: hoaDonNhaps) {
				
				count+=hoaDonNhap.getTongTien();
				
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
    	LocalDate localstart = LocalDate.now().minusMonths(months).withDayOfMonth(1);
    	LocalDate localend = LocalDate.now().minusMonths(months-1).withDayOfMonth(1);
    	Date start = Date.from(localstart.atStartOfDay(ZoneId.systemDefault()).toInstant());
    	Date end = Date.from(localend.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<Date> list=new ArrayList<Date>();
        list.add(start);
        list.add(end);
        return list;
    }

    private String covertM2S(Date date) {
        DateFormat df = new SimpleDateFormat("MM/yyy");
        return df.format(date);
    }
    
	
}
