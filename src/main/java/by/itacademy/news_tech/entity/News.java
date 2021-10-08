package by.itacademy.news_tech.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "news")
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotEmpty(message="provide title")
	@Size(min=3, max=30, message = "title - min 3 chars and max 30")
	@Column
	private String title;

	@NotEmpty(message="provide brief")
	@Size(min=3, max=30, message = "brief - min 3 chars and max 30")
	@Column
	private String brief;

	@NotEmpty(message="provide body")
	@Size(min=3, max=1000, message = "body - min 3 chars and max 1000")
	@Column
	private String body;

	@Column
	private Timestamp date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, brief, date, id, title);
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
				&& Objects.equals(date, other.date) && id == other.id && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [id=" + id + ", title=" + title + ", brief=" + brief + ", body=" + body
				+ ", date=" + date + "]";
	}

}
