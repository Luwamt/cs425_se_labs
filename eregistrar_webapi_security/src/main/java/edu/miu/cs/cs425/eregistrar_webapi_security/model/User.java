package edu.miu.cs.cs425.eregistrar_webapi_security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;



@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(nullable = false)
    @NotBlank(message = " * First Name is required")
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    @NotBlank(message = " * Last Name is required")
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = " * Username Name is required")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = " * Password is required")
    private String password;

    @Column(nullable = false)
    @NotBlank(message = " * Email is required")
    private String email;
    //Data fields needed for implementing methods of UserDetails Interface
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(name = "users_roles",
//            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "userId")},
//            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")}
//    )
    @JoinColumn
    private List<Role> roles;



    public User() {
        this(null, null);
    }

    public User(String username, String password) {
        this(null,null,null,
                null,username,password,null,null,true,
                true,true,true);
    }

    public User(Integer userId, String firstName, String middleName, String lastName, String username, String password, String email, List<Role> roles, boolean accountNonExpired,
                boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }
    public String getFullName() {
//        return (this.middleName == null || this.middleName.isBlank()) ? String.format("%s %s", this.firstName, this.lastName) : String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
        return (this.middleName == null) ? String.format("%s %s", this.firstName, this.lastName) : String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
    }

    /**
     * // What are we implementing here ?????????????????????????????
     * @return
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      String[] userRoles = getRoles().stream().map((role)-> role.getName()).toArray(String[]::new);
      Collection<GrantedAuthority> authorities= AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
