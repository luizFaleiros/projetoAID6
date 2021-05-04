package br.com.projeto.services;

import br.com.projeto.domain.entities.Person;
import br.com.projeto.exception.PersonNotFoundException;
import br.com.projeto.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Teste da classe person")
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    private Person testPerson;
    private Person testPersonUpdade;


    @BeforeEach
    public void before() {
        testPerson = Person.builder()
                .id(1L)
                .firstName("Teste")
                .lastName("Teste")
                .address("Teste")
                .gender("Teste")
                .build();

        testPersonUpdade = Person.builder()
                .id(1L)
                .firstName("Teste1")
                .lastName("Teste1")
                .address("Teste1")
                .gender("Teste1")
                .build();
    }


    @Test
    @DisplayName("Achando um Person")
    public void whenFindByIdThenReturnOnePerson() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(testPerson));
        Person person = personService.findById(1L);
        verify(personRepository, times(1)).findById(1L);
        assertEquals(person.getId(), testPerson.getId());
        assertEquals(person.getId(), testPerson.getId());
        assertEquals(person.getFirstName(), testPerson.getFirstName());
        assertEquals(person.getLastName(), testPerson.getLastName());
        assertEquals(person.getAddress(), testPerson.getAddress());
        assertEquals(person.getGender(), testPerson.getGender());

    }

    @Test
    @DisplayName("Estourando Erro por não ter um person")
    public void whenFindByIdThenTrhowException() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        assertThrows(PersonNotFoundException.class, () -> personService.findById(1L));
    }

    @Test
    @DisplayName("Trazendo uma lista de Persons")
    public void whenFindAllThenReturnListOfPerson() {
        when(personRepository.findAll()).thenReturn(List.of(testPerson));
        List<Person> persons = Arrays.asList(testPerson);
        List<Person> personMock = personService.finAll();
        verify(personRepository, times(1)).findAll();
        assertEquals(persons.size(), personMock.size());
        assertEquals(persons.hashCode(), personMock.hashCode());
    }

    @Test
    @DisplayName("Salvando um person")
    public void whenSaveThenSaveAPerson() {
        when(personRepository.save(any(Person.class))).thenReturn(testPerson);
        personService.save(testPerson);
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    @DisplayName("Salvando um person")
    public void whenUpdateThenUpdateAPerson() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(testPerson));
        when(personRepository.save(any(Person.class))).thenReturn(testPersonUpdade);
        Person person = personService.update(testPersonUpdade, 1L);
        assertEquals(person.getId(), testPersonUpdade.getId());
        assertEquals(person.getId(), testPersonUpdade.getId());
        assertEquals(person.getFirstName(), testPersonUpdade.getFirstName());
        assertEquals(person.getLastName(), testPersonUpdade.getLastName());
        assertEquals(person.getAddress(), testPersonUpdade.getAddress());
        assertEquals(person.getGender(), testPersonUpdade.getGender());
        verify(personRepository, times(1)).save(any(Person.class));

    }
}