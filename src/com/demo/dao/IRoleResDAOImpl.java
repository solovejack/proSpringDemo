package com.demo.dao;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.RoleRes;

@Repository
public class IRoleResDAOImpl extends BaseDAO implements IRoleResDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<RoleRes> findByRoleId(String roleId) {
		String strSQL = "select * from t_role_resource where role_Id = '"
				+ roleId + "'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(RoleRes.class));
	}
	
	/**
	 * 根据角色删除权限
	 * @param userId
	 * @return 删除结果
	 */
	@Override
	public String delByRoleId(String roleId){
		String strSql = "delete from t_role_resource where role_Id = '"+ roleId + "'";
		try{
			this.getJdbcTemplate().update(strSql);
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}
		return "Y";
	}
	
	/**
	 * 新增角色权限
	 * @param userRole
	 * @return 
	 */
	@Override
	public String insByPK(RoleRes roleRes){
		StringBuffer str = new StringBuffer();
		str.append("insert into t_role_resource (res_id,role_id)  VALUES(");
		str.append("'"+roleRes.getResId()+"',");
		str.append("'"+roleRes.getRoleId()+"'");
		str.append(")");
		System.out.println("ins-sql=="+str.toString());
		try{
			this.getJdbcTemplate().update(str.toString());
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}	
		return "Y";
	}
}
