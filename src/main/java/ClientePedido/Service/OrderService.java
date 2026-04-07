package ClientePedido.Service;

import ClientePedido.Entities.Enums.OrderStatus;
import ClientePedido.Entities.Order;
import ClientePedido.Entities.OrderItem;
import ClientePedido.Entities.Product;
import ClientePedido.Entities.User;
import ClientePedido.Repository.OrderRepository;
import ClientePedido.Repository.ProductRepository;
import ClientePedido.Repository.UserRepository;

import javax.persistence.EntityManager;
import java.time.Instant;

public class OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private EntityManager em;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, EntityManager em) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.em = em;
    }

    // Criar produto
    public void criarPedido(Instant moment, OrderStatus orderStatus, Long clienteId,  Long idProduto, Integer quantity) {
        User user = userRepository.findById(User.class, clienteId);

        Product produto = productRepository.findById(Product.class, idProduto);


        if (user == null) {
            throw new IllegalArgumentException("Usuario null..");
        }

        if (produto == null) {
            throw new IllegalArgumentException("Produto null..");
        }


        Order order = new Order(moment, orderStatus);

        OrderItem orderItem = new OrderItem(order, produto, quantity, produto.getPrice());

        try {
            order.getOrderItems().add(orderItem);
            orderItem.setOrder(order);
            order.setClient(user);
            user.getOrders().add(order);
            em.getTransaction().begin();
            orderRepository.save(order);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar..");
        }
    }
}
