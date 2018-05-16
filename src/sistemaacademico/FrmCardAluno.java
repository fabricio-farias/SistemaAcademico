/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author aluno
 */
public class FrmCardAluno extends JFrame {
    public static final int WIDTH_DEFAULT = 600;
    public static final int HEIGHT_DEFAULT = 300;
    private CardLayout card;
    private JPanel pnlRaiz;
    
    public FrmCardAluno (){
        setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
        setTitle("Dados do aluno");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        initComponents();
    }
    
    private void initComponents(){
        Container cnt = getContentPane();
        cnt.add(criarPainelBotoes(), BorderLayout.WEST);
        cnt.add(criarPainelDados(), BorderLayout.CENTER);
    }
    
    private JPanel criarPainelBotoes(){
        JPanel pnlBotoes = new JPanel();
        
        Box boxBotoes = Box.createVerticalBox();
        JButton bntDadosGerais = new JButton("Dados Gerais");
        bntDadosGerais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                card.show(pnlRaiz, "Dados Gerais");
            }
        });
        JButton bntEnderecos = new JButton("Endereços");
                bntEnderecos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                card.show(pnlRaiz, "Endereços");
            }
        });
        JButton bntDisciplinas = new JButton("Disciplinas");
        JButton bntFinanceiro = new JButton("Financeiro");
        
        boxBotoes.add(bntDadosGerais);
        boxBotoes.add(bntEnderecos);
        boxBotoes.add(bntDisciplinas);
        boxBotoes.add(bntFinanceiro);
        
        pnlBotoes.add(boxBotoes);
        
        return pnlBotoes;
       
    }
    
    private JPanel criarPainelDados(){
        pnlRaiz = new JPanel();
        card = new CardLayout();
        pnlRaiz.setLayout(card);
        pnlRaiz.add(criarPainelDadosGerais(), "Dados Gerais");
        pnlRaiz.add(criarPainelEnderecos(), "Endereços");
        //pnlRaiz.add(criarPainelDisciplinas(), "Disciplinas");
        //pnlRaiz.add(criarPainelFinanceiro(), "Financeiro");
        
        card.show(pnlRaiz, "Dados Gerais");
        
        return pnlRaiz;
    }
    
    private JPanel criarPainelDadosGerais(){
        JPanel pnl = new JPanel(new GridLayout(4,1));
        JLabel lblMatricula = new JLabel("Matricula");
        JTextField txtMatricula = new JTextField(20);
        JLabel lblNomeCompleto = new JLabel("Nome Completo");
        JTextField txtNomeCompleto = new JTextField(20);
        
        pnl.add(lblMatricula);
        pnl.add(txtMatricula);
        pnl.add(lblNomeCompleto);
        pnl.add(txtNomeCompleto);
        
        return pnl;
        
    }
    
    private JPanel criarPainelEnderecos(){
        JPanel pnl = new JPanel(new GridLayout(4,1));
        JLabel lblEnderecoR = new JLabel("Endereço Residencial");
        JTextField txtEnderecoR  = new JTextField(30);
        JLabel lblEnderecoC = new JLabel("Endereço Comercial");
        JTextField txtEnderecoC = new JTextField(20);
        
        pnl.add(lblEnderecoR);
        pnl.add(txtEnderecoR);
        pnl.add(lblEnderecoC);
        pnl.add(txtEnderecoC);
        
        return pnl;
        
    }
    
    public static void main(String[] args){
        FrmCardAluno app = new FrmCardAluno();
    }
}