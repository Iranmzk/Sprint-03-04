package demo.sprint.service;

import demo.sprint.configuration.exception.ApiNotFoundException;
import demo.sprint.integration.data.DataIntegration;
import demo.sprint.model.Pessoa;
import demo.sprint.repository.PessoaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {
//    @Autowired
    private final PessoaRepositorio repositorio;
    private final DataIntegration dataIntegration;

    public Pessoa save(Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    public Pessoa att(String id, Pessoa pessoaAtt){
        Pessoa pessoaSalva = repositorio.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
        pessoaAtt.setId(pessoaSalva.getId());
        return repositorio.save(pessoaAtt);
    }

    public Pessoa findById(String id){
        return repositorio.findById(id)
                .orElseThrow(() -> new ApiNotFoundException("Id não encontrado " + id));
    }
    public List<Pessoa> findAll(){
        return repositorio.findAll();
    }


    public void deleteAllById(List<String> id){
        repositorio.deleteAllById(id);
    }

    public List<Pessoa> findByNomeContains(String nome){
        return repositorio.findByNomeContains(nome);
    }
}
