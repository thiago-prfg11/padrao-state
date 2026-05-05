package Classes;

public class PedidoEstadoFalhaDeEntrega extends PedidoEstado {

    public PedidoEstadoFalhaDeEntrega(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        pedido.setEstado(new PedidoEstadoSaiuParaEntrega(pedido));
    }

    @Override
    public String getNome() { return "Falha de Entrega"; }
}