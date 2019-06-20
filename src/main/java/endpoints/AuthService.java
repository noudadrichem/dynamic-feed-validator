package endpoints;

import java.security.Key;
import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;

import persistence.user.PostgresUserDao;

@Path("/authentication")
public class AuthService {
	final static public Key key = MacProvider.generateKey();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String pass) {

		System.out.println("username: " + username + " password: " + pass);
		
		try {
			PostgresUserDao dao = new PostgresUserDao();
			String role = dao.findRoleForUser(username, pass);
			
			if(role == null) { 
				System.out.println("No user found.");
				throw new IllegalArgumentException("No user found!");
			}
			
			String token = createToken(username, role);
			
			SimpleEntry<String, String> JWT = new SimpleEntry<String, String>("JWT", token);

			return Response.ok(JWT).build();

		} catch (JwtException | IllegalArgumentException e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private String createToken(String username, String role) {
		Calendar expiration = Calendar.getInstance();
		expiration.add(Calendar.MINUTE, 30);
	
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(expiration.getTime())
				.claim("role", role)
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();
	}
}
