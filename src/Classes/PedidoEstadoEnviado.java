package Classes;

public class PedidoEstadoEnviado extends PedidoEstado {

    public PedidoEstadoEnviado(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        pedido.setEstado(new PedidoEstadoSaiuParaEntrega(pedido));
    }

    @Override
    public String getNome() { return "Enviado"; }
}
