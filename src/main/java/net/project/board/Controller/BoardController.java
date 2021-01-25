package net.project.board.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.project.Member.vo.MemberVO;
import net.project.board.BoardVO.BoardVO;
import net.project.board.service.BoardService;
import net.project.util.Criteria;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject 
	BoardService BS;
	
	
	@RequestMapping("/board/main")
	public String main(){
		
		return "redirect:/board/main";
	}
	
	@RequestMapping("/main")
	public ModelAndView boardMain(
			ModelAndView mav,
			Criteria cri
			) throws Exception {
		//페이징 처리
		mav.addObject("pm", BS.GetPagemaker(cri));
		System.out.println("GetPagemaker"+BS.GetPagemaker(cri));
		//
		
		mav.addObject("Board", BS.boardList(cri));
		mav.setViewName("board/main");
		return mav;
		
	}
	
	@RequestMapping("/regist")
	public void regist(
			@ModelAttribute MemberVO membervo) {
		
	}
	@RequestMapping("/BoardRegist")
	public String BoardRegist(
			BoardVO VO,
			RedirectAttributes rttr
			) throws Exception {
		
		String message = BS.regist(VO);
		rttr.addFlashAttribute("message", message);
		
		return "redirect:/board/main";
	}
	
	
	@RequestMapping("/member/logout")
	public String logout(
			HttpSession session,
			RedirectAttributes rttr
			) {
		session.invalidate();
		rttr.addFlashAttribute("message","S");
		return "redirect:/";
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(
			int bNum,
			ModelAndView mav
			) throws Exception {
		mav.setViewName("board/boardDetail");
		mav.addObject("VO", BS.DetailBoard(bNum));
	
		return mav;
	}
	@RequestMapping("/insert")
	public ModelAndView insert(
			ModelAndView mav,
			BoardVO VO) {
		System.out.println("insert"+VO);
		mav.addObject("VO", VO);
		mav.setViewName("board/insert");
		return mav;
	}
	
	@RequestMapping("/modify")
	public String modify(
			BoardVO VO,
			RedirectAttributes rttr
			) throws Exception {
	String message = BS.modify(VO);
		rttr.addFlashAttribute("message", message);
		
		return "redirect:/board/main";
	}
	
	@RequestMapping("/delete")
	public String delete(
			int bNum,
			RedirectAttributes rttr
			) throws Exception {
		String message = BS.DELETE(bNum);
		rttr.addFlashAttribute("message", message);
		
		return "redirect:/board/main";
	}
	
	
	
	
}
