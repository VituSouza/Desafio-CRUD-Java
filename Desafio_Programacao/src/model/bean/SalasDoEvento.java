package model.bean;

public class SalasDoEvento {

    /**
     * Criação dos atributos da classe SalasDoEvento
     *
     * @return
     */
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nomeSalasDoEvento;
    private int lotacaoSalasDoEvento;
    private int qtdPessoas;

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public String getNomeSalasDoEvento() {
        return nomeSalasDoEvento;
    }

    public void setNomeSalasDoEvento(String nomeSalasDoEvento) {
        this.nomeSalasDoEvento = nomeSalasDoEvento;
    }

    public int getLotacaoSalasDoEvento() {
        return lotacaoSalasDoEvento;
    }

    public void setLotacaoSalasDoEvento(int lotacaoSalasDoEvento) {
        this.lotacaoSalasDoEvento = lotacaoSalasDoEvento;
    }

}
