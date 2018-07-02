/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garfos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author KEVIN
 */
public class Grafos {
    //numero de vertices
    private final int n;    
    //numero de arestas
    private int m;
    private int[][] CustoAr;
    CustoAresta Custo;
    ArrayList listCust=new ArrayList();
    
    
    private HashMap<Integer,ArrayDeque<Integer>> adj;
    
    
    public Grafos(int n){
        if (n<0){
          throw new IllegalArgumentException("O numero de Vertices deve ser maior que Zero!");
        }
        this.n=n;
        this.m=0;
        this.adj=new HashMap<>();        
        for (int i=0;i<n;i++){
            adj.put(i, new ArrayDeque<Integer>());
        }
    
    }
    
    public Grafos(String nomeArquivo) throws FileNotFoundException, Exception{
        //le arquivo selecionado
        this(new Scanner(new File(nomeArquivo))); //manda para Gragos(Scanner in);       
    
    }
    
    public Grafos(Scanner in) throws Exception{
        
        if(null == in){
            throw new IllegalArgumentException("Scanner deve estar Funcionandop");
        }
        
        if (!in.hasNextInt()){
            throw new Exception("Primeiro numero deve ser um numero inteiro");
        }
        
        n=in.nextInt();//Pega primeira linha!!
        
        if(0 > n){
            throw new IllegalArgumentException("o numero de vertices deve ser mairo que zero");
        }        
        
        if (!in.hasNextInt()){
            throw new Exception("Segundo numero deve ser um numero inteiro");
        }
        int numArestas= in.nextInt();
         
        if(0 > numArestas){
            throw new IllegalArgumentException("o numero de Arestas deve ser mairo que zero");
        }
        
        adj=new HashMap<>();         
        
        
        for (int i=0;i<n;i++){
            adj.put(i, new ArrayDeque<Integer>());
        }
          
        
       //  int Test =0;
        for(int i =0;i<numArestas;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int custo=in.nextInt();
            //CustoAr[u][v]=custo;
            CustoAresta Custo= new CustoAresta(u,v,custo);
            listCust.add(Custo);
            //Test++;
            // System.out.println(u +" - "+v +" LIGAÇAO N°"+Test);
            
            addAresta(u,v);
            
            if(in.hasNextLine())in.hasNextLine();//proxima linha
        }        
        
        
    }
    
    public Grafos(Grafos g){
          if (null==g){
          throw new IllegalArgumentException("OO numeri de Vertices deve ser maior que Zero!");
        }
        this.n=g.n();
        this.m=g.m();
        for(int i=0;i <this.n;i++){
            adj.put(i, g.adj.get(i).clone());        
        }
    }
    
    public int n(){
        return n;        
    }
    
    public int m(){
        return m;         
    }
    //Verifica se os Verticves esstao dentro dos limites
    private boolean VerificaVertice(int u){
        return ((u>=0)&&(u<n+1));
    }
    
    public final void addAresta(int u,int v){        
        if(!VerificaVertice(u)){
            throw new IndexOutOfBoundsException("Vertices de origem dora da faixa");
        }
        if(!VerificaVertice(v)){
            throw new IndexOutOfBoundsException("Vertices de origem dora da faixa");
        }
        m++;//add aresta na contagem
       
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    public final void addArestaDirecionada(int u,int v){
        if(!VerificaVertice(u)){
            throw new IndexOutOfBoundsException("Vertices de origem dora da faixa");
        }
        if(!VerificaVertice(v)){
            throw new IndexOutOfBoundsException("Vertices de origem dora da faixa");
        }
        m++;//add aresta na contagem
       
        adj.get(u).add(v);
        
    }
    
    public Iterable<Integer> adj(int v){
        if(!VerificaVertice(v)){
            throw new IndexOutOfBoundsException("Vertices de origem dora da faixa");
        }
        return adj.get(v);
        
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        //Obtem separador especifico do sistema
        String SL = System.getProperty("line.separator");
        
        s.append(n).append(" Vertices ").append(m).append(" Arestas").append(SL);
        
        for(int v = 0;v<n;v++){            
                for(int u : adj(v)){
                s.append(v).append("-").append(u).append(" ");          
                
                }   
            s.append(SL);
        }        
        return s.toString();        
    } 
    
}
