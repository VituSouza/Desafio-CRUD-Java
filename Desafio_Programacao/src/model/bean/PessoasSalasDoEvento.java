package model.bean;

public class PessoasSalasDoEvento {

    /**
     * Criação dos atributos da classe PessoasSalasDoEvento
     *
     * @return
     */
    private int pessoasIdPessoas;
    private int salasDoEventoIdSalasDoEvento;
    private boolean etapas;

    public int getPessoasIdPessoas() {
        return pessoasIdPessoas;
    }

    public void setPessoasIdPessoas(int pessoasIdPessoas) {
        this.pessoasIdPessoas = pessoasIdPessoas;
    }

    public int getSalasDoEventoIdSalasDoEvento() {
        return salasDoEventoIdSalasDoEvento;
    }

    public void setSalasDoEventoIdSalasDoEvento(int salasDoEventoIdSalasDoEvento) {
        this.salasDoEventoIdSalasDoEvento = salasDoEventoIdSalasDoEvento;
    }

    public boolean isEtapas() {
        return etapas;
    }

    public void setEtapas(boolean etapas) {
        this.etapas = etapas;
    }

}
