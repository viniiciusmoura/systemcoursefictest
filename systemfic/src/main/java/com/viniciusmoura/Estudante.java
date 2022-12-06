package com.viniciusmoura;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class Estudante {
    public String nome;
    public String matricula;
    public LocalDate dataNascimento;
    public String endereco;
    public String emailInstitucional;
    public List<Celular> nCelulars= new ArrayList<>();
    
    public Estudante(String nome, String dataNascimento, String endereco, String emailInstitucional, String tCelular) throws Exception {
        if (isValid(nome) && isValid(endereco) && isValid(emailInstitucional) && isValid(tCelular) && isValid(dataNascimento)) { 
            this.nome = nome;
            isValiDate(dataNascimento);
            this.endereco = endereco;
            this.emailInstitucional = emailInstitucional;
            this.nCelulars.add(new Celular(tCelular));
            this.matricula="2021APO";
        }else{
            throw new IllegalArgumentException("Error: Existe algum atributo que está NULO ou VAZIO.");
        }
    } 

    public boolean isValid(String atribute)
    { 
        return !(Objects.isNull(atribute) || atribute.trim().isEmpty());
    }

    public void isValiDate(String data) throws Exception {    
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate dataNas = LocalDate.parse(data, formatter);
            if (ChronoUnit.YEARS.between(dataNas, LocalDate.now())>=15) {
                this.dataNascimento=dataNas;
            }else{
                throw new IllegalArgumentException("Erro: O aluno tem menos que 15 anos completos");
            }        
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Erro: Data inválida", data, 0);
        }
    }


    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }



    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }



    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }



    public void setnCelulars(List<Celular> nCelulars) {
        this.nCelulars = nCelulars;
    }



    public String getNome() {
        return nome;
    }



    public String getMatricula() {
        return matricula;
    }



    public LocalDate getDataNascimento() {
        return dataNascimento;
    }



    public String getEndereco() {
        return endereco;
    }



    public String getEmailInstitucional() {
        return emailInstitucional;
    }



    public List<Celular> getnCelulars() {
        return nCelulars;
    }




    
    // public static void main(String[] args) throws Exception {
    //     Estudante est = new Estudante("null", "06/12/2007", "nullj", "nullj", "nuljl");
    // }

    
    





        
}
