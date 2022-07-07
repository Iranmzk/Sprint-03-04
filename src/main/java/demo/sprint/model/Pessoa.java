package demo.sprint.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;

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
    private String email;
    private Integer idade;
    private String senha;
}
