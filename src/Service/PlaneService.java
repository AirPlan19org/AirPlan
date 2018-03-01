package Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CityDAO;
import DAO.FlightDAO;
import DAO.SpaceDAO;
import DAO.UserDao;
import DoMain.Flight;
import DoMain.Space;
import DoMain.User;

public class PlaneService extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String directive = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		switch (directive) {
		case "passenger":
			HttpSession ss=req.getSession();
			String usermail=(String) ss.getAttribute("usermail");
			User user=UserDao.getUserByMail(usermail);
			String flightId=req.getParameter("flightId");
			String spaceId=req.getParameter("spaceId");
			req.setAttribute("username", user.getUsername());
			req.setAttribute("useridno", user.getUseridno());
			req.setAttribute("userphone", user.getUserphone());
			Flight flight=FlightDAO.getFlightById(flightId);
			Space space=SpaceDAO.getSpaceById(spaceId);
			req.setAttribute("startcity", flight.getStartCity());
			req.setAttribute("arrivecity", flight.getArriveCity());
			String startdate=flight.getStartDate().substring(5, 10);
			String starttime=flight.getStartDate().substring(11, 16);
			String arrivetime=flight.getArriveDate().substring(11, 16);
			req.setAttribute("startdate", startdate);
			req.setAttribute("starttime", starttime);
			req.setAttribute("arrivetime", arrivetime);
			req.setAttribute("flightId", flightId);
			req.setAttribute("flightNum", space.getFlightNum());
			req.setAttribute("spacename", space.getSpaceName());
			req.setAttribute("spaceprice", space.getSpacePrice());
			req.setAttribute("oilprice", space.getOilPrice());
			req.setAttribute("airportprice", space.getAirportPrice());
			String startport=CityDAO.getCityAirport(flight.getStartCity());
			String arriveport=CityDAO.getCityAirport(flight.getArriveCity());
			req.setAttribute("startport", startport);
			req.setAttribute("arriveport", arriveport);
			req.setAttribute("spaceId", space.getSpaceId());
			req.getRequestDispatcher("/HKProject/passenger.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String directive = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		switch (directive) {
		case "search":
			String startcity = req.getParameter("startcity");
			String arrivecity = req.getParameter("arrivecity");
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
}
