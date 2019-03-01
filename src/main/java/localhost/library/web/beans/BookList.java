package localhost.library.web.beans;

import localhost.library.web.DBConnector.DBConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> booklist = new ArrayList<Book>();

    private ArrayList<Book> getBooks(String str) {

        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            connection = DBConnection.getConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery(str);

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setGenre(resultSet.getString("genre"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setAuthor(resultSet.getString("author"));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setPublishDate(resultSet.getDate("publish_year"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setImage(resultSet.getBytes("image"));
                booklist.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return booklist;
    }

    public ArrayList<Book> getBookList() {
        if (!booklist.isEmpty()) {
            return booklist;
        } else {
            return getBooks("select * from book order by name");
        }
    }

    public ArrayList<Book> getBooksByGenre(long id) {
        return getBooks("select b.id,b.name,b.isbn,b.page_count,b.publish_year, p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id "
                + "where genre_id=" + id + " order by b.name "
                + "limit 0,5");
    }


}
