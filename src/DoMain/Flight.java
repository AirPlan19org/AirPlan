package DoMain;


/**
 * @author Yuangsyoo
 * @time 2018年2月1日
 * @descripe 航班信息表
 */
public class Flight {
	private String flightId;//公司ID
	private String flightNum;//航班编号
	private String startCity;//出发城市
	private String arriveCity;//到达城市
	private String startDate;//出发时间
	private String arriveDate;//到达时间
	private String flightStatus;//航班状态
	private String planeType;//飞机型号
	private String meal;//餐食
	private String flightSpace;//开放的舱位
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(String companyId, String flightNum, String startCity, String arriveCity, String startDate,
			String arriveDate, String flightStatus, String planeType, String meal, String flightSpace) {
		super();
		this.flightId = companyId;
		this.flightNum = flightNum;
		this.startCity = startCity;
		this.arriveCity = arriveCity;
		this.startDate = startDate;
		this.arriveDate = arriveDate;
		this.flightStatus = flightStatus;
		this.planeType = planeType;
		this.meal = meal;
		this.flightSpace = flightSpace;
	}
	
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String companyId) {
		this.flightId = companyId;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getFlightSpace() {
		return flightSpace;
	}
	public void setFlightSpace(String flightSpace) {
		this.flightSpace = flightSpace;
	}
	
	
}
