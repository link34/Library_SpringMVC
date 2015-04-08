package net.codejava.frameworks.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codejava.frameworks.spring.bo.Book;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class DisplayBookTOCController extends AbstractController {

	private List<Book> books;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Book myBook = null;
		if (books != null && !books.isEmpty()) {
			for (Book book : books) {
				if (book.getIsbn()== Integer.parseInt(request.getParameter("isbn")) ) {
					myBook = book;
					break;
				}
			}
		}
		return new ModelAndView("displayBookTOC","book",myBook);
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
       
    

}
