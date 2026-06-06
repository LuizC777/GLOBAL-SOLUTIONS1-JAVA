public class DadosMissao {

    // TODOS os atributos sao privados (encapsulamento)
    private String coordenadas;      // dado sensivel: protegido por senha
    private String codigoAcesso;     // a senha que libera os dados restritos
    private double nivelCombustivel; // 0 a 100 (%)
    private String trajetoria;
    private int numeroTripulantes;

    public DadosMissao(String codigoAcesso, String coordenadas) {
        this.codigoAcesso = codigoAcesso;
        this.coordenadas = coordenadas;
        this.nivelCombustivel = 100;
        this.trajetoria = "Nao definida";
        this.numeroTripulantes = 0;
    }

    // ----- COORDENADAS: so libera com a senha correta -----
    public String getCoordenadas(String senha) {
        if (codigoAcesso.equals(senha)) {
            return coordenadas;
        }
        return "ACESSO NEGADO: senha incorreta.";
    }

    public boolean setCoordenadas(String senha, String novasCoordenadas) {
        if (!codigoAcesso.equals(senha)) {
            System.out.println("ACESSO NEGADO: senha incorreta.");
            return false;
        }
        this.coordenadas = novasCoordenadas;
        return true;
    }

    // ----- NIVEL DE COMBUSTIVEL: com validacao + alerta automatico -----
    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivel) {
        if (nivel < 0 || nivel > 100) {
            System.out.println("Valor invalido! O combustivel deve ficar entre 0 e 100.");
            return;
        }
        this.nivelCombustivel = nivel;
        if (nivel < 20) { // alerta automatico
            System.out.printf("ALERTA: combustivel baixo (%.1f%%)!%n", nivel);
        }
    }

    // ----- TRAJETORIA -----
    public String getTrajetoria() {
        return trajetoria;
    }

    public void setTrajetoria(String trajetoria) {
        if (trajetoria == null || trajetoria.isBlank()) {
            System.out.println("Trajetoria invalida!");
            return;
        }
        this.trajetoria = trajetoria;
    }

    // ----- NUMERO DE TRIPULANTES -----
    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    public void setNumeroTripulantes(int numero) {
        if (numero < 0) {
            System.out.println("Numero invalido (nao pode ser negativo).");
            return;
        }
        this.numeroTripulantes = numero;
    }

    // ----- alterar a senha (so quem souber a atual consegue) -----
    public boolean alterarCodigoAcesso(String senhaAtual, String novaSenha) {
        if (!codigoAcesso.equals(senhaAtual)) {
            System.out.println("ACESSO NEGADO: senha atual incorreta.");
            return false;
        }
        this.codigoAcesso = novaSenha;
        return true;
    }
}