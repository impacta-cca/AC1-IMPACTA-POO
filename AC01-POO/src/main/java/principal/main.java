/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author
 * Arthur Silva
 * Larrissa Ionfa
 * Lucas da Silva
 * Carolina de Castro
 * (FACULDADE IMPACTA)
 */
public class main {
    // Método Principal
    public static void main(String[] args) {
        // Inicia Jogo.
        game();
    }


    /*
     * 1. Vamos representar o nosso tabuleiro como uma matriz de caracteres 3x3. Sua primeira
     * função deverá devolver uma matriz de caracteres 3x3, com algum valor preenchido para
     * indicar que uma posição não foi ocupada.
     */
    public static  char[][] initialize(){
        // Cria Matriz
        char matriz[][] = new char[3][3];
        // Preencher Matriz
        for (char[] num : matriz)
            Arrays.fill(num, ' ');
        return matriz;
        }
    

    public  static void imprimir(char M[][]){
        // Percorre matriz do tabuleiro
        System.out.println("JOGO DA VELHA");
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                // Concatena com [] para melhor vizualizaçào do usuário
                System.out.print("["+M[i][j]+"] ");
            }   
            System.out.println();
        }System.out.println("=============");
    }
    //--------------------------------------- 1.MÉTODOS DE CRIAR E MOSTRA TABULEIRO.


    /*
     * 2. Implemente uma função que receba uma matriz do jogo da velha, uma posição (linha,
     * coluna) e o código do jogador (X ou O) e devolva a matriz com a posição preenchida com o
     * código do jogador, caso esteja livre. Se a posição conseguiu ser preenchida, step deve
     * retornar true e, caso não puder ser preenchida, false.
     */
    public static boolean step (char M[][],int lin,int col , char gamer){
        // Verifica Jogador.
        if(gamer!='O' && gamer!='X'){
            return false;
        }
        // Verifica se já foi preenchida posição.
        if(M[lin][col]!=' '){
            return false;
        }
        // Retorna se a jogoda foi concretizada.
        M[lin][col] = gamer;
        return true;
    }
    //--------------------------------------- 2.MÉTODO STEP DE VERIFICAÇÃO DE JOGADA.


   /*
    * 3. Implemente uma função que receba uma matriz do jogo do jogo da velha e verifique o
    * estado do jogo: alguém venceu, ocorreu um empate ou o jogo deve continuar. Vamos usar
    * o seguinte código: -1 (o jogo pode continuar), 0 (ocorreu um empate), 1 (O venceu) e 2 (X
    * venceu).
    */
    public static int status (char M[ ][ ]){
        // Verificação se o circulo completou alguma sequencia 
        if((M[0][0]=='O' && M[0][0]==M[1][1] && M[2][2]==M[1][1]) || // diagonal esquerda para a direita
           (M[0][2]=='O'  && M[1][1]==M[0][2] && M[2][0]==M[1][1])|| // diagonal direita para a esquerda
           (M[0][0]=='O' && M[0][1]==M[0][0] && M[0][2]==M[0][0]) || // primeira linha
           (M[1][0]=='O' && M[1][1]==M[1][0] && M[1][2]==M[1][0]) || // segunda linha
           (M[2][0]=='O' && M[2][1]==M[2][0] && M[2][2]==M[2][0]) || // terceira linha
           (M[0][0]=='O' && M[1][0]==M[0][0] && M[2][0]==M[1][0]) || // primeira coluna
           (M[0][1]=='O' && M[1][1]==M[0][1] && M[2][1]==M[1][1]) || // segunda coluna 
           (M[0][2]=='O' && M[1][2]==M[0][2] && M[2][2]==M[1][2])    // terceira coluna
                ){
            return 1; // O venceu!
            
        } 
        
        if((M[0][0]=='X' && M[0][0]==M[1][1] && M[2][2]==M[1][1]) || // diagonal esquerda para a direita
           (M[0][2]=='X'  && M[1][1]==M[0][2] && M[2][0]==M[1][1])|| // diagonal direita para a esquerda
           (M[0][0]=='X' && M[0][1]==M[0][0] && M[0][2]==M[0][0]) || // primeira linha
           (M[1][0]=='X' && M[1][1]==M[1][0] && M[1][2]==M[1][0]) || // segunda linha
           (M[2][0]=='X' && M[2][1]==M[2][0] && M[2][2]==M[2][0]) || // terceira linha
           (M[0][0]=='X' && M[1][0]==M[0][0] && M[2][0]==M[1][0]) || // primeira coluna
           (M[0][1]=='X' && M[1][1]==M[0][1] && M[2][1]==M[1][1]) || // segunda coluna 
           (M[0][2]=='X' && M[1][2]==M[0][2] && M[2][2]==M[1][2])    // terceira coluna
                ){
            return 2; // X venceu!
            
        }
        
        /*
        * Loop de verificação para analisar cada celula do jogo.
        * Se encontrar a celula diferente de ' ', ++; em var acumuladora.
        * Se chegar a 9 (total de celulas disponiveis) retorna que empatou.
        */

        // Contadora de Jogadas
        int verificarcheio = 0;
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               if(M[i][j]!=' '){
                   verificarcheio++;
               }
            }
        }
        // Se todas preenchidas, retorna valor para indicar *empate*.
        if(verificarcheio==9){
            return 0;
        }
        // Ainda restando celulas no tabuleiro, jogo continua.
        else{
            return -1;
        }
    }
    //------------------------- 3.MÉTODO STEP DE VERIFICAÇÃO RODADAS E STATUS DO JOGO.
    
    /*
    4.Implemente um procedimento para executar a lógica deste jogo. Suponha que o jogador O
    * sempre começa. A cada jogada, a matriz do jogo deverá ser exibida na tela. Ao final do jogo,
    * seu procedimento deve mostrar o estado a que se chegou (vitória ou empate). Teste o seu
    * jogo.
    */
    public static void game(){
        Scanner entrada = new Scanner(System.in);
        
        // Inicializa Tabuleiro
        char tab[][] = initialize();

        // Inicia com Jogador: O
        char c = 'O';

        // Enquanto retornar -1 (JOGO CONTINUA)
        while(status(tab) == -1){
           boolean possivel = false;
           while(possivel==false) {
               // Exibe tabuleiro a cada jogada.
               imprimir(tab);

               // Solicita coordenadas para Jogadores
               System.out.println("Escolha uma posição para colocar o: " + c);

               // Solicita coordenada válida para Linha
               int linha;
               do {
                   System.out.println("Jogador: " + c + " | Escolha a LINHA: (1, 2 ou 3)");
                   linha = entrada.nextInt();
               } while (linha > 3);
               // Decrementa em 1 o valor da linha e coluna para ser passado como coordeanda.
               linha --;
               //---------------- COORDENADA LINHA.

               // Solicita coordenada válida para Coluna.
               int coluna;
               do {
                   System.out.println("Jogador: " + c + " | Escolha a COLUNA: (1, 2 ou 3)");
                   coluna = entrada.nextInt();
               } while (coluna > 3);
               // Decrementa em 1 o valor da linha e coluna para ser passado como coordeanda.
               coluna--;
               //---------------- COORDENADA COLUNA.

               // Teste de posição válida.
               if (step(tab, linha, coluna, c) == false) {
                   System.out.println("Escolha uma posição valida!");
               } else {
                   possivel = true;
               }
               //--------------- VALIDAÇÃO DE COORDENADA.

           }
           // Realiza troca entre jogadores
           if(c=='O'){
               c='X';
           }
           else{
               c='O';
           }
        }

        // Exibe Resultados da partida
        imprimir(tab);
        if(status(tab)==0){
            System.out.println("Ocorreu um empate!");
        }
        if(status(tab)==1){
            System.out.println("Jogador: | O | venceu!");
        }
        if(status(tab)==2) {
            System.out.println("Jogador: | X | venceu!");
        }
        // -------------- FIM DA EXIBIÇÃO DE RESULTADOS
    }
    //------------------------- 4.MÉTODO GAME PARA JOGAR E EXIBIR RESULTADO DO JOGO.
}    
        
    
    

