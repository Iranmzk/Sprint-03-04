package demo.sprint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    private String id;
    @NotNull(message = "Por favor, insira um nome")
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
    private String senha;
}
