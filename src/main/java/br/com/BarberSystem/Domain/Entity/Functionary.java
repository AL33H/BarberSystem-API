package br.com.BarberSystem.Domain.Entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
public class Functionary implements Serializable {


    private static final long serialVersionUID = 1L;

    /*
                        ATTRIBUTES
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 2,max = 45)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 2,max = 45)
    private String sex;

    @Column(nullable = false)
    @Size(min = 2,max = 45)
    private String function;



    /*
                        GETTER'S AND SETTER'S
     */


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    /*
                        METHODS
     */

    @Override
    public String toString() {
        return "Functionaries{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Functionary that = (Functionary) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
