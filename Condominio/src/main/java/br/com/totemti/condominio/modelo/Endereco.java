package br.com.totemti.condominio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_endereco", nullable = false)
	private Long id;
	
	@Column(name = "rua", nullable = false)
	private String rua;
	
	@Column(name = "numero", nullable = false)
	private String numero;
	
	@Column(name = "quadra")
	private String quadra;
	
	@Column(name = "complemento")
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name = "id_condominio", nullable = false, foreignKey = @ForeignKey(name = "fk_endereco_id_condominio"))
	private Condominio condominio;
	
	@ManyToOne
	@JoinColumn(name = "id_proprietario", nullable = false, foreignKey = @ForeignKey(name = "fk_endereco_id_proprietario"))
	private Proprietario proprietario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
