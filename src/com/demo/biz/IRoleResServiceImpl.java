package com.demo.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IResourcesDAO;
import com.demo.dao.IRoleResDAO;
import com.demo.dao.entity.ResCheck;
import com.demo.dao.entity.Resources;
import com.demo.dao.entity.RoleRes;
import com.demo.util.AssertUtil;

@Service
public class IRoleResServiceImpl implements IRoleResService {
	@Autowired
	private IRoleResDAO roleResDAO;
	
	@Autowired
	private IResourcesDAO resDAO;

	@Override
    public List<ResCheck> getResListByRoleId(String roleId){
		List<ResCheck> ret = new ArrayList<ResCheck>();
		Collection<Resources> resCol = resDAO.findAllResources();
		Set<String> resList = this.getResByRoleId(roleId);
		Iterator<Resources> it = resCol.iterator();
		while(it.hasNext()){
			Resources res = it.next();
			ResCheck resCheck = new ResCheck();
			resCheck.setResId(res.getResId());
			if(resList.contains(res.getResId())){
				resCheck.setResCheck("Y");
			}else{
				resCheck.setResCheck("N");
			}
			ret.add(resCheck);
		}
		return ret;
	}
	
	@Override
	public Set<String> getResByRoleId(String roleId){
		Set<String> res = new HashSet<String>();
		Collection<RoleRes> roleResCol = roleResDAO.findByRoleId(roleId);
		Iterator<RoleRes> it = roleResCol.iterator();
		while(it.hasNext()){
			RoleRes roleRes = it.next();
			if(AssertUtil.isVal(roleRes.getResId())){
				res.add(roleRes.getResId());
			}
		}
		return res;
	}

	@Override
	public String saveRoleRes(String roleId, String resList) {
		// TODO 自动生成的方法存根
		//删除以前的权限
		roleResDAO.delByRoleId(roleId);
		//添加最新的权限
		if(AssertUtil.isVal(resList)){
			for(String resId : resList.split(",")){
				RoleRes roleRes = new RoleRes();
				roleRes.setResId(resId);
				roleRes.setRoleId(roleId);
				roleResDAO.insByPK(roleRes);
			}
		}
		return "Y";
	}
}
