package javaorders.app.repositories;
import javaorders.app.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Long> {
}
