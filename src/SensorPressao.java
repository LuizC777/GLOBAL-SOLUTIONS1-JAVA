import java.util.Random;

public class SensorPressao implements Sensor {
    private double ultimoValor;
    private double limiteAlerta = 250.0; // kPa
    private final Random random = new Random();

    @Override
    public double ler() {
        // simula pressão entre 0 e 300 kPa
        ultimoValor = random.nextDouble() * 300;
        return ultimoValor;
    }

    @Override
    public boolean verificarFuncionamento() {
        return random.nextInt(100) < 90;
    }

    @Override
    public void definirLimiteAlerta(double limite) {
        this.limiteAlerta = limite;
    }

    @Override
    public boolean acimaDoLimite() {
        return ultimoValor > limiteAlerta;
    }

    @Override
    public String getNome() { return "Sensor de Pressão"; }

    @Override
    public String getUnidade() { return "kPa"; }

    @Override
    public double getUltimoValor() { return ultimoValor; }

    @Override
    public double getLimiteAlerta() { return limiteAlerta; }
}