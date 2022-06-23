package demo.sprint.controller;


import demo.sprint.model.Pessoa;
import demo.sprint.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/sprint03")
public class PessoaController {
    @Autowired
    private final PessoaService service;

    @PostMapping("/pessoa")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa save(@RequestBody Pessoa pessoa){
        return service.save(pessoa);
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> findOne(@PathVariable String id){
        return service.findOne(id);
    }

    @GetMapping("/")
    public List<Pessoa> findAll(){
        return service.findAll();
    }

    @GetMapping("/create-coockie")
    public String criandoCoookie(Pessoa pessoa, HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("cookie-name","cookie-value");
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        return "cookie-recived/";
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") List<String> id){
        service.deleteAllById(id);
    }

    @PutMapping("/{id}")
    public Pessoa putPessoa(@RequestBody Pessoa pessoa){
        return service.save(pessoa);
    }

    @GetMapping("/filtro")
    public List<Pessoa> findPessoaNome(@RequestParam("nome") String nome){
       return service.findByNome(nome);
    }

    }

