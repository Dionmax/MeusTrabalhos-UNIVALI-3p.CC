/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HistóricoImobiliaria;

import ClassesImobiliaria.Imovel;

/**
 *
 * @author dionm
 */
public class HistoricoLocacao {

    private Imovel imovel;
    private String[] parcelas = new String[12];
    private boolean atrasado;

    public HistoricoLocacao(Imovel imovel, String valorParcelas) {
        this.imovel = imovel;
        atrasado = false;
        for (String parcela : parcelas) {
            parcela = valorParcelas;
        }
    }

    public void valorSeparadoParcela(int numeroDaParcela, String valorDaParcela) {
        parcelas[numeroDaParcela] = valorDaParcela;
    }

    public void declararAtraso() {
        atrasado = true;
    }

    public void declararQuitacao() {
        atrasado = false;
    }
}
