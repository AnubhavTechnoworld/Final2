package com.training.ata.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.training.ata.bean.VehicleBean;
import com.training.ata.exception.ATAException;
import com.training.ata.service.Vehicle;
import com.training.ata.service.VehicleImpl;

@WebServlet("/VehicleController")
public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Vehicle service= new VehicleImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		if(action==null||action.isEmpty()) {
			try {
				List<VehicleBean> employees = service.getVehicle();
				request.setAttribute("employees", employees);
				RequestDispatcher rd=request.getRequestDispatcher("ViewVehicle.jsp");
				rd.forward(request, response);
				
			} catch (ATAException e) {
				RequestDispatcher rd= request.getRequestDispatcher("error.jsp");
				request.setAttribute("error", e);
				rd.forward(request, response);
			}
		}
		else if(action.equals("add"))
		{
			response.sendRedirect("AddVehicle.jsp");
		}
		else if(action.equals("addvehicle"))
		{
			String vehicleID=request.getParameter("vehicleID");
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			String registrationNumber=request.getParameter("registrationNumber");
			int seatingCapacity=Integer.parseInt(request.getParameter("seatingCapacity"));
			double farePerKM=Double.parseDouble(request.getParameter("farePerKM"));
			VehicleBean emp = new VehicleBean();
			emp.setVehicleID(vehicleID);
			emp.setName(name);
			emp.setType(type);
			emp.setRegistrationNumber(registrationNumber);
			emp.setSeatingCapacity(seatingCapacity);
			emp.setFarePerKM(farePerKM);
			HttpSession session=request.getSession();
			try {
				List<VehicleBean> employees =service.addVehicle(emp);
				session.setAttribute("employees", employees);
				response.sendRedirect("ViewVehicleAdmin.jsp");
			} catch (ATAException e) {
				session.setAttribute("error", e);
				response.sendRedirect("error.jsp");
				
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
