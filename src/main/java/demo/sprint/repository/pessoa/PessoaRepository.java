package demo.sprint.repository.pessoa;

import demo.sprint.repository.pessoa.model.pessoa.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaRepository extends MongoRepository<Pessoa,String> {
    @Query(fields = "{'nome': 1, 'email': 1, 'id':0}")
    List<Pessoa> findByNomeContains(String nome);
}
