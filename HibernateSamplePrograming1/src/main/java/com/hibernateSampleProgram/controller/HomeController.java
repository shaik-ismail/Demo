package com.hibernateSampleProgram.controller;

import com.hibernateSampleProgram.ServiceDao.StudentService;
import com.hibernateSampleProgram.Vo.CommonVo;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{
	@Autowired
	StudentService service;

	@RequestMapping(value = "studentinfo", method = RequestMethod.GET)
	public String StudentInfo(@ModelAttribute("CommonVo") CommonVo commonvo, ModelMap model)
	{
		System.out.println("in method 1");
		return "Studentinformation";
	}

	@RequestMapping(value = "Allstudent", method = RequestMethod.GET)
	public String StudentGrid(@ModelAttribute("CommonVo") CommonVo commonvo, ModelMap model, HttpServletRequest request)
	{
		int stdID = commonvo.getStdid();

		String category = request.getParameter("buttonValue");
		String stdName = commonvo.getStdName();
		String stdGender = commonvo.getStdgender();
		JSONArray commonVO = null;
		if (category.equals("LIST"))
		{
			commonVO = service.retrive(stdID, stdName, stdGender);
		}
		else if (category.equals("ADD"))
		{

			service.insert(stdID, stdName, stdGender);
		}
		model.addAttribute("commonVO", commonVO);
		System.out.println(commonVO);
		return "StudentList";
	}
}
