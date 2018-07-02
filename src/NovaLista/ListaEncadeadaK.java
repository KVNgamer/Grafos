/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovaLista;
import NovaLista.no;
//import listaencadeada.main;

/**
 *
 * @author KEVIN
 */
public class ListaEncadeadaK<T> {

    
    private no<T> inicio;
    private no<T> fim;
    private int tamanho =0;      
    
    public void AddInicio(int dado){
	 no<T> novo = new no<>(dado, null, inicio);
	   inicio = novo;
		    
	    if(inicio != null){
               inicio.setAnterior(novo);
	    }
	    else {
	    	fim = novo;
	    }
            tamanho++;
    }
    
    public void addFim(int dado){
	no<T> novo = new no<>(dado, fim, null);
		
            if (fim != null) {
		fim.setProximo(novo);
            }
            else {
		inicio = novo;
            }
	fim = novo;
        tamanho++;
    }
    
    public boolean isEmpty() {
		return inicio == null;
	}
        
    public no getPrimeiro() {		
            return inicio;
	}
    
    public no getFim()  {		
       
        return fim;
    } 
    
    public void mostraLista(){
	no<T> i = inicio;    
        System.out.println("");
        while (i != null) {
            System.out.print(i.getDado()); 
            if(i!=fim){
            System.out.print(" - "); 
            }
            i = i.getProximo();          
        }
        System.out.println("");
    }     
    
    
    public static ListaEncadeadaK bubble_sort(ListaEncadeadaK listaNumero){
    System.out.print("Bubble_sort");
    int aux;
    boolean controle;
        for(no i=listaNumero.getPrimeiro();i!=listaNumero.getFim();i=i.getProximo()){
            controle=true;
            for(no j=listaNumero.getPrimeiro();j!=listaNumero.getFim();j=j.getProximo()){
                if(j.getDado() > j.getProximo().getDado()){
                    aux=j.getDado();
                    j.setDado(j.getProximo().getDado());
                    j.getProximo().setDado(aux);
                    controle=false;
                }              
            }
            if(controle)
                break;
        }
    return listaNumero;
    }
    
    public static void quick_sort(no anterior,no proximo){                 
        if(verificaSeVemDepois(anterior,proximo)){             
            no pivot=partition(anterior,proximo);            
           if(pivot.getDado()>1){              
               quick_sort(anterior,pivot.getAnterior());           
           }
           if(verificaSeVemDepois(pivot.getProximo(),proximo)){              
               quick_sort(pivot.getProximo(),proximo);
           }
        }   
    }
    
    private static no partition(no anterior, no proximo) {
        int pivot=anterior.getDado();
        while(true){
            while(anterior.getDado() < pivot){
                anterior=anterior.getProximo();
            }
            while(proximo.getDado() > pivot){
                proximo=proximo.getAnterior();            
            }
            if(verificaSeVemDepois(anterior,proximo)){
                int temp = proximo.getDado();
                proximo.setDado(anterior.getDado());
                anterior.setDado(temp);                
            }else{
            return proximo;
            }      
        }   
    }
    
    public static boolean verificaSeVemDepois(no anterior, no proximo) {
	no i = anterior;
        if(anterior!=null && proximo!=null)            
            if(anterior.getDado()== proximo.getDado())
                return false;        
        while (i != null) {
           if(i.getDado()==proximo.getDado()){
               return true;          
           }
           
            i = i.getProximo();            
	}        
	return false;
    } 
}
