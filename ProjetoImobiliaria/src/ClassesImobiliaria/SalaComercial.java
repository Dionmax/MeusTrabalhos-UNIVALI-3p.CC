/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesImobiliaria;

import ClassesImobiliaria.Imovel;

/**
 *
 * @author dionm
 */
public class SalaComercial extends Imovel {

    private final String tipo = "Sala Comercial";
    private String espaco = "0";
    private String salas = "0";

    public SalaComercial(String matricula) {
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
    public void setEspecificacoes(String espaco, String salas,String nada){
        this.espaco = espaco;
        this.salas = salas;
    }

    @Override
    public String getEspecificacoes() {
        return String.format("A Sala Comercial possui um espaço de %s M² com %s salas.", this.espaco, this.salas);
    }

}
