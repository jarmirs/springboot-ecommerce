package com.tts.ecommerce.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 128, nullable = false, unique = true)
	private String email;
	@Column(length = 64, nullable = false)
	private String password;
	@Column(name = "first_name", length = 45, nullable = false)
	private String firstName;
	@Column(name = "first_name", length = 45, nullable = false)
	private String lastName;
	private String image;
	@Transient
	private boolean enabled;
	@Transient
	private boolean accountNonExpired =true;
	@Transient
	private boolean accountNonLocked=true;
	@Transient
	private boolean credentialsNonExpired=true;
	@Transient
	private Collection<GrantedAuthority> authorities =null;
@ElementCollection
@ManyToMany
@JoinTable(
		name="user_roles",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns =@JoinColumn(name="role_id")
)
private Set<Role> roles=new HashSet<>();

public User() {
	super();
	
}


public User(String email, String password, String firstName, String lastName) {
	super();
	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
}


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
public void addRole(Role role) {
	this.roles.add(role);
}


}
