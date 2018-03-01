package DoMain;

public class Order {
	private String orderId;
	private String flightNum;
	private String startCity;
	private String arriveCity;
	private String spaceId;
	private String spaceName;
	private Double spacePrice;
	private Double airportprice;
	private Double oilPrice;
	private String userIdno;
	private String payId;
	private String orderStatus;
	private String draftNum;
	public Order(){}
	public Order(String orderId, String flightNum, String startCity, String arriveCity, String spaceId,
			String spaceName, Double spacePrice, Double airportprice, Double oilPrice, String userIdno, String payId,
			String orderStatus, String draftNum) {
		super();
		this.orderId = orderId;
		this.flightNum = flightNum;
		this.startCity = startCity;
		this.arriveCity = arriveCity;
		this.spaceId = spaceId;
		this.spaceName = spaceName;
		this.spacePrice = spacePrice;
		this.airportprice = airportprice;
		this.oilPrice = oilPrice;
		this.userIdno = userIdno;
		this.payId = payId;
		this.orderStatus = orderStatus;
		this.draftNum = draftNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getArriveCity() {
		return arriveCity;
	}
	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}
	public String getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public Double getSpacePrice() {
		return spacePrice;
	}
	public void setSpacePrice(Double spacePrice) {
		this.spacePrice = spacePrice;
	}
	public Double getAirportprice() {
		return airportprice;
	}
	public void setAirportprice(Double airportprice) {
		this.airportprice = airportprice;
	}
	public Double getOilPrice() {
		return oilPrice;
	}
	public void setOilPrice(Double oilPrice) {
		this.oilPrice = oilPrice;
	}
	public String getUserIdno() {
		return userIdno;
	}
	public void setUserIdno(String userIdno) {
		this.userIdno = userIdno;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getDraftNum() {
		return draftNum;
	}
	public void setDraftNum(String draftNum) {
		this.draftNum = draftNum;
	}
	
}