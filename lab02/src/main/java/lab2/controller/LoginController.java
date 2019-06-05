package lab2.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lab2.exception.UserAlreadyExistsException;
import lab2.exception.UserNotFoundException;
import lab2.model.User;
import lab2.service.UserService;

@RestController
@RequestMapping({"/v1/auth"})
public class LoginController {
	private final String TOKEN_KEY = "watermelon";
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<User> create(@RequestBody User user) throws UserAlreadyExistsException {
		User existingUser = userService.findByLogin(user.getLogin());

		if (existingUser != null)
			throw new UserAlreadyExistsException("Usuario ja existe");
		
		User newUser = userService.create(user);
		
		if (newUser == null)
			throw new InternalError("Something went wrong");
		
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public LoginResponse authenticate(@RequestBody User user) throws UserNotFoundException {
		User authUser = userService.findByLogin(user.getLogin());
		
		if (authUser == null)
			throw new UserNotFoundException("Usuario nao encontrado");
		
		if (!authUser.getPassword().equals(user.getPassword()))
			throw new UserNotFoundException("Senha invalida");
		
		String token = Jwts.builder().
				setSubject(authUser.getLogin()).
				signWith(SignatureAlgorithm.HS512, TOKEN_KEY).
				setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();
		
		return new LoginResponse(token);
	}
	
	private class LoginResponse {
		public String token;
		
		public LoginResponse(String token) {
			this.token = token;
		}
		
		public String getToken() {
			return token;
		}
	}
}
