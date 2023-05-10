package Nhom4.Controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Nhom4.Dto.TaiKhoanDTO;
import Nhom4.Model.TaiKhoan;
import Nhom4.Service.TaiKhoanService;



@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	TaiKhoanService taiKhoanService;
	@RequestMapping("/")
    public String home(ModelMap model)
    {
        
        return "index";
    }
	@GetMapping("/login")
    public String login(ModelMap model)
    {
        TaiKhoanDTO taiKhoan=new TaiKhoanDTO();
        model.addAttribute("taiKhoan",taiKhoan);
        return "login";
    }
	@PostMapping("/login")
    public String loginPost(ModelMap model, @ModelAttribute("taiKhoan") TaiKhoanDTO tk)
    {
		System.out.println(tk.getUserName()+"  "+tk.getPassword());
		Optional<TaiKhoan> tk2opt = taiKhoanService.findById(tk.getUserName());
		
		if(tk2opt.isEmpty() || !tk2opt.get().getPassword().equals(tk2opt.get().getPassword())) {
			model.addAttribute("message","Invalid username or password.");
			return "login";
		}
        
		model.addAttribute("message","Login successful.");
        return "index";
    }
	@GetMapping("/signup")
    public String signup(ModelMap model)
    {
		
        TaiKhoanDTO taiKhoan=new TaiKhoanDTO();
        model.addAttribute("taiKhoan",taiKhoan);
        return "signup";
    }
	@PostMapping("/signup")
    public String signupPost(ModelMap model, @ModelAttribute("taiKhoan") TaiKhoanDTO tk)
    {
//		System.out.println(tk.getUserName()+"  "+tk.getPassword());
		Optional<TaiKhoan> tkcheckopt = taiKhoanService.findById(tk.getUserName());
		if(tkcheckopt.isPresent() || !tk.getPassword().equals(tk.getConfirmPassword())) {
//			System.out.println("check");
			model.addAttribute("message","Registration error.");
			return "signup";
		}
		TaiKhoan tksave= new TaiKhoan();
		BeanUtils.copyProperties(tk, tksave);
		
        taiKhoanService.save(tksave);
		model.addAttribute("message","Registration Successful");
		return "login";


    }
}
