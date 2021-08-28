package controle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.RuntimeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class ControleAlunosTest {

    private ControleAlunos controle;

    @BeforeEach
    void testCriaControle(){
        this.controle = new ControleAlunos();
        controle.cadastraAluno(250, "Gabriel Reyes", "Computação");
        controle.cadastraAluno(200, "Lili Camposh", "Computação");
        controle.cadastraAluno(202, "Angela Ziegler", "Medicina");
        controle.cadastraAluno(201, "Torbjorn Lindholm", "Engenharia Mecânica");
    }

    @Test
    void testCadastraAluno() {
        assertEquals(controle.cadastraAluno(100, "Alef Adonis", "Computação"), "MATRÍCULA CADASTRADA");
    }

    @Test
    void testCadastraAlunoJaCadastrado() {
        assertEquals(controle.cadastraAluno(250, "Gabriel Reyes", "Computação"), "MATRÍCULA JÁ CADASTRADA!");
    }

    @Test
    void testCadastraAlunoNomeNulo() {
        try{
            controle.cadastraAluno(20, null, "Computação");
            fail("Deveria ter lançado um RuntimeError Aqui");
        } catch (RuntimeException re){}
    }

    @Test
    void testCadastraAlunoNomeVazio() {
        try{
            controle.cadastraAluno(20, "", "Computação");
            fail("Deveria ter lançado um RuntimeError Aqui");
        } catch (RuntimeException re){}
    }

    @Test
    void testExibeAluno() {
        assertEquals(controle.exibeAluno(250), "Aluno: 250 - Gabriel Reyes - Computação");
    }

    @Test
    void testExibeAlunoNaoCadastrado() {
        assertEquals(controle.exibeAluno(100), "Aluno não cadastrado");
    }

    @Test
    void testCadastraGrupoSemRestricaoDeTamanho() {
        assertEquals(controle.cadastraGrupo("Programaçao OO"), "CADASTRO REALIZADO!");
    }

    @Test
    void testCadastraGrupoComRestricaoDeTamanho() {
        assertEquals(controle.cadastraGrupo("Listas", 2), "CADASTRO REALIZADO!");
    }

    @Test
    void testCadastraGrupoComRestricaoDeTamanhoJaCadastrado() {
        controle.cadastraGrupo("Listas", 2);
        assertEquals(controle.cadastraGrupo("Listas"), "GRUPO JÁ CADASTRADO!");
    }

    @Test
    void testCadastraGrupoAmbosComRestricaoDeTamanhoJaCadastrado() {
        controle.cadastraGrupo("Listas", 2);
        assertEquals(controle.cadastraGrupo("Listas", 3), "GRUPO JÁ CADASTRADO!");
    }

    @Test
    void testAdicionaAlunoEmGrupo() {
        controle.cadastraGrupo("Programaçao OO");
        assertEquals(controle.adicionaAlunoEmGrupo(200, "Programaçao OO"), "ALUNO ALOCADO!");
    }

    @Test
    void testAdicionaDoisAlunoEmGrupo() {
        controle.cadastraGrupo("Programaçao OO");
        controle.adicionaAlunoEmGrupo(200, "Programaçao OO");
        assertEquals(controle.adicionaAlunoEmGrupo(202, "Programaçao OO"), "ALUNO ALOCADO!");
    }

    @Test
    void testAdicionaAlunoEmGrupoQueEleJaEstaAlocado(){
        controle.cadastraGrupo("Programaçao OO");
        controle.adicionaAlunoEmGrupo(200, "Programaçao OO");
        controle.adicionaAlunoEmGrupo(202, "Programaçao OO");
        assertEquals(controle.adicionaAlunoEmGrupo(202, "Programaçao OO"), "ALUNO ALOCADO!");
    }

    @Test
    void testAdicionaAlunoEmGrupoAlunoNaoExiste() {
        controle.cadastraGrupo("Programaçao OO");
        assertEquals(controle.adicionaAlunoEmGrupo(100, "Programaçao OO"), "Aluno não cadastrado.");
    }

    @Test
    void testAdicionaAlunoEmGrupoQueNaoExiste() {
        assertEquals(controle.adicionaAlunoEmGrupo(200, "Anatomia"), "Grupo não cadastrado");
    }

    @Test
    void testAdicionaAlunoEmGrupoComRestricaoDeTamanho() {
        controle.cadastraGrupo("listas", 1);
        controle.adicionaAlunoEmGrupo(200, "Listas");
        assertEquals(controle.adicionaAlunoEmGrupo(202, "Listas"), "GRUPO CHEIO");
    }

    @Test
    void testPertenceAoGrupo() {
        controle.cadastraGrupo("listas");
        controle.adicionaAlunoEmGrupo(250, "Listas");
        assertEquals(controle.pertenceAoGrupo("Listas", 250), "ALUNO PERTENCE AO GRUPO");
    }

    @Test
    void testPertenceAoGrupoAlunoNaoPertence() {
        controle.cadastraGrupo("listas");
        controle.adicionaAlunoEmGrupo(250, "Listas");
        assertEquals(controle.pertenceAoGrupo("Listas", 200), "ALUNO NÃO PERTENCE AO GRUPO");
    }

    @Test
    void testPertenceAoGrupoComGrupoNaoCadastrado() {
        assertEquals(controle.pertenceAoGrupo("Anatomia", 200), "GRUPO NÃO CADASTRADO.");
    }

    @Test
    void testPertenceAoGrupoComAlunoNaoCadastrado() {
        controle.cadastraGrupo("Programacao 00");
        assertEquals(controle.pertenceAoGrupo("Programacao 00", 100), "Aluno não cadastrado.");
    }

    @Test
    void registraAlunoRespondeu() {
        assertEquals(controle.registraAlunoRespondeu(250), "ALUNO REGISTRADO");
    }

    @Test
    void registraAlunoRespondeuAlunoNaoExiste() {
        assertEquals(controle.registraAlunoRespondeu(100), "Aluno não cadastrado.");
    }

    @Test
    void listaAlunosRespondoes() {
        controle.registraAlunoRespondeu(250);
        controle.registraAlunoRespondeu(202);
        assertEquals(controle.listaAlunosRespondoes(), "Alunos: \n1. 250 - Gabriel Reyes - Computação\n2. 202 - Angela Ziegler - Medicina");
    }

    @Test
    void imprimeGruposDeAlunoSemGrupo() {
        assertEquals(controle.imprimeGruposDeAluno(202), "Grupos: ");
    }

    @Test
    void imprimeGruposDeAluno() {
        controle.cadastraGrupo("Programacão OO");
        controle.cadastraGrupo("Listas");
        controle.adicionaAlunoEmGrupo(250, "Programacão OO");
        controle.adicionaAlunoEmGrupo(250, "listas");
        assertEquals(controle.imprimeGruposDeAluno(250), "Grupos: \n- Programacão OO\n- Listas");
    }
}