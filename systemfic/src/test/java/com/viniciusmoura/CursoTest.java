package com.viniciusmoura;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CursoTest {
    
    @Test
    @DisplayName("Cursocomatributoinvalidolancaexcesao")
    public void shouldAnswerMsgError() throws Exception
    {
        assertThrowsExactly(java.lang.IllegalArgumentException.class, ()->{
            new Curso("", "null", "null");
        });
    }

    
    
}
