package br.com.medinapassos.preencherlista;

import java.util.List;

/**
 *
 * @author JP1
 */
public interface IPreencherLista<T, E> {
    void preencher(T t, List<? super E> e);
}
