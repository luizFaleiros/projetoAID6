package br.com.projeto.services;

import br.com.projeto.domain.entities.Person;
import br.com.projeto.exception.PersonNotFound;
import br.com.projeto.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person findById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFound("Pessoa não encontrada"));
    }

    public List<Person> finAll(){
        return personRepository.findAll();
    }
}
