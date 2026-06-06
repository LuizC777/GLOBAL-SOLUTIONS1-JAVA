import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMonitoramento {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Sensor> sensores = new ArrayList<>();
    private static List<SistemaPropulsao> propulsores = new ArrayList<>();
    private static DadosMissao dados;

    public static void main(String[] args) {
        inicializar();

        int opcao;
        do { // LOOP PRINCIPAL do programa
            exibirMenu();
            opcao = lerInteiro();

            switch (opcao) {
                case 1: verificarSensores();    break;
                case 2: controlarPropulsao();   break;
                case 3: gerenciarDados();        break;
                case 4: simularAlertas();        break;
                case 5: exibirStatusCompleto();  break;
                case 0: System.out.println("Encerrando o sistema..."); break;
                default: System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // cria os objetos iniciais do sistema
    private static void inicializar() {
        sensores.add(new SensorTemperatura());
        sensores.add(new SensorPressao());
        sensores.add(new SensorRadiacao());

        propulsores.add(new PropulsaoQuimica(1, "Hidrogenio liquido"));
        propulsores.add(new PropulsaoEletrica(2, 100));

        dados = new DadosMissao("1234", "Orbita da Lua");
    }

    private static void exibirMenu() {
        System.out.println("\n===== MONITORAMENTO ESPACIAL =====");
        System.out.println("1 - Verificar sensores");
        System.out.println("2 - Controlar propulsao");
        System.out.println("3 - Gerenciar dados da missao");
        System.out.println("4 - Simular alertas");
        System.out.println("5 - Exibir status completo");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    // ---------- 1. VERIFICAR SENSORES ----------
    private static void verificarSensores() {
        System.out.println("\n--- Sensores ---");
        for (Sensor s : sensores) {
            double valor = s.ler();
            String func = s.verificarFuncionamento() ? "OK" : "FALHA";
            System.out.printf("%s: %.2f %s | %s%n",
                    s.getNome(), valor, s.getUnidade(), func);
        }
    }

    // ---------- 2. CONTROLAR PROPULSAO ----------
    private static void controlarPropulsao() {
        System.out.println("\n--- Propulsao ---");
        for (int i = 0; i < propulsores.size(); i++) {
            System.out.println((i + 1) + " - " + propulsores.get(i).getNome());
        }
        System.out.print("Escolha o motor: ");
        int escolha = lerInteiro();
        if (escolha < 1 || escolha > propulsores.size()) {
            System.out.println("Motor invalido!");
            return;
        }
        SistemaPropulsao motor = propulsores.get(escolha - 1);

        System.out.println("1 - Ligar | 2 - Desligar | 3 - Acelerar | 4 - Ver empuxo");
        System.out.print("Acao: ");
        switch (lerInteiro()) {
            case 1: motor.ligar(); break;
            case 2: motor.desligar(); break;
            case 3:
                System.out.print("Potencia (0-100): ");
                motor.acelerar(lerDouble());
                break;
            case 4:
                System.out.printf("Empuxo gerado: %.1f kN%n", motor.calcularEmpuxo());
                break;
            default: System.out.println("Acao invalida!");
        }
    }

    // ---------- 3. GERENCIAR DADOS DA MISSAO ----------
    private static void gerenciarDados() {
        System.out.println("\n--- Dados da Missao ---");
        System.out.println("1 - Ver coordenadas (protegidas) | 2 - Atualizar combustivel");
        System.out.println("3 - Definir trajetoria | 4 - Definir numero de tripulantes");
        System.out.print("Acao: ");
        int acao = lerInteiro();
        scanner.nextLine(); // limpa o buffer antes de ler textos

        switch (acao) {
            case 1:
                System.out.print("Digite a senha: ");
                String senha = scanner.nextLine();
                System.out.println("Coordenadas: " + dados.getCoordenadas(senha));
                break;
            case 2:
                System.out.print("Novo nivel de combustivel (0-100): ");
                dados.setNivelCombustivel(lerDouble());
                break;
            case 3:
                System.out.print("Nova trajetoria: ");
                dados.setTrajetoria(scanner.nextLine());
                break;
            case 4:
                System.out.print("Numero de tripulantes: ");
                dados.setNumeroTripulantes(lerInteiro());
                break;
            default: System.out.println("Acao invalida!");
        }
    }

    // ---------- 4. SISTEMA DE ALERTAS ----------
    private static void simularAlertas() {
        System.out.println("\n--- Sistema de Alertas ---");
        boolean algumAlerta = false;
        for (Sensor s : sensores) {
            s.ler(); // faz uma nova leitura antes de avaliar
            String nivel = classificarAlerta(s);
            if (!nivel.equals("NORMAL")) {
                System.out.printf("[%s] %s: %.2f %s%n",
                        nivel, s.getNome(), s.getUltimoValor(), s.getUnidade());
                algumAlerta = true;
            }
        }
        if (!algumAlerta) {
            System.out.println("Todos os sensores em niveis normais.");
        }
    }

    // diferencia os niveis de alerta com base na distancia do limite
    private static String classificarAlerta(Sensor s) {
        double valor = s.getUltimoValor();
        double limite = s.getLimiteAlerta();
        if (valor >= limite * 1.3) return "CRITICO"; // muito acima
        if (valor >= limite)       return "ALERTA";  // passou do limite
        if (valor >= limite * 0.8) return "ATENCAO"; // chegando perto
        return "NORMAL";
    }

    // ---------- 5. EXIBIR STATUS COMPLETO ----------
    private static void exibirStatusCompleto() {
        System.out.println("\n===== STATUS COMPLETO =====");

        System.out.println("\n[Sensores]");
        for (Sensor s : sensores) {
            s.ler();
            System.out.printf("  %s: %.2f %s (%s)%n",
                    s.getNome(), s.getUltimoValor(), s.getUnidade(), classificarAlerta(s));
        }

        System.out.println("\n[Propulsao]");
        for (SistemaPropulsao motor : propulsores) {
            System.out.println("  " + motor.exibirDetalhes());
        }

        System.out.println("\n[Missao]");
        System.out.printf("  Combustivel: %.1f%%%n", dados.getNivelCombustivel());
        System.out.println("  Trajetoria: " + dados.getTrajetoria());
        System.out.println("  Tripulantes: " + dados.getNumeroTripulantes());
    }

    // ---------- METODOS AUXILIARES (leitura segura) ----------
    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um numero valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double lerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um numero valido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}