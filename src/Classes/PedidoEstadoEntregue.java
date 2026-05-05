package Classes;

public class PedidoEstadoEntregue extends PedidoEstado {

    public PedidoEstadoEntregue(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        // estado terminal — nenhuma transição possível
    }

    @Override
    public String getNome() { return "Entregue"; }
}
