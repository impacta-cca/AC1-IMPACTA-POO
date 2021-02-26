/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class main {
    
    public static void main(String[] args) {
        game();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static boolean step (char M[][],int lin,int col , char gamer){
        
        if(gamer!='O' && gamer!='X'){
            return false;
        }
        if(M[lin][col]!=' '){
            return false;
        }
        
        M[lin][col] = gamer;
        return true;
        
    }
    
    public static  char[][] initialize(){
        
        char matriz[][]={
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
        };
       
                
                
        return matriz;
            
        }
    
   
    
    public  static void imprimir(char M[][]){
        for (int i=0;i<3;i++){
            
            for(int j=0;j<3;j++){
                System.out.print(" "+M[i][j]+" |");
            }   
            System.out.println();
        }
       
    }
    
    public static int status (char M[ ][ ]){
        // Verificação se o circulo completou alguma sequencia 
        if((M[0][0]=='O' && M[0][0]==M[1][1] && M[2][2]==M[1][1]) || // diagonal esquerda para a direita
           (M[0][2]=='O'  && M[1][1]==M[0][2] && M[2][0]==M[1][1])|| // diagonal direita para a esquerda
           (M[0][0]=='O' && M[0][1]==M[0][0] && M[0][2]==M[0][0]) || // primeira linha
           (M[1][0]=='O' && M[1][1]==M[1][0] && M[1][2]==M[1][0]) || // segunda linha
           (M[2][0]=='O' && M[2][1]==M[2][0] && M[2][2]==M[2][0]) || // terceira linha
           (M[0][0]=='O' && M[1][0]==M[0][0] && M[2][0]==M[1][0]) || // primeira coluna
           (M[0][1]=='O' && M[1][1]==M[0][1] && M[2][1]==M[1][1]) || // segunda coluna 
           (M[0][2]=='O' && M[1][2]==M[0][2] && M[2][2]==M[1][2])    //terceira coluna      
                ){
            return 1; // Circulo venceu
            
        } 
        
        if((M[0][0]=='X' && M[0][0]==M[1][1] && M[2][2]==M[1][1]) || // diagonal esquerda para a direita
           (M[0][2]=='X'  && M[1][1]==M[0][2] && M[2][0]==M[1][1])|| // diagonal direita para a esquerda
           (M[0][0]=='X' && M[0][1]==M[0][0] && M[0][2]==M[0][0]) || // primeira linha
           (M[1][0]=='X' && M[1][1]==M[1][0] && M[1][2]==M[1][0]) || // segunda linha
           (M[2][0]=='X' && M[2][1]==M[2][0] && M[2][2]==M[2][0]) || // terceira linha
           (M[0][0]=='X' && M[1][0]==M[0][0] && M[2][0]==M[1][0]) || // primeira coluna
           (M[0][1]=='X' && M[1][1]==M[0][1] && M[2][1]==M[1][1]) || // segunda coluna 
           (M[0][2]=='X' && M[1][2]==M[0][2] && M[2][2]==M[1][2])    //terceira coluna      
                ){
            return 2; // o X venceu
            
        }
        
        //Loop de verificação para analisar cada celula do jogo, e se encontrar a celula diferente de ' ', incrementa uma variavel acumuladora
        // que se chegar a 9( o quantidade total de celulas disponiveis, retorna que empatou)
        int verificarcheio=0;
        for (int i=0;i<3;i++){
            
            for(int j=0;j<3;j++){
               if(M[i][j]!=' '){
                   verificarcheio+=1;
               }
            }
        }
        
        if(verificarcheio==9){
            return 0;
        }
        else{
            return -1;
        }
        
       
    }
    
    
    public static void game(){
        Scanner entrada = new Scanner(System.in);
        
        
        char tab[][] = initialize();
        boolean jogo=true;
        char c='O';
        while(status(tab)==-1){
           
           boolean possivel=false;
           while(possivel==false){
               imprimir(tab);
               System.out.println("Escolha uma posição para colocar o "+c);
               System.out.println("Escolha a linha: 0 a 2 do "+ c);
               int linha = entrada.nextInt();
               System.out.println("Escolha a coluna: 0 a 2 do "+ c);
               int coluna = entrada.nextInt();
           
               if(step(tab, linha, coluna, c)==false){
                   System.out.println("Escolha uma posição valida");
               }
               else{
                   possivel = true;
               }
               
           }
           
            if(c=='O'){
                c='X';
            }
            else{
                c='O';
            }
        }
        
        imprimir(tab);
        if(status(tab)==0){
            System.out.println("Ocorreu um empate!!!");
        }
        if(status(tab)==1){
            System.out.println("O Circulo ganhou a rodada!!!");
        }
        if(status(tab)==2){
            System.out.println("O X ganhou a rodada!!!");
        }
        
        
    }
        
}    
        
    
    

