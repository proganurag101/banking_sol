package banking;

import java.util.Date;

public class UserData {

	
	public UserData(String fullname, long conatctNo, String city, long govtID, long acc_no, long balance, Date dob) {
		
		this.fullname = fullname;
		this.conatctNo = conatctNo;
		this.city = city;
		this.govtID = govtID;
		this.acc_no = acc_no;
		this.balance = balance;
		this.dob = dob;
	}
	private String fullname;
	private long conatctNo;
	private String city;
	private long govtID;
	private long acc_no;
	private long balance;
	private Date dob;
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public long getConatctNo() {
		return conatctNo;
	}
	public void setConatctNo(long conatctNo) {
		this.conatctNo = conatctNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getGovtID() {
		return govtID;
	}
	public void setGovtID(long govtID) {
		this.govtID = govtID;
	}
	
}
