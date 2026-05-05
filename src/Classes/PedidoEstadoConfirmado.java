package Classes;

public class PedidoEstadoConfirmado extends PedidoEstado {

    public PedidoEstadoConfirmado(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        pedido.setEstado(new PedidoEstadoEmSeparacao(pedido));
    }

    @Override
    public String getNome() { return "Confirmado"; }
}
