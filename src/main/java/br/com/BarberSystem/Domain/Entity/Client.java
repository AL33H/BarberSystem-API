package br.com.BarberSystem.Domain.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;



@Entity
@Builder
@AllArgsConstructor
public class Client implements Serializable{


    private static final long serialVersionUID = 1L;

    /*
                        ATTRIBUTES
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    @Size(min = 2,max = 45)
    private String FirstName;

    @Column(nullable = false)
    @Size(min = 2,max = 45)
    private String LastName;

    @Column(nullable = false)
    @Size(min = 2,max = 45)
    private String Sex;

    @Column(nullable = false)
    @Size(max = 45)
    private String BirthDate;

    @Size(max = 45)
    private String Telephone;

    @Size(max = 45)
    private String City;

   /*
                        CONSTRUCTOR'S
    */



    /*
                        GETTER'S AND SETTER'S
     */


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    /*
                        METHODS
     */


    @Override
    public String toString() {
        return "Client{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }


}