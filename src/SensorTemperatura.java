import java.util.Random;

public class SensorTemperatura implements Sensor {
    private double ultimoValor;
    private double limiteAlerta = 100.0; // °C
    private final Random random = new Random();

    @Override
    public double ler() {
        // simula temperatura entre -150 e 150 °C
        ultimoValor = -150 + random.nextDouble() * 300;
        return ultimoValor;
    }

    @Override
    public boolean verificarFuncionamento() {
        // 90% de chance de estar funcionando normalmente
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
    public String getNome() { return "Sensor de Temperatura"; }

    @Override
    public String getUnidade() { return "°C"; }

    @Override
    public double getUltimoValor() { return ultimoValor; }

    @Override
    public double getLimiteAlerta() { return limiteAlerta; }
}