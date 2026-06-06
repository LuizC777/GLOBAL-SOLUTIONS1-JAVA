public interface Sensor {
    double ler();                            // 1. Leitura de valores (simulada)
    boolean verificarFuncionamento();        // 2. Verificação de funcionamento
    void definirLimiteAlerta(double limite); // 3. Definição de limites de alerta
    boolean acimaDoLimite();                 // 4. Detecção quando passa do limite

    String getNome();
    String getUnidade();
    double getUltimoValor();
    double getLimiteAlerta();
}