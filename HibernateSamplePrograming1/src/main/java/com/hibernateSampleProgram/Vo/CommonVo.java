package com.hibernateSampleProgram.Vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
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

@Entity
@Table(name = "Student1")
public class CommonVo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer Stdid;

	private String StdName;

	private String Stdgender;

	@OneToMany(targetEntity = CommonVo.class)
	private Set<CommonVoAddress> address = new HashSet<CommonVoAddress>();

	public Integer getStdid()
	{
		return this.Stdid;
	}

	public void setStdid(Integer stdid)
	{
		this.Stdid = stdid;
	}

	public String getStdName()
	{
		return this.StdName;
	}

	public void setStdName(String stdName)
	{
		this.StdName = stdName;
	}

	public String getStdgender()
	{
		return this.Stdgender;
	}

	public void setStdgender(String stdgender)
	{
		this.Stdgender = stdgender;
	}

	public Set<CommonVoAddress> getAddress()
	{
		return address;
	}

	public void setAccounts(Set<CommonVoAddress> Address)
	{
		this.address = Address;
	}

}
