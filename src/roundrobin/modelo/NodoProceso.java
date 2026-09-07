package roundrobin.modelo;

public class NodoProceso {
    public Proceso proceso;
    public NodoProceso siguiente;

    public NodoProceso(Proceso proceso) {
        this.proceso = proceso;
    }
}
