package DoMain;

public class Addr {
	private String addr;
	private String addno;
	public Addr(String addr, String addno) {
		super();
		this.addr = addr;
		this.addno = addno;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddno() {
		return addno;
	}
	public void setAddno(String addno) {
		this.addno = addno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addno == null) ? 0 : addno.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Addr other = (Addr) obj;
		if (addno == null) {
			if (other.addno != null)
				return false;
		} else if (!addno.equals(other.addno))
			return false;
		return true;
	}
}
