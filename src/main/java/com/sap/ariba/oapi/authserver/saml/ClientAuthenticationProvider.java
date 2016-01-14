package com.sap.ariba.oapi.authserver.saml;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i851894 on 1/7/16.
 */
public class ClientAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
  @Override
  protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

  }

  @Override
  protected UserDetails retrieveUser(String email, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
    authorities.add(authority);
    UserDetails userDetails = new User(
        email, "password", true, true, true, true, authorities);
    return userDetails;

  }
}

