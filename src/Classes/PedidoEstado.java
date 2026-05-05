package Classes;

// Estado base — classe abstrata
public abstract class PedidoEstado {

    protected Pedido pedido;

    public PedidoEstado(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void avancar();
    public abstract String getNome();

    public void reportarFalha() {
        // comportamento padrão: ação inválida para o estado atual
    }
}
