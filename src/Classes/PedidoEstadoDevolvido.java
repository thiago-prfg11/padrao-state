package Classes;

public class PedidoEstadoDevolvido extends PedidoEstado {

    public PedidoEstadoDevolvido(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        // estado terminal — nenhuma transição possível
    }

    @Override
    public String getNome() { return "Devolvido"; }
}
