public class Objetivo {
    private String nome;
    private double custoObjetivo;
    private double disponibilidadeMensal;
    private double disponibilidadeDiaria;
    private double tempoMes;
    private double tempoDias;
    private double saldo = 0;

    // Usuário completa os três campos e cria um objetivo, as informações são salvas no banco
    public Objetivo(String nome, double custoObjetivo, double disponibilidadeMensal) {
        this.nome = nome;
        this.custoObjetivo = custoObjetivo;
        this.disponibilidadeMensal = disponibilidadeMensal;
        this.disponibilidadeDiaria = this.disponibilidadeMensal/30;
        this.tempoMes = this.custoObjetivo / this.disponibilidadeMensal;
        this.tempoDias = this.custoObjetivo / this.disponibilidadeDiaria;
    }

    // Construtor vazio para testes
    public Objetivo() {

    }

    // Usuário pode alterar um dos parametros depois do objeto ser criado (Nome, custo ou disponibilidade) - deve informar todos novamente.
    public void alteraParametros(String nome, double custoObjetivo, double disponibilidadeMensal){
        this.nome = nome;
        this.custoObjetivo = custoObjetivo;
        this.disponibilidadeMensal = disponibilidadeMensal;
        this.disponibilidadeDiaria = this.disponibilidadeMensal/30;
        this.tempoMes = (this.custoObjetivo-this.saldo) / this.disponibilidadeMensal;
        this.tempoDias = (this.custoObjetivo-this.saldo)/this.disponibilidadeDiaria;
    }

    // Printa informações na tela
    @Override
    public String toString() {
        return "Objetivo{" +
                "nome='" + nome + '\'' +
                ", custoObjetivo=" + custoObjetivo +
                ", disponibilidadeMensal=" + disponibilidadeMensal +
                ", disponibilidadeDiaria=" + disponibilidadeDiaria +
                ", tempoMes=" + tempoMes +
                ", tempoDias=" + tempoDias +
                ", saldo=" + saldo +
                '}'
                ;
    }


    // Atualiza os campos sempre que o saldo muda
    private void atualizaCampos(){
        this.tempoMes = (this.custoObjetivo-this.saldo) / this.disponibilidadeMensal;
        this.tempoDias = (this.custoObjetivo-this.saldo)/this.disponibilidadeDiaria;
    }

    // Adiciona extamente a disponibilidade mensal do usuário no saldo (botão)
    public  void adicionarDisponibilidadeMensal(){
        if(this.saldo+this.disponibilidadeMensal<this.custoObjetivo){
            this.saldo+=this.disponibilidadeMensal;
        }else{
            this.saldo = this.custoObjetivo;
        }
        atualizaCampos();
    }

    // Retira quantia
    public void retirarCapital(double valor){
        if(this.saldo>=valor){
            this.saldo-=valor;
        }else{
            this.saldo = 0;
        }
        atualizaCampos();
    }

    // Adiciono uma Quantia
    public void adicionarCapital(double valor){
        if(this.saldo+valor < this.custoObjetivo){
            this.saldo+=valor;
        }else {
            this.saldo = this.custoObjetivo;
        }
        atualizaCampos();
    }

    // Verifica se o usuário conquistou ou não e exibe uma mensagem
    public void conquistado(){
        if(this.saldo == this.custoObjetivo){
            System.out.println("O objetivo foi concluído!");
        } else{
            System.out.println("O objetivo não foi concluído!");
        }
    }

// ===================================================================== Dados são jogados na tela (get...)
    public String getNome() { // Mostra o nome do objetivo  na tela                       ]
        return nome;
    }

    public void setNome(String nome) { // Muda o nome caso o usuário deseje
        this.nome = nome;
    }

    public double getCustoObjetivo() { // Mostra o valor do objetivo na tela
        return custoObjetivo;
    }

    public void setCustoObjetivo(double custoObjetivo) { // Altera o valor caso o usuário deseje
        this.custoObjetivo = custoObjetivo;
    }

    public double getDisponibilidadeMensal() { // Mostra a disponibilidade por mês na tela
        return disponibilidadeMensal;
    }

    public void setDisponibilidadeMensal(double disponibilidadeMensal) { // Altera a disponibilidade mensal caso deseje
        this.disponibilidadeMensal = disponibilidadeMensal;
    }

    public double getDisponibilidadeDiaria() { // Mostra na tela a disponibilidade diaria
        return disponibilidadeDiaria;
    }

    public double getTempoMes() { // Mostra na tela o tempo em mês
        return tempoMes;
    }

    public double getTempoDias() { // Mostra na tela o tempo em dias
        return tempoDias;
    }

    public double getSaldo() { // Mostra na tela o saldo em reais
        return saldo;
    }
}
