public class PropulsaoEletrica extends SistemaPropulsao {

    private double nivelBateria; // 0 a 100

    public PropulsaoEletrica(int id, double nivelBateria) {
        super(id, "Propulsao Eletrica");
        this.nivelBateria = nivelBateria;
    }

    @Override
    public boolean acelerar(double porcentagem) {
        boolean ok = super.acelerar(porcentagem);
        if (ok) {
            nivelBateria -= porcentagem * 0.1;
            if (nivelBateria < 0) nivelBateria = 0;
            temperatura = 20 + porcentagem * 0.5; // aquece pouco
            System.out.printf("Bateria restante: %.1f%%%n", nivelBateria);
        }
        return ok;
    }

    @Override
    public double calcularEmpuxo() {
        return potencia * 5; // empuxo BAIXO
    }

    @Override
    public String exibirDetalhes() {
        return "[" + id + "] " + nome
                + " | Bateria: " + nivelBateria + "%"
                + " | Empuxo: " + calcularEmpuxo() + " kN"
                + " | Temp: " + temperatura + " C";
    }

    public double getNivelBateria() { return nivelBateria; }
}