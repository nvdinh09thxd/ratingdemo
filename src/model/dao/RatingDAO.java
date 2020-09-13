package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Rating;
import utils.JDBCConnectionUtil;

public class RatingDAO {
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;

	public boolean haveRating(int idNews) {
		conn = JDBCConnectionUtil.getConnection();
		try {
			String sql = "SELECT * FROM rating WHERE id_news = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNews);
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}
		return false;
	}

	public int addItem(Rating rating) {
		int result = 0;
		conn = JDBCConnectionUtil.getConnection();
		String sql = "INSERT INTO rating (id_news, score) VALUES (?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rating.getId_news());
			pst.setFloat(2, rating.getScore());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}
		return result;
	}

	public int editItem(Rating rating) {
		int result = 0;
		conn = JDBCConnectionUtil.getConnection();
		String sql = "UPDATE rating SET score = (? + score*count)/(count+1), count = count + 1 WHERE id_news = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setFloat(1, rating.getScore());
			pst.setInt(2, rating.getId_news());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}
		return result;
	}

	public float getScore(int idNews) {
		conn = JDBCConnectionUtil.getConnection();
		try {
			String sql = "SELECT * FROM rating WHERE id_news = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNews);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getFloat("score");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}
		return 0;
	}

}
