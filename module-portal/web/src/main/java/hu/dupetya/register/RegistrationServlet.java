package hu.dupetya.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import hu.dupetya.common.converter.ConversionException;
import hu.dupetya.common.converter.Converter;
import hu.dupetya.common.entity.User;
import hu.dupetya.common.model.RegistrationInput;
import hu.dupetya.common.service.UserService;
import hu.dupetya.common.validator.Validator;
import hu.dupetya.common.validator.ViolationException;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	@Autowired
	private UserService userService;

	@Autowired
	private Validator<RegistrationInput> registerValidator;

	@Autowired
	private Converter<RegistrationInput, User> inputToUserConverter;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		RegistrationInput regInput = getRegistrationInput(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");

		try {
			registerValidator.validate(regInput);

			User user = inputToUserConverter.convert(regInput);
			userService.registerUser(user);

			request.setAttribute("result", "OK");
		} catch (ViolationException ve) {
			request.setAttribute("result", "FAIL");
			request.setAttribute("cause", ve.getMessage());
		} catch (ConversionException e) {
			request.setAttribute("result", "FAIL");
		} finally {
			dispatcher.forward(request, response);
		}

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
