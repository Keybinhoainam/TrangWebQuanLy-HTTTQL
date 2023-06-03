package Nhom4.Controller;

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

import Nhom4.Dto.DanhMucSanPhamDTO;
import Nhom4.Dto.SanPhamDTO;
import Nhom4.Exception.StorageException;
import Nhom4.Exception.StoreFileNotFoundException;
import Nhom4.Model.DanhMucSanPham;
import Nhom4.Model.SanPham;
import Nhom4.Service.DanhMucSanPhamService;
import Nhom4.Service.SanPhamService;
import Nhom4.Service.StorageService;



@Controller
@RequestMapping("/product/")
public class SanPhamController {
	@Autowired
	SanPhamService productservice;
	@Autowired
	DanhMucSanPhamService categoryService;
	
	@Autowired
	StorageService storageService;
	
	@ModelAttribute("categories")
	public List<DanhMucSanPhamDTO> getCategories(){
		return categoryService.findAll().stream().map(item->{
			DanhMucSanPhamDTO dtoc=new DanhMucSanPhamDTO();
			BeanUtils.copyProperties(item, dtoc);
			return dtoc;
		}).collect(Collectors.toList());
	}

	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("product", new SanPhamDTO());
		return "htttql/ProductAddorEdit";
	}
	@GetMapping("edit/{productId}")
	public String edit(Model model, @PathVariable("productId") Long productId) {
		Optional<SanPham> opt=productservice.findById(productId);
		SanPhamDTO dtop=new SanPhamDTO();
		if(opt.isPresent()) {
			SanPham p=opt.get();
			BeanUtils.copyProperties(p, dtop);
			dtop.setDanhMucSanPhamId(p.getDanhMucSanPham().getId()) ;
			dtop.setIsEdit(true);

			model.addAttribute("product", dtop);
			return "htttql/ProductAddorEdit";
		}
		model.addAttribute("mes", "Product is Empty");
		return "forward: /product/list";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveorupdate(ModelMap model,
			@Valid @ModelAttribute("product") SanPhamDTO dto,BindingResult result) throws StorageException {
		if(result.hasErrors()) {
			return new ModelAndView("htttql/ProductAddorEdit",model);
		}
		SanPham p=new SanPham();
		BeanUtils.copyProperties(dto, p);
		DanhMucSanPham category=new DanhMucSanPham();
		category.setId(dto.getDanhMucSanPhamId());
		System.out.println(dto.getDanhMucSanPhamId());
		p.setDanhMucSanPham(category);
//		if(p.getSoLuong()==0) {
//			p.setIsshow(false);
//		}
		if(!dto.getImageFile().isEmpty()) {
			UUID uuid=UUID.randomUUID();
			String uuString=uuid.toString();
			p.setHinhAnh(storageService.getStoredFilename(dto.getImageFile(), uuString));
			storageService.store(dto.getImageFile(), p.getHinhAnh());
		}
		else {
			if(dto.getHinhAnh().isEmpty()||dto.getHinhAnh().isBlank()) {
				p.setHinhAnh(null);
			}
			else {
				p.setHinhAnh(dto.getHinhAnh());
			}
			
			
		}
		
		productservice.save(p);
		model.addAttribute("mes", "Product is saved");
		return new ModelAndView("redirect:/product/list",model);
	}
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws StoreFileNotFoundException{
		Resource file=storageService.loadAsResource(filename); 
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment; filename=\"" +file.getFilename()+"\"").body(file);
	}
	@GetMapping("delete/{productId}")
	public String delete(Model model, @PathVariable("productId") Long productId) {
		Optional<SanPham> opt=productservice.findById(productId);
		
		if(opt.isPresent()) {
			productservice.deleteById(productId);
			model.addAttribute("mes", "Product is Deleted");
			return "forward:/product/list";
		}
		model.addAttribute("mes", "Product is Empty");
		return "forward:/product/list";
	}
	@RequestMapping("list")
	public String list(Model model) {
		List<SanPham> list=productservice.findAll();
		model.addAttribute("products", list);
		return "htttql/ProductList";
	}
	@RequestMapping("search")
	public String search(Model model, @RequestParam(name="name") String name){
		List<SanPham> list=null;
		if(!name.isEmpty()) {
			list=productservice.findByNameContaining(name);
		}
		else list=productservice.findAll();
		model.addAttribute("products", list);
		return "htttql/ProductList";
	}
	@RequestMapping("listinstock")
	public String listinstock(Model model) {
		List<SanPham> list=productservice.findProductInStock();
		model.addAttribute("products", list);
		return "htttql/ProductList";
	}
	@RequestMapping("listoutstock")
	public String listoutstock(Model model) {
		List<SanPham> list=productservice.findProductOutStock();
		model.addAttribute("products", list);
		return "htttql/ProductList";
	}
}
