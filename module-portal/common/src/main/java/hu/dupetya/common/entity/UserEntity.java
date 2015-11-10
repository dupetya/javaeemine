package hu.dupetya.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 4651123575995035275L;

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "username")
	private String username;

	@Column(name = "pass")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private Date dateOfBirth;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id") )
	private List<RoleEntity> roles;

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public UserEntity() {
	}

	public UserEntity(long id, String username, String password, String email, Date dateOfBirth,
			List<RoleEntity> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserEntity)) {
			return false;
		}
		UserEntity other = (UserEntity) obj;
		if (id != other.id) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserEntity [id=").append(id).append(", username=").append(username).append(", password=")
				.append(password).append(", email=").append(email).append(", dateOfBirth=").append(dateOfBirth)
				.append(", roles=").append(roles).append("]");
		return builder.toString();
	}

}
