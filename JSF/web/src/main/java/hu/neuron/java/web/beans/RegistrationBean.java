package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.UserVO;

@ManagedBean
@ViewScoped
public class RegistrationBean implements Serializable {

	@ManagedProperty("#{userService}")
	private UserService userService;

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String passwordConfirmation;

	public void registration() {
		FacesContext currInstance = FacesContext.getCurrentInstance();
		UserVO userVo = new UserVO();
		userVo.setUsername(username);
		userVo.setPassword(password);

		if (username == null || password == null || passwordConfirmation == null
				|| !password.equals(passwordConfirmation)) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in registration");
			currInstance.addMessage(null, facesMessage);
			return;
		}
		try {
			getUserService().registrationUser(userVo);
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in registration");
			currInstance.addMessage(null, facesMessage);
			e.printStackTrace();
		}

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Successful registration!");
		currInstance.addMessage(null, facesMessage);

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
