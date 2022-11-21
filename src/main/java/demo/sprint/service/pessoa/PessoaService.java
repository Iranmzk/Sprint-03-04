package demo.sprint.service.pessoa;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.repository.pessoa.PessoaRepository;
import demo.sprint.repository.pessoa.model.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa att(String id, Pessoa pessoaAtt){
        Pessoa pessoaSalva = pessoaRepository.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
        pessoaAtt.setId(pessoaSalva.getId());
        return pessoaRepository.save(pessoaAtt);
    }

    public Pessoa findById(String id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
    }
    public Page<Pessoa> findAll(Pageable pageable){
        return pessoaRepository.findAll(pageable);
    }

    public void deleteAllById(List<String> id){
        pessoaRepository.deleteAllById(id);
    }

    public List<Pessoa> findByNomeContains(String nome){
        return pessoaRepository.findByNameContains(nome);
    }

    public List<Pessoa> getAllByExample(Pessoa pessoa) {
        Example<Pessoa> e = Example.of(pessoa);
        return pessoaRepository.findAll(e);
    }

}
