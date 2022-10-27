package com.ej5.Controller;

import com.ej5.Service.PersonService;
import com.ej5.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;


@Controller
public class PersonViewTable {

    @Autowired
    PersonService personService;

    @GetMapping("/tabla")
    public String viewTable(final Model model) {

        final Flux<Person> personList = personService.allPerson();
        model.addAttribute("personlist", personList);
        return "personList";
    }
}
