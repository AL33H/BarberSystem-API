package br.com.BarberSystem.Controller.DTO.Request;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Builder
@NoArgsConstructor
public class UserDTO {

   /*
                        ATTRIBUTES
    */

    private String id;

    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String userName;

    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String password;

    /*
                        GETTER'S AND SETTER'S
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
