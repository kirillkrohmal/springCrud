package ru.demo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.demo.crud.model.Person;
import ru.demo.crud.service.PersonService;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/list")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.show(id));
        return "/form";
    }

    @PostMapping(value = "/new")
    public String addUserForm(@ModelAttribute("person")Person person, BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("person", personService.index());
        }

        personService.save(person);

        return "redirect:/list";
    }

    @PutMapping(value = "list/{id}/edit")
    public String update(@ModelAttribute("person")Person person, Model model) {
        //personService.update(id, person);
        return "/form";
    }

    @DeleteMapping(value = "list/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        //model.addAttribute(personService.delete(id));
        return "redirect:/list";
    }
}
