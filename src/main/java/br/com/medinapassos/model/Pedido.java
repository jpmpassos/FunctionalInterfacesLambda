package br.com.medinapassos.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP1
 */
public class Pedido {

    private Integer pedidoId;
    private List<Item> itens;
    private BigDecimal total;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Pedido(Integer pedidoId, BigDecimal total) {
        this.pedidoId = pedidoId;
        this.total = total;
        this.itens = new ArrayList<>();
    }

    public Pedido() {
    }

}
