package br.com.projeto.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 80)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 80)
    private String lastName;

    @Column(name = "ADDRESS", nullable = false, length = 80)
    private String address;

    @Column(name = "GENDER", nullable = false, length = 10)
    private String gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId().equals(person.getId()) && getFirstName().equals(person.getFirstName())
                && getLastName().equals(person.getLastName()) && getAddress().equals(person.getAddress())
                && getGender().equals(person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
    }
}
