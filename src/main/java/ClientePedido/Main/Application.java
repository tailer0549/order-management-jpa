package ClientePedido.Main;

import ClientePedido.Entities.Enums.OrderStatus;
import ClientePedido.Repository.OrderRepository;
import ClientePedido.Repository.ProductRepository;
import ClientePedido.Repository.UserRepository;
import ClientePedido.Service.OrderService;
import ClientePedido.Service.ProductService;
import ClientePedido.Service.UserService;
import ClientePedido.Util.JPAUtil;

import javax.persistence.EntityManager;
import java.time.Instant;

public class Application {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        // Repositories
        OrderRepository orderRepository = new OrderRepository(em);
        ProductRepository productRepository = new ProductRepository(em);
        UserRepository userRepository = new UserRepository(em);

        // Service
        OrderService orderService = new OrderService(orderRepository, userRepository, productRepository,em);
        ProductService productService = new ProductService(productRepository, em);
        UserService userService = new UserService(userRepository, em);

        //userService.criarUsuario("Malcon X", "malconTHEdammer@gmail.com");
        //productService.criarProduto("MacBook PRO", 4.100);

        orderService.criarPedido(Instant.parse("2026-04-26T00:00:00Z"), OrderStatus.WAITING_PAYMENT, 1L,1L, 3);


        em.close();


    }
}
