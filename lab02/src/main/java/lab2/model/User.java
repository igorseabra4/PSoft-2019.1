package lab2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String login;
	private String password;
	
	public User() {
		
	}
	
	public User(String name, String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password; // isso nao eh muito seguro ne
	}
}
