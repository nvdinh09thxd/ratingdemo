package model.bean;

public class Rating {
	private int id;
	private int id_news;
	private float score;
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_news() {
		return id_news;
	}

	public void setId_news(int id_news) {
		this.id_news = id_news;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Rating(int id, int id_news, float score, int count) {
		super();
		this.id = id;
		this.id_news = id_news;
		this.score = score;
		this.count = count;
	}

	public Rating() {
		super();
	}

}
