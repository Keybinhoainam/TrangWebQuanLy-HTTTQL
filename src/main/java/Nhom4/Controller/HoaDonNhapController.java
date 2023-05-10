package Nhom4.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import Nhom4.Model.HoaDonNhap;
import Nhom4.Model.NhaCungCap;
import Nhom4.Model.SanPham;
import Nhom4.Responsitory.ChiTietHoaDonNhapRespository;
import Nhom4.Responsitory.HoaDonNhapRespository;
import Nhom4.Responsitory.NhaCungCapRespository;
import Nhom4.Responsitory.SanPhamResponsitory;
//import Nhom4.Responsitory.SanPhamRespository;

@Controller
@RequestMapping("/purchase")
public class HoaDonNhapController {
	@Autowired
	HoaDonNhapRespository hoaDonNhapRespository;
	@Autowired
	ChiTietHoaDonNhapRespository chiTietHoaDonNhapRespository;
	@Autowired
	SanPhamResponsitory sanPhamRespository;
	@Autowired
	NhaCungCapRespository nhaCungCapRespository;
	
	
	@GetMapping("/list")
	public String showList(ModelMap model)
    {
		List<HoaDonNhap> list = hoaDonNhapRespository.findAll();
		model.addAttribute("listHDN",list);
        return "table_list_purchase";
    }
	
	@GetMapping("/invoice")
	public String showInvoice(ModelMap model, @RequestParam("id") Long id)
    {
		HoaDonNhap h = hoaDonNhapRespository.getById(id);
		model.addAttribute("hoaDonNhap",h);
        return "purchase_detail";
    }
	
	@GetMapping("/add")
	public String showAddForm(ModelMap model)
    {
		List<NhaCungCap> list = nhaCungCapRespository.findAll();
		model.addAttribute("listNCC",list);
		
		List<SanPham> listSP = sanPhamRespository.findAll();
		model.addAttribute("listSP",listSP);
		
        return "create_purchase";
    }
	
	
	@GetMapping("/delete")
	public ModelAndView deleteInvoice(Model model, @RequestParam("id") Long id) {
		hoaDonNhapRespository.deleteById(id);
		return new ModelAndView("redirect:" + "/purchase/list");
	}
}
