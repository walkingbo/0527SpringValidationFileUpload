package co.kr.pk;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.pk.domain.Member;
import co.kr.pk.domain.Report;
import co.kr.pk.validator.MemberValidator;


@Controller
public class HomeController {
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model,@ModelAttribute("member") Member member) {
		//register로 포워딩 하도록 설정 
		return "register";
	}
	//유효성 검사를 수행해야 하면 매개변수로 BindingResult를 추가 
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Model model, @Valid @ModelAttribute("member") Member member, Errors errors) {
		
		//유효성 검사를 통과하지 못한 경우 
		if(errors.hasErrors()) {
			return "register";
		}
		//메인페이지로 리다이렉트 
		return "./";
	}
	
	@RequestMapping(value = "fileupload", method = RequestMethod.GET)
	public String fileupload(Model model) {
		return "fileupload";
	}
	/*
	//파일 업로드 처리가 가능한 MultipartRequest를 이용한 처리 
	@RequestMapping(value = "fileupload", method = RequestMethod.POST)
	public String fileupload(Model model,MultipartHttpServletRequest request) {
		//파라미터 가져오기
		String name =  request.getParameter("name");
		MultipartFile file = request.getFile("imgfile");
		System.out.println("name:"+name);
		System.out.println("file:"+file);
		return "fileupload";
	}*/
	
	/*
	//@RequestParam을 이용하는 방법 
		@RequestMapping(value = "fileupload", method = RequestMethod.POST)
		public String fileupload(Model model, @RequestParam("name") String name, @RequestParam("imgfile") MultipartFile file	) {
			//파라미터 가져오기
			System.out.println("name:"+name);
			System.out.println("file:"+file);
			return "fileupload";
		}
	*/
	
	//Command 객체를 이용하는 방법 
	@RequestMapping(value = "fileupload", method = RequestMethod.POST)
	public String fileupload(Model model, Report report	) {
		//파라미터 가져오기
		System.out.println(report);
		//파일을 전송
		//파일 이름 만들기
		String filename =UUID.randomUUID().toString() + report.getImgfile().getOriginalFilename();
		File f = new File("/Users/a503_18/Documents/"+filename);
		try {
			report.getImgfile().transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "fileupload";
	}
	
	
	
	
}
