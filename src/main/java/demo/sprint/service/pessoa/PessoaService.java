package demo.sprint.service.pessoa;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.model.pessoa.Pessoa;
import demo.sprint.repository.PessoaRepository;
import lombok.AllArgsConstructor;
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
    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }


    public void deleteAllById(List<String> id){
        pessoaRepository.deleteAllById(id);
    }

    public List<Pessoa> findByNomeContains(String nome){
        return pessoaRepository.findByNomeContains(nome);
    }
}
