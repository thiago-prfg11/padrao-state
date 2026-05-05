package Classes;

public class PedidoEstadoSaiuParaEntrega extends PedidoEstado {

    public PedidoEstadoSaiuParaEntrega(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        pedido.setEstado(new PedidoEstadoEntregue(pedido));
    }

    @Override
    public void reportarFalha() {
        pedido.tentativasDeEntrega++;
        if (pedido.tentativasDeEntrega < 3) {
            pedido.setEstado(new PedidoEstadoFalhaDeEntrega(pedido));
        } else {
            pedido.setEstado(new PedidoEstadoDevolvido(pedido));
        }
    }

    @Override
    public String getNome() { return "Saiu Para Entrega"; }
}
