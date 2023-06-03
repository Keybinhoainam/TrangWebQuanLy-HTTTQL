package Nhom4.Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import Nhom4.Dto.DashBoardOverview;
import Nhom4.Dto.DashboardNV;
import Nhom4.Dto.Change;
import Nhom4.Model.HoaDonBan;
import Nhom4.Model.NhanVien;
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.HoaDonBanRespository;
import Nhom4.Service.DashBoardService;
import Nhom4.Service.HoaDonBanService;
import Nhom4.Service.NhanVienService;
import Nhom4.Service.ReportService;
import Nhom4.Service.SanPhamService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	HoaDonBanService hoaDonBanService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DashBoardService dashBoardService;
	@Autowired
	ReportService reportService;
	@RequestMapping("/getdbnv")
	public ResponseEntity<String> getdbnv() {
		Gson gson=new Gson();
		
		List<NhanVien> list1=nhanVienService.findAll();
		Collections.sort(list1, new Comparator<NhanVien>() {
			
			
			@Override
			public int compare(NhanVien nv1,NhanVien nv2) {
				return (int)(getDoanhThuByNv(nv2)-getDoanhThuByNv(nv1));
			}
		});
		StringBuilder jsonData= new StringBuilder("[");
		Object[] dt= {"$", "Revenue"};
		jsonData.append(gson.toJson(dt)).append(",");
		for(NhanVien nv: list1) {
			Object[] data= {nv.getTen(), getDoanhThuByNv(nv)};
			jsonData.append(gson.toJson(data)).append(",");
		}
		jsonData.deleteCharAt(jsonData.length() - 1); // Xóa dấu phẩy cuối cùng
		jsonData.append("]");
		
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(jsonData.toString());
		
	}
	public Float getDoanhThuByNv(NhanVien nv) {
		return hoaDonBanService.getDoanhThuByNhanVien(nv);
	}
	@RequestMapping("/getdbsales")
	public ResponseEntity<String> getdbsales() {
		Gson gson=new Gson();
		
		List<SanPham> list1=sanPhamService.findAll();
		Collections.sort(list1, new Comparator<SanPham>() {
			
			
			@Override
			public int compare(SanPham sp1,SanPham sp2) {
				return (int)(getQuantityBySales(sp2)-getQuantityBySales(sp1));
			}
		});
		StringBuilder jsonData= new StringBuilder("[");
		Object[] dt= {"", "Quantity"};
		jsonData.append(gson.toJson(dt)).append(",");
		for(SanPham sp: list1) {
			Object[] data= {sp.getTen(), getQuantityBySales(sp)};
			jsonData.append(gson.toJson(data)).append(",");
		}
		jsonData.deleteCharAt(jsonData.length() - 1); // Xóa dấu phẩy cuối cùng
		jsonData.append("]");
		
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-Type", "application/json")
				.body(jsonData.toString());
		
	}
	public int getQuantityBySales(SanPham sp) {
		return sanPhamService.getQuantityBySales(sp);
	}
	public Map<String,Float> getdatanv(Date from,Date to) {
		List<NhanVien> list1=nhanVienService.findAll();
		Collections.sort(list1, new Comparator<NhanVien>() {
			
			
			@Override
			public int compare(NhanVien nv1,NhanVien nv2) {
				return (int)(getDoanhThuByNhanVienDay(nv2,from,to)-getDoanhThuByNhanVienDay(nv1,from,to));
			}
		});
		Map<String,Float> data=new LinkedHashMap();
		for(NhanVien nv: list1) {
			
			data.put(nv.getTen(), getDoanhThuByNhanVienDay(nv,from,to));
			
		}
		return data;
		
	}
	public Float getDoanhThuByNhanVienDay(NhanVien nv,Date from,Date to) {
		return hoaDonBanService.getDoanhThuByNhanVienDay(nv,from,to);
	}
	public Map<String,Integer> getDataProduct(Date from,Date to) {
		List<SanPham> list1=sanPhamService.findAll();
		Collections.sort(list1, new Comparator<SanPham>() {
			
			
			@Override
			public int compare(SanPham sp1,SanPham sp2) {
				return (int)(getQuantityBySalesDay(sp2,from,to)-getQuantityBySalesDay(sp1,from,to));
			}
		});
		Map<String,Integer> data=new LinkedHashMap();
		for(SanPham sp: list1) {
			data.put(sp.getTen(), getQuantityBySalesDay(sp,from,to));
		}
		return data;
	}
	public int getQuantityBySalesDay(SanPham sp,Date from,Date to) {
		return sanPhamService.getQuantityBySalesDay(sp,from,to);
	}	
	@RequestMapping("/requestdata")
	public DashBoardOverview db(@RequestBody Change datechange) {
		Date from;
		Date to;
		if(datechange.getFrom()==null) {
			to= new Date();
			from= new Date();
		}
		else {
			from=datechange.getFrom();
			to=datechange.getTo();
		}
		
		Float revenue=dashBoardService.getRevenue(from, to);
		int order= dashBoardService.getOrder(from, to);
		int customer=dashBoardService.getCustomer(from, to);
		int kcdate=(int) ((-from.getTime()+to.getTime())/ (1000 * 60 * 60 * 24))+1;
		int kcmonth= to.getMonth()+1;
		Map<String, Integer>  data1=new HashMap<String, Integer>();
		Map<String, Integer> data2 =new HashMap<String, Integer>();
		if(datechange.getOption().equals("3") || datechange.getOption().equals("6")) {
			data1 = reportService.reportRecentMonthlySalesQuantity(to, kcmonth);
			data2 = reportService.reportTotalSalesAmountByMonth(to, kcmonth);
		}
		else {
			data1 = reportService.reportTotalSalesAmountByDate(to, kcdate);
			data2 = reportService.reportRecentDailySalesQuantity(to, kcdate);
		}
		Map<String,Float> datanv=getdatanv(from,to);
		Map<String,Integer> dataproduct= getDataProduct(from,to);
		if(datechange.getFrom2()!=null) {
			Date from2=datechange.getFrom2();
			Date to2=datechange.getTo2();
			int comparedRevenue= dashBoardService.comparedRevenue( from2, to2,from, to);
			int comparedOrder= dashBoardService.comparedOrder(from2, to2,from, to);
			int comparedCustomer= dashBoardService.comparedCustomer(from2, to2,from, to);
			DashBoardOverview db= new DashBoardOverview(revenue,order,customer,comparedRevenue,comparedOrder,comparedCustomer,data1.keySet(),data1.values(),data2.values(),datanv.keySet(),datanv.values(),dataproduct.keySet(),dataproduct.values());
			return db;
		}
		DashBoardOverview db= new DashBoardOverview(revenue,order,customer,200000,200000,200000,data1.keySet(),data1.values(),data2.values(),datanv.keySet(),datanv.values(),dataproduct.keySet(),dataproduct.values());
		return db;
		
		
	}
	public static Date subDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
    }
}
