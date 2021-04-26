package br.com.projeto.services;

import br.com.projeto.domain.entities.Person;
import br.com.projeto.repository.PersonRepository;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Teste da classe person")
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class PersonServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    private Person testPerson;


    @BeforeEach
    public void before() {
        testPerson = Person.builder()
                .id(1L)
                .firstName("Teste")
                .lastName("Teste")
                .address("Teste")
                .gender("Teste")
                .build();
    }


    @Test
    @DisplayName("Achando um Person")
    public void whenFindByIdThenReturnOnePerson() {
        //Quando for chamado o repositório
        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(testPerson));
        //
        Person person = personService.findById(1L);

        verify(personRepository, times(1)).findById(1L);
        assertEquals(person.getId(),testPerson.getId());
        assertEquals(person.getId(),testPerson.getId());
        assertEquals(person.getFirstName(),testPerson.getFirstName());
        assertEquals(person.getLastName(),testPerson.getLastName());
        assertEquals(person.getAddress(),testPerson.getAddress());
        assertEquals(person.getGender(),testPerson.getGender());

    }

    @Test
    @DisplayName("Trazendo uma lista de Persons")
    public void whenFindAllThenReturnListOfPerson() {
        when(personRepository.findAll()).thenReturn(List.of(testPerson));
        List<Person> persons = Arrays.asList(testPerson);
        List<Person> personMock = personService.finAll();
        verify(personRepository,times(1)).findAll();
        assertEquals(persons.size(),personMock.size());
        assertEquals(persons.hashCode(),personMock.hashCode());
    }
}