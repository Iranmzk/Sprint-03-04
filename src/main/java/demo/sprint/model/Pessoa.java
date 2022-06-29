package demo.sprint.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
}
