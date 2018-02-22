package DoMain;

public class Company {
	private int companyid;
	private String companyname;
	private String companycode;
	public Company(){}
	public Company(int companyid, String companyname, String companycode) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
		this.companycode = companycode;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanycode() {
		return companycode;
	}
	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}
	
}
