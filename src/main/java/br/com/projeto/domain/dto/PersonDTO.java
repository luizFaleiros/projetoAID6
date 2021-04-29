package br.com.projeto.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String gender;
}
