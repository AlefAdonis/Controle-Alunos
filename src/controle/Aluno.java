package controle;

public class Aluno {

    private int matricula;
    private String nome;
    private String curso;

    public Aluno(int matricula, String nome, String curso) throws IllegalArgumentException{
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome  nulo ou vazio para aluno.");
        }
        if (curso == null || curso.isBlank()) {
            throw new IllegalArgumentException("Nome nulo ou vazio para curso.");
        }

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * (result + matricula);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Aluno alumn = (Aluno) o;
        if(this.matricula == alumn.matricula) {
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }
}
