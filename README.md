## Functional Interface Lambda

Esse projeto tem o intuito de implementar uma interface funcional de uma função genérica de mesclar duas listas de objetos. Esse exemplo foi criado por mim, [Medina Passos](http://medinapassos.com.br).

Para rodar este código basta apenas realizar o clone do repositório em seu computador e executar o mesmo com sua IDE de preferência.

### Problema

Normalmente sempre temos a necessidade de carregar uma lista de objetos que em cada objeto pode conter inúmeros objetos e até uma lista de objetos. Como exemplo, posso citar um Pedido que pode ter uma lista de pedidos.

E se por algum motivo, ao invés de de ter cada Pedido com sua lista já carregada, tivermos duas lista uma de pedidos e outra dos itens do pedido? Assim necessitaríamos de mesclar essas duas lista preenchendo cada pedido com seus respectivos itens.   

Abaixo segue uma implementação que faz uso da nova Stream Api do Java 8, onde para cada pedido é realizado um filtro dos itens pelo `pedidoId`;

```markdown

  public static void preencherPedidos(List<Pedido> pedidos, List<Item> itens) {
      pedidos.forEach(
              p -> p.getItens().addAll(
                      itens.stream().filter(i -> i.getPedidoId().equals(p.getPedidoId())).collect(Collectors.toList())
              )
      );
  }
  
```

Mas se tivermos outras situações semelhantes a de `Pedido` e `Item` como `Cliente` e `Enderco` teríamos que criar um segunda função semelhante a essa mas para essa nova necessidade.

Então abaixo segue a implementação  de função genérica que que vai servir para quaisquer classes que tenha tal comportamento.

Para tal implementação foi usada duas interfaces funcionais que permitirá realizar a chamada da função com a uso do recurso Lambda.

```markdown
# Interface funcional para verificar se o item pertence ao pedido

    public interface IPreencherTeste<T, E> {
        boolean testar(T t, E e);
    }

# Interface funcional para preencher os itens filtrado em seu pedido

    public interface IPreencherLista<T, E> {
        void preencher(T t, List<? super E> e);
    }
 
# Por fim a função que faz uso das interfaces funcionais
 
     public static <T, E> void preencher(
            List<T> t, List<E> e,
            IPreencherTeste<? super T, ? super E> iPreencherTeste,
            IPreencherLista<? super T, ? super E> iPreencherLista) {
        t.forEach(p -> iPreencherLista
                .preencher(p, e.stream().filter(f -> iPreencherTeste.testar(p, f))
                        .collect(Collectors.toList())));
    }
```

Assim podemos realizar a chamada da função fazendo uso do recusro Lambda.

```markdown

        FuncoesUtils.<Pedido, Item>preencher(
                pedidos, itens,
                (Pedido p, Item i) -> p.getPedidoId().equals(i.getPedidoId()),
                (Pedido p, List<? super Item> l)
                -> p.setItens((List<Item>) l)
        );

```

Ao baixar o projeto, pode visualizar o teste unitário com na classe `FuncoesUtilsTest`.

Esse exemplo foi criado por mim, [Medina Passos](http://medinapassos.com.br).

