package net.project.Member.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.project.Member.service.MemberService;
import net.project.Member.vo.MemberVO;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Inject
	MemberService MS;

	@RequestMapping("/join")
	public void join() {
		
	}
	@RequestMapping("/joinsubmit")
	public String joinSubmit(
			MemberVO vo,
			RedirectAttributes rttr) throws Exception {
		
		String message = MS.joinMember(vo);
		rttr.addFlashAttribute("message",message);
	
		System.out.println("message : "+message);
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	public void login() {
		
	}
	
	@RequestMapping("/loginsubmit")
	public String loginSubmit(
			String userid,
			String userpw,
			HttpSession session) throws Exception {
		
		
		MemberVO member = MS.loginSubmit(userid, userpw);
		System.out.println("member"+member);
		/*
		 * mav.addObject("member", member); mav.setViewName("common/home");
		 */
		session.setAttribute("member", member);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(
			HttpSession session,
			RedirectAttributes rttr
			) {
		session.invalidate();
		rttr.addFlashAttribute("message","S");
		return "redirect:/";
	}
	
	
}
