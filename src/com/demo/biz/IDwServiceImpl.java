package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IDwDAO;
import com.demo.dao.entity.Dw;

@Service
public class IDwServiceImpl implements IDwService {
	@Autowired
	private IDwDAO dwDAO;

	@Override
	public Collection<Dw> findAllDw() {
		// TODO 自动生成的方法存根
		return dwDAO.findAllDw();
	}

	@Override
	public Collection<Dw> findDwByDwmc(String dwmc) {
		// TODO 自动生成的方法存根
		return dwDAO.findDwByDwmc(dwmc);
	}
}
