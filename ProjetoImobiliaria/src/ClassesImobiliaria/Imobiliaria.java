package ClassesImobiliaria;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import ImobiliariaEnum.*;
import java.util.Comparator;
import ClassesExceptions.*;

public class Imobiliaria {

    private final Set<Imovel> imoveis;
    private final List<Venda> imoPvender;
    private final List<Locacao> imoPalugar;

    public Imobiliaria() {
        imoveis = new TreeSet<>();
        imoPvender = new LinkedList<>();
        imoPalugar = new LinkedList<>();
    }

    public void cadastrar(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    public void porPvender(Imovel apt) throws NovoImovelException {
        try {
            if (podeVender(apt)) {
                imoPvender.add(new Venda(apt));
                //Para cada Objeto, vai comparar com o objeto pegando informação da Data. (Funcional [o -> o.])
                imoPvender.sort(Comparator.comparing(o -> o.getData()));
            }

        } catch (Exception InserirImovel) {

        }

    }

    public void porPalugar(Imovel apt) {
        if (podeAlugar(apt)) {
            imoPalugar.add(new Locacao(apt));
        }
    }

    public String getTipoImovel(Imovel apt) {
        return apt.getTipo();
    }

    public String getMatricula(Imovel apt) {
        return apt.getMatricula();
    }

    public Set getListaImoveis() {
        return imoveis;
    }

    public List ListaVendas() {
        return imoPvender;
    }

    public List ListaLocações() {
        return imoPalugar;
    }

    public String getEspecificacoes(Imovel apt) {
        return apt.getEspecificacoes();
    }

    public void removerImovel(Imovel apt) {
        this.imoveis.remove(apt);
    }

    private boolean podeAlugar(Imovel apt) {
        return (this.imoPalugar.stream().filter(f -> f.imovel.equals(apt) && f.getEstado() == LocacaoEstado.Alugar).count() == 0
                && this.imoPalugar.stream().filter(f -> f.imovel.equals(apt) && f.getEstado() == LocacaoEstado.Disponivel).count() == 0
                && this.imoPalugar.stream().filter(f -> f.imovel.equals(apt) && f.getEstado() == LocacaoEstado.Alugado).count() == 0);
    }

    //Professor
    public Imovel obterImovel(String matricula) {
        return (Imovel) this.imoveis.stream().filter(t -> t.matricula.equals(matricula)).findFirst().get();
    }

    private boolean podeVender(Imovel imovel) {
        return (this.imoPvender.stream().filter(t -> t.imovel.equals(imovel) && t.getEstado() == VendaEstado.Disponivel).count() == 0
                && this.imoPvender.stream().filter(t -> t.imovel.equals(imovel) && t.getEstado() == VendaEstado.Vender).count() == 0
                && this.imoPvender.stream().filter(t -> t.imovel.equals(imovel) && t.getEstado() == VendaEstado.Vendido).count() == 0);
    }
}
