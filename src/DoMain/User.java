package DoMain;

public class User {
	private String userid;
	private String username;
	private String useridno;
	private String userphone;
	private String useraddr;
	private String usermail;
	private String userpsw;
	private String userstatus;
	private String userbalance;
	public User(){}
	public User(String userid, String username, String useridno, String userphone, String useraddr, String usermail,
			String userpsw, String userstatus, String userbalance) {
		super();
		this.userid = userid;
		this.username = username;
		this.useridno = useridno;
		this.userphone = userphone;
		this.useraddr = useraddr;
		this.usermail = usermail;
		this.userpsw = userpsw;
		this.userstatus = userstatus;
		this.userbalance = userbalance;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseridno() {
		return useridno;
	}
	public void setUseridno(String useridno) {
		this.useridno = useridno;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getUserpsw() {
		return userpsw;
	}
	public void setUserpsw(String userpsw) {
		this.userpsw = userpsw;
	}
	public String getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	public String getUserbalance() {
		return userbalance;
	}
	public void setUserbalance(String userbalance) {
		this.userbalance = userbalance;
	}
}
