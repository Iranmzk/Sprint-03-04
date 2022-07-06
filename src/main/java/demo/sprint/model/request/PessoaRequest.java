package demo.sprint.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class PessoaRequest {
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
    private String senha;
}
