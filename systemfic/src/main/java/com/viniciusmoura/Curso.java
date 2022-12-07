package com.viniciusmoura;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso {
    public String nome;
    public String cargaHoraria;
    public String descricao;

    private List<TurmaCurso> turmaCursos = new ArrayList<>();

    public Curso(String nome, String cargaHoraria, String descricao) {
        if (isValid(nome)&&isValid(cargaHoraria)&&isValid(descricao)) {
            this.nome = nome;
            this.cargaHoraria = cargaHoraria;
            this.descricao = descricao;
        }else{
            throw new IllegalArgumentException("Error: Existe algum atributo que está NULO ou VAZIO.");
        }
        
    }

    public List<TurmaCurso> getTurmas(){
        List<TurmaCurso> turmas = new ArrayList<>();
        for(TurmaCurso turma: this.turmaCursos){
            if(turma.matriculas.size()!=0){
                turmas.add(turma);
            } 
        }

        if(turmas.size()!=0){
            return turmas;
        }else{
            throw new IllegalArgumentException("Turma vazia");
        }
        
    }


    public void addTurma(TurmaCurso turmaCurso){
        this.turmaCursos.add(turmaCurso);
    }

    public boolean isValid(String atribute)
    { 
        return !(Objects.isNull(atribute) || atribute.trim().isEmpty());
    } 
    
}
