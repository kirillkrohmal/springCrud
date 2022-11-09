package ru.demo.crud.repository;

import ru.demo.crud.model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> index();

    Person show(int id);

    void save(Person person);

    void update(int id, Person person);

    void delete(int id);

}
