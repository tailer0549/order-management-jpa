package ClientePedido.Repository;

import ClientePedido.Entities.User;

import javax.persistence.EntityManager;

public class UserRepository extends GenericRepository<User> {

    public UserRepository(EntityManager em) {
        super(em);
    }
}
