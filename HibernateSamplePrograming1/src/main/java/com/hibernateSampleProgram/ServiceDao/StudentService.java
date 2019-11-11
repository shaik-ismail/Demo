package com.hibernateSampleProgram.ServiceDao;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
  JSONArray retrive(int paramInt, String paramString1, String paramString2);
  
  void insert(int paramInt, String paramString1, String paramString2);
}
