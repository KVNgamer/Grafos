/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovaLista;
/**
 *
 * @author KEVIN
 * 
 */
public class no<T> {
    	private int dado;
	private no<T> proximo;
	private no<T> anterior;
		
	public no(int dado, no<T> anterior, no<T> proximo) {
            this.dado = dado;
            this.proximo = proximo;
            this.anterior = anterior;
	} 

        public no(int dado) {
            this.dado = dado;
        }
        
        public int getDado(){
            return this.dado;
        }        
        public void setDado(int dado) {
		this.dado = dado;
	}
        
	public no<T> getProximo() {
		return this.proximo;
	}
	public void setProximo(no<T> proximo) {
		this.proximo = proximo;
	}
        
	public no<T> getAnterior() {
		return this.anterior;
	}
	public void setAnterior(no<T> anterior) {
		this.anterior = anterior;
	}
        
	public String toString() {
		return "" + dado;
	}
    
}
