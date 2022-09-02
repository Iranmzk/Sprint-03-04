package demo.sprint.repository.pessoa.model.pessoa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaResponse {
        private String nome;
        private String sobrenome;
        private Integer idade;
        private String email;
        }
