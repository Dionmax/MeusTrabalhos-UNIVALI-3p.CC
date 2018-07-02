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
public class Apartamento extends Imovel {

    private final String tipo = "Apartamento";
    private String andares = "1";
    private String comodos = "1";
    private String cor = "Branca";

    public Apartamento(String matricula) {
        super(matricula);
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
    public void setEspecificacoes(String andares, String comodos, String cor) {
        this.andares = andares;
        this.comodos = comodos;
        this.cor = cor;
    }

    @Override
    public String getEspecificacoes() {
        return String.format("O apartamento possui %s andar com %s comodos na cor %s .", this.andares, this.comodos, this.cor);
    }
}
