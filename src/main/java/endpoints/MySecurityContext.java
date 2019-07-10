// package endpoints;

// import java.security.Principal;
// import javax.ws.rs.core.SecurityContext;

// public class MySecurityContext implements SecurityContext {
	
// 		private String name;
// 		private String role;
// 		private boolean isSecure;
		
// 		public MySecurityContext(String name, String role, boolean isSecure) {
// 			this.name = name;
// 			this.role = role;
// 			this.isSecure = isSecure;
// 		}
		
// 		public Principal getUserPrincipal() {
// 			return new Principal() {
// 				public String getName() { 
// 					return name; 
// 				}
// 			};
// 		}
		
// 		public boolean isUserInRole(String role) {
// 			return role.equals(this.role);
// 		}
		
// 		public boolean isSecure() {
// 			return isSecure;
// 		}
		
// 		public String getAuthenticationScheme() {
// 			return "Bearer";
// 		}
// }
