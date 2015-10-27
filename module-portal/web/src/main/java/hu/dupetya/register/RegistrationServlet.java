package hu.dupetya.register;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DAOManagerException;
import hu.dupetya.core.account.dao.MySQLDAOManager;
import hu.dupetya.core.util.DBUtil;
import hu.dupetya.web.account.AccountRegistrationException;
import hu.dupetya.web.account.AccountRegistrationRequest;
import hu.dupetya.web.account.AccountService;
import hu.dupetya.web.register.validation.RegistrationResult;
import hu.dupetya.web.register.validation.Result;
import hu.schonherz.training.java.solid.account.impl.AccountRegistrationRequestToAccountConverter;
import hu.schonherz.training.java.solid.account.impl.AccountServiceImpl;
import hu.schonherz.training.java.solid.account.validation.EmailFormatRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryEmailRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordConfirmationRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryPasswordRule;
import hu.schonherz.training.java.solid.account.validation.MandatoryUsernameRule;
import hu.schonherz.training.java.solid.account.validation.PasswordAndConfirmationAreEqualRule;
import hu.schonherz.training.java.solid.account.validation.PasswordFormatRule;
import hu.schonherz.training.java.solid.account.validation.UniqueUsernameRule;
import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.impl.CipherServiceImpl;
import hu.schonherz.training.java.solid.validator.Validator;
import hu.schonherz.training.java.solid.validator.Violation;
import hu.schonherz.training.java.solid.validator.ViolationException;
import hu.schonherz.training.java.solid.validator.rule.RuleValidator;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
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
		HttpSession session = request.getSession();

		AccountRegistrationRequest aRequest = ARRFromHttpRequest(request);
		session.setAttribute("registerInfo", aRequest);

		RegistrationResult regResult = new RegistrationResult();
		regResult.setResult(Result.SUCCESS);
		regResult.setMessage("Successfully registered user " + aRequest.getUsername());

		session.setAttribute("result", regResult);

		MySQLDAOManager daoMgr = null;

		try {
			daoMgr = new MySQLDAOManager();
			daoMgr.open();
			AccountDAO dao = daoMgr.getDao();

			validate(aRequest, dao);

			CipherService cipherService = new CipherServiceImpl("+d/Hd+CIMj/ochQmEcLGTg==", "WVyENBxRsmHQyYJWWahmfg==");

			AccountService accountService = new AccountServiceImpl(dao,
					new AccountRegistrationRequestToAccountConverter(cipherService));

			accountService.register(aRequest);

		} catch (ViolationException e) {
			regResult.setResult(Result.FAIL);
			regResult.setMessage("Could not register user");
			List<String> causes = new ArrayList<>();
			regResult.setCauses(causes);

			for (Violation violation : e.getViolations()) {
				causes.add(violation.getError());
			}

		} catch (AccountRegistrationException | DAOManagerException e) {
			regResult.setResult(Result.FAIL);
			regResult.setMessage(e.getMessage());
		} finally {

			DBUtil.close(daoMgr);

			response.sendRedirect("register.jsp");
		}

	}

	private void validate(AccountRegistrationRequest aRequest, AccountDAO dao) throws ViolationException {
		Validator<AccountRegistrationRequest> validator = new RuleValidator<>(
				Arrays.asList(new MandatoryEmailRule(), new MandatoryUsernameRule(), new MandatoryPasswordRule(),
						new MandatoryPasswordConfirmationRule(), new PasswordAndConfirmationAreEqualRule(),
						new EmailFormatRule(), new PasswordFormatRule(), new UniqueUsernameRule(dao)));

		validator.validate(aRequest);

	}

	private AccountRegistrationRequest ARRFromHttpRequest(HttpServletRequest request) {
		AccountRegistrationRequest res = new AccountRegistrationRequest();

		res.setEmail(request.getParameter("email"));
		res.setPassword(request.getParameter("password"));
		res.setPasswordConfirmation(request.getParameter("password2"));
		res.setUsername(request.getParameter("username"));
		res.setDateOfBirth(request.getParameter("dob"));

		return res;
	}

}
