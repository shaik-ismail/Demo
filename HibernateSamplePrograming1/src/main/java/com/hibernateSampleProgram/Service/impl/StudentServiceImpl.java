package com.hibernateSampleProgram.Service.impl;

import com.hibernateSampleProgram.Dao.Studentdao;
import com.hibernateSampleProgram.ServiceDao.StudentService;
import com.hibernateSampleProgram.interfaces.ListAll;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService
{
	@Autowired
	Studentdao dao;

	public JSONArray retrive(int stdID, String stdName, String stdGender)
	{
		List common = this.dao.Save(stdID, stdName, stdGender);
		JSONArray json = new JSONArray();
		Iterator itr = common.iterator();
		ListAll lst = obj -> {
			while (itr.hasNext())
			{
				obj = (Object[]) itr.next();
				LinkedHashMap<Object, Object> lhm = new LinkedHashMap<Object, Object>();
				lhm.put("Emp_ID", obj[0]);
				lhm.put("Emp_Address", obj[1]);
				lhm.put("Emp_Age", obj[2]);

				json.add(lhm);
			}
		};

		lst.retriveAll(null);

		return json;
	}

	public void insert(int stdID, String stdName, String stdGender)
	{
		this.dao.insert(stdID, stdName, stdGender);
	}
}
