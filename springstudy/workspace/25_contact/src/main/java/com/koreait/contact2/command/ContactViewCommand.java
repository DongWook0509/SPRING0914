package com.koreait.contact2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.contact2.dao.ContactDao;

public class ContactViewCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		ContactDao contactDao = new ContactDao();
		model.addAttribute("contactDto", contactDao.contactView(no));
		
	}

}