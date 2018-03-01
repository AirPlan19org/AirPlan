package Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FlightDAO;
import DAO.OrderDao;
import DAO.SpaceDAO;
import DoMain.Flight;
import DoMain.Order;
import DoMain.Space;
import Util.FormatUtil;

public class OderService extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String directive = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		String querytype=null;
		String queryinfo=null;
		String orderStatus=null;
		switch (directive) {
		case "add":
			String flightId=req.getParameter("flightId");
			String spaceId=req.getParameter("spaceId");
			String useridno=req.getParameter("useridno");
			Flight flight=FlightDAO.getFlightById(flightId);
			Space space=SpaceDAO.getSpaceById(spaceId);
			Order order=new Order("default", flight.getFlightNum(), flight.getStartCity(), flight.getArriveCity(), spaceId, space.getSpaceName(), space.getSpacePrice(), space.getAirportPrice(), space.getOilPrice(), useridno, "PD"+FormatUtil.getRand(4), "0","DF"+FormatUtil.getRand(5));
			OrderDao.addOrder(order);
			ArrayList<Order> orderlist=OrderDao.getOrderList("3",useridno, null);
			req.setAttribute("querytype", "3");
			req.setAttribute("queryinfo", useridno);
			req.setAttribute("orderlist", orderlist);
			req.getRequestDispatcher("/HKProject/orderquery.jsp").forward(req, resp);
			return;
		case "query":
			querytype=req.getParameter("querytype");
			queryinfo=req.getParameter("queryinfo");
			orderStatus=req.getParameter("orderStatus");
			orderlist=OrderDao.getOrderList(querytype,queryinfo, orderStatus);
			req.setAttribute("orderStatus",orderStatus);
			req.setAttribute("querytype", querytype);
			req.setAttribute("queryinfo", queryinfo);
			req.setAttribute("orderlist", orderlist);
			req.getRequestDispatcher("/HKProject/orderquery.jsp").forward(req, resp);
			return;
		case "modify":
			String orderId=req.getParameter("orderId");
			querytype=req.getParameter("querytype");
			queryinfo=req.getParameter("queryinfo");
			orderStatus=req.getParameter("orderStatus");
			OrderDao.modifyStatus(orderId, orderStatus);
			resp.sendRedirect("/AirPlan/query.order?querytype="+querytype+"&queryinfo="+queryinfo+"&orderStatus="+orderStatus);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
