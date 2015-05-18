package com.demo.dao;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.UserRole;

@Repository
public class IUserRoleDAOImpl extends BaseDAO implements IUserRoleDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<UserRole> findByUserId(String userId) {
		String strSQL = "select * from t_user_roles where userId = '"
				+ userId + "'";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(UserRole.class));
	}
	
	/**
	 * 根据用户删除角色
	 * @param userId
	 * @return 删除结果
	 */
	@Override
	public String delByUserId(String userId){
		String strSql = "delete from t_user_roles where userId = '"+ userId + "'";
		try{
			this.getJdbcTemplate().update(strSql);
		} catch (Exception e){
			System.out.println(e);
			return "N";
		}
		return "Y";
	}
	
	/**
	 * 
	 * @param userRole
	 * @return 
	 */
	@Override
	public String insByPK(UserRole userRole){
		StringBuffer str = new StringBuffer();
		str.append("insert into t_user_roles (userId,role_id)  VALUES(");
		str.append("'"+userRole.getUserId()+"',");
		str.append("'"+userRole.getRoleId()+"'");
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
