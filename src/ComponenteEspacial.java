public abstract class ComponenteEspacial {

    // atributos comuns a TODOS os componentes
    protected int id;
    protected String nome;
    protected boolean status;     // true = ligado, false = desligado
    protected double temperatura; // em graus Celsius

    public ComponenteEspacial(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.status = false;      // comeca desligado
        this.temperatura = 20.0;  // temperatura ambiente
    }

    // METODOS CONCRETOS (ja vem prontos para as subclasses usarem)
    public void ligar() {
        status = true;
        System.out.println(nome + " ligado.");
    }

    public void desligar() {
        status = false;
        System.out.println(nome + " desligado.");
    }

    // METODO ABSTRATO: toda subclasse e OBRIGADA a implementar
    public abstract String exibirDetalhes();

    // getters e setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public boolean isStatus() { return status; }
    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }
}