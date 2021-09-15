package by.itacademy.news_tech.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int newsId;
	
	@Column
	private String title;
	
	@Column
	private String brief;
	
	@Column
	private String body;
	
	@Column
	private String style;
	
	@Column
	private Timestamp date;

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, brief, date, newsId, style, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(body, other.body) && Objects.equals(brief, other.brief)
				&& Objects.equals(date, other.date) && newsId == other.newsId && Objects.equals(style, other.style)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [newsId=" + newsId + ", title=" + title + ", brief=" + brief + ", body=" + body + ", style="
				+ style + ", date=" + date + "]";
	}
	
	

}
