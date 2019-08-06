/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medinapassos.model;

/**
 *
 * @author JP1
 */
public class Endereco {

    private Integer enderecoId;
    private String endereco;
    private Integer clienteId;

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Endereco() {
    }

    public Endereco(Integer enderecoId, String endereco, Integer clienteId) {
        this.enderecoId = enderecoId;
        this.endereco = endereco;
        this.clienteId = clienteId;
    }

}
