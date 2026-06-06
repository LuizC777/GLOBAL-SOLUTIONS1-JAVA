public abstract class SistemaPropulsao extends ComponenteEspacial {

    protected double potencia; // 0 a 100

    public SistemaPropulsao(int id, String nome) {
        super(id, nome); // chama o construtor de ComponenteEspacial
        this.potencia = 0;
    }

    // sobrescreve desligar() para tambem zerar a potencia
    @Override
    public void desligar() {
        super.desligar(); // faz o que a classe mae ja faz
        potencia = 0;     // e ainda zera a potencia
    }

    // acelerar com validacao (usa o 'status' herdado da classe mae)
    public boolean acelerar(double porcentagem) {
        if (!status) {
            System.out.println("Nao e possivel acelerar: motor desligado.");
            return false;
        }
        if (porcentagem < 0 || porcentagem > 100) {
            System.out.println("Potencia invalida! Use um valor entre 0 e 100.");
            return false;
        }
        this.potencia = porcentagem;
        System.out.printf("%s acelerando a %.1f%% de potencia.%n", nome, potencia);
        return true;
    }

    public abstract double calcularEmpuxo();

    public double getPotencia() { return potencia; }
}