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
public class Morador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_morador", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco", nullable = false, foreignKey = @ForeignKey(name = "fk_morador_id_endereco"))
	private Endereco endereco;
	
}
