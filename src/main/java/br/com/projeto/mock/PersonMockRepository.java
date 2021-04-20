package br.com.projeto.mock;

import br.com.projeto.domain.entities.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class PersonMockRepository {

    private final AtomicLong counter = new AtomicLong();

    public Optional<Person> findById(Long id) {
        return Optional.of(Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Teste")
                .lastName("Teste")
                .address("Teste")
                .gender("Teste")
                .build());
    }

    private Person mockPerson (int i) {
        return Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Teste" + i)
                .lastName("Teste" + i)
                .address("Teste" + i)
                .gender("Teste" + i)
                .build();
    }

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            persons.add(mockPerson(i));
        }
        return persons;
    }
}
