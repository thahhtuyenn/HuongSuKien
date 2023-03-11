package quanLySach;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Sach implements Serializable{
	private String id;
	private String title;
	private String author;
	private int year;
	private String publishing;
	private int page;
	private double price;
	private String isbn;

	public Sach(String id, String title, String author, int year, String publishing, int page, double price,
			String isbn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.publishing = publishing;
		this.page = page;
		this.price = price;
		this.isbn = isbn;
	}

	public Sach(String id) {
		this.id = id;
		this.title = "-----";
		this.author = "-----";
		this.year = LocalDate.now().getYear();
		this.publishing = "-----";
		this.page = 1;
		this.price = 1;
		this.isbn = "-----";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (!id.trim().equals(""))
			this.id = id;
		else
			this.id = "xxx";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (!title.trim().equals(""))
			this.title = title;
		else
			this.title = "-----";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (!author.trim().equals(""))
			this.author = author;
		else
			this.author = "-----";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year > 0)
			this.year = year;
		else 
			this.year = LocalDate.now().getYear();
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		if(!publishing.trim().equals(""))
			this.publishing = publishing;
		else
			this.publishing = "-----";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page > 0)
			this.page = page;
		else 
			this.page = 1;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price > 0)
			this.price = price;
		else
			this.price = 1;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if(!isbn.trim().equals(""))
			this.isbn = isbn;
		else
			this.isbn = "-----";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
