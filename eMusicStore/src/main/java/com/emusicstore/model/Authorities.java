package com.emusicstore.model;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authId;
    private String username;
    private String password;
    private String authority;



    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


}
