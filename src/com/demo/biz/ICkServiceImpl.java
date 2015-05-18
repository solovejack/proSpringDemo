package com.demo.biz;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ICkDAO;
import com.demo.dao.entity.Ck;

@Service
public class ICkServiceImpl implements ICkService {
	@Autowired
	private ICkDAO ckDAO;

	@Override
	public Ck findByPK(String ckdm){
        return ckDAO.findByPK(ckdm);
	}

	@Override
	public Collection<Ck> findAllCk() {
		// TODO 自动生成的方法存根
		return ckDAO.findAllCk();
	}

	@Override
	public Collection<Ck> findCkByCkdm(String ckdm) {
		// TODO 自动生成的方法存根
		return ckDAO.findCkByCkdm(ckdm);
	}

	@Override
	public Collection<Ck> findCkByCkmc(String ckmc) {
		// TODO 自动生成的方法存根
		return ckDAO.findCkByCkmc(ckmc);
	}
	
	@Override
	public String delByPK(String ckmc){
		return ckDAO.delByPK(ckmc);
	}

	@Override
	public String saveCk(Ck ck, String flag) {
		// TODO 自动生成的方法存根
		if("u".equals(flag)){
			//保存
			return ckDAO.updByPK(ck);
		}else{
			//新增
			return ckDAO.insByPK(ck);
		}
	}
}
