package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.ICBScoreMgmtService;
@WebServlet(value="/controller", loadOnStartup = 1)
public class MainController extends HttpServlet {
	
	private AnnotationConfigApplicationContext ctx;
	@Override
	public void init() throws ServletException {
		System.out.println("MainController.init()");
		//IOC container
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get local service class object
		ICBScoreMgmtService service = ctx.getBean("cbservice",ICBScoreMgmtService.class);
		//read match id as the request param value 
		int mid = Integer.parseInt(req.getParameter("mid"));
		//invoke local service class object
		String score =service.findScore(mid);
		//keep the result in request mode
		req.setAttribute("scoreboard", score);
		//FORWARD to result_show.jsp 
		RequestDispatcher rd= req.getRequestDispatcher("/result_show.jsp");
		rd.forward(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	@Override
	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}
	
}
