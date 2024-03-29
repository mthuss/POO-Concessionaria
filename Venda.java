public class Venda
{
    private long ID;
    private Cliente cliente;
    private Vendedor vendedor;
    private Veiculo veiculo;
    private float valor;
    private Data data;
    private Horario horario;
    boolean aVista;

    public Venda(long ID, Cliente cliente, Vendedor vendedor, Veiculo veiculo, float valor, Data data, Horario horario, boolean aVista) {
        this.ID = ID;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.veiculo = veiculo;
        this.valor = valor;
        this.data = data;
        this.horario = horario;
        this.aVista = aVista;
    }

    public Venda()  {
        
    }

    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public Horario getHorario() {
        return horario;
    }
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    public boolean getAVista()
    {
        return this.aVista;
    }
    public void setAVista(boolean aVista)
    {
        this.aVista = aVista;
    }
}