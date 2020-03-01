package com.manager.entity.hospital;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class HospitalGuia implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero_guia")
	private String numeroGuia;
	
	private String nome;
	
	@Column(name = "nome_convenio")
	private String nomeConvenio;
	
	@Column(name = "data_faturamento")
	@Temporal(TemporalType.DATE)
	private Date dataFaturamento;
	
	@Column(name = "valor_guia")
	private double valorGuia;
	
	@Column(name = "valor_pago_guia")
	private double valorPagoGuia;
	
	@Column(name = "valor_glosa_guia")
	private double valorGlosaGuia;
	
	@Column(name = "quantidade_de_item")
	private int quantidadeItem;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Column(name = "valor_item")
	private double valorItem;
	
	@Column(name = "valor_pago_item")
	private double valorPagoItem;
	
	@Column(name = "valor_glosa_item")
	private double valorGlosaItem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroGuia() {
		return numeroGuia;
	}
	public void setNumeroGuia(String numeroGuia) {
		this.numeroGuia = numeroGuia;
	}
	public Date getDataFaturamento() {
		return dataFaturamento;
	}
	public void setDataFaturamento(Date dataFaturamento) {
		this.dataFaturamento = dataFaturamento;
	}
	public double getValorGuia() {
		return valorGuia;
	}
	public void setValorGuia(double valorGuia) {
		this.valorGuia = valorGuia;
	}
	public double getValorPagoGuia() {
		return valorPagoGuia;
	}
	public void setValorPagoGuia(double valorPagoGuia) {
		this.valorPagoGuia = valorPagoGuia;
	}
	public double getValorGlosaGuia() {
		return valorGlosaGuia;
	}
	public void setValorGlosaGuia(double valorGlosaGuia) {
		this.valorGlosaGuia = valorGlosaGuia;
	}
	public int getQuantidadeItem() {
		return quantidadeItem;
	}
	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getValorItem() {
		return valorItem;
	}
	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}
	public double getValorPagoItem() {
		return valorPagoItem;
	}
	public void setValorPagoItem(double valorPagoItem) {
		this.valorPagoItem = valorPagoItem;
	}
	public double getValorGlosaItem() {
		return valorGlosaItem;
	}
	public void setValorGlosaItem(double valorGlosaItem) {
		this.valorGlosaItem = valorGlosaItem;
	}
	public String getNomeConvenio() {
		return nomeConvenio;
	}
	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HospitalGuia other = (HospitalGuia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
