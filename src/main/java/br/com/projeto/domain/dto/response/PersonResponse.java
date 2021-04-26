package br.com.projeto.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

}
