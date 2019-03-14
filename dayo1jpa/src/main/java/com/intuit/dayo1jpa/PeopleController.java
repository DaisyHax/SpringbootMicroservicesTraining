package com.intuit.dayo1jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonsRepository personsRepository;



    @PostMapping("/{name}/{age}")
    public String savePerson(@PathVariable("name") String name,@PathVariable("age") int age){
        Persons persons = new Persons();
        persons.setName(name);
        persons.setAge(age);
        personsRepository.save(persons);
//        System.out.println(persons.getId()+"  "+persons.getName()+"   "+persons.getAge()+"  .");
        return "Person Created";
    }

    @PutMapping("update/{id}/{age}")
    public String updateAge(@PathVariable int id,@PathVariable int age){
        if(personsRepository.findById(id).isPresent()){
            Persons oldPerson = personsRepository.findById(id).get();
            oldPerson.setAge(age);
            personsRepository.save(oldPerson);
        }
        else{
            return "Person with id: " +id+ " not present";
        }
        return "Person age Updated";
    }

//    @GetMapping("/all")
//    public Iterable getAllPersons(){
//        return personsRepository.findAll();
//    } // this method was also working

    @GetMapping("/all")
    public List<Persons> getAllPersons(){
        List<Persons> persons = new ArrayList<>();
        personsRepository.findAll().forEach(i -> persons.add(i));
        return persons;
    }


    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable int id){
        if(personsRepository.findById(id).isPresent()){
            Persons oldPerson = personsRepository.findById(id).get();
            personsRepository.delete(oldPerson);
        }
        else{
            return "Person with id: " +id+ " not present";
        }
        return "Person deleted";
    }


}
