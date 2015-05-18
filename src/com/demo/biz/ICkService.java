package com.demo.biz;

import java.util.Collection;

import com.demo.dao.entity.Ck;

public interface ICkService {
	public Ck findByPK(String ckdm);

	public Collection<Ck> findAllCk();
	
	public Collection<Ck> findCkByCkdm(String ckdm);
	
	public Collection<Ck> findCkByCkmc(String ckmc);
	
	public String saveCk(Ck ck, String flag);
	
	public String delByPK(String ckmc);
}
