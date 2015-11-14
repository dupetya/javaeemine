package hu.schonherz.java.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sendDate;

	@OneToOne
	private User sendUser;

	@OneToOne
	private User targetUser;

	public String getContent() {
		return content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public User getSendUser() {
		return sendUser;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}
}
