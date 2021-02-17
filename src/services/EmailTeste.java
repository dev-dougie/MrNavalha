/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class EmailTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
        Email email = new Email("A Keyrus não mandou resposta", 
                "Falta de comprometimento\n"+"Deixa eles, deixa eles\n"+"CARALHO!", 
                "dougllasp.s@outlook.com");
        
        email.enviar();
        

    }
    
}
