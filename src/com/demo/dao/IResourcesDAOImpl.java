package com.demo.dao;

import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.demo.base.BaseDAO;
import com.demo.dao.entity.Resources;

@Repository
public class IResourcesDAOImpl extends BaseDAO implements IResourcesDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Resources> findResourcesByResId(String resId) {
		String strSQL = "select res_Id resId,res_Desc resDesc,res_Form resForm,res_ActionName resActionName,res_Xtmc resXtmc,bz bz from t_resources where res_Id like '%"
				+ resId + "%'";
		// return this.getJdbcTemplate().queryForObject(strSQL,
		// new ParameterizedRowMapper<User>() {
		// @Override
		// public User mapRow(ResultSet rs, int rowNum)
		// throws SQLException {
		// User user = new User();
		// user.setUsrId(rs.getString("userid"));
		// user.setUsrName(rs.getString("username"));
		// user.setUsrPwd(rs.getString("password"));
		// return user;
		// }
		// });

		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Resources.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Resources> findAllResources() {
		String strSQL = "select res_Id resId,res_Desc resDesc,res_Form resForm,res_ActionName resActionName,res_Xtmc resXtmc,bz bz from t_resources";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(Resources.class));
	}

	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String saveRes(Resources res,String flag){
		String strSql = "";
		if("c".equals(flag)){
			strSql = "INSERT INTO t_resources (res_Id, res_Desc,res_Xtmc,bz)  VALUES('"  
			           + res.getResId() + "', '"  
			           + res.getResDesc() + "', '"  
			           + res.getResXtmc() + "', '"  
			           + res.getBz() + "')";
		}else if("u".equals(flag)){
			strSql = "UPDATE  t_resources set  res_Desc='"  
			           + res.getResDesc() + "', res_Xtmc='"  
			           + res.getResXtmc() + "', bz='"  
			           + res.getBz() + "' where res_Id = '"+res.getResId()+"'";
		}
		System.out.println("strSql=="+strSql);
		try{
			this.getJdbcTemplate().update(strSql);
			return "Y";
		} catch(Exception e){
			return "N";
		}	
	}
	
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String delRes(Resources res){
		return this.delRes(res.getResId());
	}
	
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String delRes(String resId){
		String strSql = "delete from t_resources where res_Id='"+resId+"'";
		System.out.println("sql=="+strSql);
		this.getJdbcTemplate().update(strSql);
		return "Y";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Resources findByPK(String resId) {
		String strSQL = "select res_Id resId,res_Desc resDesc,res_Form resForm,res_ActionName resActionName,res_Xtmc resXtmc,bz bz from t_resources where res_Id='"+resId+"'";
		try {
			System.out.println(strSQL);
			   return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(Resources.class));
			} catch (EmptyResultDataAccessException erdae) {
			   return new Resources();
		}
	}
}
