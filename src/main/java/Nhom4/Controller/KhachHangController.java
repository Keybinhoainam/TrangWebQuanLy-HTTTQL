package Nhom4.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Nhom4.Dto.KhachHangDTO;
import Nhom4.Model.KhachHang;
import Nhom4.Service.KhachHangService;

@Controller
@RequestMapping("/customer")
public class KhachHangController {
	@Autowired
	KhachHangService khachHangService;
	
	@GetMapping("/list")
	public String showList(ModelMap model)
    {
		List<KhachHang> list = khachHangService.findAll();
//		List<KhachHangDTO> listDTO = new ArrayList<>();
//		for (KhachHang khachHang : list) {
//			KhachHangDTO khachHangDTO = new KhachHangDTO();
//			BeanUtils.copyProperties(khachHang, khachHangDTO);
//			
//			listDTO.add(khachHangDTO);
//		}
//		for (KhachHangDTO khachHangDTO : listDTO) {
//			System.out.println(khachHangDTO.getTen());
//		}
		model.addAttribute("listKH",list);
        return "table_list_customers";
    }
	
	@GetMapping("/add")
	public String showAddForm(ModelMap model)
    {
		KhachHangDTO kh = new KhachHangDTO();
		model.addAttribute("khachHang",kh);
        return "form_add_customer";
    }
	
	@PostMapping("/add")
    public ModelAndView addCustomer(ModelMap model, @ModelAttribute("khachHang") KhachHangDTO kh)
    {
		System.out.println(kh.getNgaySinh().toString());
		KhachHang k = new KhachHang();
		BeanUtils.copyProperties(kh, k);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		
		LocalDate date1 = LocalDate.parse(kh.getNgaySinh());
		Date date = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		k.setNgaySinh(date);
		khachHangService.save(k);
		model.addAttribute("message","Thành công!");
        return new ModelAndView("redirect:" + "/customer/list");
    }
	
	@GetMapping("/edit")
	public String showEditForm(ModelMap model, @RequestParam("id") Long id)
    {
		KhachHang k = khachHangService.getById(id);
		KhachHangDTO kh = new KhachHangDTO();
		BeanUtils.copyProperties(k, kh);
		kh.setNgaySinh(k.getNgaySinh().toString());
		model.addAttribute("khachHang",kh);
        return "form_edit_customer";
    }
	
	@PostMapping("/edit")
    public ModelAndView editCustomer(ModelMap model, @RequestParam("id") Long id, @ModelAttribute("khachHang") KhachHangDTO kh)
    {
//		System.out.println(tk.getUserName()+"  "+tk.getPassword());
		KhachHang k = new KhachHang();
		BeanUtils.copyProperties(kh, k);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		
		LocalDate date1 = LocalDate.parse(kh.getNgaySinh());
		Date date = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		k.setNgaySinh(date);
		k.setId(id);
		khachHangService.save(k);
		model.addAttribute("message","Thành công!");
		return new ModelAndView("redirect:" + "/customer/list");
    }
	
	@GetMapping("/delete")
	public ModelAndView deleteCustomer(Model model, @RequestParam("id") Long id) {
		khachHangService.deleteById(id);
		return new ModelAndView("redirect:" + "/customer/list");
	}
}
