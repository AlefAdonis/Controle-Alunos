package controle;

import java.util.Scanner;

/**
 *
 *
 * @author alefadonis
 *
 */

public class MainControle {

    public static void main(String[] args){
        ControleAlunos controle = new ControleAlunos();

        System.out.println("CONTROLE DE ALUNOS");

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            try {
                escolha = menu(scanner);
                comando(escolha, scanner, controle);
            } catch (Exception e){
                System.err.println("Erro durante a execução do Controle");
            }
        }
    }

    private static String menu(Scanner scanner) throws NullPointerException{
        System.out.println("\n(C)adastrar Aluno\n" +
                "(E)xibir Aluno\n" +
                "(N)ovo Grupo\n" +
                "(A)locar Aluno no Grupo ou Verificar (P)ertinência a Grupos\n" +
                "(R)egistrar Aluno que Respondeu\n" +
                "(I)mprimir Alunos que Responderam\n" +
                "(O)lhaí quais Grupos o Aluno Tá.\n" +
                "(S)im, quero Fechar o Programa!\n" +
                "\n" +
                "Opção> ");

        return scanner.nextLine().toUpperCase();
    }

    private static void comando(String escolha, Scanner scanner, ControleAlunos controle){
        switch(escolha) {

            case "C":
                cadastraAluno(scanner, controle);
                break;

            case "E":
                exibirAluno(scanner, controle);
                break;

            case "N":
                adicionarGrupo(scanner, controle);
                break;

            case "A":
                adicionarAlunoGrupo(scanner, controle);
                break;

            case "P":
                pertencimentoAoGrupo(scanner, controle);
                break;

            case "R":
                registrarAlunoResposta(scanner, controle);
                break;

            case "I":
                exibirListaAlunoResposta(scanner, controle);
                break;

            case "O":
                imprimirGruposAluno(scanner, controle);
                break;

            case "S":
                saidaControle();

            default:
                System.out.println("OPCAO INVÁLIDA");
        }


    }

    private static void cadastraAluno(Scanner scanner, ControleAlunos controle) {
        System.out.println("\nMatrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nNome: ");
        String nome = scanner.nextLine();

        System.out.println("\nCurso: ");
        String curso = scanner.nextLine();

        System.out.println(controle.cadastraAluno(matricula, nome, curso));
    }

    private static void exibirAluno(Scanner scanner, ControleAlunos controle) {
        System.out.println("\nMatrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println(controle.exibeAluno(matricula));
    }

    private static void adicionarGrupo(Scanner scanner, ControleAlunos controle) {
        System.out.println("\nGrupo: ");
        String nomeGrupo = scanner.nextLine().toLowerCase();

        System.out.println("\nTamanho: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        System.out.println(controle.cadastraGrupo(nomeGrupo, tamanho));

    }

    private static void adicionarAlunoGrupo(Scanner scanner, ControleAlunos controle) {
        System.out.println("\nMatricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nGrupo: ");
        String nomeGrupo = scanner.nextLine().toLowerCase();

        System.out.println(controle.adicionaAlunoEmGrupo(matricula, nomeGrupo));

    }

    private static void pertencimentoAoGrupo(Scanner scanner, ControleAlunos controle) {
        System.out.println("\nGrupo: ");
        String nomeGrupo = scanner.nextLine();

        System.out.println("\nAluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println(controle.pertenceAoGrupo(nomeGrupo, matricula));

    }

    private static void registrarAlunoResposta(Scanner scanner, ControleAlunos controle) {
        System.out.println("\nMatricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println(controle.registraAlunoRespondeu(matricula));

    }

    private static void exibirListaAlunoResposta(Scanner scanner, ControleAlunos controle) {
        System.out.println(controle.listaAlunosRespondoes());

    }

    private static void imprimirGruposAluno(Scanner scanner, ControleAlunos controle) {
        System.out.println("Aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.println(controle.imprimeGruposDeAluno(matricula));

    }

    private static void saidaControle() {
        System.out.println("\nObrigado por utilizar o Controle de Alunos!\n");
        System.exit(0);
    }

}

