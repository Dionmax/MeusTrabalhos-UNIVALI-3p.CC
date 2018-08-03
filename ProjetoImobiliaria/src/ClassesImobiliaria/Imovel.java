/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesImobiliaria;

public abstract class Imovel implements Comparable<Imovel> {

    String matricula;

    public Imovel(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int compareTo(Imovel object) {
        return this.matricula.compareTo(object.matricula);
    }

    public abstract String getMatricula();

    public abstract String getTipo();

    public abstract void setEspecificacoes(String a, String b, String c);

    public abstract String getEspecificacoes();
}
