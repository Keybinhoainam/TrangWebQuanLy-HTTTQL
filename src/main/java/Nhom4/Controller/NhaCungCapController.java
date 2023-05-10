package Nhom4.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Nhom4.Dto.NhaCungCapDTO;
import Nhom4.Model.NhaCungCap;
import Nhom4.Responsitory.NhaCungCapRespository;

@Controller
@RequestMapping("/supplier")
public class NhaCungCapController {
	@Autowired
	NhaCungCapRespository nhaCungCapRespository;
	
	@GetMapping("/list")
	public String showList(ModelMap model)
    {
		List<NhaCungCap> list = nhaCungCapRespository.findAll();
		model.addAttribute("listNCC",list);
        return "table_list_suppliers";
    }
	
	@GetMapping("/add")
	public String showAddForm(ModelMap model)
    {
		NhaCungCapDTO ncc = new NhaCungCapDTO();
		model.addAttribute("nhacungcap",ncc);
        return "form_add_supplier";
    }
	
	@PostMapping("/add")
    public ModelAndView addCustomer(ModelMap model, @ModelAttribute("nhacungcap") NhaCungCapDTO ncc)
    {
//		System.out.println(kh.getNgaySinh().toString());
		NhaCungCap k = new NhaCungCap();
		BeanUtils.copyProperties(ncc, k);
		nhaCungCapRespository.save(k);
		model.addAttribute("message","Thành công!");
        return new ModelAndView("redirect:" + "/supplier/list");
    }
	
	@GetMapping("/edit")
	public String showEditForm(ModelMap model, @RequestParam("id") Long id)
    {
		NhaCungCap k = nhaCungCapRespository.getById(id);
		NhaCungCapDTO kh = new NhaCungCapDTO();
		BeanUtils.copyProperties(k, kh);
		model.addAttribute("nhacungcap",kh);
        return "form_edit_supplier";
    }
	
	@PostMapping("/edit")
    public ModelAndView editCustomer(ModelMap model, @RequestParam("id") Long id, @ModelAttribute("nhacungcap") NhaCungCapDTO ncc)
    {
//		System.out.println(tk.getUserName()+"  "+tk.getPassword());
		NhaCungCap k = new NhaCungCap();
		BeanUtils.copyProperties(ncc, k);
		k.setId(id);
		nhaCungCapRespository.save(k);
		model.addAttribute("message","Thành công!");
		return new ModelAndView("redirect:" + "/supplier/list");
    }
	
	@GetMapping("/delete")
	public ModelAndView deleteCustomer(Model model, @RequestParam("id") Long id) {
		nhaCungCapRespository.deleteById(id);
		return new ModelAndView("redirect:" + "/supplier/list");
	}
}
