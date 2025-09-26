import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {
    private Biblioteca biblioteca;
    private Livro livro1;
    private Livro livro2;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();

        livro1 = new Livro("123456", "Dom Casmurro", "Machado de Assis", 1899);
        livro2 = new Livro("789012", "O Cortiço", "Aluísio Azevedo", 1890);

        usuario1 = new Usuario("U001", "João Silva", "joao@email.com");
        usuario2 = new Usuario("U002", "Maria Santos", "maria@email.com");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        // TODO: Adicionar livros e usuários à biblioteca

    }

    @Test
    @DisplayName("✅ Deve cadastrar livro com sucesso")
    void testCadastrarLivro() {
        // TODO: Implementar teste para cadastro de livro
        // Verificar se livro foi adicionado à biblioteca

        Livro livro3 = new Livro("456789", "Memórias Póstumas", "Machado de Assis", 1881);
        biblioteca.adicionarLivro(livro3);

        List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
        assertTrue(livrosDisponiveis.contains(livro3), "Livro deveria estar na lista de disponíveis");
    }

    @Test
    @DisplayName("❌ Deve lançar exceção ao cadastrar livro nulo")
    void testCadastrarLivroNulo() {
        // TODO: Implementar teste para livro nulo
        // Usar assertThrows para verificar exceção
        assertThrows(IllegalArgumentException.class, () -> biblioteca.adicionarLivro(null));
    }

    @Test
    @DisplayName("✅ Deve realizar empréstimo com sucesso")
    void testEmprestarLivro() {
        // TODO: Implementar teste de empréstimo bem-sucedido
        // Verificar se livro ficou indisponível

        LocalDate data = LocalDate.now();
        boolean emprestado = biblioteca.emprestarLivro("123456", "U001", data);
        assertTrue(emprestado);
        assertFalse(livro1.isDisponivel(), "Livro deveria estar indisponível após empréstimo");
    }

    @Test
    @DisplayName("❌ Não deve emprestar livro indisponível")
    void testEmprestarLivroIndisponivel() {
        // TODO: Implementar teste para livro já emprestado

        LocalDate data = LocalDate.now();
        boolean emprestimo1 = biblioteca.emprestarLivro("123456", "U001", data);
        assertTrue(emprestimo1, "Empréstimo inicial deve ser bem-sucedido");
        boolean emprestimo2 = biblioteca.emprestarLivro("123456", "U001", data);
        assertFalse(emprestimo2, "Não deve permitir novo empréstimo do mesmo livro enquanto estiver emprestado");
    }

    @ParameterizedTest
    @DisplayName("💰 Deve calcular multa corretamente")
    @ValueSource(ints = {0, 5, 10})
    void testCalcularMulta(int diasAtraso) {
        // TODO: Implementar teste parametrizado para cálculo de multa
        // Dica: usar LocalDate.now().plusDays(diasAtraso) para data de devolução

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusDays(14 + diasAtraso);

        biblioteca.emprestarLivro("123456", "U001", dataEmprestimo);
        double multa = biblioteca.devolverLivro("123456", dataDevolucao);
        assertEquals(diasAtraso * 2.0, multa, 0.001, "Multa deve ser 2.0 por dia de atraso");
    }

    @Test
    @DisplayName("📚 Deve listar apenas livros disponíveis")
    void testListarLivrosDisponiveis() {
        // TODO: Implementar teste para listagem de livros disponíveis
        // Emprestar um livro e verificar se não aparece na lista

        biblioteca.emprestarLivro("123456", "U001", LocalDate.now());

        List<Livro> disponiveis = biblioteca.listarLivrosDisponiveis();

        assertFalse(disponiveis.contains(livro1), "Livro emprestado não deve estar disponível");
        assertTrue(disponiveis.contains(livro2), "Livro não emprestado deve estar disponível");
    }

    @Test
    @DisplayName("⏰ Deve bloquear empréstimo para usuário com multa")
    void testUsuarioComMulta() {
        // TODO: Implementar teste para usuário com multa
        // Configurar usuário com multa e tentar empréstimo

        biblioteca.emprestarLivro("123456", "U001", LocalDate.now());
        biblioteca.devolverLivro("123456", LocalDate.now().plusDays(20)); // atraso → multa

        boolean novoEmprestimo = biblioteca.emprestarLivro("789012", "U001", LocalDate.now());
        assertFalse(novoEmprestimo, "Usuário com multa não deve conseguir novo empréstimo");
    }

    @AfterEach
    void tearDown() {
        // TODO: Limpar recursos se necessário
        biblioteca = null;
        System.out.println("Teste finalizado.");
    }
}
