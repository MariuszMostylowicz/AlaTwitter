package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
public class AppUser {

    @Id
    private Long id;
    private String login;
    private String name;
    private String lastName;
    private String email;
    private Set<AppUser> following = new HashSet();
    private Set<AppUser> followedBy = new HashSet();
    private Date registeredSince;

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AppUser> getFollowing() {
        return following;
    }

    public void setFollowing(Set<AppUser> following) {
        this.following = following;
    }

    public Set<AppUser> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(Set<AppUser> followedBy) {
        this.followedBy = followedBy;
    }

    public Date getRegisteredSince() {
        return registeredSince;
    }

    public void setRegisteredSince(Date registeredSince) {
        this.registeredSince = registeredSince;
    }
}