package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.DAO.ClienteDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AgendamentoControllerHelper implements Helper{
    private final Agenda view;

    public AgendamentoControllerHelper(Agenda view) {
        this.view = view;
    }
    
    //Preencher a tabela
    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        //Obtendo acesso ao conteúdo da table
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        //Percorrer a lista preenchendo o tableModel
        for (Agendamento agendamento : agendamentos) {
               tableModel.addRow(new Object[]{
                   agendamento.getId(),
                   agendamento.getCliente().getNome(),
                   agendamento.getServico().getDescricao(),
                   agendamento.getValor(),
                   agendamento.getDataFormatada(),
                   agendamento.getHOraFormatada(),
                   agendamento.getObservacao()
               });
        }
    
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboxBoxModel = (DefaultComboBoxModel) view.getTextCliente().getModel();
        for (Cliente cliente : clientes) {
            comboxBoxModel.addElement(cliente); 
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        DefaultComboBoxModel comboBoxServico = (DefaultComboBoxModel) view.getTextServico().getModel();
        for (Servico servico : servicos) {
            comboBoxServico.addElement(servico);
        }
    
    }
    
    public Cliente obterCliente() {
        return (Cliente) view.getTextCliente().getSelectedItem();
    }

    public Servico obterServico() {
        return (Servico) view.getTextServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        //Toda a operação vira string quando concatenada
        view.getTextValor().setText(valor+"");
    }

    @Override
    public Agendamento obterModelo() {
        //int id, Cliente cliente, Servico servico, float valor, String data
        String idString = view.getTextId().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getTextFormatedData().getText();
        String hora = view.getTextFormatedHora().getText();
        String stringDataHora = data + " " + hora;
        String obs = view.getTextObservacao().getText();
        
        
        //Salvando o agendamento no banco de dados
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, data, obs);
        
        return agendamento;   
        
    }

    @Override
    public void limparTela() {
        view.getTextId().setText("0");
        view.getTextValor().setText("");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");
    }
    
   
}
