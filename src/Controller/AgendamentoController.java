package Controller;

import Controller.Helper.AgendamentoControllerHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

public class AgendamentoController {
    private final Agenda view;
    private final AgendamentoControllerHelper helper;

    public AgendamentoController(Agenda view) {
        this.view = view;
        this.helper = new AgendamentoControllerHelper(view);
    }

    //Toda a regra de negócio aqui  
    public void atualizaTabela(){
        //buscar informações no banco de dados (lista de agendamentos)
        AgendamentoDAO agendamentoDAO =  new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        
        //Exibir as informações da lista na view
        helper.preencherTabela(agendamentos);
    }

      
    public void atualizaCliente(){
        //Buscar clientes no banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        //Mostra-los em tela [comboxbox] 
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico(){
       ServicoDAO servicoDAO = new ServicoDAO();
       ArrayList<Servico> servicos = servicoDAO.selectAll();
       helper.preencherServicos(servicos);
    }
    
    public void AtualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        //Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        //Salvar objeto no banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.insert(agendamento);
        //Atualizar tabela
        atualizaTabela();
        //Limpar campos
        helper.limparTela();
       
    }
}
