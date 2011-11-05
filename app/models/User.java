package models;

public class User {
	private int userID;
	private String username;
	private String password;
	private String birthday;
	private String email;
	private int posts;
	
	public User(String username, String password, String birthday, String email)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.setBirthday(birthday);
		this.setEmail(email);
		setPosts(0);
	}
	
	public User(int userID, String username, String password, String birthday, String email, int posts)
	{	
		this.userID = userID;
		this.setUsername(username);
		this.setPassword(password);
		this.setBirthday(birthday);
		this.setEmail(email);
		this.setPosts(posts);
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPosts(int posts) {
		this.posts = posts;
	}

	public int getPosts() {
		return posts;
	}

}
