package Nhom4.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Nhom4.Dto.NhanVienDTO;
import Nhom4.Exception.StorageException;
import Nhom4.Model.NhanVien;
import Nhom4.Service.NhanVienService;
import Nhom4.Service.StorageService;





@Controller
@RequestMapping("/employee/")
public class NhanVienController {
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	StorageService storageService;
	
//	@ModelAttribute("categories")
//	public List<DanhMucSanPhamDTO> getCategories(){
//		return categoryService.findAll().stream().map(item->{
//			DanhMucSanPhamDTO dtoc=new DanhMucSanPhamDTO();
//			BeanUtils.copyProperties(item, dtoc);
//			return dtoc;
//		}).collect(Collectors.toList());
//	}

	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("nhanVien", new NhanVienDTO());
		return "htttql/ListEmployee";
	}
	@GetMapping("edit/{employeeId}")
	public String edit(Model model, @PathVariable("employeeId") Long employeeId) {
		Optional<NhanVien> opt=nhanVienService.findById(employeeId);
		NhanVienDTO dtop=new NhanVienDTO();
		if(opt.isPresent()) {
			NhanVien p=opt.get();
			BeanUtils.copyProperties(p, dtop);
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            String date = dateFormat.format(p.getNgaySinh());  
			dtop.setIsEdit(true);
			model.addAttribute("nhanVien", dtop);
			return "htttql/NhanVienAddorEdit";
		}
		model.addAttribute("mes", "Product is Empty");
		return "forward: /employee/list";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveorupdate(ModelMap model,
			@Valid @ModelAttribute("nhanVien") NhanVienDTO dto,BindingResult result) throws StorageException, ParseException {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return new ModelAndView("htttql/NhanVienAddorEdit",model);
			
		}
		NhanVien p=new NhanVien();
		
		BeanUtils.copyProperties(dto, p);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println("Gioi tinh: "+dto.getGioiTinh());
//		Date date = formatter.parse(dto.getNgaySinh());
		LocalDate date1 = LocalDate.parse(dto.getNgaySinh());
		Date date = Date.from(date1.atStartOfDay(ZoneId.systemDefault()).toInstant());
//		System.out.println(date);
//		Date date2=new Date();
//		System.out.println(date2);
		p.setNgaySinh(date);
//		if(p.getSoLuong()==0) {
//			p.setIsshow(false);
//		}
		
		
		nhanVienService.save(p);
		model.addAttribute("mes", "Employee is saved");
		return new ModelAndView("redirect:/employee/list",model);
	}

	/*
	 * @GetMapping("/images/{filename:.+}")
	 * 
	 * @ResponseBody public ResponseEntity<Resource> serveFile(@PathVariable String
	 * filename) throws StoreFileNotFoundException{ Resource
	 * file=storageService.loadAsResource(filename); return
	 * ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	 * "attachment; filename=\"" +file.getFilename()+"\"").body(file); }
	 */
	@GetMapping("delete/{nhanVienId}")
	public String delete(Model model, @PathVariable("nhanVienId") Long nhanVienId) {
		Optional<NhanVien> opt=nhanVienService.findById(nhanVienId);
		
		if(opt.isPresent()) {
			nhanVienService.deleteById(nhanVienId);
			model.addAttribute("mes", "Employee is Deleted");
			return "forward:/employee/list";
		}
		model.addAttribute("mes", "Employee is Empty");
		return "forward:/employee/list";
	}
	@RequestMapping("list")
	public String list(Model model) {
		List<NhanVien> list=nhanVienService.findAll();
		model.addAttribute("nhanViens", list);
		return "htttql/NhanVienList";
	}
	@RequestMapping("search")
	public String search(Model model, @RequestParam(name="name") String name){
		List<NhanVien> list=null;
		if(!name.isEmpty()) {
			list=nhanVienService.findByNameContaining(name);
		}
		else list=nhanVienService.findAll();
		model.addAttribute("products", list);
		return "htttql/NhanVienList";
	}
	
}
