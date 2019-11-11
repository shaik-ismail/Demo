package com.hibernateSampleProgram.DaoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernateSampleProgram.Dao.Studentdao;
import com.hibernateSampleProgram.Vo.CommonVo;
import com.hibernateSampleProgram.Vo.CommonVoAddress;

@Repository
public class StudentDaoImpl implements Studentdao
{
	@Autowired
	SessionFactory sessionFactory;

	public List Save(int stdID, String stdName, String stdGender)
	{
		Session session = this.sessionFactory.openSession();
		org.hibernate.Query nativeQuery = null;
		try
		{
			nativeQuery = session.createSQLQuery("Select * from Student1");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return nativeQuery.list();
	}

	@Transactional
	public void insert(Integer stdID, String stdName, String stdGender)
	{
		Session session6 = null;
		session6 = sessionFactory.openSession();
		Transaction tx1 = session6.beginTransaction();
		CommonVoAddress address;
		try
		{
			CommonVo common = new CommonVo();
			common.setStdName(stdName);
			common.setStdgender(stdGender);
			session6.save(common);

			address = new CommonVoAddress();
			address.setStdAddCity("Benguluru");
			address.setStdAddCountry("India");

			address.setCommonVo(common);

			session6.save(address);

			address = new CommonVoAddress();
			address.setStdAddCity("Hyderbad");
			address.setStdAddCountry("India");
			session6.save(address);

			System.out.println("3. Before committing save transaction");
			tx1.commit();
			System.out.println("4. After committing save transaction");
			System.out.println("*****");
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			tx1.rollback();
		}
		finally
		{
			if (session6 != null && session6.isOpen())
			{
				session6.flush();
				session6.clear();
				session6.close();
			}
		}
	}
}
