package com.demo.dao;

import java.util.Collection;

import com.demo.dao.entity.Ck;

public interface ICkDAO {
	public Ck findByPK(String ckdm);

	public Collection<Ck> findAllCk();
	
	public Collection<Ck> findCkByCkdm(String ckdm);
	
	public Collection<Ck> findCkByCkmc(String ckmc);
	
	public String delByPK(String ckdm);
	
	public String insByPK(Ck ck);
	
	public String updByPK(Ck ck);
}
