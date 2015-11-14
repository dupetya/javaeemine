package hu.neuron.java.service.vo;

import java.io.Serializable;
import java.util.Date;

public class MessageVO implements Serializable {

	private static final long serialVersionUID = -8403753397412273249L;

	private Long id;
	private String content;

	private Date sendDate;

	private UserVO sendUser;

	private UserVO targetUser;

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public UserVO getSendUser() {
		return sendUser;
	}

	public UserVO getTargetUser() {
		return targetUser;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public void setSendUser(UserVO sendUser) {
		this.sendUser = sendUser;
	}

	public void setTargetUser(UserVO targetUser) {
		this.targetUser = targetUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageVO [id=").append(id).append(", content=").append(content).append(", sendDate=")
				.append(sendDate).append(", sendUser=").append(sendUser).append(", targetUser=").append(targetUser)
				.append("]");
		return builder.toString();
	}

}
