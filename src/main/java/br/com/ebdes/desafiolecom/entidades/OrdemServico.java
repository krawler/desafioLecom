package br.com.ebdes.desafiolecom.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.SessionAttributes;

@XmlRootElement
@Entity
public class OrdemServico {
	
	@Id @Column @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Servico> servicos;
	@Temporal(value=TemporalType.DATE)
	private Date dataInicio;
	@Temporal(value=TemporalType.DATE)
	private Date dataFim;
	
	public OrdemServico(){
	}

	public OrdemServico(Long id, Cliente cliente, List<Servico> servicos,
			Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servicos = servicos;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
