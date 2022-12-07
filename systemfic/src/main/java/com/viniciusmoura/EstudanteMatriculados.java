package com.viniciusmoura;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class EstudanteMatriculados {

    public LocalDate dataMatricula;
    public String matricula;
    public List<TurmaCurso> turmacurso;

    public EstudanteMatriculados(String dataMatricula, String matricula, List<TurmaCurso> turmacurso) throws Exception { 
        this.turmacurso=turmacurso;
        if(isValid(dataMatricula)&&isValid(matricula)){
            var dataToLocalDate = LocalDate.parse(dataMatricula);
            if (podeMatricular(dataToLocalDate)) {
                this.dataMatricula=dataToLocalDate;
                this.matricula=matricula;
                turmacurso.get(0).setVagasDisponiveis();
                turmacurso.get(0).matriculas.add(matricula);
            }else{
                throw new IllegalArgumentException("Error: Não pode ser matriculado");
            }            
        }else{
            throw new IllegalArgumentException("Error: Existe algum atributo que está NULO ou VAZIO.");
        }
       
    }
    


    
    public boolean isValid(String atribute){ 
        return !(Objects.isNull(atribute) || atribute.trim().isEmpty());
    }

    public boolean podeMatricular(LocalDate dataMatricula){
        if (verificaVagas()&&verificaPeriodoMatricula(dataMatricula))
            return true;
        return false;
    }

    public boolean verificaVagas(){
        return turmacurso.get(0).getVagasDisponiveis()>0 ? true : false;
    }

    public boolean verificaPeriodoMatricula(LocalDate dataMatricula){
        var dataInicio = turmacurso.get(0).getPeriodoMatriculas().get(0);
        var dataFim = turmacurso.get(0).getPeriodoMatriculas().get(1);
        return dataMatricula.isAfter(dataInicio)&&dataMatricula.isBefore(dataFim) ? true : false;
    }    
}
