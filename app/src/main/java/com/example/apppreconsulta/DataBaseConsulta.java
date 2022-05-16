package com.example.apppreconsulta;

public class DataBaseConsulta {

    String febre, dorcabeca, diarreia, ar, tontura, edtfebre;



    public DataBaseConsulta(String febre, String dorcabeca, String diarreia, String ar, String tontura, String edtfebre){
        this.febre = febre;
        this.dorcabeca = dorcabeca;
        this.diarreia = diarreia;
        this.ar = ar;
        this.tontura = tontura;
        this.edtfebre = edtfebre;
    }

    public String getFebre() {
        return febre;
    }

    public void setFebre(String febre) {
        this.febre = febre;
    }

    public String getDorcabeca() {
        return dorcabeca;
    }

    public void setDorcabeca(String dorcabeca) {
        this.dorcabeca = dorcabeca;
    }

    public String getDiarreia() {
        return diarreia;
    }

    public void setDiarreia(String diarreia) {
        this.diarreia = diarreia;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getTontura() {
        return tontura;
    }

    public void setTontura(String tontura) {
        this.tontura = tontura;
    }

    public String getEdtfebre() {
        return edtfebre;
    }

    public void setEdtfebre(String edtfebre) {
        this.edtfebre = edtfebre;
    }

}
