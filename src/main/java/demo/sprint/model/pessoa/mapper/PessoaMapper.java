package demo.sprint.model.pessoa.mapper;

import demo.sprint.model.pessoa.Pessoa;
import demo.sprint.model.pessoa.request.PessoaRequest;
import demo.sprint.model.pessoa.response.PessoaResponse;
import demo.sprint.model.pessoa.response.PessoaResponseSenha;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PessoaMapper {
    public static Pessoa requestPessoa(PessoaRequest pessoaRequest){
        return Pessoa.builder()
                .id(pessoaRequest.getId())
                .nome(pessoaRequest.getNome())
                .sobrenome(pessoaRequest.getSobrenome())
                .idade(pessoaRequest.getIdade())
                .email(pessoaRequest.getEmail())
                .senha(pessoaRequest.getSenha())
                .build();
    }

    public static PessoaResponseSenha pessoaResponseSenha(Pessoa pessoa){
        return PessoaResponseSenha.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .sobrenome(pessoa.getSobrenome())
                .idade(pessoa.getIdade())
                .email(pessoa.getEmail())
                .senha(pessoa.getSenha())
                .build();
    }
    public static PessoaResponse pessoaResponse(Pessoa pessoa){
        return PessoaResponse.builder()
                .nome(pessoa.getNome())
                .sobrenome(pessoa.getSobrenome())
                .idade(pessoa.getIdade())
                .email(pessoa.getEmail())
                .build();
    }
}
