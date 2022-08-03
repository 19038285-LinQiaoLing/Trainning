package com.ncs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.util.JWTUtil;

@RestController
@RequestMapping("/public")
public class TokenValidatorController {

	String orgKey = "ncs-";

	@Autowired
	com.ncs.service.UserService AppUserService;

	@Autowired
	JWTUtil jwtUtil;

	@GetMapping("/validate")
	public boolean validateToken(HttpServletRequest request) {
		String requestedTokenHeader = request.getHeader("Authorization");
		String userType = request.getHeader("userType");
		String requestedTokenHeaderAuthority = request.getHeader("authority");

		String username = null;
		String jwtToken = null;

		if (requestedTokenHeader != null && requestedTokenHeader.startsWith(orgKey)) {
			System.out.println("\n\n  ***---->> 2 code Inside filter " + requestedTokenHeader + "\n");
			int cutToken = orgKey.length();
			jwtToken = requestedTokenHeader.substring(cutToken);
			System.out.println("\n\n  ***---->> 3 JWT Token is  " + jwtToken + "\n");

			try {

				username = jwtUtil.extractUsername(jwtToken);
				System.out.println(" 4 username from token is :- " + username);

			} catch (Exception e) {
				throw new UsernameNotFoundException("Username not found");
			}

			// --- code execute if no exception

			if (username != null) {

				UserDetails userDetails = this.AppUserService.loadUserByUsername(username);
				System.out.println(" --->> 5 Inside if Username not null " + userDetails);

				System.out.println(userDetails.getAuthorities());

				List<GrantedAuthority> allAuthorities = (List<GrantedAuthority>) userDetails.getAuthorities();

				for (GrantedAuthority grantedAuthority : allAuthorities) {
					String authority = grantedAuthority.getAuthority();
					System.out.println("--->> 5.0 authority :- " + authority + " userType " + userType);
					if (authority.equals(userType)) {
						System.out.println("----->> 5.a user and auth are same ");
						return true;
					}
				}

				System.out.println("--->> 5.b Inside else ");
				return false;

			} // end if username != null
		} // end if
		else {
			System.out.println("2.b Token is not validated ...");
			return false;

		}

		return false;
	}// end of get mapping
}// end class
