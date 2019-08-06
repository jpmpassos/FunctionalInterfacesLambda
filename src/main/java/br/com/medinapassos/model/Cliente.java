package br.com.medinapassos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP1
 */
public class Cliente {

    private Integer clienteId;
    private String nome;
    private List<Endereco> enderecos;

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Cliente() {
    }

    public Cliente(Integer clienteId, String nome) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.enderecos = new ArrayList<>();
    }
}
