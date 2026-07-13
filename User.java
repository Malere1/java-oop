package ng.ourChemo.data.models;

import java.util.Objects;

public class User {

    private Long id;
    private String  username;
    private String password;
    private String fullName;
    public User() {

    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFullName(String FullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass() ) {
            return false;
        }
        User otherUser = (User) obj;
        return id != null && id.equals(otherUser.id);
    }



}
