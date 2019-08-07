package br.com.medinapassos.utils;

import br.com.medinapassos.model.Item;
import br.com.medinapassos.model.Pedido;
import br.com.medinapassos.repository.ModelRepository;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JP1
 */
public class NewApiDateInstance {

    public NewApiDateInstance() {
    }

    @Test
    public void DateInstant() {

        List<Pedido> pedidos1 = ModelRepository.getPedidos(10000);
        List<Item> itens = ModelRepository.getItens(100000, 10000);

        List<Pedido> pedidos2 = ModelRepository.getPedidos(10000);

        List<Pedido> pedidos3 = ModelRepository.getPedidos(10000);

        List<Pedido> pedidos4 = ModelRepository.getPedidos(10000);
        
        List<Pedido> pedidos5 = ModelRepository.getPedidos(10000);

        Duration duracao;
        Instant inicio;
        Instant fim;
        long duracaoEmMilissegundos;

        inicio = Instant.now();
        FuncoesUtils.<Pedido, Item>preencher(pedidos2, itens,
                (Pedido p, Item i) -> p.getPedidoId().equals(i.getPedidoId()),
                (Pedido p, List<? super Item> l) -> p.setItens((List<Item>) l));
        fim = Instant.now();

        duracao = Duration.between(inicio, fim);
        duracaoEmMilissegundos = duracao.toMillis();

        System.out.println("FuncoesUtils.<Pedido, Item>preencher");
        System.out.println("Duração tempo:" + duracaoEmMilissegundos);

        inicio = Instant.now();
        FuncoesUtils.preencherPedidos(pedidos1, itens);
        fim = Instant.now();

        duracao = Duration.between(inicio, fim);
        duracaoEmMilissegundos = duracao.toMillis();

        System.out.println("FuncoesUtils.preencherPedidos(pedidos1, itens1);");
        System.out.println("Duração tempo:" + duracaoEmMilissegundos);

        inicio = Instant.now();
        FuncoesUtils.<Pedido, Item>preencherParallel(pedidos3, itens,
                (Pedido p, Item i) -> p.getPedidoId().equals(i.getPedidoId()),
                (Pedido p, List<? super Item> l) -> p.setItens((List<Item>) l));
        fim = Instant.now();

        duracao = Duration.between(inicio, fim);
        duracaoEmMilissegundos = duracao.toMillis();

        System.out.println("FuncoesUtils.<Pedido, Item>preencherParallel");
        System.out.println("Duração tempo:" + duracaoEmMilissegundos);

        inicio = Instant.now();
        FuncoesUtils.preencherPedidosCustomizado(pedidos4, itens);
        fim = Instant.now();

        duracao = Duration.between(inicio, fim);
        duracaoEmMilissegundos = duracao.toMillis();

        System.out.println("FuncoesUtils.preencherPedidosCustomizado(pedidos4, itens)");
        System.out.println("Duração tempo:" + duracaoEmMilissegundos);
        
        inicio = Instant.now();
        FuncoesUtils.preencherPedidosParallel(pedidos5, itens);
        fim = Instant.now();

        duracao = Duration.between(inicio, fim);
        duracaoEmMilissegundos = duracao.toMillis();

        System.out.println("FuncoesUtils.preencherPedidosParallel(pedidos1, itens1);");
        System.out.println("Duração tempo:" + duracaoEmMilissegundos);        

        assertEquals(true, true);
    }
}
