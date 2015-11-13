package hu.dupetya.web.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import hu.dupetya.common.dao.DAOException;
import hu.dupetya.common.dao.UserDAO;
import hu.dupetya.web.AutowiringHttpSerlvet;

/**
 * Servlet implementation class CheckUserNameAjax
 */
@WebServlet("/CheckUserNameAjax")
public class CheckUserNameAjax extends AutowiringHttpSerlvet {
	private static class CheckUserResult {
		private String result;

		public CheckUserResult() {
		}

		public CheckUserResult(String result) {
			super();
			this.result = result;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

	}

	@Autowired
	UserDAO userDAO;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserNameAjax() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleRequest(request, response);
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

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CheckUserResult result = new CheckUserResult("SUCCESS");
		try {
			if (userDAO.findUserByName(request.getParameter("username")) != null) {
				result.setResult("FAIL");
			}
		} catch (DAOException e) {
		}

		Gson gson = new Gson();
		gson.toJson(result, response.getWriter());
	}

}
