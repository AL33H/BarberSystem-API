package br.com.BarberSystem.DTO.Request;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@NoArgsConstructor
public class JobsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
                        ATTRIBUTES
     */

    private Long id;

    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String name;

    
    private Double value;

    /*
                        GETTER'S AND SETTER'S
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
