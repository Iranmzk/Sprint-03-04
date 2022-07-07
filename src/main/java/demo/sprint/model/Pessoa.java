package demo.sprint.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank
    private String sobrenome;
    @NonNull
    private String email;
    @NonNull
    private Integer idade;
    @NotBlank
    private String senha;

    public Pessoa(String nome, @NotBlank String sobrenome, @NonNull String email, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade;
    }
}
