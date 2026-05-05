package Testes;

import Classes.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido("BR-1042");
    }

    @Test
    void pedidoDeveIniciarComoEfetuado() {
        assertEquals("Efetuado", pedido.getEstado().getNome());
    }

    @Test
    void pedidoDeveAvancarDeEfetuadoParaConfirmado() {
        pedido.avancar();
        assertEquals("Confirmado", pedido.getEstado().getNome());
    }

    @Test
    void pedidoDevePercorrerFluxoCompletoAtéEntregue() {
        pedido.avancar(); // Confirmado
        pedido.avancar(); // Em Separação
        pedido.avancar(); // Enviado
        pedido.avancar(); // Saiu Para Entrega
        pedido.avancar(); // Entregue
        assertEquals("Entregue", pedido.getEstado().getNome());
    }

    @Test
    void pedidoDeveIrParaFalhaDeEntregaAposUmaFalha() {
        pedido.avancar(); // Confirmado
        pedido.avancar(); // Em Separação
        pedido.avancar(); // Enviado
        pedido.avancar(); // Saiu Para Entrega
        pedido.reportarFalha();
        assertEquals("Falha de Entrega", pedido.getEstado().getNome());
    }

    @Test
    void pedidoDeveVoltarParaSaiuParaEntregaAposNovatentativa() {
        pedido.avancar(); // Confirmado
        pedido.avancar(); // Em Separação
        pedido.avancar(); // Enviado
        pedido.avancar(); // Saiu Para Entrega
        pedido.reportarFalha();
        pedido.avancar(); // Nova tentativa
        assertEquals("Saiu Para Entrega", pedido.getEstado().getNome());
    }

    @Test
    void pedidoDeveSerDevolvidoAposTresFalhas() {
        pedido.avancar(); // Confirmado
        pedido.avancar(); // Em Separação
        pedido.avancar(); // Enviado
        pedido.avancar(); // Saiu Para Entrega
        pedido.reportarFalha();
        pedido.avancar();
        pedido.reportarFalha();
        pedido.avancar();
        pedido.reportarFalha(); // 3ª falha
        assertEquals("Devolvido", pedido.getEstado().getNome());
    }

    @Test
    void pedidoEntregueDevePermaneceEntregueAoAvancar() {
        pedido.avancar(); // Confirmado
        pedido.avancar(); // Em Separação
        pedido.avancar(); // Enviado
        pedido.avancar(); // Saiu Para Entrega
        pedido.avancar(); // Entregue
        pedido.avancar(); // Tenta avançar — deve permanecer
        assertEquals("Entregue", pedido.getEstado().getNome());
    }

    @Test
    void pedidoDevolvidoDevePermaneserDevolvidoAoAvancar() {
        pedido.avancar();
        pedido.avancar();
        pedido.avancar();
        pedido.avancar();
        pedido.reportarFalha();
        pedido.avancar();
        pedido.reportarFalha();
        pedido.avancar();
        pedido.reportarFalha(); // Devolvido
        pedido.avancar();       // Tenta avançar — deve permanecer
        assertEquals("Devolvido", pedido.getEstado().getNome());
    }
}