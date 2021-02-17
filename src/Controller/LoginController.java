/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author tiago
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        //Pegar um  Usuario da View
        Usuario usuario = helper.obterModelo();

       //Pesquisa Usuario no Banco
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
       
       ////Se o usuario da view tiver mesmo usuario e senha que o usuario vindo do banco direcionar para menu principal
       if(usuarioAutenticado != null){
           MenuPrincipal menuPrincipal = new MenuPrincipal();
           menuPrincipal.setVisible(true);
           this.view.dispose();
       }else{
           //Senão mostrar uma mensagem ao usuario "Usuario ou senha invalidos"
           this.view.exibeMensagem("Usuário/ senha inválidos!");
       }
    }
    
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
