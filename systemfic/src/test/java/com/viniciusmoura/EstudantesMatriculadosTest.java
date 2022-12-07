package com.viniciusmoura;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class EstudantesMatriculadosTest {

    @Test
    @DisplayName("matricularalunocomvagasigualaZEROdeveralancarexcecao")
    public void naodeveramatricularaluno() throws Exception{
        List<Estudante> estudantes = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        List<TurmaCurso> turmaCurso = new ArrayList<>();

        cursos.add(new Curso("Matematica", "40hs", "Curso de exatas"));
        turmaCurso.add(new TurmaCurso("Sala 105", 0, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(2), cursos.get(0)));
        estudantes.add(new Estudante("Flavio", "25/05/2006", "308 sul", "gat@gmail.com", "69666485"));
        
        assertThrowsExactly(java.lang.IllegalArgumentException.class, ()->{
            new EstudanteMatriculados("2016-08-15", estudantes.get(0).getMatricula(), turmaCurso);  
        });
        
    }

    @Test
    @DisplayName("estudatematriculadodeveradiminuironumerodevagasDisponivies")
    public void deveraDiminuirVagasDisponiveis() throws Exception{
        List<Estudante> estudantes = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        List<TurmaCurso> turmaCurso = new ArrayList<>();

        cursos.add(new Curso("Matematica", "40hs", "Curso de exatas"));
        turmaCurso.add(new TurmaCurso("Sala 105", 10, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(2), cursos.get(0)));
        estudantes.add(new Estudante("Flavio", "25/05/2006", "308 sul", "gat@gmail.com", "69666485"));
        //Pega a quantidade de vagas
        int vagasD = turmaCurso.get(0).getVagasDisponiveis();
        //Estancia estudante
        new EstudanteMatriculados("2022-12-07", estudantes.get(0).getMatricula(), turmaCurso);
        //Verificando se foi decrementado
        assertTrue(turmaCurso.get(0).getVagasDisponiveis()<vagasD);

    }

    @Test
    @DisplayName("MatricularEstudanteComDataForaDoPeriodoLancaExcecao")
    public void deveraValidarDataForaDoPeriodo() throws Exception{
        List<Estudante> estudantes = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        List<TurmaCurso> turmaCurso = new ArrayList<>();

        cursos.add(new Curso("Matematica", "40hs", "Curso de exatas"));
        turmaCurso.add(new TurmaCurso("Sala 105", 10, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(2), cursos.get(0)));
        estudantes.add(new Estudante("Flavio", "25/05/2006", "308 sul", "gat@gmail.com", "69666485"));
        
        assertThrowsExactly(java.lang.IllegalArgumentException.class,()->{
            new EstudanteMatriculados("2022-12-25", estudantes.get(0).getMatricula(), turmaCurso);
        });
        
    }

    @Test
    @DisplayName("MatricularEstudanteComDataDentroDoPeriodo")
    public void deveraValidarEstudanteComDataDentroDoPeriodo() throws Exception{
        List<Estudante> estudantes = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        List<TurmaCurso> turmaCurso = new ArrayList<>();

        cursos.add(new Curso("Matematica", "40hs", "Curso de exatas"));
        turmaCurso.add(new TurmaCurso("Sala 105", 10, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(2), cursos.get(0)));
        estudantes.add(new Estudante("Flavio", "25/05/2006", "308 sul", "gat@gmail.com", "69666485"));
        
        assertDoesNotThrow(()->{
            new EstudanteMatriculados("2022-12-07", estudantes.get(0).getMatricula(), turmaCurso);
        });
    }

    @Test
    @DisplayName("MatricularEstudanteComNumeroDeVagasIgualAZeroLancaExcecao")
    public void deveraValidarEstudanteComNumeroDeVagasIgualZero() throws Exception{
        List<Estudante> estudantes = new ArrayList<>();
        List<Curso> cursos = new ArrayList<>();
        List<TurmaCurso> turmaCurso = new ArrayList<>();

        cursos.add(new Curso("Matematica", "40hs", "Curso de exatas"));
        turmaCurso.add(new TurmaCurso("Sala 105", 0, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now(), LocalDate.now().plusDays(2), cursos.get(0)));
        estudantes.add(new Estudante("Flavio", "25/05/2006", "308 sul", "gat@gmail.com", "69666485"));
        
        assertThrowsExactly(java.lang.IllegalArgumentException.class,()->{
            new EstudanteMatriculados("2022-12-07", estudantes.get(0).getMatricula(), turmaCurso);
        });
    }



}
