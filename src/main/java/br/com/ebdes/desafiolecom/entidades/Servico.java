package br.com.ebdes.desafiolecom.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity 
public class Servico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name="id", unique=true) @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String descricao;
	@ManyToMany(mappedBy="servicos")
	private List<OrdemServico> ordens;
	
	public Servico(){
	}

	public Servico(Long id, String descricao, List<OrdemServico> ordens) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ordens = ordens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
