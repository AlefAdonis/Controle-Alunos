package controle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {

    private Grupo grupoTeste;

    @BeforeEach
    void testCriaGrupoComRestricao(){
        this.grupoTeste = new Grupo("LAB4", 1);
    }

    @Test
    void testCriaGrupoNomeNuloComRestricao(){
        try {
            Grupo grupoTeste2 = new Grupo(null, 10);
            fail("Deveria ter um IllegalArgumentException aqui");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void testCriaGrupoNomeVazioComRestricao(){
        try {
            Grupo grupoTeste2 = new Grupo("", 10);
            fail("Deveria ter um IllegalArgumentException aqui");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void testCriaGrupoTamanhoGrupoVazioComRestricao(){
        try {
            Grupo grupoTeste2 = new Grupo("LAB4", 0);
            fail("Deveria ter um IllegalArgumentException aqui");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void testCriaGrupoSemRestricao() {
        Grupo grupoTeste3 = new Grupo("LAB4");
    }

    @Test
    void testCriaGrupoNomeNuloSemRestricao(){
        try {
            Grupo grupoTeste3 = new Grupo(null);
            fail("Deveria ter um IllegalArgumentException aqui");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void testCriaGrupoNomeVazioSemRestricao(){
        try {
            Grupo grupoTeste3 = new Grupo("");
            fail("Deveria ter um IllegalArgumentException aqui");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    void testAdicionaAlunoEmGrupo() {
        assertEquals(this.grupoTeste.adicionaAlunoEmGrupo(100), "ALUNO ALOCADO!");
    }

    @Test
    void testAdicionaAlunoEmGrupoCheio() {
        this.grupoTeste.adicionaAlunoEmGrupo(100);
        assertEquals(this.grupoTeste.adicionaAlunoEmGrupo(3), "GRUPO CHEIO");
    }

    @Test
    void testEhDoGrupo() {
        this.grupoTeste.adicionaAlunoEmGrupo(100);
        assertTrue(this.grupoTeste.ehDoGrupo(100));
    }

    @Test
    void testEhDoGrupoInvalido() {
        assertFalse(this.grupoTeste.ehDoGrupo(100));
    }

    @Test
    void testHashCode() {
        Grupo grupoIgual = new Grupo("LAB4", 1);
        assertEquals(grupoTeste.hashCode(), grupoIgual.hashCode());
    }

    @Test
    void testEquals() {
        Grupo grupoIgual = new Grupo("LAB4", 1);
        assertEquals(grupoTeste, grupoIgual);
    }

    @Test
    void testNotEquals() {
        Grupo grupoIgual = new Grupo("Programação OO", 1);
        assertNotEquals(grupoTeste, grupoIgual);
    }

    @Test
    void testEqualsNomeMinusculo() {
        Grupo grupoIgual = new Grupo("lab4", 10);
        assertEquals(grupoTeste, grupoIgual);
    }

    @Test
    void testGetNomeGrupo(){

    }

    @Test
    void testToString(){
        assertEquals(grupoTeste.toString(), "Grupo{nome='LAB4'}");
    }
}