package Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import Dao.UserDAO;
import Model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;
public class Welcome {
public void welcomeScreen() throws Exception  {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Welcome to the app");
	System.out.println("press 1 to login");
	System.out.println("press 2 to signup");
	System.out.println("press 0 to exit ");
	int choice=0;
	try {
		choice=Integer.parseInt(br.readLine());
	}catch(IOException ex) {
		ex.printStackTrace();
		
	}
	switch(choice) {
	case 1: login();
	case 2: signUP();
	case 0: System.exit(0);
	}
}

private void login() throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter email");
	String email=sc.nextLine();
	try {
		if(UserDAO.isExist(email)) {
			String genOTP=GenerateOTP.getOTP();
			SendOTPService.sendOTP(email, genOTP);
			System.out.println("enter the otp");
			String otp=sc.nextLine();
			if(otp.equals(genOTP)) {
			new UserView(email).home();
			}else {
				System.out.println("wrong otp");
			}
			
		}else {
			System.out.println("user not found");
		}
	}catch(SQLException ex) {
		ex.printStackTrace();
	}	
}
private void signUP() throws Exception {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter name");
	String name=sc.nextLine();
	System.out.println("enter email");
	String email=sc.nextLine();
	String genOTP=GenerateOTP.getOTP();
	SendOTPService.sendOTP(email, genOTP);
	System.out.println("enter the otp");
	String otp=sc.nextLine();
	if(otp.equals(genOTP)) {
		User user=new User(name,email);
	int response=UserService.saveUser(user);
	switch(response) {
	case 0: System.out.println("user registered");
	case 1: System.out.println("user alreay exis");
	}
            
	}
            else {
		System.out.println("wrong otp");
	}
}
}
