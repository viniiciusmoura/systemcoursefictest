package com.viniciusmoura;

import java.time.LocalDate;

import java.util.List;

public class EstudanteMatriculados {

    public LocalDate dataMatricula;
    public String matricula;
    public List<TurmaCurso> turmacurso;
    List<Estudante> estudantes;

    public EstudanteMatriculados(String dataMatricula, String matricula, List<TurmaCurso> turmacurso) {
        this.turmacurso=turmacurso;
        if (dataMatricula!=null&&matricula!=null) {
            if(podeMatricular(LocalDate.parse(dataMatricula))){
                this.dataMatricula = LocalDate.parse(dataMatricula);
                this.matricula=matricula;
                turmacurso.get(0).setVagasDisponiveis();
            }else{
                throw new IllegalArgumentException("Error: Não pode ser matriculado");
            }
        }else{
            throw new IllegalArgumentException("Error: Data nula");
        }
        
        
    }


    public boolean podeMatricular(LocalDate dataMatricula){
        if (turmacurso.get(0).getVagasDisponiveis()>0) {
            if(dataMatricula.isAfter(turmacurso.get(0).getPeriodoMatriculas().get(0))&&dataMatricula.isBefore(turmacurso.get(0).getPeriodoMatriculas().get(1))){
                return true;
            }else{
                return false;
            }  
        }else{
            return false;
        }
    }

    
    
}
