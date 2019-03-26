package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal implements Serializable {
	
	// ID PADRÃO DO SERIALIZABLE
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String especie;
	
	public Animal() {
	
	}
	
	public Animal(Integer codigo, String nome, String especie) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.especie = especie;
	}
	
	
	
	@Override
	public String toString() {
		return "Animal [codigo=" + codigo + ", nome=" + nome + ", especie=" + especie + "]";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
}
