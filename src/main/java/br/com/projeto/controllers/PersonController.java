package br.com.projeto.controllers;

import br.com.projeto.domain.dto.response.PersonResponse;
import br.com.projeto.domain.mappers.PersonMapper;
import br.com.projeto.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .map(personMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(personResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> findById(@PathVariable("id") Long id) {
        PersonResponse personResponse = personMapper.
                toResponse(personService.findById(id));
        return ResponseEntity.ok(personResponse);
    }


}
