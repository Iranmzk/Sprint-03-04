package demo.sprint.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    private String id;
    @NotBlank(message = "Por favor, insira um nome")
    private String nome;
    @NonNull
    private String sobrenome;
    @NonNull
    private String email;
    @NotBlank(message = "Idade inválida.")
    private Integer idade;
    @NotBlank
    private String senha;

    public Pessoa(String id, String nome, @NonNull String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
