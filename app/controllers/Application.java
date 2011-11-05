package controllers;

import play.*;
import play.db.DB;
import play.db.jpa.JPA;
import play.mvc.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.persistence.EntityManager;

import com.mysql.jdbc.Connection;

import models.*;

public class Application extends Controller {
	private static User activeUser;
	
    public static void index(String message) {
        render(message);
    }
    
    public static void register() {
    	render();
    }
    
    public static void newUser(String user, String password, String birthday, String email) {
    	User registerUser = new User(user, password, birthday, email);
    	boolean register = DatabaseHandler.getInstance().register(registerUser);
    	if(register)
    		render();
    	else
    		register();
    }
    
    public static void login(String user, String password) {
        
    	activeUser = DatabaseHandler.getInstance().login(user, password);
    	if(activeUser != null){
    		String message = "Hallo " + activeUser.getUsername() + ", der Login war erfolgreich!";
    		render(message);
    	}
    	else {
    	String message = "Login fehlgeschlagen!";
    	index(message);
    	}
    }
}