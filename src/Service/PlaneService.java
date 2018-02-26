package Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FlightDAO;
import DoMain.Flight;

public class PlaneService extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String directive = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		switch (directive) {
		case "search":
			String startcity = req.getParameter("startcity");
			startcity = new String(startcity.getBytes("iso-8859-1"), "utf-8");
			String arrivecity = req.getParameter("arrivecity");
			arrivecity = new String(arrivecity.getBytes("iso-8859-1"), "utf-8");
			String startdate = req.getParameter("startdate");
			Flight flight = new Flight();
			flight.setStartCity(startcity);
			flight.setArriveCity(arrivecity);
			flight.setStartDate(startdate);
			ArrayList<Flight> flightlist = FlightDAO.getFightList(flight);
			if (flightlist == null) {
				req.setAttribute("noflight", "没有航班信息");
			}
			req.setAttribute("flightlist", flightlist);
			req.setAttribute("startcity", startcity);
			req.setAttribute("arrivecity", arrivecity);
			req.setAttribute("startdate", startdate);
			req.getRequestDispatcher("/HKProject/SearchPlane.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
