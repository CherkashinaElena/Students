package com.students.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Elena on 5/28/2014.
 */
public class User implements UserDetails {

    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities;

    public User(String username, String password, String roles) {
        super();
        this.username = username;
        this.password = password;
        this.setRoles(roles);
    }

    public void setRoles(String roles) {
        this.authorities = new HashSet<GrantedAuthority>();
        for (final String role : roles.split(",")) {
            if (role != null && !"".equals(role.trim())) {
                GrantedAuthority grandAuthority = new GrantedAuthority() {
                    public String getAuthority() {
                        return role.trim();
                    }
                };
                this.authorities.add(grandAuthority);
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
