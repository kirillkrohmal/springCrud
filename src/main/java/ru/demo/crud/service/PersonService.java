package ru.demo.crud.service;

import ru.demo.crud.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> index();

    Person show(int id);

    void save(Person person);

    void update(int id, Person person);

    void delete(int id);

}
