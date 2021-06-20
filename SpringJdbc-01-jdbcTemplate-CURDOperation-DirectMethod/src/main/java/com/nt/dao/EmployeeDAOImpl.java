package com.nt.dao;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.nt.dao.IEmployeeDAO;
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMP_NO="SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_SAL_BY_ENO="SELECT SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS_BY_ENO="SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DESG="SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private static final String GET_EMP_DETTAILS_BY_SALRANGE="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>=? AND SAL<=?";
	private static final String INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(EMP_SEQ.NEXTVAL,?,?,?)";
	private static final String UPDATE_EMP_SALARY_QUERY="UPDATE EMP SET SAL=? WHERE EMPNO=?";
	private static final String DELETE_EMPS_BY_SALARY_RANGE="DELETE FROM EMP WHERE EMPNO=?";
	
	
	
	private JdbcTemplate jt;
		public EmployeeDAOImpl(JdbcTemplate jt) {
			this.jt=jt;
		}
	
	@Override
	public int fetchAllEmployee() {
		int count=jt.queryForObject(GET_EMP_NO, Integer.class);
		return count;
	}

	@Override
	public Float getEmployeeSalaryByEno(int eno) {
		float salary=jt.queryForObject(GET_EMP_SAL_BY_ENO, Float.class, eno);
		return salary;
	}

	@Override
	public Map<String, Object> getEmployeeDetailsByEno(int eno) {
		Map<String, Object> map=jt.queryForMap(GET_EMP_DETAILS_BY_ENO, eno);
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesg(String desg1, String desg2, String desg3) {
		List<Map<String, Object>> map=jt.queryForList(GET_EMP_DESG, desg1,desg2,desg3);
		return map;
	}

	@Override
	public SqlRowSet getEmployeeDetailsbySalaryRange(float startSalary, float endSalary) {
		SqlRowSet rowset=jt.queryForRowSet(GET_EMP_DETTAILS_BY_SALRANGE, startSalary,endSalary);
		return rowset;
	}

	@Override
	public int insertEmployee(String ename, String desg, float salary) {
		int count=jt.update(INSERT_EMP, ename,desg,salary);
		return count;
	}

	@Override
	public int updateEmployeeSalary(int eno, float newSalary) {
		int count = jt.update(UPDATE_EMP_SALARY_QUERY, newSalary,eno);
		return count;
	}

	@Override
	public int deleteEmployeeBySalaryRange(int eno) {
		int count=jt.update(DELETE_EMPS_BY_SALARY_RANGE, eno);
		return count;
	}

	

}
