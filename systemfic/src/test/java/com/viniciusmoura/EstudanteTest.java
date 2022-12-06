package com.viniciusmoura;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class EstudanteTest{
    
    @Test
    @DisplayName("Estudantecomatributoinvalidolancaexcecao")
    public void shouldAnswerMsgError()
    {
        assertThrowsExactly(java.lang.IllegalArgumentException.class, ()->{
            new Estudante(null, "02/09/2022", "nullj", "nullj", "nuljl");
        });

    }

    @Test
    @DisplayName("Estudantecomatributosvalidosnaolancaexcecao")
    public void shoulnotdAnswerMsgError() {
        assertDoesNotThrow(()->{new Estudante("vinicius", "02/09/2001", "308 sul", "adada@gmail.com", "6399978754");});
    }



    @Test
    @DisplayName("Estudantecomidademenorque15lancaexcesao")
    public void shouldAnswermissingfielderrormessage() {
        assertThrows(java.lang.IllegalArgumentException.class, ()->{
            new Estudante("null", "02/09/2008", "nullj", "nullj", "nuljl");
        });
    }


    





}







