package model.bean;

public class EspacosDeCafe {

    /**
     * Criação dos atributos da classe EspacosDeCafe
     *
     * @return
     */
    private String nomeEspacosDeCafe;
    private int lotacaoEspacosDeCafe;
    private boolean intervaloEspacosDeCafe;

    public String getNomeEspacosDeCafe() {
        return nomeEspacosDeCafe;
    }

    public void setNomeEspacosDeCafe(String nomeEspacosDeCafe) {
        this.nomeEspacosDeCafe = nomeEspacosDeCafe;
    }

    public int getLotacaoEspacosDeCafe() {
        return lotacaoEspacosDeCafe;
    }

    public void setLotacaoEspacosDeCafe(int lotacaoEspacosDeCafe) {
        this.lotacaoEspacosDeCafe = lotacaoEspacosDeCafe;
    }

    public boolean isIntervaloEspacosDeCafe() {
        return intervaloEspacosDeCafe;
    }

    public void setIntervaloEspacosDeCafe(boolean intervaloEspacosDeCafe) {
        this.intervaloEspacosDeCafe = intervaloEspacosDeCafe;
    }

}
