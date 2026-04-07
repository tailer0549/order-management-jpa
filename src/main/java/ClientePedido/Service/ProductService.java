package ClientePedido.Service;

import ClientePedido.Entities.Product;
import ClientePedido.Repository.ProductRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductService {

    private ProductRepository productRepository;
    private EntityManager em;

    public ProductService(ProductRepository repository, EntityManager em) {
       this.productRepository = repository;
       this.em = em;
    }

    // Criar produto
    public void criarProduto(String nome, Double preco) {
        Product produto = new Product(nome, preco);

        if (produto == null) {
            throw new IllegalArgumentException("Produto é null..");
        }

        try {
            em.getTransaction().begin();
            productRepository.save(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().begin();
            throw new RuntimeException("Erro ao criar produto..");
        }
    }

    // Deletar produto
    public void deletarProduto(Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id inválido..");
        }

        Product product = productRepository.findById(Product.class, id); // Já deixa o objeto como managed

        if (product == null) {
            throw new IllegalArgumentException("Produto é null..");
        }

        try {
            em.getTransaction().begin();
            productRepository.delete(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao deletar produto..");
        }
    }

    // Buscar produto por ID
    public Product buscarProduto(Long id) {
        return productRepository.findById(Product.class, id);
    }

    // Listar produtos
    public List<Product> listarProdutos() {
        return productRepository.findAll(Product.class);
    }
}
