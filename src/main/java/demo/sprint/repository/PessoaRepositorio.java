package demo.sprint.repository;

import demo.sprint.model.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PessoaRepositorio extends MongoRepository<Pessoa,String> {
    /**
     * Find all Pessoa objects whose nome field contains the given string.
     *
     * @param nome The name of the method parameter.
     * @return List<Pessoa>
     */
    List<Pessoa> findByNomeContains(String nome);
}
