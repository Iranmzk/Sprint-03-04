package demo.sprint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class PessoaDTO {
    private String nome;
    private String sobrenome;
    private String email;

    public PessoaDTO(Pessoa pessoa) {
        nome = pessoa.getNome();
        sobrenome = pessoa.getSobrenome();
        email = pessoa.getEmail();
    }
}
