package demo.sprint.model.pessoa.response;

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
public class PessoaResponse {
        private String nome;
        private String sobrenome;
        private Integer idade;
        private String email;
        }
