package com.viniciusmoura;

import java.util.Objects;

public class Curso {
    public String nome;
    public String cargaHoraria;
    public String descricao;
    public Curso(String nome, String cargaHoraria, String descricao) {
        if (isValid(nome)&&isValid(cargaHoraria)&&isValid(descricao)) {
            this.nome = nome;
            this.cargaHoraria = cargaHoraria;
            this.descricao = descricao;
        }else{
            throw new IllegalArgumentException("Error: Existe algum atributo que está NULO ou VAZIO.");
        }
        
    }


    public boolean isValid(String atribute)
    { 
        return !(Objects.isNull(atribute) || atribute.trim().isEmpty());
    } 
    
}
