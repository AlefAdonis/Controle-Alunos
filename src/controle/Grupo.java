package controle;

import java.util.HashSet;

public class Grupo {

    private String nome;
    private HashSet<Integer> alunos;
    private int capacidadeMax;

    public Grupo(String nome) {
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome de grupo inválido");
        }

        this.nome = nome;
        this.capacidadeMax = 0;
        this.alunos = new HashSet<Integer>();
    }

    public Grupo(String nome, int tamanhoGrupo) {
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome de grupo inválido");
        }

        if(tamanhoGrupo <= 0){
            throw new IllegalArgumentException("Tamanho de grupo inválido");
        }
        this.nome = nome;
        this.capacidadeMax = tamanhoGrupo;
        this.alunos = new HashSet<Integer>();
    }

    public String adicionaAlunoEmGrupo(int matricula){
        if(!(alunos.size() == capacidadeMax) || capacidadeMax == 0) {
                alunos.add(matricula);
                return "ALUNO ALOCADO!";
        }
        return "GRUPO CHEIO";
    }

    public String getNome(){
        return this.nome;
    }

    public boolean ehDoGrupo(int matricula) {
        return alunos.contains(matricula);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Grupo other = (Grupo) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "nome='" + nome +
                "'}";
    }
}
