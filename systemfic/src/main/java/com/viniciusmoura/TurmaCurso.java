package com.viniciusmoura;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TurmaCurso {
    public String local;
    public int vagas;
    public int vagasDisponiveis;
    public LocalDate inicioAulas;
    public LocalDate fimAulas;
    public LocalDate inicioMatriculas;
    public LocalDate fimMatriculas;
    public Curso curso;

    public List<LocalDate> getPeriodoMatriculas(){
        List<LocalDate> datasPeriodo = new ArrayList<>();
        datasPeriodo.add(inicioMatriculas);
        datasPeriodo.add(fimMatriculas);
        return datasPeriodo;
    }

    public TurmaCurso(String local, int vagas, LocalDate inicioAulas, LocalDate fimAulas, LocalDate inicioMatriculas,
        LocalDate fimMatriculas, Curso curso) {
        if (isValid(local)&&isValidDate(fimMatriculas)&&isValidDate(inicioAulas)&&isValidDate(fimAulas)&&isValidDate(inicioMatriculas)&&isValidNumber(vagas)&&curso!=null) {
            this.local = local;
            this.vagas=vagas;
            this.vagasDisponiveis=vagas;
            this.inicioAulas = inicioAulas;
            this.fimAulas = fimAulas;
            this.curso=curso;
            if (inicioMatriculas.isBefore(inicioAulas)&&fimMatriculas.isBefore(inicioAulas)&&fimMatriculas.isAfter(inicioMatriculas)) {
                this.inicioMatriculas = inicioMatriculas;
                this.fimMatriculas = fimMatriculas;
            }else{
                throw new IllegalArgumentException("Error: Datas de matriculas superior ao inicio do curso");
            }
            
        }else{
            throw new IllegalArgumentException("Error: Existe algum atributo que está NULO ou VAZIO.");
        }
        
    }

    //Get vagas
    public int getVagasDisponiveis(){
        return vagasDisponiveis;
    }

    //Set vagas
    public void setVagasDisponiveis(){
        vagasDisponiveis-=1;
    }

    //Valida String
    public boolean isValid(String atribute)
    { 
        return !(Objects.isNull(atribute) || atribute.trim().isEmpty());
    } 

    //Valida Data
    public boolean isValidDate(LocalDate data){    
        return data!=null ? true : false;
    }

    //Valida o numero
    public boolean isValidNumber(int numero){
        return numero>=0 ? true : false;
    }

    public int getVagas() {
        return this.vagas;
    } 

    
    

    
}
