package quanLySach;

import java.io.Serializable;
import java.util.ArrayList;

public class QuanLySachModel implements Serializable{
	private ArrayList<Sach> listBook;

	public QuanLySachModel() {
		listBook = new ArrayList<Sach>();
	}

	private int index(String id) {
		int index = listBook.indexOf(new Sach(id));
		if (index < 0)
			return -1;
		return index;
	}

	public boolean addBook(Sach s) {
		int index = index(s.getId());
		if (index >= 0)
			return false;
		else {
			listBook.add(s);
			return true;
		}
	}

	public boolean removeBook(Sach s) {
		int index = index(s.getId());
		if (index >= 0) {
			listBook.remove(s);
			return true;
		} else
			return false;
	}

	public Sach searchBookByIndex(int index) {
		if (index < 0 || index > listBook.size())
			return null;
		return listBook.get(index);
	}

	public boolean updateBook(String id, String title, String author, int year, String publishing, int page,
			double price, String isbn) {
		Sach newBook;
		if (index(id) < 0)
			return false;
		else {
			newBook = listBook.get(index(id));
			newBook.setTitle(title);
			newBook.setAuthor(author);
			newBook.setYear(year);
			newBook.setPublishing(publishing);
			newBook.setPage(page);
			newBook.setPrice(price);
			newBook.setIsbn(isbn);
			return true;
		}
	}

	public ArrayList<Sach> getListBook() {
		return listBook;
	}

}
