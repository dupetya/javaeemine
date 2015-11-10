package hu.dupetya.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NamedQueries({
		@NamedQuery(name = "RoleEntity.findRolesByUserId", query = "select roles from UserEntity u join u.roles roles where u.id=?1") })
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 9148623831757914426L;

	@Id
	@Column(name = "role_id")
	private long id;

	@Column(name = "role_name")
	private String name;

	public RoleEntity() {
	}

	public RoleEntity(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (!(obj instanceof RoleEntity)) {
			return false;
		}
		RoleEntity other = (RoleEntity) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleEntity [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}

}
