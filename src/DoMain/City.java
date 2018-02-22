package DoMain;

public class City {
	private int cityid;
	private String cityname;
	private String citycode;
	public City(){}
	public City(int cityid, String cityname, String citycode) {
		super();
		this.cityid = cityid;
		this.cityname = cityname;
		this.citycode = citycode;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
}
