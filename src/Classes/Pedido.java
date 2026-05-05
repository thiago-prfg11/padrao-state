package Classes;

// Contexto
public class Pedido {

    private PedidoEstado estado;
    private String codigo;
    int tentativasDeEntrega = 0;

    public Pedido(String codigo) {
        this.codigo = codigo;
        this.estado = new PedidoEstadoEfetuado(this);
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void avancar() {
        estado.avancar();
    }

    public void reportarFalha() {
        estado.reportarFalha();
    }
}
