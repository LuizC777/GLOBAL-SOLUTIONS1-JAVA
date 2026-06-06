public class PropulsaoQuimica extends SistemaPropulsao {

    private String tipoCombustivel;

    public PropulsaoQuimica(int id, String tipoCombustivel) {
        super(id, "Propulsao Quimica");
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public boolean acelerar(double porcentagem) {
        boolean ok = super.acelerar(porcentagem);
        if (ok) {
            temperatura = 20 + porcentagem * 3; // aquece bastante com a potencia
            System.out.println("Queimando combustivel: " + tipoCombustivel);
        }
        return ok;
    }

    @Override
    public double calcularEmpuxo() {
        return potencia * 50; // empuxo ALTO
    }

    // implementa o metodo abstrato exigido por ComponenteEspacial
    @Override
    public String exibirDetalhes() {
        return "[" + id + "] " + nome
                + " | Combustivel: " + tipoCombustivel
                + " | Empuxo: " + calcularEmpuxo() + " kN"
                + " | Temp: " + temperatura + " C";
    }

    public String getTipoCombustivel() { return tipoCombustivel; }
}