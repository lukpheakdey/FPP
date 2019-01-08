package countycity;

public class TopCity {
	private String cname; // City Name
	private double pop; // Population in Millions
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getPop() {
		return pop;
	}
	public void setPop(double pop) {
		this.pop = pop;
	}
	public TopCity(String cname, double pop) {
		this.cname = cname;
		this.pop = pop;
	}
	@Override
	public String toString() {
		String temp = String.format("%10.0f", this.pop);
		return  cname + " Population : " + temp + " million ";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pop);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TopCity other = (TopCity) obj;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (Double.doubleToLongBits(pop) != Double.doubleToLongBits(other.pop))
			return false;
		return true;
	}
}
