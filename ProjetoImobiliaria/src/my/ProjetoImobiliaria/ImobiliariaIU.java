/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ProjetoImobiliaria;

import ClassesExceptions.NovoImovelException;
import ClassesExceptions.TypeErrorImovel;
import ClassesImobiliaria.*;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dionm
 */
public class ImobiliariaIU extends javax.swing.JFrame {

    public static Imobiliaria imobiliaria = new Imobiliaria();

    public static LocacaoIU janelaLocacao;

    public static VendaIU janelaVenda;

    private String modo;

    public ImobiliariaIU() {
        initComponents();

        setLocationRelativeTo(null);

        modo = "navegar";
        controleInterface();
    }

    private void controleInterface() {
        switch (modo) {
            case "navegar":
                btn_imo_novo.setEnabled(true);
                btn_imo_registrar.setEnabled(false);
                btn_imo_cancelar.setEnabled(false);
                cons_imo_numero.setEnabled(false);

                radio_btn_apartamento.setEnabled(false);
                radio_btn_casa.setEnabled(false);
                radio_btn_salacomercial.setEnabled(false);
                radio_btn_terreno.setEnabled(false);

                btn_imo_alugar.setEnabled(false);
                btn_imo_venda.setEnabled(false);
                btn_imo_limparCadastro.setEnabled(false);

                Label_imoveis_especificacoes_Atributo1.setVisible(false);
                Label_imoveis_especificacoes_Atributo2.setVisible(false);
                Label_imoveis_especificacoes_Atributo3.setVisible(false);
                Label_imoveis_especificacoes_Atributo4.setVisible(false);

                cons_imo_atributo_1.setVisible(false);
                cons_imo_atributo_2.setVisible(false);
                cons_imo_atributo_3.setVisible(false);
                cons_imo_atributo_4.setVisible(false);

                area_de_texto_imo_1.setEnabled(false);

                carregarTabelaImovel();
                break;

            case "novo":
                btn_imo_registrar.setEnabled(true);
                btn_imo_cancelar.setEnabled(true);
                cons_imo_numero.setEnabled(true);

                radio_btn_apartamento.setEnabled(true);
                radio_btn_casa.setEnabled(true);
                radio_btn_salacomercial.setEnabled(true);
                radio_btn_terreno.setEnabled(true);

                break;

            case "registrar":
                btn_imo_registrar.setEnabled(false);
                btn_imo_cancelar.setEnabled(false);
                cons_imo_numero.setEnabled(false);

                radio_btn_apartamento.setEnabled(false);
                radio_btn_casa.setEnabled(false);
                radio_btn_salacomercial.setEnabled(false);
                radio_btn_terreno.setEnabled(false);

                break;

            case "cancelarImobiliaria":
                btn_imo_novo.setEnabled(true);

                btn_imo_registrar.setEnabled(false);
                btn_imo_cancelar.setEnabled(false);
                cons_imo_numero.setEnabled(false);

                radio_btn_apartamento.setEnabled(false);
                radio_btn_casa.setEnabled(false);
                radio_btn_salacomercial.setEnabled(false);
                radio_btn_terreno.setEnabled(false);

                btn_imo_alugar.setEnabled(false);
                btn_imo_venda.setEnabled(false);
                btn_imo_limparCadastro.setEnabled(false);

                Label_imoveis_especificacoes_Atributo1.setVisible(false);
                Label_imoveis_especificacoes_Atributo2.setVisible(false);
                Label_imoveis_especificacoes_Atributo3.setVisible(false);
                Label_imoveis_especificacoes_Atributo4.setVisible(false);

                cons_imo_atributo_1.setVisible(false);
                cons_imo_atributo_2.setVisible(false);
                cons_imo_atributo_3.setVisible(false);
                cons_imo_atributo_4.setVisible(false);

                break;

            case "SelecaoLinhaTabelaImobiliaria":

                btn_imo_novo.setEnabled(false);
                btn_imo_cancelar.setEnabled(true);

                btn_imo_alugar.setEnabled(true);
                btn_imo_venda.setEnabled(true);
                btn_imo_limparCadastro.setEnabled(true);

                break;

            default:
                System.out.println("Invalido");
        }
    }

    private void carregarTabelaImovel() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Tipo Imovel", "Número"}, 0);
        Set<Imovel> imoveis_aux = imobiliaria.getListaImoveis();

        imoveis_aux.forEach((imovel) -> {
            modelo.addRow(new Object[]{imobiliaria.getTipoImovel(imovel), imobiliaria.getMatricula(imovel)});
        });

        tbl_imo_registroPrincipal.setModel(modelo);
    }

    private void cadastrarUI() {
        Imovel imovel = null;
        String atributo1 = "";
        String atributo2 = "";
        String atributo3 = "";

        String numero_aux = cons_imo_numero.getText();

        if ("".equals(numero_aux)) {
            JOptionPane.showMessageDialog(rootPane, "Número de Imovel não informado!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

        if (radio_btn_apartamento.isSelected()) {
            imovel = new Apartamento(numero_aux);
        } else if (radio_btn_casa.isSelected()) {
            imovel = new Casa(numero_aux);
        } else if (radio_btn_salacomercial.isSelected()) {
            imovel = new SalaComercial(numero_aux);
        } else if (radio_btn_terreno.isSelected()) {
            imovel = new Terreno(numero_aux);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tipo de Imovel não informado!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        imobiliaria.cadastrar(imovel);

        imovel.setEspecificacoes(cons_imo_atributo_1.getText(), cons_imo_atributo_2.getText(), cons_imo_atributo_3.getText());

        cons_imo_numero.setText("");
        cons_imo_atributo_1.setText("");
        cons_imo_atributo_2.setText("");
        cons_imo_atributo_3.setText("");

        modo = "navegar";
        controleInterface();
    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        tbl_geral = new javax.swing.JTabbedPane();
        tbl_panel_imoveis = new javax.swing.JPanel();
        btn_imo_registrar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cons_imo_numero = new javax.swing.JTextField();
        radio_btn_casa = new javax.swing.JRadioButton();
        radio_btn_terreno = new javax.swing.JRadioButton();
        radio_btn_apartamento = new javax.swing.JRadioButton();
        radio_btn_salacomercial = new javax.swing.JRadioButton();
        btn_imo_cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Label_imoveis_especificacoes_Atributo1 = new javax.swing.JLabel();
        cons_imo_atributo_1 = new javax.swing.JTextField();
        Label_imoveis_especificacoes_Atributo2 = new javax.swing.JLabel();
        cons_imo_atributo_2 = new javax.swing.JTextField();
        Label_imoveis_especificacoes_Atributo3 = new javax.swing.JLabel();
        cons_imo_atributo_3 = new javax.swing.JTextField();
        Label_imoveis_especificacoes_Atributo4 = new javax.swing.JLabel();
        cons_imo_atributo_4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_imo_registroPrincipal = new javax.swing.JTable();
        btn_imo_venda = new javax.swing.JButton();
        btn_imo_alugar = new javax.swing.JButton();
        btn_imo_limparCadastro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_de_texto_imo_1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btn_imo_novo = new javax.swing.JButton();
        btn_abrir_locacoa = new javax.swing.JButton();
        btn_abrir_venda = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Imobiliaria");

        tbl_geral.setToolTipText("");
        tbl_geral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_geralMousePressed(evt);
            }
        });

        btn_imo_registrar.setText("Registrar");
        btn_imo_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imo_registrarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));
        jPanel6.setInheritsPopupMenu(true);

        jLabel18.setText("Tipo:");

        jLabel19.setText("Numero da matricula:");

        buttonGroup1.add(radio_btn_casa);
        radio_btn_casa.setText("Casa");
        radio_btn_casa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_btn_casaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_btn_terreno);
        radio_btn_terreno.setText("Terreno");
        radio_btn_terreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_btn_terrenoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_btn_apartamento);
        radio_btn_apartamento.setText("Apartamento");
        radio_btn_apartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_btn_apartamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_btn_salacomercial);
        radio_btn_salacomercial.setText("Sala Comercial");
        radio_btn_salacomercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_btn_salacomercialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cons_imo_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radio_btn_casa, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio_btn_terreno)
                        .addGap(27, 27, 27)
                        .addComponent(radio_btn_apartamento)
                        .addGap(10, 10, 10)
                        .addComponent(radio_btn_salacomercial)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(radio_btn_casa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio_btn_terreno)
                    .addComponent(radio_btn_apartamento)
                    .addComponent(radio_btn_salacomercial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cons_imo_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_imo_cancelar.setText("Cancelar");
        btn_imo_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imo_cancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Especificações"));
        jPanel2.setToolTipText("");

        Label_imoveis_especificacoes_Atributo1.setText("Atributo_1");

        Label_imoveis_especificacoes_Atributo2.setText("Atributo_2");

        Label_imoveis_especificacoes_Atributo3.setText("Atributo_3");

        Label_imoveis_especificacoes_Atributo4.setText("Atributo_4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_imoveis_especificacoes_Atributo4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(Label_imoveis_especificacoes_Atributo1)
                            .addGap(18, 18, 18)
                            .addComponent(cons_imo_atributo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(Label_imoveis_especificacoes_Atributo2)
                            .addGap(18, 18, 18)
                            .addComponent(cons_imo_atributo_2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(Label_imoveis_especificacoes_Atributo3)
                            .addGap(18, 18, 18)
                            .addComponent(cons_imo_atributo_3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cons_imo_atributo_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_imoveis_especificacoes_Atributo1)
                    .addComponent(cons_imo_atributo_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cons_imo_atributo_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_imoveis_especificacoes_Atributo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_imoveis_especificacoes_Atributo3)
                    .addComponent(cons_imo_atributo_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_imoveis_especificacoes_Atributo4)
                    .addComponent(cons_imo_atributo_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tbl_panel_imoveisLayout = new javax.swing.GroupLayout(tbl_panel_imoveis);
        tbl_panel_imoveis.setLayout(tbl_panel_imoveisLayout);
        tbl_panel_imoveisLayout.setHorizontalGroup(
            tbl_panel_imoveisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_panel_imoveisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl_panel_imoveisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl_panel_imoveisLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tbl_panel_imoveisLayout.createSequentialGroup()
                        .addComponent(btn_imo_registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_imo_cancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tbl_panel_imoveisLayout.setVerticalGroup(
            tbl_panel_imoveisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl_panel_imoveisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl_panel_imoveisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_imo_cancelar)
                    .addComponent(btn_imo_registrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbl_geral.addTab("Novo", tbl_panel_imoveis);

        tbl_imo_registroPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo Imovel", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_imo_registroPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_imo_registroPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_imo_registroPrincipal);
        if (tbl_imo_registroPrincipal.getColumnModel().getColumnCount() > 0) {
            tbl_imo_registroPrincipal.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_imo_registroPrincipal.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        btn_imo_venda.setText("Por para vender");
        btn_imo_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imo_vendaActionPerformed(evt);
            }
        });

        btn_imo_alugar.setText("Por para Alugar");
        btn_imo_alugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imo_alugarActionPerformed(evt);
            }
        });

        btn_imo_limparCadastro.setForeground(new java.awt.Color(255, 0, 0));
        btn_imo_limparCadastro.setText("Limpar Cadastro");
        btn_imo_limparCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imo_limparCadastroActionPerformed(evt);
            }
        });

        area_de_texto_imo_1.setEditable(false);
        area_de_texto_imo_1.setColumns(20);
        area_de_texto_imo_1.setRows(5);
        jScrollPane2.setViewportView(area_de_texto_imo_1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_imo_venda, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(btn_imo_alugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_imo_limparCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(443, 443, 443))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_imo_venda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_imo_alugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_imo_limparCadastro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        tbl_geral.addTab("Registrados", jPanel1);

        jLabel1.setText("Imobiliaria");

        btn_imo_novo.setText("Novo");
        btn_imo_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imo_novoActionPerformed(evt);
            }
        });

        btn_abrir_locacoa.setText("Locação");
        btn_abrir_locacoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_locacoaActionPerformed(evt);
            }
        });

        btn_abrir_venda.setText("Venda");
        btn_abrir_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_vendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tbl_geral, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_imo_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_abrir_locacoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_abrir_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_imo_novo)
                    .addComponent(btn_abrir_locacoa)
                    .addComponent(btn_abrir_venda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbl_geral)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_imo_registroPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_imo_registroPrincipalMouseClicked
        int indice = tbl_imo_registroPrincipal.getSelectedRow();

        Object matricula_aux = tbl_imo_registroPrincipal.getValueAt(indice, 1);

        Imovel imovel_aux = imobiliaria.obterImovel(matricula_aux.toString());

        area_de_texto_imo_1.setEnabled(true);

        area_de_texto_imo_1.setText(imobiliaria.getEspecificacoes(imovel_aux));

        modo = "SelecaoLinhaTabelaImobiliaria";
        controleInterface();
    }//GEN-LAST:event_tbl_imo_registroPrincipalMouseClicked

    private void tbl_geralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_geralMousePressed
        carregarTabelaImovel();
    }//GEN-LAST:event_tbl_geralMousePressed

    private void btn_imo_limparCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imo_limparCadastroActionPerformed
        int indice = tbl_imo_registroPrincipal.getSelectedRow();

        Object matricula_aux = tbl_imo_registroPrincipal.getValueAt(indice, 1);

        Imovel imovel_aux = imobiliaria.obterImovel(matricula_aux.toString());

        imobiliaria.removerImovel(imovel_aux);

        cons_imo_numero.setText("");
        area_de_texto_imo_1.setText("");
        area_de_texto_imo_1.setEnabled(false);
        modo = "navegar";
        carregarTabelaImovel();
        controleInterface();
    }//GEN-LAST:event_btn_imo_limparCadastroActionPerformed

    private void btn_imo_alugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imo_alugarActionPerformed
        int indice = tbl_imo_registroPrincipal.getSelectedRow();

        Object matricula_aux = tbl_imo_registroPrincipal.getValueAt(indice, 1);

        Imovel imovel_aux = imobiliaria.obterImovel(matricula_aux.toString());

        List<Locacao> locacao_aux = imobiliaria.ListaLocações();

        locacao_aux.forEach((locacao) -> {
            if (imovel_aux.getMatricula() != locacao.getNumeroImovel()) {

            }
        });

        imobiliaria.porPalugar(imovel_aux);

        modo = "navegar";

        controleInterface();
    }//GEN-LAST:event_btn_imo_alugarActionPerformed

    private void btn_imo_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imo_vendaActionPerformed

        int indice = tbl_imo_registroPrincipal.getSelectedRow();

        Object matricula_aux = tbl_imo_registroPrincipal.getValueAt(indice, 1);

        Imovel imovel_aux = imobiliaria.obterImovel(matricula_aux.toString());

        try {
            imobiliaria.porPvender(imovel_aux);
        } catch (NovoImovelException ex) {
            Logger.getLogger(ImobiliariaIU.class.getName()).log(Level.SEVERE, null, ex);
        }

        modo = "navegar";

        controleInterface();
    }//GEN-LAST:event_btn_imo_vendaActionPerformed

    private void btn_imo_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imo_cancelarActionPerformed

        cons_imo_numero.setText("");

        modo = "cancelarImobiliaria";
        controleInterface();
    }//GEN-LAST:event_btn_imo_cancelarActionPerformed

    private void btn_imo_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imo_novoActionPerformed

        cons_imo_numero.setText("");

        modo = "novo";
        controleInterface();
    }//GEN-LAST:event_btn_imo_novoActionPerformed

    private void btn_imo_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imo_registrarActionPerformed

        cadastrarUI();
        carregarTabelaImovel();

        modo = "registrar";
        controleInterface();
    }//GEN-LAST:event_btn_imo_registrarActionPerformed

    private void radio_btn_casaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_btn_casaActionPerformed
        Label_imoveis_especificacoes_Atributo1.setText("Andares:");
        Label_imoveis_especificacoes_Atributo2.setText("Comodos:");
        Label_imoveis_especificacoes_Atributo3.setText("Cor:");

        Label_imoveis_especificacoes_Atributo1.setVisible(true);
        Label_imoveis_especificacoes_Atributo2.setVisible(true);
        Label_imoveis_especificacoes_Atributo3.setVisible(true);

        cons_imo_atributo_1.setVisible(true);
        cons_imo_atributo_2.setVisible(true);
        cons_imo_atributo_3.setVisible(true);

    }//GEN-LAST:event_radio_btn_casaActionPerformed

    private void radio_btn_terrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_btn_terrenoActionPerformed
        Label_imoveis_especificacoes_Atributo1.setText("Metros quadrados (m²):");
        Label_imoveis_especificacoes_Atributo1.setVisible(true);
        cons_imo_atributo_1.setVisible(true);

        cons_imo_atributo_2.setVisible(false);
        cons_imo_atributo_3.setVisible(false);
        Label_imoveis_especificacoes_Atributo2.setVisible(false);
        Label_imoveis_especificacoes_Atributo3.setVisible(false);
    }//GEN-LAST:event_radio_btn_terrenoActionPerformed

    private void radio_btn_apartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_btn_apartamentoActionPerformed
        Label_imoveis_especificacoes_Atributo1.setText("Andares:");
        Label_imoveis_especificacoes_Atributo2.setText("Comodos:");
        Label_imoveis_especificacoes_Atributo3.setText("Cor:");

        Label_imoveis_especificacoes_Atributo1.setVisible(true);
        Label_imoveis_especificacoes_Atributo2.setVisible(true);
        Label_imoveis_especificacoes_Atributo3.setVisible(true);

        cons_imo_atributo_1.setVisible(true);
        cons_imo_atributo_2.setVisible(true);
        cons_imo_atributo_3.setVisible(true);
    }//GEN-LAST:event_radio_btn_apartamentoActionPerformed

    private void radio_btn_salacomercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_btn_salacomercialActionPerformed

        Label_imoveis_especificacoes_Atributo1.setText("Espaço: ");
        Label_imoveis_especificacoes_Atributo2.setText("Salas: ");
        cons_imo_atributo_1.setVisible(true);
        cons_imo_atributo_2.setVisible(true);

        cons_imo_atributo_3.setVisible(false);
        Label_imoveis_especificacoes_Atributo3.setVisible(false);
    }//GEN-LAST:event_radio_btn_salacomercialActionPerformed

    private void btn_abrir_locacoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrir_locacoaActionPerformed

        if (janelaLocacao == null) {
            janelaLocacao = new LocacaoIU();
            janelaLocacao.setVisible(true);
            janelaLocacao.setResizable(false);
        } else {
            janelaLocacao.setVisible(true);
            janelaLocacao.setResizable(false);
        }

    }//GEN-LAST:event_btn_abrir_locacoaActionPerformed

    private void btn_abrir_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrir_vendaActionPerformed

        if (janelaVenda == null) {
            janelaVenda = new VendaIU();
            janelaVenda.setVisible(true);
            janelaVenda.setResizable(false);
        } else {
            janelaVenda.setVisible(true);
            janelaVenda.setResizable(false);
        }
    }//GEN-LAST:event_btn_abrir_vendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImobiliariaIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImobiliariaIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImobiliariaIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImobiliariaIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImobiliariaIU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_imoveis_especificacoes_Atributo1;
    private javax.swing.JLabel Label_imoveis_especificacoes_Atributo2;
    private javax.swing.JLabel Label_imoveis_especificacoes_Atributo3;
    private javax.swing.JLabel Label_imoveis_especificacoes_Atributo4;
    private javax.swing.JTextArea area_de_texto_imo_1;
    private javax.swing.JButton btn_abrir_locacoa;
    private javax.swing.JButton btn_abrir_venda;
    private javax.swing.JButton btn_imo_alugar;
    private javax.swing.JButton btn_imo_cancelar;
    private javax.swing.JButton btn_imo_limparCadastro;
    private javax.swing.JButton btn_imo_novo;
    private javax.swing.JButton btn_imo_registrar;
    private javax.swing.JButton btn_imo_venda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JTextField cons_imo_atributo_1;
    private javax.swing.JTextField cons_imo_atributo_2;
    private javax.swing.JTextField cons_imo_atributo_3;
    private javax.swing.JTextField cons_imo_atributo_4;
    private javax.swing.JTextField cons_imo_numero;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radio_btn_apartamento;
    private javax.swing.JRadioButton radio_btn_casa;
    private javax.swing.JRadioButton radio_btn_salacomercial;
    private javax.swing.JRadioButton radio_btn_terreno;
    private javax.swing.JTabbedPane tbl_geral;
    private javax.swing.JTable tbl_imo_registroPrincipal;
    private javax.swing.JPanel tbl_panel_imoveis;
    // End of variables declaration//GEN-END:variables
}
