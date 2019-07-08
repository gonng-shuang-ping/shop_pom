package com.qf.utilt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
@Component
public class powerAttestation {

    public boolean Attestation(HttpServletRequest request, Authentication authentication){
        AntPathMatcher antPathMatcher=new AntPathMatcher();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            String requestURI = request.getRequestURI();
            UserDetails user= (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (antPathMatcher.match(requestURI,authority.getAuthority())){
                    return  true;
                }
            }
        }
        return false;
    }
}
