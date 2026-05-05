package Classes;

public class PedidoEstadoEfetuado extends PedidoEstado {

    public PedidoEstadoEfetuado(Pedido pedido) { super(pedido); }

    @Override
    public void avancar() {
        pedido.setEstado(new PedidoEstadoConfirmado(pedido));
    }

    @Override
    public String getNome() { return "Efetuado"; }
}