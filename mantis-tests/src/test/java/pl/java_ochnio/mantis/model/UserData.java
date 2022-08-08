package pl.java_ochnio.mantis.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;

@XStreamAlias("user")
@Entity
@Table(name = "mantis_user_table")
public class UserData {


    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "username")
    private String username;

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
