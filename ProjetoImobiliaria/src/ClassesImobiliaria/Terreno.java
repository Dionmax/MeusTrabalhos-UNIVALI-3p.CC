/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesImobiliaria;

/**
 *
 * @author dionm
 */
public class Terreno extends Imovel {

    private final String tipo = "Terreno";
    private String metros2 = "0";

    public Terreno(String matricula) {
        super(matricula);
    }

    public void setMetros2(String metros2) {
        this.metros2 = metros2;
    }

    @Override
    public String getMatricula() {
        return this.matricula;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setEspecificacoes(String metros2, String nada, String nada2) {
       this.metros2 =  metros2;
    }

    @Override
    public String getEspecificacoes() {
        return String.format("O terreno possui $s metros quadrados.", this.metros2);
    }
}
