package pl.woonkievitch.Authentication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name ="myUser")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String password;
    private int activate;
    private Set<Role> roleSet;


    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getActivate() {
        return activate;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivate(int activate) {
        this.activate = activate;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
