package com.andrew.SpringSecurity.util;

import com.andrew.SpringSecurity.models.Person;
import com.andrew.SpringSecurity.services.PeopleService;
import com.andrew.SpringSecurity.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;
    //private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService, PeopleService peopleService) {
        this.personDetailsService = personDetailsService;
        //this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

//    @Override
//    public void validate(Object o, Errors errors) {
//        Person person = (Person) o;
//
//        Optional<Person> similarName = peopleService.findingPerson(person.getUsername());
//
//        if(similarName.isPresent()){
//            errors.rejectValue("username", "", "User with this name exist");
//        } else {
//            return;
//        }
//    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        try {
            personDetailsService.loadUserByUsername(person.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return;
        }

        errors.rejectValue("username", "", "User with this name exist");
    }
}
