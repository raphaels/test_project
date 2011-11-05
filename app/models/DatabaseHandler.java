package models;

import java.sql.ResultSet;
import java.sql.SQLException;


import play.db.DB;

public class DatabaseHandler {

	private static DatabaseHandler instance;
	
	public static DatabaseHandler getInstance() {
		if (instance == null) {
			instance = new DatabaseHandler();
		}
		return instance;
	}
	
	public User login(String user, String password){
		
    	try{
        	
        	ResultSet result = DB.executeQuery("select * from user");
        	while (result.next()) {
                int id_user = result.getInt("id_user");
                String user_db = result.getString("user");
                String password_db = result.getString("password");
                String email = result.getString("email");
                String birthday = result.getString("birthday");
                int posts = result.getInt("posts");
                if(user.equals(user_db)  && (password.equals(password_db)))
                {
                	User activeUser = new User(id_user, user, password, birthday, email, posts);
                	return activeUser;
                }
              }
        	}
        	catch(SQLException e){
        	e.printStackTrace();
        	}
        	return null;
	}
	
	public boolean register(User user){
		
		String sqlStatement = "insert  into `user`(`user`,`password`,`email`,`birthday`) values ('";
		sqlStatement += user.getUsername() + "','" + user.getPassword() + "','" + user.getEmail();
		sqlStatement += "','" + user.getBirthday() + "');";
		return DB.execute(sqlStatement);
	}
}
