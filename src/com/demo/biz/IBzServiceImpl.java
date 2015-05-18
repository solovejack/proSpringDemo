package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IBzDAO;
import com.demo.dao.entity.Bz;

@Service
public class IBzServiceImpl implements IBzService {
	@Autowired
	private IBzDAO bzDAO;

	@Override
	public Collection<Bz> findAllBz() {
		// TODO 自动生成的方法存根
		return bzDAO.findAllBz();
	}

	@Override
	public Collection<Bz> findBzByBzmc(String bzmc) {
		// TODO 自动生成的方法存根
		return bzDAO.findBzByBzmc(bzmc);
	}
}
