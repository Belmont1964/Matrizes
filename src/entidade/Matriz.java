package entidade;
import java.util.*;

public class Matriz {
	double soma = 0;
	double aux = 0;

	ArrayList <Double> path = new ArrayList <> ();
	int pathIndex = 0;
		
	Scanner entra = new Scanner (System.in);

	
	public double [][] criaMatriz (int n, int m) {
		double [][] mat = new double [n][m];
		for (int i=0; i<mat.length ; i++) {
			for (int j=0; j<mat[0].length ; j++) {
				System.out.print("Digite o elemento ["+i+"]["+j+"]: ");
				mat[i][j] = entra.nextDouble();				
			}
		}
		return mat;		
	}
	
	
	public static void imprimeMatriz (double[][] mat) {
		System.out.println("  ");
		System.out.println(" MATRIZ ");
		for (int i=0; i<mat.length ; i++) {
			for (int j=0; j<mat[0].length ; j++) {
				System.out.printf(" %06.2f", mat[i][j]);				
			}
			System.out.println();
		}
	}
	
	
	public static void imprimeVetor(double[] vec) {
		if (vec.length != 0) {
			System.out.println();
			System.out.print(" VETOR ");
			for (int i=0; i<vec.length; i++) {
				System.out.printf(" %.2f", vec[i]);	
			}
			System.out.println();
		}
		
	}
	
	public double [] diagonalSecundaria (double[][] mat) {
		if (mat.length != mat[0].length) {
			double [] vec = new double [0];
			System.out.println();
			System.out.println(" MATRIZ NAO QUADRADA ");
			return vec;
		}
		else {
			double vec[] = new double [mat.length];
			int j = vec.length - 1;
			for (int i=0; i<mat.length; i++) {
				vec[i] = mat [i][j];
				j -= 1;				
			}
			return vec;
		}
	}

	
	public double [] diagonalPrincipal (double[][] mat) {
		if (mat.length != mat[0].length) {
			double [] vec = new double [0];
			System.out.println();
			System.out.println(" MATRIZ NAO QUADRADA ");
			return vec;
		}
		else {
			double vec[] = new double [mat.length];
			for (int i=0; i<mat.length; i++) {
				vec[i] = mat [i][i];
			}
			return vec;
		}
	}
	
	// TEOREMA DE LAPLACE PARA DETERMINANTES
	//https://www.infoescola.com/matematica/teorema-de-laplace/
	
	public double determinante (double [][] mat) {
		double num;
		
		if (mat.length != mat[0].length) {
			System.out.println(" MATRIZ NAO QUADRADA ");
			return 0;
		}
		else {
			double [][] novaMat;
			if (mat.length > 2) {	
				for (int c=0; c<1; c++) {
					for (int i = 0; i<mat.length; i++) {	
						int ordem = mat.length - 1;
						int nmi = 0; 					
						novaMat = new double [ordem][ordem];
						for (int j=0; j<mat.length; j++) {
							if (i != j) {
								int nmj = 0;
								for (int k=0; k<mat.length; k++) {						
									if (k != c) {
										novaMat[nmi][nmj] = mat[j][k];
										nmj += 1;
									}
								}
								nmi += 1;
							}
							else {
								int arg = (i+1)+(c+1);
								num = mat[i][c]*Math.pow(-1, arg);
								path.add(num);
								pathIndex += 1;									
								//System.out.println( );
								
							}
						}
						
						//Matriz.imprimeMatriz(novaMat);
						//System.out.print (/*"mat.lenght; "+mat.length+*/"   path"+path);
						if (novaMat.length == 2) {
							double coef = 1;
							for (Double z : path) {
								coef *= z;	
							}
							soma = soma + coef*this.determinante2x2(novaMat);
							//System.out.println();
							//System.out.println("coef = "+coef+" determinante ="+this.determinante2x2(novaMat)+"  soma ="+soma);
						}
						
						if (mat.length == 3) {
							pathIndex -= 1;
							path.remove(pathIndex);
						}					
						
						this.determinante(novaMat);
					}
				}
				pathIndex = 0;
				path.clear();
			}
			else {
				return this.determinante2x2(mat);
			}
		}
	
		return soma;
	}
	
	private double determinante2x2 (double[][] mat) {
		if (mat.length<2) {
			return mat[0][0];
		}
		else {
			double [] dp = this.diagonalPrincipal(mat);
			double [] ds = this.diagonalSecundaria(mat);
			return dp[0]*dp[1] - ds[0]*ds[1];
		}
	}
	
	
	public double [][] multiplicaMatriz (double[][] mat1, double[][] mat2){
		double aux = 0;
		double [][]result = new double [0][0];
		if (mat1[0].length == mat2.length) {
			result = new double[mat1.length][mat2[0].length];
			for (int i=0; i<result.length; i++) {
				for (int j=0; j<result[0].length; j++) {
					for (int c=0; c<mat1[0].length; c++) {						
						//System.out.print(mat1[i][c]+" * "+mat2[c][j]+" + ");
						aux = aux + mat1[i][c]*mat2[c][j];
					}
					//System.out.print (" = "+aux);
					System.out.println();
					result[i][j] = aux;
					aux = 0;
				}
			}
		}
		if (result.length == 0) {
			System.out.println();
			System.out.println(" A OPERAÃ‡ÃƒO Ã‰ IMPOSSÃVEL ");
		}
		return result;
	}
	
	public double[][] somaMatriz (double[][] mat1, double[][] mat2) {		
		double [][] soma = new double [0][0];
		if (mat1.length == mat2.length && mat1[0].length == mat2[0].length) {
			soma = new double [mat1.length][mat1[0].length];
			for (int i=0; i<mat1.length; i++) {
				for (int j=0; j<mat1[0].length; j++) {
					soma [i][j] = mat1[i][j] + mat2[i][j];
				}
			}
		}
		if (soma.length == 0) {
			System.out.println();
			System.out.println(" A OPERAÃ‡ÃƒO Ã‰ IMPOSSÃVEL ");
		}
		return soma;
	}
	
	public double [][] matrizTransposta (double [][]mat){
		double[][] transp = new double [mat[0].length][mat.length];
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[0].length; j++) {
				transp[j][i] = mat[i][j];
			}
		}
		return transp;
	}
	
	//  https://www.infoescola.com/matematica/matriz-adjunta/
	public double [][] matrizInversa (double[][]mat){
		double det = this.determinante(mat);
		double [][] result = new double [0][0];
		if (det != 0) {
			result = new double [mat.length][mat.length];
			if (mat.length == mat[0].length) {
				int ordem = mat.length - 1;
				double [][] menor= new double [ordem][ordem];
				double [][] cofator = new double [mat.length][mat.length];
				for (int x=0; x<mat.length; x++) {             // CONTROI MATRIZ DE COFATORES
					for (int y=0; y<mat[0].length; y++) {				
						int m=0;
						int n=0;
						for (int i=0; i<mat.length; i++) {           // PERCORRER MATRIZ ORIGINAL 
							for (int j=0; j<mat[0].length; j++) {    // E CONSTROI AS MATRIZES MENOR
								if (i != x && j != y) {
									if (n < ordem) {
										menor [m][n] = mat[i][j];
										n++;
									}
									else {
										n=0;
										m++;
										menor [m][n] = mat[i][j];
										n++;
									}
								}
							}
						}
						
						int exp = (x+1)+(y+1);
						cofator[x][y] = Math.pow(-1, exp)*this.determinante(menor);
						
						//Matriz.imprimeMatriz(menor);
						//System.out.println("cofator ["+(x+1)+"]["+(y+1)+"] = "+cofator[x][y]);
						//System.out.println("x = "+x+"  y = "+y);
						//Matriz.imprimeMatriz(cofator);
					}
				}
				double[][]adj;
				adj = this.matrizTransposta(cofator);
				//Matriz.imprimeMatriz(adj);	
				System.out.println("Determinante ="+det);
				for (int i=0 ; i<mat.length; i++) {
					for (int j=0 ; j<mat[0].length; j++) {
						result[i][j] = adj[i][j]/det;
					}
				}
			}
		}
		return result;
	}
	
}

