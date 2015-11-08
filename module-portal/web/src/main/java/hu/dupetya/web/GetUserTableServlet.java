package hu.dupetya.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.dupetya.web.users.DataTableRequest;
import hu.dupetya.web.users.DataTableRequest.Column;
import hu.dupetya.web.users.DataTableRespond;
import hu.dupetya.web.users.UserTableEntry;

/**
 * Servlet implementation class GetUserTableServlet
 */
@WebServlet("/GetUserTableServlet")
public class GetUserTableServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserTableServlet() {
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

	}

	private DataTableRequest DataTableRequestFromRequest(HttpServletRequest request) {
		DataTableRequest res = new DataTableRequest();

		res.setDraw(Integer.valueOf(request.getParameter("draw")));
		res.setLength(Integer.valueOf(request.getParameter("length")));
		res.setOrderCol(Column.from(request.getParameter("order[0][column]")));
		res.setOrderDir(request.getParameter("order[0][dir]"));
		res.setSearch(request.getParameter("search[value]"));
		res.setStart(Integer.valueOf(request.getParameter("start")));

		return res;
	}

}
