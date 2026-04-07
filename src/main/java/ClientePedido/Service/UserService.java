package ClientePedido.Service;

import ClientePedido.Entities.User;
import ClientePedido.Repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class UserService {

    private UserRepository userRepository;
    private EntityManager em;

    public UserService(UserRepository userRepository, EntityManager em) {
        this.userRepository = userRepository;
        this.em = em;
    }

    // Criar usuario
    public void criarUsuario(String nome, String email) {
        if (nome.isBlank() || email.isBlank()) {
            throw new IllegalArgumentException("Campo vazio..");
        }

        User user = new User(nome, email);

        try {
        em.getTransaction().begin();
        userRepository.save(user);
        em.getTransaction().commit(); } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao criar usuário..");
        }
    }

    // Deletar usuario
    public void deletarUsuario(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id inválido..");
        }

        User user = userRepository.findById(User.class, id);

        if (user == null) {
            throw new IllegalArgumentException("Usuario nulo..");
        }

        try {
        em.getTransaction().begin();
        userRepository.save(user);
        em.getTransaction().commit(); } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao deletar usuário..");
        }
    }

    // Buscar usuario por ID
    public User buscarUsuario(Long id) {
        return userRepository.findById(User.class, id);
    }

    // Listar usuarios
    public List<User> listarUsuario() {
        return userRepository.findAll(User.class);
    }
}
