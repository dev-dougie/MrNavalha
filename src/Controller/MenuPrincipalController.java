/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Agenda;
import View.MenuPrincipal;

public class MenuPrincipalController {
    private static MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    
    //Acesso a view
    public void navegarParaAgenda(){
        //Instancia-se o objeto do tipo View Agenda 
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
    }
}
