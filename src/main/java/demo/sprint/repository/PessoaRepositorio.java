package demo.sprint.repository;

import demo.sprint.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PessoaRepositorio extends MongoRepository<Pessoa,String> {
    Optional<Pessoa> findByNomeContains(String nome);
}
