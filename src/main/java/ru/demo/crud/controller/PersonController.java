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

    @GetMapping(value = "/list/{id}")
    public String show(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("person", personService.show(id));
        return "/form";
    }

    @PostMapping(value = "/new")
    public String addPersonForm(@ModelAttribute("person")Person person, BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("person", personService.index());
        }

        personService.save(person);

        return "redirect:/list";
    }

    @GetMapping()
    public String edit(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("person", personService.show(id));

        return "/edit";
    }

    @PutMapping(value = "{id}/edit")
    public String update(@PathVariable("id") int id, @ModelAttribute("person")Person person) {
        personService.update(id, person);

        return "redirect:/list";
    }

    @DeleteMapping(value = "list/{id}")
    public String delete(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/list";
    }
}
