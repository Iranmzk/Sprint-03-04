package demo.sprint.repository.pessoa.model.pessoa.mapper;

import demo.sprint.repository.pessoa.model.pessoa.Pessoa;
import demo.sprint.repository.pessoa.model.pessoa.request.PessoaRequest;
import demo.sprint.repository.pessoa.model.pessoa.response.PessoaResponse;
import demo.sprint.repository.pessoa.model.pessoa.response.PessoaResponseSenha;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PessoaMapper {
    public static Pessoa requestPessoa(PessoaRequest pessoaRequest){
        return Pessoa.builder()
                .id(pessoaRequest.getId())
                .name(pessoaRequest.getName())
                .postName(pessoaRequest.getPostName())
                .age(pessoaRequest.getAge())
                .email(pessoaRequest.getEmail())
                .password(pessoaRequest.getPassword())
                .build();
    }

    public static PessoaResponseSenha pessoaResponseSenha(Pessoa pessoa){
        return PessoaResponseSenha.builder()
                .id(pessoa.getId())
                .name(pessoa.getName())
                .postName(pessoa.getPostName())
                .age(pessoa.getAge())
                .email(pessoa.getEmail())
                .password(pessoa.getPassword())
                .build();
    }
    public static PessoaResponse pessoaResponse(Pessoa pessoa){
        return PessoaResponse.builder()
                .name(pessoa.getName())
                .postName(pessoa.getPostName())
                .age(pessoa.getAge())
                .email(pessoa.getEmail())
                .build();
    }
}
