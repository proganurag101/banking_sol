package banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankingMain {
	
	
	
	public static void main(String args[])

	{

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String fullname = "";
		long contactNo;
		String city = "";
		long govtId;
		long balance;
		long acc_no;
		Date dob = null;
		int choice;
		UserData data;

		while (true) {
			System.out.println("Welcome to Amdocs Bank of India\n");
			System.out.println("1.Create  New Account");
			System.out.println("2.Check Account Balance");
			System.out.println("3.Deposit Cash");
			System.out.println("4.Withdraw Cash");
			System.out.println("5.Exit");

			try {
				System.out.print("\n Enter Input:"); 
				choice = Integer.parseInt(sc.readLine());

				switch (choice) {
				case 1:
					try {
						System.out.println("Enter Full Name:");
						fullname = sc.readLine();
						System.out.println("Enter Contact Number:");
						contactNo = Long.parseLong(sc.readLine());
						System.out.println("Enter City:");
						city = sc.readLine();
						System.out.println("Enter DOB(dd/mm/yyyy):");
						String date = sc.readLine();
						System.out.println("Enter Govt ID:");
						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						if(null != date && date.trim().length() > 0){
				             dob = format.parse(date);
				        }
						govtId = Long.parseLong(sc.readLine());
						balance =0;
						if((acc_no=DBConsole.generateAccountNumber())!=0) {}
						else {
							System.out.println("error creating account number\n");
							break;
						}
						
						data = new UserData(fullname,contactNo,city,govtId,acc_no,balance,dob);
						if (DBConsole.createAccount(data)==1) {
							System.out.println("MSG : Account Generated Successfully!\n");
							System.out.println("Account Number:"+ acc_no +"\n");
						} else {
							System.out.println("ERR : Account Creation Failed!\n");
						}
					} catch (Exception e) {
						System.out.println(" ERR : Enter Valid Data::Insertion Failed!\n");
						System.out.println(e.toString());
					}
					break;

				case 2:
					try {
						System.out.println("Enter Account number:");
						acc_no = Long.parseLong(sc.readLine());
						DBConsole.getBalance(acc_no);
							
					} catch (Exception e) {
						System.out.println(" ");
					}
					break;
					
				case 3:
					try {
						System.out.println("Enter Account number:");
						acc_no = Long.parseLong(sc.readLine());
						System.out.println("Enter Deposit Amount:");
						long amt = Long.parseLong(sc.readLine());
						DBConsole.depositMoney(acc_no,amt);
							
					} catch (Exception e) {
						System.out.println(e.toString());
					}
					break;
					
				case 4:
					try {
						System.out.println("Enter Account number:");
						acc_no = Long.parseLong(sc.readLine());
						System.out.println("Enter Withdrawal Amount:");
						long amt = Long.parseLong(sc.readLine());
						DBConsole.withdrawMoney(acc_no,amt);
							
					} catch (Exception e) {
						System.out.println(e.toString());
					}
					break;

				case 5:
					System.out.println("Thank you for banking with us!");
					break;
	
				default:
					System.out.println("Invalid Entry!\n");
					break;
				}
				System.out.println("Do you want to continue banking?(y/n)");
				if(sc.readLine().charAt(0)=='n') {
					break;
				}
			} 
			catch (Exception e) {
				System.out.println("Enter Valid Entry!");
			}
			
		}
//		sc.close();
	}
}
