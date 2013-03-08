import java.util.Random;


public class ordena {

	public static int[] InsertionSort(int[] vetor){
		int pivo;
		int comp = 0;
		int troca = 0;
		for (int i = 0; i < vetor.length; i++) {
			pivo=vetor[i];
			comp++;
			int j =i-1;
			while (j>=0 &&  vetor[j] >pivo){
				vetor [j+1]= vetor[j];
				j=j-1;
				vetor[j+1] = pivo;
				troca++;
			}
			
		}
		return vetor;

		
	}
	
	public static int[] SelectionSort(int[] vetor){
		for (int i = 0; i < vetor.length ; i++) {
			int min = i;
			for (int j = i+1; j < vetor.length; j++) {
				if (vetor[j] < vetor[min]) {
					min=j;
				}
				
					int aux = vetor[min];
					vetor[min] = vetor[i];
					vetor[i]= aux;					
			}
		}
		return vetor;
	}
	
	public static int[] ShellSort(int[] vetor){
		
		double h= 1;
		while(h<=vetor.length){
			h=3*h+1;
		}
		do {
		h=(Math.floor(h));
		for (int i = (int) h; i < vetor.length; i++) {
			int pivo = vetor[i];
			int j=(int) (i-h);
			while(j >=0 && vetor[j] >pivo){
				vetor[(int) (j+h)] = vetor[j];
				j=(int) (j-h);
			}
			vetor[(int) (j+h)] = pivo;
	}
		h=h/2;
		
	} while (h>1);
		return vetor;
	}
	

		
	public static void main(String[] args) {
		String args0 = "10000";
		String args1 = "1";
		int qnt = Integer.parseInt(args0);
		int tipo = Integer.parseInt(args1);
		String modo =null;
		if(args1.equals("1")){
			modo = " Ordenado Aleatóriamente";
		}
		if(args1.equals("2")){
			modo = "Em Ordem Decrescente";
		}
		if(args1.equals("3")){
			modo = "Em Ordem Crescente";
		}
	
		
		int y[] = new int[qnt];
		switch(tipo) {
		case 1:
			
			Random generator = new Random();	
	    for (int i = 0; i < y.length; i++) {
	        y[i] = generator.nextInt(qnt*10);
	      }
		break;
		
		case 2:

			int j = 0;
			for (int i = qnt  ; i > 0; i--) {
				y[j]=i;
				j++;
			}
		break;
		
		case 3:

			for (int i = 0; i < y.length; i++) {
				y[i]=i;
			}
		break;
		}
		
		int x[] = y;
		int z[] = y;
		long startTime = System.currentTimeMillis();
		InsertionSort(y);
		long stopTime = System.currentTimeMillis();
		System.out.println("Resultado Ordenação InsertioSort Com O Vetor " + modo);
		long elapsedTime = stopTime - startTime;
	    System.out.println("InsertionSort gastou " + elapsedTime + " ms");
	    System.out.println();
	    
	    System.out.println("");
	    long startTime2 = System.currentTimeMillis();
		SelectionSort(x);
		long stopTime2 = System.currentTimeMillis();
		System.out.println("Resultado Ordenação SelectionSort Com O Vetor " + modo);
	    long elapsedTime2 = stopTime2 - startTime2;
	    System.out.println("SelectionSort gastou " + elapsedTime2 + " ms");
	    
	    
	   
	    System.out.println("");
	    long startTime3 = System.currentTimeMillis();
		ShellSort(z);
		long stopTime3 = System.currentTimeMillis();
		System.out.println("Resultado Ordenação ShellSort Com O Vetor " + modo );

		
	    long elapsedTime3 = stopTime3 - startTime3;
	    System.out.println("ShellSort gastou " + elapsedTime3 + " ms");
	}
}
