/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesImobiliaria;

import ImobiliariaEnum.VendaEstado;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dionm
 */
public class Venda implements Comparable<Venda> {

    public Imovel imovel = null;
    private String valor = "0";
    private VendaEstado estado;
    private Pessoa comprador;
    private Date data;

    public Venda(Imovel imovel) {
        this.imovel = imovel;
        this.estado = VendaEstado.Disponivel;
    }

    public void vender(String valor) {
        this.valor = valor;
        estado = VendaEstado.Vender;
        data = Calendar.getInstance().getTime();
    }

    public void finalizar(String comprador, String CPF) {
        this.comprador = new Pessoa();
        this.comprador.setNome(comprador);
        this.comprador.setCPF(CPF);
        estado = VendaEstado.Vendido;
        this.data = Calendar.getInstance().getTime();
    }

    public String getValor() {
        return valor;
    }

    public VendaEstado getEstado() {
        return estado;
    }

    public String getNumeroImovel() {
        return this.imovel.getMatricula();
    }

    public String getTipoImovel() {
        return this.imovel.getTipo();
    }

    public String getComprador() {
        return comprador.getNome();
    }

    public String getEspecificacoes() {
        return this.imovel.getEspecificacoes();
    }

    public Date getData() {
        return data;
    }

    @Override
    public int compareTo(Venda venda) {
        return this.data.compareTo(venda.data);
    }
}
