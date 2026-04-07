package ClientePedido.Repository;

import ClientePedido.Entities.Product;

import javax.persistence.EntityManager;

public class ProductRepository extends GenericRepository<Product>{

    public ProductRepository(EntityManager em) {
        super(em);
    }
}
