package Nhom4.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Nhom4.Dto.ChiTietHDNhapDTO;
import Nhom4.Dto.HoaDonBanDTO;
import Nhom4.Dto.HoaDonNhapDTO;
import Nhom4.Dto.chiTietHoaDonBanDTO;
import Nhom4.Model.ChiTietHDNhap;
import Nhom4.Model.ChiTietHoaDonBan;
import Nhom4.Model.HoaDonBan;
import Nhom4.Model.HoaDonNhap;
import Nhom4.Model.NhanVien;
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.ChiTietHoaDonNhapRespository;
import Nhom4.Responsitory.HoaDonBanRespository;
import Nhom4.Responsitory.HoaDonNhapRespository;
import Nhom4.Responsitory.NhaCungCapRespository;
import Nhom4.Responsitory.SanPhamResponsitory;
import Nhom4.Service.ChiTietHoaDonBanService;
import Nhom4.Service.HoaDonBanService;
import Nhom4.Service.KhachHangService;

@RestController
@RequestMapping("/data")
public class Controller {
	@Autowired 
	HoaDonBanService hoaDonBanService;
	@Autowired
	KhachHangService khachHangService;
	@Autowired
	ChiTietHoaDonBanService ChiTietHoaDonBanService;
	@Autowired
	SanPhamResponsitory sanPhamRespository;
	@Autowired
	NhaCungCapRespository nhaCungCapRespository;
	@Autowired
	HoaDonNhapRespository hoaDonNhapRespository;
	@Autowired
	ChiTietHoaDonNhapRespository chiTietHoaDonNhapRespository;
	@Autowired
	HttpSession session ;
	@PostMapping(value = "/add")
    public Long addInvoice(ModelMap model, @RequestBody HoaDonBanDTO hdb)
    {
		HoaDonBan h = new HoaDonBan();
		
		float tongTien = 0;
		Set<ChiTietHoaDonBan> ct = new HashSet<>();

		for (chiTietHoaDonBanDTO cdto : hdb.getListChiTietHoaDonBan()) {
			ChiTietHoaDonBan c = new ChiTietHoaDonBan(); 
			SanPham s = sanPhamRespository.getById(cdto.getSanPham().getId()); 
			tongTien += s.getDonGia()*cdto.getSoLuong();
			c.setSoLuong(cdto.getSoLuong());
			s.setSoLuong(s.getSoLuong()-cdto.getSoLuong());
			c.setSanPham(s); 
			ct.add(c); 
		}
		
		h.setDiscount(hdb.getDiscount());
		h.setNgayBan(hdb.getNgayBan());
		h.setTrangThai(hdb.getTrangThai());
		h.setKhachHang(khachHangService.getById(hdb.getKhachHang().getId()));
		h.setTongTien(tongTien);
		NhanVien nv= new NhanVien();
		nv.setId((Long) session.getAttribute("nhanVienId"));
		h.setNhanVien(nv);
		HoaDonBan x = hoaDonBanService.save(h);
		
		System.out.println(x);
		for (ChiTietHoaDonBan ChiTietHoaDonBan : ct) {
			ChiTietHoaDonBan.setHoaDonBan(x);
			ChiTietHoaDonBanService.save(ChiTietHoaDonBan);
		}
		
		return x.getId();
    }
	
	@PostMapping(value = "/purchase")
    public Long addPurchase(ModelMap model, @RequestBody HoaDonNhapDTO hdn)
    {
		HoaDonNhap h = new HoaDonNhap();
		
		float tongTien = 0;
		Set<ChiTietHDNhap> ct = new HashSet<>();

		for (ChiTietHDNhapDTO cdto : hdn.getListChiTietHoaDonNhap()) {
			ChiTietHDNhap c = new ChiTietHDNhap(); 
			SanPham s = sanPhamRespository.getById(cdto.getSanPham().getId()); 
			tongTien += cdto.getDonGiaNhap()*cdto.getSoLuong();
			c.setSoLuong(cdto.getSoLuong());
			c.setDonGiaNhap(cdto.getDonGiaNhap());
			s.setSoLuong(s.getSoLuong()+cdto.getSoLuong());
			c.setSanPham(s); 
			ct.add(c); 
		}
		h.setNgayNhap(hdn.getNgayNhap());
		h.setTrangThai(hdn.getTrangThai());
		h.setNhaCungCap(nhaCungCapRespository.getById(hdn.getNhaCungCap().getId()));
		h.setTongTien(tongTien);
		NhanVien nv= new NhanVien();
		nv.setId((Long) session.getAttribute("nhanVienId"));
		h.setNhanVien(nv);
		HoaDonNhap x = hoaDonNhapRespository.save(h);
		
		System.out.println(x);
		for (ChiTietHDNhap chiTietHoaHdNhap: ct) {
			chiTietHoaHdNhap.setHoaDonNhap(x);
			chiTietHoaDonNhapRespository.save(chiTietHoaHdNhap);
		}
		
		return x.getId();
    }
}
