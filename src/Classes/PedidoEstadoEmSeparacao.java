package Classes;

public class PedidoEstadoEmSeparacao extends PedidoEstado {

    public PedidoEstadoEmSeparacao(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        pedido.setEstado(new PedidoEstadoEnviado(pedido));
    }

    @Override
    public String getNome() { return "Em Separação"; }
}
