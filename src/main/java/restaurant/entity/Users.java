package restaurant.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @NotNull
    @Column(name = "username", columnDefinition = "varchar(50)")
    private String username;

    @NotNull
    @Column(name = "password", columnDefinition = "char (68)")
    private String password;

    @NotNull
    @Column(name = "enabled", columnDefinition = "int(1)")
    private int enabled;

    public Users() {
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
