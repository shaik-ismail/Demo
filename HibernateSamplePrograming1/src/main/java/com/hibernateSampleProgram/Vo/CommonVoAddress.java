package com.hibernateSampleProgram.Vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "studentAddress")
public class CommonVoAddress
{

	@Id
	@GeneratedValue
	private Integer AddId;
	private String StdAddCountry;
	private String StdAddCity;
	
	@ManyToOne(targetEntity=CommonVo.class)
	private CommonVo commonVo ;

	
	@JoinColumn(name="ID", nullable=false)
	public Integer getAddId()
	{
		return AddId;
	}
	public void setAddId(Integer  addId)
	{
		AddId = addId;
	}
	public String getStdAddCountry()
	{
		return StdAddCountry;
	}
	public void setStdAddCountry(String stdAddCountry)
	{
		StdAddCountry = stdAddCountry;
	}
	public String getStdAddCity()
	{
		return StdAddCity;
	}
	public void setStdAddCity(String stdAddCity)
	{
		StdAddCity = stdAddCity;
	}
	
	public CommonVo getCommonVo()
	{
		return commonVo;
	}
	public void setCommonVo(CommonVo commonVo)
	{
		this.commonVo = commonVo;
	}

}
