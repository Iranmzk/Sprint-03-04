package demo.sprint.service;

import demo.sprint.configuration.exception.ApiNotFoundException;
import demo.sprint.model.Pessoa;
import demo.sprint.repository.PessoaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {
    private final PessoaRepositorio pessoaRepositorio;

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepositorio.save(pessoa);
    }

    public Pessoa att(String id, Pessoa pessoaAtt){
        Pessoa pessoaSalva = pessoaRepositorio.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
        pessoaAtt.setId(pessoaSalva.getId());
        return pessoaRepositorio.save(pessoaAtt);
    }

    public Pessoa findById(String id){
        return pessoaRepositorio.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
    }
    public List<Pessoa> findAll(){
        return pessoaRepositorio.findAll();
    }


    public void deleteAllById(List<String> id){
        pessoaRepositorio.deleteAllById(id);
    }

    public List<Pessoa> findByNomeContains(String nome){
        return pessoaRepositorio.findByNomeContains(nome);
    }
}
