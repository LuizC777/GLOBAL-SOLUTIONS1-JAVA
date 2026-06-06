import java.util.Random;

public class SensorRadiacao implements Sensor {
    private double ultimoValor;
    private double limiteAlerta = 500.0; // mSv
    private final Random random = new Random();

    @Override
    public double ler() {
        // simula radiação entre 0 e 1000 mSv
        ultimoValor = random.nextDouble() * 1000;
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
    public String getNome() { return "Sensor de Radiação"; }

    @Override
    public String getUnidade() { return "mSv"; }

    @Override
    public double getUltimoValor() { return ultimoValor; }

    @Override
    public double getLimiteAlerta() { return limiteAlerta; }
}