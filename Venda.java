public class Venda
{
    private int ID;
    private Cliente cliente;
    private Vendedor vendedor;
    private Veiculo veiculo;
    private float valor;
    private Data data;
    private Horario horario;

    public Venda(int ID, Cliente cliente, Vendedor vendedor, Veiculo veiculo, float valor, Data data, Horario horario) {
        this.ID = ID;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.veiculo = veiculo;
        this.valor = valor;
        this.data = data;
        this.horario = horario;
    }

    public Venda()  {
        
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
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
}