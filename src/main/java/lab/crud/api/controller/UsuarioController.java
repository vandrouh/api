package lab.crud.api.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lab.crud.api.model.usuario;
import lab.crud.api.repository.ProdutoRepository;

@RestController
public class UsuarioController {


	@Autowired
	public UsuarioController repository;
	
	//curl -X POST http://localhost:8080/produtos -H "Content-Type: application/json; Charset=utf-8" -d @produto-pao.json
	
	//@RequestMapping(method = RequestMethod.POST, path = "/produto")
	@PostMapping("/usuarios")
	public ResponseEntity<usuario> novo(
			@RequestBody usuario usuario) {
		
		
		usuario.setDataNascimento(LocalDate.now());
		
		repository.save(usuario);
		
		System.out.println(usuario.toString());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(produto);
	}

	@GetMapping("/usuarios")
	public ResponseEntity<Iterable<Usuario>> obterTodos() {
		
		List<Usuario> listUsuario = repository.findByNomeLike("%o%");
				
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {

		// Alt + SHIFT + L -> extrai variável local
		Optional<Usuario> usuarioEncontrado = repository.findById(id);

		// Empty = Vazio
		if (usuarioEncontrado.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrado");
		}

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(usuarioEncontrado.get());
	}
	
	//Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis minusculo)
	//curl -X PUT http://localhost:8080/produtos/1 -H "Content-Type: application/json; Charset=utf-8" -d @produto-pao.json
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> atualizarProduto(
			@PathVariable Integer id,
			@RequestBody usuario user){
		
		Optional<usuario> usuario = repository.findById(id);
		
		if (usuario.isEmpty()) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrado!");
		}
		
		user.setId(id);
		user.setDataCriacao(usuario.get().getDataCriacao());
		repository.save(user);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Usuario atualizado com scesso!");
	}
	
	//curl -X DELETE http://localhost:8081/produtos/1
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Object> apagarUsuario(
			@PathVariable Integer id) {
		
		Optional<Usuario> usuario = repository.findById(id);
		
		if (usuario.isEmpty()) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Usuario não encontrado!");
		}
		
		usuario user = usuario.get();
		repository.delete(user);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Usuario apagado com sucesso!");
			
		}
	

}


	