package ru.demo.crud.repository;


import org.springframework.stereotype.Repository;
import ru.demo.crud.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDAO {
    private static Connection connection;

    @Override
    public List<Person> index() {
        List<Person> personList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("address"));
                person.setAddress(resultSet.getString("email"));

                personList.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return personList;
    }

    @Override
    public Person show(int id) {

        Person person = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAddress(resultSet.getString("address"));
            person.setEmail(resultSet.getString("email"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;
    }

    @Override
    public void save(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Person VALUES(id, ?, ?, ?)");
            statement.setString(1, person.getName());
            statement.setString(2, person.getAddress());
            statement.setString(3, person.getEmail());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(int id, Person person) {
        try {
            PreparedStatement statement = connection.
                    prepareStatement("UPDATE Person SET name = ?, address = ?, email = ? WHERE id = ?");

            statement.setString(1, person.getName());
            statement.setString(2, person.getAddress());
            statement.setString(3, person.getEmail());
            statement.setInt(4, person.getId());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.
                    prepareStatement("DELETE FROM Person WHERE id=?");

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
