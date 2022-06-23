package demo.sprint.repository;

import demo.sprint.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepositorio extends MongoRepository<Pessoa,String> {
}
