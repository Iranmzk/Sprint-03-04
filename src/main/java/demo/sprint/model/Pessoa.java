package demo.sprint.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Pessoa {
    @Id
    private String id;
    private String nome;
    private String email;
    private Integer idade;

    public Pessoa(String nome, String email, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
}
