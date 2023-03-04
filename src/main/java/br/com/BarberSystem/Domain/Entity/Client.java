package br.com.BarberSystem.Domain.Entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    @Size(min = 2, max = 45)
    private String FirstName;

    @Column(nullable = false)
    @Size(min = 2, max = 45)
    private String LastName;

    @Column(nullable = false)
    @Size(min = 2, max = 45)
    private String Sex;

    @Column(nullable = false)
    @Size(max = 45)
    private String BirthDate;

    @Size(max = 45)
    private String Telephone;

    @Size(max = 45)
    private String City;

    @Override
    public String toString() {
        return "Client{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

}
