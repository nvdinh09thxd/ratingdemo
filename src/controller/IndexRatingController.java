package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Rating;
import model.dao.RatingDAO;

public class IndexRatingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RatingDAO ratingDao;

	public IndexRatingController() {
		super();
		ratingDao = new RatingDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idNews = 1;
		float score = ratingDao.getScore(idNews);
		request.setAttribute("score", score);
		request.getRequestDispatcher("rating/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int idNews = Integer.parseInt(request.getParameter("aid"));
		float score = Float.parseFloat(request.getParameter("ascore"));
		// System.out.println(score);
		Rating rating = new Rating(0, idNews, score, 1);
		if (ratingDao.haveRating(idNews)) {
			// đã tồn tại thì update lại đánh giá
			if (ratingDao.editItem(rating) > 0) {
				// lưu thành công
				out.print("Cảm ơn bạn đã đánh giá!");
			} else {
				// thất bại
				out.print("Không thể lưu đánh giá!");
			}
		} else {
			// chưa tồn tại thì thêm mới
			if (ratingDao.addItem(rating) > 0) {
				// lưu thành công
				out.print("Cảm ơn bạn đã đánh giá!");
			} else {
				// thất bại
				out.print("Không thể lưu đánh giá!");
			}
		}

	}

}
