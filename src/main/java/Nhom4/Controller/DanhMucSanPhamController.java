package Nhom4.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Nhom4.Dto.DanhMucSanPhamDTO;
import Nhom4.Model.DanhMucSanPham;
import Nhom4.Service.DanhMucSanPhamService;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
@Controller
@RequestMapping("/categories/")
public class DanhMucSanPhamController {
	@Autowired
	DanhMucSanPhamService categoryService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new DanhMucSanPhamDTO());
		return "htttql/CategoryAddorEdit";
	}
	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		Optional<DanhMucSanPham> opt=categoryService.findById(categoryId);
		DanhMucSanPhamDTO dto=new DanhMucSanPhamDTO();
		if(opt.isPresent()) {
			DanhMucSanPham entity=opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("category", dto);
			return new ModelAndView("htttql/CategoryAddorEdit",model);
		}
		model.addAttribute("mes", "Category is not existed");
		return new ModelAndView("forward:/categories/list",model);
		
		
	}
	@GetMapping("delete/{categoryId}")
	public ModelAndView delete(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		categoryService.deleteById(categoryId);
		model.addAttribute("mes", "Category is Deleted");
		return new ModelAndView("forward:/categories/list",model);
	}
	@PostMapping("saveOrUpdate")
			 
	public ModelAndView saveorupdate(ModelMap model,
			@Valid @ModelAttribute("category") DanhMucSanPhamDTO dto,BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("htttql/CategoryAddorEdit");
		}
		DanhMucSanPham entity=new DanhMucSanPham();
		BeanUtils.copyProperties(dto, entity);
		categoryService.save(entity);
		model.addAttribute("mes", "Category is saved");
		return new ModelAndView("forward:/categories/list",model);
	}
	@RequestMapping("list")
	public String list(Model model) {
		
		List<DanhMucSanPham>list=categoryService.findAll();
		model.addAttribute("categories", list);
		return "htttql/CategoryList";
	}
	@GetMapping("search")
	public String search(Model model,
			@RequestParam(name="name",required = false) String name) {
		
		List<DanhMucSanPham>list=null;
		if(!name.isEmpty()) {
			list=categoryService.findByNameContaining(name);
			
		}
		else {
			list=categoryService.findAll();
		}
		model.addAttribute("categories", list);
//		return new ModelAndView("forward:/admin/categories",model);
		return "htttql/CategoryList";
	}
//	@GetMapping("search/paginated")
//	public String paginated(Model model,
//			@RequestParam(name="name",required = false) String name,
//			@RequestParam("page") Optional<Integer> page,
//			@RequestParam("size") Optional<Integer> size
//			
//			) {
//		int currentPage=page.orElse(1);
//		int pageSize=size.orElse(5);
//		
//		Pageable pageable=PageRequest.of(currentPage, pageSize, Sort.by("name"));
//		Page<Category>
//		
//		
//		List<Category>list=null;
//		if(!name.isEmpty()) {
//			list=categoryService.findByNameContaining(name);
//			
//		}
//		else {
//			list=categoryService.findAll();
//		}
//		model.addAttribute("categories", list);
////		return new ModelAndView("forward:/admin/categories",model);
//		return "admin/categories/CategoryList";
//	}
	
	
}
