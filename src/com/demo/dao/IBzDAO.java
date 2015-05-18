package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Bz;

public interface IBzDAO {
	public Bz findByPK(String bzdm);

	public Collection<Bz> findAllBz();
	
	public Collection<Bz> findBzByBzmc(String bzmc);
}
