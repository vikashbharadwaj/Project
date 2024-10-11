package service;

import java.sql.SQLException;

import Dao.UserDAO;
import Model.User;

public class UserService {
	public static Integer saveUser(User user) throws Exception {
		
		try {
			if(UserDAO.isExist(user.getEmail())) {
				return 0;
			
					
				}else {
					return UserDAO.saveUser(user);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
		
	}

}
