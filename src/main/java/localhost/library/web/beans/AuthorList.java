package localhost.library.web.beans;

import localhost.library.web.DBConnector.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AuthorList {

    private ArrayList<Author> authorsList = new ArrayList<Author>();


    private ArrayList<Author> AuthorsList () {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from author order by fio");
            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getLong("id"));
                author.setName(resultSet.getString("fio"));
                authorsList.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {




        }

        return authorsList;
    }

    public ArrayList<Author> getAuthorsList() {
        if (!authorsList.isEmpty()) {
            return authorsList;
        } else {
            return AuthorsList();
        }
    }


}
