package com.andrew.SpringSecurity.services;

import com.andrew.SpringSecurity.models.Person;
import com.andrew.SpringSecurity.repositories.PeopleRepositories;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepositories peopleRepositories;

    public PeopleService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    public Optional<Person> findingPerson(String name){
        Optional<Person> findPeople = peopleRepositories.findByUsername(name);
        return findPeople;
    }
}
