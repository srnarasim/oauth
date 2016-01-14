package com.sap.ariba.oapi.authserver.saml.core;

/**
 * Created by i851894 on 1/6/16.
 */
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SAMLUserDetailsServiceImpl implements SAMLUserDetailsService
{
  @Override
  public Object loadUserBySAML(SAMLCredential credential)
      throws UsernameNotFoundException
  {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    String email = credential.getNameID().getValue();
    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
    authorities.add(authority);

    UserDetails userDetails = new User(
        email, "password", true, true, true, true, authorities);

    return userDetails;
  }
}

