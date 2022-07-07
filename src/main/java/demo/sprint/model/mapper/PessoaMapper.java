package demo.sprint.model.mapper;

import demo.sprint.model.Pessoa;
import demo.sprint.model.request.PessoaRequest;
import demo.sprint.model.response.PessoaResponse;
import demo.sprint.model.response.PessoaResponseSenha;

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
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .sobrenome(pessoa.getSobrenome())
                .idade(pessoa.getIdade())
                .email(pessoa.getEmail())
                .build();
    }
}
