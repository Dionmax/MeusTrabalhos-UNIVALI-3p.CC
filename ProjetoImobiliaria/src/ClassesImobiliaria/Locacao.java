/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesImobiliaria;

import ImobiliariaEnum.LocacaoEstado;
import HistóricoImobiliaria.*;

/**
 *
 * @author dionm
 */
public class Locacao {

    private Pessoa inquilino = null;
    public Imovel imovel = null;
    private String valor = "0";
    private LocacaoEstado estado;
    private HistoricoLocacao historico;

    public Locacao(Imovel imovel) {
        this.imovel = imovel;
        this.estado = LocacaoEstado.Disponivel;
    }

    public void alugar(String valor) {
        this.valor = valor;
        estado = LocacaoEstado.Alugar;
    }

    public void finalizar(String inquilino, String CPF) {
        this.inquilino = new Pessoa();
        this.inquilino.setNome(inquilino);
        this.inquilino.setCPF(CPF);
        estado = LocacaoEstado.Alugado;
        historico = new HistoricoLocacao(imovel, this.valor);
    }

    public String getValor() {
        return valor;
    }

    public LocacaoEstado getEstado() {
        return estado;
    }

    public String getNumeroImovel() {
        return this.imovel.getMatricula();
    }

    public String getTipoImovel() {
        return this.imovel.getTipo();
    }

    public String getInquilino() {
        return inquilino.getNome();
    }

    public void setInquilino(String inquilino, String CPF) {
        this.inquilino.setNome(inquilino);
        this.inquilino.setCPF(CPF);
    }

    public String getEspecificacoes() {
        return this.imovel.getEspecificacoes();
    }
}
