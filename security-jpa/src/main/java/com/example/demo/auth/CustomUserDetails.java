package com.example.demo.auth;

import com.example.demo.security.ApplicationUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "user")
public class CustomUserDetails implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean isAccountNonExpired;
    @Column
    private boolean isAccountNonLocked;
    @Column
    private boolean isCredentialsNonExpired;
    @Column
    private boolean isEnabled;

    @Column(name="role", nullable = false, length = 15 )
    @Enumerated(EnumType.STRING)
    private ApplicationUserRole role;



    public CustomUserDetails(){}

    public CustomUserDetails(String username,
                           String password,
                           boolean isAccountNonExpired,
                           boolean isAccountNonLocked,
                           boolean isCredentialsNonExpired,
                           boolean isEnabled,
                             ApplicationUserRole role) {
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.role = role;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.role.getGrantedAuthorities();
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
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public int getId() {
        return id;
    }

    public ApplicationUserRole getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setRole(ApplicationUserRole role) {
        this.role = role;
    }
}
