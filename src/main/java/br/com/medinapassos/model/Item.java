package br.com.medinapassos.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author JP1
 */
public class Item {

    private Integer itemId;
    private Integer pedidoId;
    private String descricao;
    private BigDecimal valor;
    private BigDecimal quantidade;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.itemId);
        hash = 89 * hash + Objects.hashCode(this.pedidoId);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.valor);
        hash = 89 * hash + Objects.hashCode(this.quantidade);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        if (!Objects.equals(this.pedidoId, other.pedidoId)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        return true;
    }

    public Item(Integer itemId, Integer pedidoId, String descricao, BigDecimal valor, BigDecimal quantidade) {
        this.itemId = itemId;
        this.pedidoId = pedidoId;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Item() {
    }

}
