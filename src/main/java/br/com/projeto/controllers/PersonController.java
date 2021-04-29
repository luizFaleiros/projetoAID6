package br.com.projeto.controllers;

import br.com.projeto.domain.dto.PersonDTO;
import br.com.projeto.domain.dto.response.PersonResponse;
import br.com.projeto.domain.mappers.PersonMapper;
import br.com.projeto.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    private final PersonMapper personMapper;


    @GetMapping
    public ResponseEntity<List<PersonResponse>> findAll() {
        List<PersonResponse> personResponse = personService.finAll().stream()
                .map(personMapper::EntityToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(personResponse);

    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PersonDTO person) {
        personService.save(personMapper.dtoToEntity(person));
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid PersonDTO person, @PathVariable("id") Long id) {
        personService.update(personMapper.dtoToEntity(person), id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable("id") Long id) {
        PersonResponse personResponse = personMapper.
                EntityToResponse(personService.findById(id));
        return ResponseEntity.ok(personResponse);
    }


}
