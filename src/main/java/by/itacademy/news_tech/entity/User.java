package by.itacademy.news_tech.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String salt;

	@Column
	private int enabled;

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "authorities_username")
	 */
	private UserDetail userDetail;

	public User() {
	}

	public User(String username, String password, int enabled, UserDetail userDetail) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userDetail = userDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enabled, id, password, salt, userDetail, username);
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
		return enabled == other.enabled && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(salt, other.salt) && Objects.equals(userDetail, other.userDetail)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", enabled="
				+ enabled + ", userDetail=" + userDetail + "]";
	}

	

}
