package scsms.jc.entity;


public class usersTable {
    private  String  position;
    private   int users_id;
    private  String users_passwd;
    private String users_name;
 
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getUsers_passwd() {
		return users_passwd;
	}
	public void setUsers_passwd(String users_passwd) {
		this.users_passwd = users_passwd;
	}
	public usersTable() {
		super();
	}
    
    
}
