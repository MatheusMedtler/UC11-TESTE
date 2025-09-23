import Classes.Cliente;
import Classes.Estoque;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    private Estoque estoque;

    @BeforeAll
    static void iniciarTestes() {
        System.out.println("🚀 Iniciando os testes...");
    }

    @BeforeEach
    void configurarTeste() {
        estoque = new Estoque(200,500,"Hastes","São Leopoldo");
        System.out.println("🔄 Teste concluído.");
    }

    @Test
    @DisplayName("💰 Depósito bem-sucedido")
    void testAumentarEstoque() {
        estoque.aumentarEstoque(30);
        assertEquals(230, estoque.getEstoqueAtual(), "O estoque deveria ser 230 após o depósito.");
    }

    @Test
    @DisplayName("Estoque retirado com sucesso")
    void testRetirar() {
        estoque.retirarDoEstoque(40);
        //assertTrue(resultado, "O saque deveria ser permitido.");
        assertEquals(160, estoque.getEstoqueAtual(), "O saldo deveria ser 190 após o saque.");
    }

    @Test
    @DisplayName("🚫 Estoque inválido (peças insuficientes)")
    void testEstoqueInvalido() {
        boolean resultado = estoque.retirarDoEstoque(1000);
        assertFalse(resultado, "A retirada não deveria ser permitida.");
        assertEquals(200, estoque.getEstoqueAtual(), "O estoque deveria permanecer sem alteração.");
    }


    @AfterEach
    void limparTeste() {
        System.out.println("✅ Teste finalizado.");
    }

    @AfterAll
    static void finalizarTestes() {
        System.out.println("🏁 Todos os testes concluídos.");
    }
}