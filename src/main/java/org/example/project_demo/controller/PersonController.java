package org.example.project_demo.controller;


import lombok.RequiredArgsConstructor;
import org.example.project_demo.domain.Person;
import org.example.project_demo.domain.PersonRepository;
import org.example.project_demo.models.PersonRequestDto;
import org.example.project_demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    @GetMapping("/api/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }
}
