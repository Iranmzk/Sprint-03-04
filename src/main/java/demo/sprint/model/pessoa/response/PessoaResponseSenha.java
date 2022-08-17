package demo.sprint.model.pessoa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaResponseSenha {
    private String id;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String email;
    private String senha;
}
