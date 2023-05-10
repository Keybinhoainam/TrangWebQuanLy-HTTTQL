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

@Controller
@RequestMapping("/sell")
public class HoaDonBanController {
	@Autowired 
	HoaDonBanService hoaDonBanService;
	@Autowired
	KhachHangService khachHangService;
	@Autowired
	SanPhamResponsitory sanPhamRepository;
	
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
		
		List<SanPham> sp = sanPhamRepository.findAll();
		List<SanPhamDTO> listSP = new ArrayList<>();
		for (SanPham sanPham : sp) {
			SanPhamDTO sanPhamDTO = new SanPhamDTO();
			BeanUtils.copyProperties(sanPham, sanPhamDTO);
			listSP.add(sanPhamDTO);
		}
		model.addAttribute("listSP",listSP);
		
		Set<chiTietHoaDonBanDTO> c = new HashSet<>();
		model.addAttribute("chiTiet",c);
		
		HoaDonBanDTO hdb = new HoaDonBanDTO();
		model.addAttribute("hoaDonBan",hdb);
        return "create_invoice";
    }
	
	
	@GetMapping("/delete")
	public ModelAndView deleteInvoice(Model model, @RequestParam("id") Long id) {
		hoaDonBanService.deleteById(id);
		return new ModelAndView("redirect:" + "/sell/list");
	}
}
