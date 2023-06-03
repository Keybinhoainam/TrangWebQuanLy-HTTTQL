package Nhom4.Controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Nhom4.Dto.TaiKhoanDTO;
import Nhom4.Model.NhanVien;
import Nhom4.Model.TaiKhoan;
import Nhom4.Service.NhanVienService;
import Nhom4.Service.TaiKhoanService;



@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	TaiKhoanService taiKhoanService;
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	HttpSession session;
	@RequestMapping("/")
    public String home(ModelMap model)
    {
        
        return "redirect:/dashboard";
    }
	@RequestMapping("/dashboard")
    public String dashboard(ModelMap model)
    {
        
        return "htttql/dashboard";
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
		
		if(tk2opt.isEmpty() || !tk2opt.get().getPassword().equals(tk.getPassword())) {
			model.addAttribute("message","Invalid username or password.");
			return "login";
		}
		session.setAttribute("vaiTro", tk2opt.get().getVaiTro());
		NhanVien nhanVien=nhanVienService.findById(tk2opt.get().getNhanVien().getId()).get();
		session.setAttribute("nhanVienId", tk2opt.get().getNhanVien().getId());
		session.setAttribute("anhNhanVien", nhanVien.getHinhAnh());
		session.setAttribute("tenNhanVien", nhanVien.getTen());
		model.addAttribute("message","Login successful.");
        return "forward:/";
    }
	@RequestMapping("/logout")
    public String logout(ModelMap model)
    {
		session.removeAttribute("vaiTro");
        session.removeAttribute("nhanVienId");
        session.removeAttribute("anhNhanVien");
        session.removeAttribute("tenNhanVien");
        return "redirect:/login";
    }
	/*
	 * @GetMapping("/signup") public String signup(ModelMap model) {
	 * 
	 * TaiKhoanDTO taiKhoan=new TaiKhoanDTO();
	 * model.addAttribute("taiKhoan",taiKhoan); return "signup"; }
	 * 
	 * @PostMapping("/signup") public String signupPost(ModelMap
	 * model, @ModelAttribute("taiKhoan") TaiKhoanDTO tk) { //
	 * System.out.println(tk.getUserName()+"  "+tk.getPassword());
	 * Optional<TaiKhoan> tkcheckopt = taiKhoanService.findById(tk.getUserName());
	 * if(tkcheckopt.isPresent() ||
	 * !tk.getPassword().equals(tk.getConfirmPassword())) { //
	 * System.out.println("check");
	 * model.addAttribute("message","Registration error."); return "signup"; }
	 * TaiKhoan tksave= new TaiKhoan(); BeanUtils.copyProperties(tk, tksave);
	 * 
	 * taiKhoanService.save(tksave);
	 * model.addAttribute("message","Registration Successful"); return "login";
	 * 
	 * 
	 * }
	 */
}
