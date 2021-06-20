package com.nt.dao;

import org.springframework.beans.factory.annotation.Qualifier;

import com.nt.bo.StudentBO;
public interface IStudentDAO {
	public int insert(StudentBO bo) throws Exception;
}
