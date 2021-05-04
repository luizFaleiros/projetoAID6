package br.com.projeto.services;

import br.com.projeto.domain.entities.Person;
import br.com.projeto.exception.PersonNotFoundException;
import br.com.projeto.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Pessoa não encontrada"));
    }

    public List<Person> finAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person update(Person person, Long id) {
        Person oldPerson = findById(id);
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setAddress(person.getAddress());
        oldPerson.setGender(person.getGender());
        return personRepository.save(oldPerson);
    }

    public void delete(Long id) {
        Person person = findById(id);
        personRepository.delete(person);
    }
}
