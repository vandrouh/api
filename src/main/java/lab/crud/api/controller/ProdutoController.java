package lab.crud.api.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lab.crud.api.model.Produto;

@RestController
public class ProdutoController {

	private List<Produto> listaProdutos = new ArrayList<Produto>();
	private static int proxId = 1;
	
	//curl -X POST http://localhost:8080/produtos -H "Content-Type: application/json; Charset=utf-8" -d @produto-pao.json
	
	//@RequestMapping(method = RequestMethod.POST, path = "/produto")
	@PostMapping("/produtos")
	public ResponseEntity<Produto> novo(
			@RequestBody Produto produto) {
		
		produto.setId(proxId++);
		produto.setDataCriacao(LocalDate.now());
		
		this.listaProdutos.add(produto);
		
		System.out.println(produto.toString());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(produto);
	}

	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> obterTodos() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(this.listaProdutos);
	}
}
