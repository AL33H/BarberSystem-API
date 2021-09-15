package br.com.BarberSystem.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
                        ATTRIBUTES
     */
    private Long id;

    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String FirstName;


    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String LastName;


    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String Sex;


    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String BirthDate;

    @Size(max = 25, message = "Tamanho máximo de 25 caracteres!")
    private String Telephone;

    @Size(max = 25, message = "Tamanho máximo de 25 caracteres!")
    private String City;


    /*
                        GETTER'S AND SETTER'S
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
