package hu.dupetya.web.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import hu.dupetya.common.converter.ConversionException;
import hu.dupetya.common.converter.Converter;
import hu.dupetya.common.entity.UserEntity;
import hu.dupetya.common.model.RegistrationInput;
import hu.dupetya.common.service.UserService;
import hu.dupetya.common.validator.Validator;
import hu.dupetya.common.validator.ViolationException;
import hu.dupetya.web.AutowiringHttpSerlvet;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends AutowiringHttpSerlvet {

	@Autowired
	private UserService userService;

	@Autowired
	private Validator<RegistrationInput> registrationInputValidator;

	@Autowired
	private Converter<RegistrationInput, UserEntity> registrationInputToUserConverter;

	private static Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		RegistrationInput regInput = getRegistrationInput(request);
		logger.info(regInput.toString());

		try {
			registrationInputValidator.validate(regInput);

			UserEntity user = registrationInputToUserConverter.convert(regInput);
			userService.registerUser(user);

			session.setAttribute("result", "OK");
		} catch (ViolationException ve) {
			session.setAttribute("result", "FAIL");
			session.setAttribute("cause", ve.getMessage());
		} catch (ConversionException e) {
			session.setAttribute("result", "FAIL");
		}

		response.sendRedirect("public/register.jsp");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleRequest(request, response);
	}

	private RegistrationInput getRegistrationInput(HttpServletRequest request) {
		RegistrationInput res = new RegistrationInput();

		res.setDateOfBirth(request.getParameter("dob"));
		res.setEmail(request.getParameter("email"));
		res.setPassword(request.getParameter("password"));
		res.setPasswordAgain(request.getParameter("password2"));
		res.setUsername(request.getParameter("username"));

		return res;
	}

}
