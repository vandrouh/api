package lab.crud.api.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int tipoUsuario;
	private LocalDate dataNascimento;
	
	
	//Alt + SHIFT + S(Source/Fonte/Código Fonte)
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public int setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public LocalDate setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", tipoUsuario=" + tipoUsuario + ", dataNascimento=" + dataNascimento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}


}

	
	
	

