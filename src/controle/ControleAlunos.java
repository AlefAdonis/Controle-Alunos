package controle;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;

public class ControleAlunos {

    private HashMap<Integer, Aluno> alunos;
    private HashMap<String, Grupo> grupos;
    private ArrayList<Aluno> alunosQueResponderam;

    public ControleAlunos() {
        this.alunos = new HashMap<Integer, Aluno>();
        this.grupos = new HashMap<String, Grupo>();
        this.alunosQueResponderam = new ArrayList<Aluno>();
    }

    public String cadastraAluno(int matricula, String nome, String curso) throws RuntimeException{
        Aluno aluno = new Aluno(matricula, nome, curso);

        if(!(this.alunos.isEmpty())){
            for(Aluno alunoInMap : this.alunos.values()) {
                if(aluno.equals(alunoInMap)){
                    return "MATRÍCULA JÁ CADASTRADA!";
                }
            }
        }
        alunos.put(matricula, aluno);
        return "MATRÍCULA CADASTRADA";

    }

    public String exibeAluno(int matricula) {
        if(this.alunos.containsKey(matricula)) {
            Aluno alumn = this.alunos.get(matricula);
            return "Aluno: " + alumn.toString();
        }

        return "Aluno não cadastrado";
    }

    public String cadastraGrupo(String nomeGrupo) throws RuntimeException {
       Grupo novoGrupo = new Grupo(nomeGrupo);
        nomeGrupo = nomeGrupo.toLowerCase();

        if(!(this.grupos.containsKey(nomeGrupo))) {
            this.grupos.put(nomeGrupo, novoGrupo);
            return "CADASTRO REALIZADO!";
        }

        return "GRUPO JÁ CADASTRADO!";
    }

    public String cadastraGrupo(String nomeGrupo, int tamanho) throws RuntimeException {
        Grupo novoGrupo = new Grupo(nomeGrupo, tamanho);
        nomeGrupo = nomeGrupo.toLowerCase();

        if(!(this.grupos.containsKey(nomeGrupo))) {
            this.grupos.put(nomeGrupo, novoGrupo);
            return "CADASTRO REALIZADO!";
        }

        return "GRUPO JÁ CADASTRADO!";
    }

    public String adicionaAlunoEmGrupo(int matricula, String nomeGrupo) {
        nomeGrupo = nomeGrupo.toLowerCase();
        if(this.alunos.containsKey(matricula)){
            if(this.grupos.containsKey(nomeGrupo)) {
                Grupo grupoAlunos = grupos.get(nomeGrupo);
                return grupoAlunos.adicionaAlunoEmGrupo(matricula);
            }
            return "Grupo não cadastrado";
        }
        return "Aluno não cadastrado.";
    }

    public String pertenceAoGrupo(String nomeGrupo, int matricula) {
        nomeGrupo = nomeGrupo.toLowerCase();
        if(this.alunos.containsKey(matricula)){
            if(this.grupos.containsKey(nomeGrupo)) {
                Grupo grupo = this.grupos.get(nomeGrupo);
                if(grupo.ehDoGrupo(matricula)) {
                    return "ALUNO PERTENCE AO GRUPO";
                }
                return "ALUNO NÃO PERTENCE AO GRUPO";
            }
            return "GRUPO NÃO CADASTRADO.";
        }

        return "Aluno não cadastrado.";
    }

    public String registraAlunoRespondeu(int matricula) {
        if(this.alunos.containsKey(matricula)) {
            Aluno alumn = this.alunos.get(matricula);
            this.alunosQueResponderam.add(alumn);
            return("ALUNO REGISTRADO");

        }
        return "Aluno não cadastrado.";
    }

    public String listaAlunosRespondoes() {
        String lista = "Alunos: \n";
        for(int i = 0; i < this.alunosQueResponderam.size(); i++) {
            if(i == (this.alunosQueResponderam.size() - 1)) {
                lista += (i+1) + ". " + this.alunosQueResponderam.get(i).toString();
                break;
            }
            lista += (i+1) + ". " + this.alunosQueResponderam.get(i).toString() + "\n";
        }
        return lista;
    }

    public String imprimeGruposDeAluno(int matricula) {

        String listaGrupos = "Grupos: ";
        for(Entry<String, Grupo> entry : this.grupos.entrySet()) {
            Grupo grupo = entry.getValue();

            if(grupo.ehDoGrupo(matricula)) {
                listaGrupos += "\n- " + grupo.getNome();
            }

        }

        return listaGrupos;
    }
}