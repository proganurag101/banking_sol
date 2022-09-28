package banking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConsole { 


	static Connection con = DBConnection.getConnection();
	static String sql = "";
	
	public static long generateAccountNumber() { 
		try {
			long temp;
			sql = "select * from (SELECT acc FROM userdata order by acc desc) where rownum <=1";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				temp=rs.getLong("acc");
				temp++;
				return temp;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	    
	}
	public static long createAccount(UserData data) 
	{
		try {
			
			sql = "INSERT INTO userdata(fullname,contact_no,city,govt_id,acc,balance,dob) values(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, data.getFullname());
			st.setLong(2, data.getConatctNo());
			st.setString(3, data.getCity());
			st.setLong(4, data.getGovtID());
			st.setLong(5, data.getAcc_no());
			st.setLong(6, data.getBalance());
			st.setDate(7, new Date(data.getDob().getTime()));

			if (st.executeUpdate() == 1) {
                
                return 1;
            }
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void depositMoney(long accNo,long amt) 
	{
		try {

			sql = "select acc,balance from userdata where acc=?";
			PreparedStatement st
				= con.prepareStatement(sql);
			st.setLong(1, accNo);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				long bal=rs.getLong("balance");
				bal+=amt;
				st = con.prepareStatement("update userdata set balance = ? where acc=? ");
				st.setLong(1,bal);
				st.setLong(2, accNo);
				st.executeUpdate();
				System.out.println("Deposit successful");
				st = con.prepareStatement("select balance from userdata where acc=?");
				st.setLong(1, accNo);
				rs = st.executeQuery();
				if(rs.next()) {
					System.out.println("New account balance: "+ rs.getLong("balance"));
				}
				else {
					System.out.println("Can't retrieve new balance ");
				}
			} 
			else {
				System.out.println("Invalid account number");
			}
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void withdrawMoney(long accNo,long amt) 
	{
		try {

			sql = "select acc,balance from userdata where acc=?";
			PreparedStatement st
				= con.prepareStatement(sql);
			st.setLong(1, accNo);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				long bal=rs.getLong("balance");
				bal-=amt;
				st
				= con.prepareStatement("update userdata set balance = ? where acc=? ");
				st.setLong(1,bal);
				st.setLong(2, accNo);
				st.executeUpdate();
				System.out.println("Withdrawal successful");
				st = con.prepareStatement("select balance from userdata where acc=?");
				st.setLong(1, accNo);
				rs = st.executeQuery();
				if(rs.next()) {
					System.out.println("New account balance: "+ rs.getLong("balance"));
				}
				else {
					System.out.println("Can't retrieve new balance ");
				}
			} 
			else {
				System.out.println("Invalid account number");
			}
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void getBalance(long accNo) 
	{
		try {

			sql = "select * from userdata where acc=?";
			PreparedStatement st
				= con.prepareStatement(sql);
			st.setLong(1, accNo);
			ResultSet rs = st.executeQuery();
			System.out.println();
			

			if (rs.next()) {
				System.out.print(rs.getLong("acc")+" "+ rs.getString("fullname")+" "+ rs.getLong("balance"));
			} 
			else {
				System.out.println("Invalid account number");
			}
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
