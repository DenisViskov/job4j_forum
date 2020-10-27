package forum.service;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
public interface Login<V>{
    boolean validate(V some);
}
