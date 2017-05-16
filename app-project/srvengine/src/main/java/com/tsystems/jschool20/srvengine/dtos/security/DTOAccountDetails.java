package com.tsystems.jschool20.srvengine.dtos.security;

import com.tsystems.jschool20.srvengine.entities.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ruslbard on 20.04.2017.
 */
public class DTOAccountDetails implements UserDetails {

    private long personId;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public DTOAccountDetails(Account entity){

        this.personId = entity.getId();
        this.username = entity.getLogin();
        this.password = entity.getPwd();

        Collection<SimpleGrantedAuthority> userGrantedAuthorities = new ArrayList<SimpleGrantedAuthority>();

        SimpleGrantedAuthority clientAuthority = new SimpleGrantedAuthority(entity.getRole().getName());
        userGrantedAuthorities.add(clientAuthority);
        this.authorities = userGrantedAuthorities;
    }

    public long getPersonId() {
        return personId;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
