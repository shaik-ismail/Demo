package com.hibernateSampleProgram.Dao;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentdao {
  List Save(int paramInt, String paramString1, String paramString2);
  
  void insert(Integer paramInt, String paramString1, String paramString2);
}
