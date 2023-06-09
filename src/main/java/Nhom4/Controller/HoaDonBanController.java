package Nhom4.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Nhom4.Dto.HoaDonBanDTO;
import Nhom4.Dto.KhachHangDTO;
import Nhom4.Dto.SanPhamDTO;
import Nhom4.Dto.chiTietHoaDonBanDTO;
import Nhom4.Model.HoaDonBan;
import Nhom4.Model.KhachHang;
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.SanPhamResponsitory;
import Nhom4.Service.HoaDonBanService;
import Nhom4.Service.KhachHangService;
import Nhom4.Service.SanPhamService;

@Controller
@RequestMapping("/sell")
public class HoaDonBanController {
	@Autowired 
	HoaDonBanService hoaDonBanService;
	@Autowired
	KhachHangService khachHangService;
	@Autowired
	SanPhamResponsitory sanPhamRepository;
	@Autowired
	SanPhamService sanPhamService;
	@GetMapping("/list")
	public String showList(ModelMap model)
    {
		List<HoaDonBan> list = hoaDonBanService.findAll();
		List<HoaDonBanDTO> listDTO = new ArrayList<>();
		for (HoaDonBan hoaDonBan : list) {
			HoaDonBanDTO hoaDonBanDTO = new HoaDonBanDTO();
			BeanUtils.copyProperties(hoaDonBan, hoaDonBanDTO);
			KhachHangDTO khdto = new KhachHangDTO();
			BeanUtils.copyProperties(hoaDonBan.getKhachHang(), khdto);
			hoaDonBanDTO.setKhachHang(khdto);
			listDTO.add(hoaDonBanDTO);
		}
		for (HoaDonBanDTO hoaDonBanDTO : listDTO) {
			System.out.println(hoaDonBanDTO.getKhachHang().getTen());
		}
		model.addAttribute("listHDB",listDTO);
        return "table_list_invoices";
    }
	
	@GetMapping("/invoice")
	public String showInvoice(ModelMap model, @RequestParam("id") Long id)
    {
		HoaDonBan h = hoaDonBanService.getById(id);
		HoaDonBanDTO hdb = new HoaDonBanDTO();
		BeanUtils.copyProperties(h, hdb);
		
		KhachHangDTO khdto = new KhachHangDTO();
		BeanUtils.copyProperties(h.getKhachHang(), khdto);
		hdb.setKhachHang(khdto);
		
		model.addAttribute("hoaDonBan",h);
        return "invoice_detail";
    }
	public Map<String,Integer> getDataProduct() {
		List<SanPham> list1=sanPhamService.findAll();
		Collections.sort(list1, new Comparator<SanPham>() {
			
			
			@Override
			public int compare(SanPham sp1,SanPham sp2) {
				return (int)(getQuantityBySales(sp2)-getQuantityBySales(sp1));
			}
		});
		Map<String,Integer> data=new LinkedHashMap();
		for(SanPham sp: list1) {
			data.put(sp.getTen(), getQuantityBySales(sp));
		}
		
		return data;
	}
	public int getQuantityBySales(SanPham sp) {
		return sanPhamService.getQuantityBySales(sp);
	}
	@GetMapping("/add")
	public String showAddForm(ModelMap model)
    {
		KhachHangDTO khach = new KhachHangDTO();
		model.addAttribute("khachHang",khach);
		
		List<KhachHang> list = khachHangService.findAll();
		List<KhachHangDTO> listDTO = new ArrayList<>();
		for (KhachHang khachHang : list) {
			KhachHangDTO khachHangDTO = new KhachHangDTO();
			BeanUtils.copyProperties(khachHang, khachHangDTO);
			listDTO.add(khachHangDTO);
		}
		model.addAttribute("listKH",listDTO);
		Map<String,Integer> dataProduct= getDataProduct();
		Iterator<Entry<String, Integer>> iterator=dataProduct.entrySet().iterator();
		int maxQuantity=iterator.next().getValue();
		int minQuantity=0;
		while (iterator.hasNext()) { minQuantity = iterator.next().getValue(); }
		
		List<SanPham> sp = sanPhamRepository.findAll();
		List<SanPhamDTO> listSP = new ArrayList<>();
		for (SanPham sanPham : sp) {
			SanPhamDTO sanPhamDTO = new SanPhamDTO();
			BeanUtils.copyProperties(sanPham, sanPhamDTO);
			sanPhamDTO.setLoai(sanPham.getDanhMucSanPham().getTen());
			sanPhamDTO.setDoHot(getDoHot(minQuantity,maxQuantity,dataProduct.get(sanPham.getTen())));
			listSP.add(sanPhamDTO);
		}
		model.addAttribute("listSP",listSP);
		
		Set<chiTietHoaDonBanDTO> c = new HashSet<>();
		model.addAttribute("chiTiet",c);
		
		HoaDonBanDTO hdb = new HoaDonBanDTO();
		model.addAttribute("hoaDonBan",hdb);
        return "create_invoice";
    }
	
	public String getDoHot(int minQuantity,int maxQuantity,int soluong) {
		int nguong=Math.round((maxQuantity-minQuantity) / 3) ;
		if(soluong<minQuantity+nguong) {
			return "Ít";
		}
		else if(soluong>=minQuantity+nguong&&soluong<minQuantity+2*nguong) {
			return "Trung Bình";
		}
		else {
			return "Nhiều";
		}
	}
	@GetMapping("/delete")
	public ModelAndView deleteInvoice(Model model, @RequestParam("id") Long id) {
		hoaDonBanService.deleteById(id);
		return new ModelAndView("redirect:" + "/sell/list");
	}
}
