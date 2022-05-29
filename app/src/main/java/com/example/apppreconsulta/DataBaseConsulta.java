package com.example.apppreconsulta;

public class DataBaseConsulta {

    String CPF, nome, local, medico, data;



    public DataBaseConsulta(String CPF, String nome, String local, String medico, String data){
        this.CPF = CPF;
        this.nome = nome;
        this.local = local;
        this.medico = medico;
        this.data = data;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
