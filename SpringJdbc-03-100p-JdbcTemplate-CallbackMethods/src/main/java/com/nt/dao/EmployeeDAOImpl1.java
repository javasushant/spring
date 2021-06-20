package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
//@Repository("dao")
public class EmployeeDAOImpl1 implements IEmployeeDAO {
	private static final String  GET_EMP_BY_ENO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String  GET_EMP_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	
	@Autowired
	private JdbcTemplate jt;
	@Override
	public EmployeeBO getEmployeeByNo(int eno) {
		EmployeeBO bo=jt.queryForObject(GET_EMP_BY_ENO, 
																			new RowMapper<EmployeeBO>() {

																				@Override
																				public EmployeeBO mapRow(ResultSet rs,int rowNum) throws SQLException {
																					//convert Rs Object record to BO class obj
																					EmployeeBO bo= new EmployeeBO();
																					bo.setEmpNo(rs.getInt(1));
																					bo.setEname(rs.getString(2));
																					bo.setJob(rs.getString(3));
																					bo.setSal(rs.getFloat(4));
																					return bo;
																					
																				}
			
		}
																							,eno);
		return bo;
	}
	@Override
	public List<EmployeeBO> getEmployeesByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listbo1=jt.query(GET_EMP_BY_DESG, new ResultSetExtractor<List<EmployeeBO>>() {

			@Override
			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeBO> listbo=new ArrayList<EmployeeBO>();
				while(rs.next()) {
					EmployeeBO bo=new EmployeeBO();
					bo.setEmpNo(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(rs.getFloat(4));
					//add each BO class obj to LIST collection
					listbo.add(bo);
				}
				return listbo;
			}//inner Annonymus class
		}, desg1,desg2,desg3);
		return listbo1;
	}//ResultSetExtractor
}//class
