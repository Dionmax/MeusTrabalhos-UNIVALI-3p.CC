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
public class Casa extends Imovel {

    private final String tipo = "Casa";
    private String comodos = "1";
    private String andares = "0";
    private String cor = "branca";

    public Casa(String matricula) {
        super(matricula);
    }
    
    public void setnComodos(String comodos) {
        this.comodos = comodos;
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
        return String.format("A casa possui %s andar com %s comodos na cor %s .", this.andares, this.comodos, this.cor);
    }
}
