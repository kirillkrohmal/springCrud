package ru.demo.crud.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.crud.model.Person;
import ru.demo.crud.repository.PersonDAO;

import javax.servlet.annotation.ServletSecurity;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;

    @Override
    public List<Person> index() {
        return personDAO.index();
    }

    @Override
    public Person show(int id) {
        return personDAO.show(id);
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public void update(int id, Person person) {
        personDAO.update(id, person);
    }

    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }
}
