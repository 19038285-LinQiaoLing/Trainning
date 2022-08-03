package com.ncs.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class User implements Serializable, Comparable<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int userId;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String role;
	@NotNull
	private String email;
	@NotNull
	private boolean is_available = true;
	private Date date_created;
	private Timestamp date_updated;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	@JsonBackReference
	private Set<Test_Score> allTestScore;

	public User() {
		super();
	}

	public User(int userId, String username, String password, String role, String email, boolean is_available,
			Date date_created, Timestamp date_updated, Set<Test_Score> allTestScore) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.is_available = is_available;
		this.date_created = date_created;
		this.date_updated = date_updated;
		this.allTestScore = allTestScore;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Timestamp getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(Timestamp date_updated) {
		this.date_updated = date_updated;
	}

	public Set<Test_Score> getAllTestScore() {
		return allTestScore;
	}

	public void setAllTestScore(Set<Test_Score> allTestScore) {
		this.allTestScore = allTestScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(allTestScore, date_created, date_updated, email, is_available, password, role, userId,
				username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(allTestScore, other.allTestScore) && Objects.equals(date_created, other.date_created)
				&& Objects.equals(date_updated, other.date_updated) && Objects.equals(email, other.email)
				&& is_available == other.is_available && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && userId == other.userId
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", email=" + email + ", is_available=" + is_available + ", date_created=" + date_created
				+ ", date_updated=" + date_updated + ", allTestScore=" + allTestScore + "]";
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.userId - o.userId;
	}

}
