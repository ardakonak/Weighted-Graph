/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author ardakonak
 */

public class DiWeightGraph {

    int vertices;
    int numEdges;
    LinkedList<EdgesOfG> [] adjList;
    
    DiWeightGraph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        
        for (int i = 0; i < vertices; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    
   /* public void addFirst(EdgesOfG edges ){
        this.adjList = 
    } */
    
    public void addEdge(String from, String to, int weight){
        
        EdgesOfG edges = new EdgesOfG (from,to,weight);
      //  adjList[from].addFirst(edges.from);
        
    }
    
    
    public void toStringGraph(){
        for(int i = 0; i < vertices; i++){
            LinkedList<EdgesOfG> l1 = adjList[1];
            for(int a = 0; a < l1.size(); a++) {
                System.out.println("Vertice " + i + "is connected to " + l1.get(a).from + "and their connection weight is " + l1.get(a).weight);
            }
        }
    }
    
    
    public static DiWeightGraph readfromFile(String f) {
        // TODO code application logic here

        try {
            Scanner sc = new Scanner(new File(f));
            int vertices = 104;
            String v = sc.nextLine();
            String e = sc.nextLine();
            System.out.println("constructing a graph of " + vertices + " vertices. ");
            DiWeightGraph g1 = new DiWeightGraph(vertices);
            sc.useDelimiter(" ");
            for (int i = 0; i < 104; i++) {
                String v1 = sc.nextLine();
                String v2 = sc.nextLine();
                int v3 = sc.nextInt();
                g1.addEdge(v1, v2,v3);
            }
            System.out.println("Loaded " + e + " edges ");
            return g1;

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return null;
        }
    }
       public void removeEdge(int from, int to) {
        if (adjList[from].contains(to)) {
            adjList[from].remove(to);
        } else {
            System.out.println("Edge not found!");
        }
    }
       public Integer[] neighborsArray(int from) {
        Integer[] ar = new Integer[adjList[from].size()];
        adjList[from].toArray(ar);
        return ar;
    }
       public int getedgew() {
        return numEdges;
    }

    public int getNumV() {
        return vertices;
    }
    
    public void change(String char1, String char2, int newWeight ) {
        if(isConnected(char1,char2)== false){
            System.out.println("There is no connection so can't change the weight...");
           } else {
        int index1 = 0;
       
        for(int i = 0; i<vertices; i++){
            if(adjList[i].get(1).from == char1){
                index1 = i;
            }
           
        }
       adjList[index1].get(1).weight = newWeight;                       
    }
    }
    
    public void shortestPathTo(String char1, String char2){
   // DepthFS.printPathTo(w);
    
}
       
    
    public boolean isConnected(String char1, String char2 ) {
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i<vertices; i++){
            if(adjList[i].get(1).from == char1){
                index1 = i;
            }
            else if(adjList[i].get(1).from == char2){
                index2 = i;
            }
        }
        if(adjList[index1].get(1).from == adjList[index2].get(1).to){
            return true;         
        } else if(adjList[index2].get(1).from == adjList[index1].get(1).to){
            return true;
        } else{
            return false;
        }
                
    }
    
   // public void printClosestCharacters()
    
    public static void main(String[] args) {
        int vertices = 6;
        DiWeightGraph d1 = readfromFile("got-edges.csv");
        System.out.println("Reading from the file....");
        DiWeightGraph graph = new DiWeightGraph(vertices);
        Scanner userin = new Scanner(System.in);
        System.out.println("The graph is created.. Please select an action ");
        System.out.println("1 = Print closest charachters ");
        System.out.println("2 = Print Farther Characters ");
        System.out.println("3 = Check if they are connected ");
        System.out.println("4 = Show the shortest path ");
        System.out.println("5 = Delete a character ");
        System.out.println("6 = Change the weight of an edge ");  
        System.out.println("7 = Print number of character groups ");
        System.out.println("8 = Get number of V ");
        
        int choice = userin.nextInt();
        
        switch (choice) {
            case 3:
                System.out.println("Choose two character to check  ");
                String c1 = userin.nextLine();
                String c2 = userin.nextLine();
                d1.isConnected(c1, c2);
                break;
                
            case 4:
                System.out.println("Choose characters ");
                String c3 = userin.nextLine();
                String c4 = userin.nextLine();
                d1.shortestPathTo(c3, c4);
                break;
            
            case 5: 
                System.out.println("Choose character to delete ");
                String c5 = userin.nextLine();
               // d1.removeEdge(c5);
                break;
               
            case 6:
                System.out.println("Choose the characters and new weight ");
                String s1 = userin.nextLine();
                String s2 = userin.nextLine();
                int w1 = userin.nextInt();
                d1.change(s1, s2, w1);
                break;
                
            case 8:
                System.out.println(d1.getNumV());
                break;
                
        }
       /* DiWeightGraph graph = new DiWeightGraph(vertices);
       
       graph.addEdge("Mehmet", "Arda", 5);
       graph.addEdge("Ahmet", "Arda", 5);
       graph.addEdge("Arda","Ahmet", 10);
       graph.addEdge("Arda", "Mehmet", 10);
       graph.addEdge("Mehmet", "Ahmet, 100);
       graph.addEdge("Ahmet", "Mehmet", 100);
       
       graph.toStringGraph();   */
       
    }
    
}
