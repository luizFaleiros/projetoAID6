package br.com.projeto.domain.mappers;

import br.com.projeto.domain.dto.response.PersonResponse;
import br.com.projeto.domain.entities.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {
    private final ModelMapper mapper;

    public PersonResponse toResponse(Person entity){
        return mapper.map(entity,PersonResponse.class);
    }
}
