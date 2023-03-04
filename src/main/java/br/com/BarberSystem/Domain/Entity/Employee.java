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
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 2, max = 45)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 2, max = 45)
    private String sex;

    @Column(nullable = false)
    @Size(min = 2, max = 45)
    private String function;

}
