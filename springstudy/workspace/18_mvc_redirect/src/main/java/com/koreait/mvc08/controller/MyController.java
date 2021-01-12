package com.koreait.mvc08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mvc08.dto.PersonDto;

@Controller
public class MyController {

	/*
		@RequestMapping(value= {"/", "index"})
		
		연결되는 URLMapping 값이 2개 이상인 경우에 사용하시면 됩니다.
	*/
	
	@RequestMapping(value= {"/", "index"}, method=RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="v01", method=RequestMethod.GET)
	public String view01(PersonDto personDto, Model model) {
		
		model.addAttribute("personDto", personDto);
		
		return "view01";	// 포워드를 의미합니다. return "뷰이름";
		
	}
	
	@RequestMapping(value="v02", method=RequestMethod.GET)
	public String view02(PersonDto personDto, Model model) {
		
		model.addAttribute("personDto", personDto);
		// model은 request에 데이터를 저장합니다.
		
		return "redirect:v03";  // redirect입니다. redirect:매핑값(RequestMapping)
		// redirect는 기존의 request(model이 사용한 request)를 유지하지 않고 이동합니다.
		
	}
	
	@RequestMapping(value="v03", method=RequestMethod.GET)
	// redirect:v03 으로 이동하면서 기존의 request는 다 버리고 옵니다.
	// 따라서, view03.jsp에는 표시되는 내용이 없습니다.
	public String view03() {
		return "view03";
	}
	
	
	/*
		redirect를 할 때 값을 전달하고 싶으면,
		새로운 파라미터를 만들지 말고,
		RedirectAttributes rttr을 선언하고, addFlashAttribute() 메소드로 값을 저장하면 됩니다.
	*/
	@RequestMapping(value="v04", method=RequestMethod.GET)
	public String view04(PersonDto personDto, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("personDto", personDto);
		
		return "redirect:v05";
		
	}
	
	@RequestMapping(value="v05", method=RequestMethod.GET)
	public String view05() {
		return "view05";
	}
	
}
