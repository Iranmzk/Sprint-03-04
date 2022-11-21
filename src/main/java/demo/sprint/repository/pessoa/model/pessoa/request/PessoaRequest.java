package demo.sprint.repository.pessoa.model.pessoa.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class PessoaRequest {
    private String id;
    @NotNull
    private String name;
    private String postName;
    @NotNull
    private String email;
    @NotNull
    private Integer age;
    private String password;
}
