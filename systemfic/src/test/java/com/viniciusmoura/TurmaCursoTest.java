package com.viniciusmoura;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


public class TurmaCursoTest {

    @Test
    @DisplayName("TurmaCursocomatributoinvalidolancaexcecao")
    public void shouldAnswerMsgError() throws Exception
    {
        assertThrowsExactly(java.lang.IllegalArgumentException.class, ()->{
            new TurmaCurso("Sala 308", 10, LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(), new Curso("Matematica", "40", "adasdasd"));
        });

    }

    @Test
    @DisplayName("TurmaCursoComAtributosValidosNaoLancaExcecao")
    public void shoulnotdAnswerMsgError(){
        assertDoesNotThrow(()->{
            new TurmaCurso("Sala 308", 10, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now().minusDays(2), LocalDate.now(), new Curso("Matematica", "40", "adasdasd"));
        });
    }

    @Test
    @DisplayName("AoestanciarTurmaCursocomvagasdiponiveistemqueserigualaqtdvagas")
    public void deveraRetornaTruevagaigualvagasDisponiveis() throws Exception
    {
        var turmacursox =  new TurmaCurso("Sala 308", 0, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now().minusDays(2), LocalDate.now(), new Curso("Matematica", "40", "adasdasd"));
        assertTrue(turmacursox.getVagasDisponiveis()==turmacursox.getVagas());
    }

    @Test
    @DisplayName("deveraVerificarSeOPeriodoDeMatriculaEInvalido")
    public void deveraVerificarPeriodoDeMatriculaEInvalido(){
        assertThrowsExactly(java.lang.IllegalArgumentException.class, ()->{
            new TurmaCurso("Sala 308", 10, LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(), new Curso("Matematica", "40", "adasdasd"));
        });
    } 

    @Test
    @DisplayName("DeveraVerificarSeoPeriodoDeMatriculaEValido")
    public void deveraVerificarPeriodoDeMatriculaEValido(){
        assertDoesNotThrow(()->{
            new TurmaCurso("Sala 308", 10, LocalDate.now().plusDays(5), LocalDate.now().plusDays(10), LocalDate.now().minusDays(2), LocalDate.now(), new Curso("Matematica", "40", "adasdasd"));
        });
    }

    





}
