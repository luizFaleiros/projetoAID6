package br.com.projeto.services;

import br.com.projeto.domain.entities.Person;
import br.com.projeto.exception.PersonNotFound;
import br.com.projeto.mock.PersonMockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonMockRepository personMockRepository;

    public Person findById(Long id){
        return personMockRepository.findById(id).orElseThrow(() -> new PersonNotFound("Pessoa não encontrada"));
    }

    public List<Person> finAll(){
        return personMockRepository.findAll();
    }
}
