
package com.manager.entity.convenio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Guia implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    private String convenio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pagamento")
    private Date dataPagamento;
    
    @Column(name = "numero_protocolo")
    private String numeroProtocolo;
    
    private String matricula;
    
    private String nome;
    
    @Column(name = "numero_guia")
    private String numeroGuia;
    
    @Column(name = "ng_prest")
    private String ngPrest;
    
    @Column(name = "senha_guia")
    private String senhaGuia;
    
    @Column(name = "codigo_produto")
    private String codigoProduto;
    
    @Column(name = "descricao_produto")
    private String descricaoProduto;
    
    @Column(name = "valor_apresentado")
    private String valorApresentado;
    
    @Column(name = "valor_pago")
    private BigDecimal valorPago;
    
    @Column(name = "valor_glosa")
    private BigDecimal valorGlosa;
    
    @Column(name = "descricao_motivo")
    private String descricaoMotivo;
    
    @Column(name = "codigo_motivo")
    private String codigoMotivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getNgPrest() {
        return ngPrest;
    }

    public void setNgPrest(String ngPrest) {
        this.ngPrest = ngPrest;
    }

    public String getSenhaGuia() {
        return senhaGuia;
    }

    public void setSenhaGuia(String senhaGuia) {
        this.senhaGuia = senhaGuia;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getValorApresentado() {
        return valorApresentado;
    }

    public void setValorApresentado(String valorApresentado) {
        this.valorApresentado = valorApresentado;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorGlosa() {
        return valorGlosa;
    }

    public void setValorGlosa(BigDecimal valorGlosa) {
        this.valorGlosa = valorGlosa;
    }

    public String getDescricaoMotivo() {
        return descricaoMotivo;
    }

    public void setDescricaoMotivo(String descricaoMotivo) {
        this.descricaoMotivo = descricaoMotivo;
    }

    public String getCodigoMotivo() {
        return codigoMotivo;
    }

    public void setCodigoMotivo(String codigoMotivo) {
        this.codigoMotivo = codigoMotivo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Guia other = (Guia) obj;
        return Objects.equals(this.id, other.id);
    }

}
