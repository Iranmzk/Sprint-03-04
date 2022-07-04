package demo.sprint.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    private String id;
    @NonNull
    private String nome;
    @NonNull
    private String sobrenome;
    @NonNull
    private String email;
    @NonNull
    private Integer idade;
}
