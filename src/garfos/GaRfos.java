/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garfos;

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author KEVIN
 */
public class GaRfos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //le arquivo;
        String NomeArquivo = "src/Grafo.Grafo.txt";
        
        //Cria Arquivo
        Grafos g;
        try{
            g = new Grafos(NomeArquivo);
            System.out.println(g);//mostra arquivo
        }catch(Exception ex){
            Logger.getLogger(GaRfos.class.getName()).log(Level.SEVERE,null,ex);
        }
        System.out.println("Qual distancia vc quer ver?");
       
    
    
    
    
    }
    
}
