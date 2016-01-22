package dbService.dataSets;

import accounts.UserProfile;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 21.01.2016.
 */

@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable{
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String name;

    @Column(name = "password", unique = false, updatable = true)
    private String password;

    public UsersDataSet(UserProfile userProfile) {
        this.setId(-1);
        this.setName(userProfile.getLogin());
        this.setPassword(userProfile.getPass());
    }


//    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {

    }
/*
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public UsersDataSet(String name) {
        this.setId(-1);
        this.setName(name);
    }
*/

//    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

