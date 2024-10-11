package Views;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import Dao.DataDAO;

public class UserView {
	private String email;
	UserView(String email){
		this.email=email;
		
	}
	public void home() {
		do {
			System.out.println("welcome"+this.email);
			System.out.println("press 1 to show hidden files");
			System.out.println("press 2 to hide a new files");
			System.out.println("press 3 to unhide a  files");
			System.out.println("press 0 to exit");
			Scanner sc=new Scanner(System.in);
			int ch=Integer.parseInt(sc.nextLine());
			
			switch(ch) {
			case 1:{
				List<Data>files=DataDAO.getAllFile(this.email);
				System.out.println("id- file name");
				for(Data file:files) {
					System.out.println(file.getId+" "+file.getFileName());
				}
			}
			case 2: {
				System.out.println("enter the file path");
				String path=sc.nextLine();
				File f=new File(path);
				Data file=new Data(0,f.getName(),path,this.email);
				DataDAO.hideFile(file);
			}
			case 3:{
				List<Data>files=DataDAO.getAllFile(this.email);
				System.out.println("id- file name");
				for(Data file:files) {
					System.out.println(file.getId+" "+file.getFileName());
				}
				System.out.println("enter the id of file to unhide");
				int id=Integer.parseInt(sc.nextLine());
				boolean isValid=false;
				for(Data file:files) {
					if(file.getId==id) {
						boolean isValidId = true;
						break;
					}
				}
				boolean isValidId;
				if(isValidId) {
					DataDAO.unhide(id);
				}else {
					System.out.println("wrong");
				}
				
			}
			case 0:{
				System.exit(0);
				
			}
			}
			
		}while(true);
	}

}
