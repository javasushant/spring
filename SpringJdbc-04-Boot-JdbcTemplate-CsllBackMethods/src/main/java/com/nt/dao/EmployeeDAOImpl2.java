package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("dao")
//@Primary
public class EmployeeDAOImpl2 implements IEmployeeDAO {
	private static final String GET_EMP_BY_ENO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_DESG = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public EmployeeBO getEmployeeByNo(int eno) {
		EmployeeBO ebo = jt.queryForObject(GET_EMP_BY_ENO, (rs, rowNum) -> {

			// convert Rs Object record to BO class obj
			EmployeeBO bo = new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			return bo;
		}, eno);
		return ebo;
	}

	@Override
	public List<EmployeeBO> getEmployeesByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=jt.query(GET_EMP_BY_DESG, 
				rs-> {
					//copy RS object BO obj
					List<EmployeeBO> listbo=new ArrayList();
					while(rs.next()) {
						//retrieve each record to BO class obj
						EmployeeBO bo= new EmployeeBO();
						 bo.setEmpNo(rs.getInt(1));
              		   bo.setEname(rs.getString(2));
              		   bo.setJob(rs.getString(3));
              		   bo.setSal(rs.getFloat(4));
              		   //addd each BO class obj to list collection
              		   listbo.add(bo);
					}//while
					return listbo;
				}//LAMBDA based annonymus inner class
				
				, desg1,desg2,desg3);
		return listBO;
		
	}
}
