package principal;

import java.util.*;
import entidade.Matriz;

public class App {

	public static void main(String[] args) {

		Scanner entra = new Scanner (System.in);
		
		
		int n, m, escolha;
		double det;
		double [][]mm;	
		double [][]mm1;
		double [][]mm2;
		double [] vec;
		Matriz mat = new Matriz();;
		
		do  {
			System.out.println ();
			System.out.println ("1- Determinante");
			System.out.println ("2- MultiplicaÃ§Ã£o de Matrizes");
			System.out.println ("3- Soma de Matrizes");
			System.out.println ("4- Matriz Transposta");
			System.out.println ("5- Matriz Inversa");
			System.out.println ("6- Diagonal Principal");
			System.out.println ("7- Diagonal SecundÃ¡ria");
			System.out.println ("9- FIM");
			
			escolha = entra.nextInt();
			
			switch (escolha) {			
			case 1:	
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm = mat.criaMatriz(n, m);
				Matriz.imprimeMatriz(mm);
				det = mat.determinante(mm);
				System.out.println ("Determinante: "+det);
				break;
				
			case 2:
				mat = new Matriz();
				System.out.println ();
				System.out.println ("Entre a Matriz 1");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm1 = mat.criaMatriz(n, m);
				
				System.out.println ();
				System.out.println ("Entre a Matriz 2");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm2 = mat.criaMatriz(n, m);
								
				double [][] produto;
				produto = mat.multiplicaMatriz(mm1,mm2);
				Matriz.imprimeMatriz(mm1);
				Matriz.imprimeMatriz(mm2);
				Matriz.imprimeMatriz(produto);
				break;
				
			case 3:
				mat = new Matriz();
				System.out.println ();
				System.out.println ("Entre a Matriz 1");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm1 = mat.criaMatriz(n, m);
				
				System.out.println ();
				System.out.println ("Entre a Matriz 2");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm2 = mat.criaMatriz(n, m);
								
				double [][] soma;
				soma = mat.somaMatriz(mm1,mm2);
				Matriz.imprimeMatriz(mm1);
				Matriz.imprimeMatriz(mm2);
				Matriz.imprimeMatriz(soma);
				break;
				
			case 4:
				System.out.println ();
				System.out.println ("Entre a Matriz 1");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm = mat.criaMatriz(n, m);
				Matriz.imprimeMatriz(mm);
				double[][] transp = mat.matrizTransposta(mm);
				Matriz.imprimeMatriz(transp);
				break;
				
			case 5:
				System.out.println ();
				System.out.println ("Entre a Matriz 1");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm = mat.criaMatriz(n, m);
				Matriz.imprimeMatriz(mm);
				double[][] inversa = mat.matrizInversa(mm);
				System.out.println ("MATRIZ INVERSA");
				Matriz.imprimeMatriz(inversa);
				break;
							
			case 6:
				System.out.println ();
				System.out.println ("Entre a Matriz 1");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm = mat.criaMatriz(n, m);
				Matriz.imprimeMatriz(mm);
				vec = mat.diagonalPrincipal(mm);
				Matriz.imprimeVetor(vec);
				break;
			
			case 7:
				System.out.println ();
				System.out.println ("Entre a Matriz 1");
				System.out.print(" Digite o numero de linhas: ");
				n = entra.nextInt();
				System.out.print(" Digite o numero de colunas: ");
				m = entra.nextInt();
				mm = mat.criaMatriz(n, m);
				Matriz.imprimeMatriz(mm);
				vec = mat.diagonalSecundaria(mm);
				Matriz.imprimeVetor(vec);
				break;
				
			case 9:
				break;
								
			}
			
		}while (escolha != 9);
			
		entra.close();
	}

}

