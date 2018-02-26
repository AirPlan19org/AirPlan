package DoMain;

/**
 * @author Yuangsyoo
 * @time 2018年2月1日
 * @descripe 舱位信息表
 */
public class Space {
	private String spaceId;// 舱位ID
	private String flightNum;// 航班编号
	private String seatNum;// 座位号
	private String spaceName;// 舱位名称
	private double spacePrice;// 舱位价格
	private double airportPrice;// 基建费
	private double oilPrice;// 燃油附加费
	private String spaceStatus;// 舱位状态

	public Space() {
		super();
	}

	public Space(String spaceId, String flightNum, String seatNum, String spaceName, double spacePrice,
			double airportPrice, double oilPrice, String spaceStatus) {
		super();
		this.spaceId = spaceId;
		this.flightNum = flightNum;
		this.seatNum = seatNum;
		this.spaceName = spaceName;
		this.spacePrice = spacePrice;
		this.airportPrice = airportPrice;
		this.oilPrice = oilPrice;
		this.spaceStatus = spaceStatus;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public double getSpacePrice() {
		return spacePrice;
	}

	public void setSpacePrice(double spacePrice) {
		this.spacePrice = spacePrice;
	}

	public double getAirportPrice() {
		return airportPrice;
	}

	public void setAirportPrice(double airportPrice) {
		this.airportPrice = airportPrice;
	}

	public double getOilPrice() {
		return oilPrice;
	}

	public void setOilPrice(double oilPrice) {
		this.oilPrice = oilPrice;
	}

	public String getSpaceStatus() {
		return spaceStatus;
	}

	public void setSpaceStatus(String spaceStatus) {
		this.spaceStatus = spaceStatus;
	}

}
