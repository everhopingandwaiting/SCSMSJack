package scsms.jc.entity;


public class cousTable {
	private   int cous_num;
	private String cous_name;
	private  float cous_credit;
	private String cous_property;
	private int cous_maxnum;
	private String cous_tec;
	public cousTable(int cous_num, String cous_name, float cous_credit,
			String cous_property, int cous_maxnum, String cous_tec) {
		super();
		this.cous_num = cous_num;
		this.cous_name = cous_name;
		this.cous_credit = cous_credit;
		this.cous_property = cous_property;
		this.cous_maxnum = cous_maxnum;
		this.setCous_tec(cous_tec);
	}
	public int getCous_num() {
		return cous_num;
	}
	public void setCous_num(int cous_num) {
		this.cous_num = cous_num;
	}
	public String getCous_name() {
		return cous_name;
	}
	public void setCous_name(String cous_name) {
		this.cous_name = cous_name;
	}
	public float getCous_credit() {
		return cous_credit;
	}
	public void setCous_credit(float cous_credit) {
		this.cous_credit = cous_credit;
	}
	public String getCous_property() {
		return cous_property;
	}
	public cousTable() {
		super();
	}
	public cousTable(int cous_num, String cous_name, float cous_credit,
			String cous_property, int cous_maxnum) {
		super();
		this.cous_num = cous_num;
		this.cous_name = cous_name;
		this.cous_credit = cous_credit;
		this.cous_property = cous_property;
		this.cous_maxnum = cous_maxnum;
	}
	public void setCous_property(String cous_property) {
		this.cous_property = cous_property;
	}
	public int getCous_maxnum() {
		return cous_maxnum;
	}
	public void setCous_maxnum(int cous_maxnum) {
		this.cous_maxnum = cous_maxnum;
	}
	public String getCous_tec() {
		return cous_tec;
	}
	public void setCous_tec(String cous_tec) {
		this.cous_tec = cous_tec;
	}
	
}
