package controle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void testCriaAluno(){
        this.aluno = new Aluno(250, "Gabriel Reyes", "Computação");
    }

    @Test
    void testCriaAlunoMatriculaInvalidaNomeNulo(){
        try{
            this.aluno = new Aluno(250, null, "Computação");
            fail("Deveria ter lançado um Illegal Argument Exception");
        } catch (IllegalArgumentException iae){}
    }

    @Test
    void testCriaAlunoMatriculaInvalidaNomeVazio(){
        try{
            this.aluno = new Aluno(250, "", "Computação");
            fail("Deveria ter lançado um Illegal Argument Exception");
        } catch (IllegalArgumentException iae){}
    }

    @Test
    void testCriaAlunoMatriculaInvalidaNomeVazioComEspaco(){
        try{
            this.aluno = new Aluno(250, "  ", "Computação");
            fail("Deveria ter lançado um Illegal Argument Exception");
        } catch (IllegalArgumentException iae){}
    }

    @Test
    void testCriaAlunoMatriculaInvalidaCursoNulo(){
        try{
            this.aluno = new Aluno(250, "Computação", null);
            fail("Deveria ter lançado um Illegal Argument Exception");
        } catch (IllegalArgumentException iae){}
    }

    @Test
    void testHashCode() {
        Aluno outroAluno = new Aluno(250, "Gabriel Reyes", "Computação");
        assertEquals(aluno.hashCode(), outroAluno.hashCode());
    }

    @Test
    void testEquals() {
        Aluno outroAluno = new Aluno(250, "Gabriel Reyes", "Computação");
        assertEquals(aluno, outroAluno);
    }

    @Test
    void testEqualsNomeECursoDiff() {
        Aluno outroAluno = new Aluno(250, "Luís Vaz de Camões", "Literatura");
        assertEquals(aluno, outroAluno);
    }

    @Test
    void testNotEquals() {
        Aluno outroAluno = new Aluno(200, "Lucas Godoy", "Direito");
        assertNotEquals(aluno, outroAluno);
    }

    @Test
    void testToString() {
        assertEquals(aluno.toString(), "250 - Gabriel Reyes - Computação");
    }
}