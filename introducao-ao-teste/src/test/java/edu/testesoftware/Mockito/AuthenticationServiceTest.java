package edu.testesoftware.Mockito;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Test
    public void testLoginSuccess() {
        // Cria um mock do UserRepository
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        // Stub do método findByUsername para retornar um usuário válido
        User user = new User("john_doe", "password123");
        when(userRepository.findByUsername("john_doe")).thenReturn(user);

        // Cria uma instância do AuthenticationService usando o mock
        AuthenticationService authService = new AuthenticationService(userRepository);

        // Testa o login com credenciais válidas
        boolean result = authService.login("john_doe", "password123");
        assertTrue(result); // Verifica se o login foi bem-sucedido
    }

    @Test
    public void testLoginFailureInvalidPassword() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        // Retorna o usuário, mas com uma senha incorreta
        User user = new User("john_doe", "password123");
        when(userRepository.findByUsername("john_doe")).thenReturn(user);

        AuthenticationService authService = new AuthenticationService(userRepository);

        // Testa o login com uma senha incorreta
        boolean result = authService.login("john_doe", "wrongpassword");
        assertFalse(result); // O login deve falhar
    }

    @Test
    public void testLoginFailureUserNotFound() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        // Configura o método findByUsername para retornar null (usuário não encontrado)
        when(userRepository.findByUsername("nonexistent_user")).thenReturn(null);

        AuthenticationService authService = new AuthenticationService(userRepository);

        // Testa o login com um usuário inexistente
        boolean result = authService.login("nonexistent_user", "password");
        assertFalse(result); // O login deve falhar
    }
}