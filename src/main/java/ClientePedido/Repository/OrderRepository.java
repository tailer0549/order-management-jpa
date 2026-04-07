package ClientePedido.Repository;

import ClientePedido.Entities.Order;

import javax.persistence.EntityManager;

public class OrderRepository extends GenericRepository<Order> {

    public OrderRepository(EntityManager em) {
        super(em);
    }
}
