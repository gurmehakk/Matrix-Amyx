package ApA3;

public class Operations  {
	protected int m;
	protected int n;
	protected String name;
	protected int[][] matrix1;
	protected int[][] matrix2;
	
	public Operations(int m, int n, String name, int[][] matrix1, int[][] matrix2) {
		this.m=m;
		this.n=n;
		this.name=name;
		this.matrix1=matrix1;
		this.matrix2=matrix2;
		
 }  
	public static void addition(int[][] matrix1, int[][] matrix2) {
	 if((matrix1.length==matrix2.length)&&(matrix1[0].length==matrix2[0].length)) {
		 int res[][] = new int[matrix1.length][matrix1[0].length];
		 for (int i = 0; i <matrix1.length; i++){
			 for (int j = 0; j <matrix1[0].length; j++) {
				 res[i][j] = matrix1[i][j] + matrix2[i][j];
				 System.out.print(res[i][j]+ " ");
			 }System.out.println();
		 } 
	 }else {
		 System.out.println("Addition not valid");
	 } 
 } 
	public static void addition(int[][] matrix1, int singleton) {
		 
			 int res[][] = new int[matrix1.length][matrix1[0].length];
			 for (int i = 0; i <matrix1.length; i++){
				 for (int j = 0; j <matrix1[0].length; j++) {
					 res[i][j] = matrix1[i][j] + singleton;
					 System.out.print(res[i][j]+ " ");
				 }System.out.println();
			 } 
		  
	 }
	
	public static void subtraction(int[][] matrix1, int[][] matrix2) {
	 if((matrix1.length==matrix2.length)&&(matrix1[0].length==matrix2.length)) {
		 System.out.println("Result after subtracting the two matrices : ");
		 int res[][] = new int[matrix1.length][matrix1[0].length];
		 for (int i = 0; i <matrix1.length; i++){
			 for (int j = 0; j <matrix1[0].length; j++) {
				 res[i][j] = matrix1[i][j] - matrix2[i][j];
				 System.out.print(" " + res[i][j]+ " ");
			 }System.out.println();
		 } 
	 }else {
		 System.out.println("Subtraction not valid");
	 } 
 }
	public static void subtraction(int[][] matrix1, int singleton) {
			 System.out.println("Result after subtracting  : ");
			 int res[][] = new int[matrix1.length][matrix1[0].length];
			 for (int i = 0; i <matrix1.length; i++){
				 for (int j = 0; j <matrix1[0].length; j++) {
					 res[i][j] = matrix1[i][j] - singleton;
					 System.out.print(" " + res[i][j]+ " ");
				 }System.out.println();
			 } 
		  
	 }

 public static void multiplication(int[][] matrix1, int[][] matrix2) {
	 if(matrix1[0].length==matrix2.length) {
		 
		 double res[][] = new double[matrix1.length][matrix2[0].length];
		 for(int i = 0; i <matrix1.length; i++) {
	            for (int j = 0; j < matrix2[0].length; j++) {
	                for (int k = 0; k <matrix2.length; k++)
	                    res[i][j] += matrix1[i][k] * matrix2[k][j];
	            }
	        }for (int i = 0; i <res.length; i++){
				 for (int j = 0; j <res[0].length; j++) {
					 System.out.print(" " + res[i][j] + " ");
				 }System.out.println();
			 } 
		 
	 }else {
		 System.out.println("Multiplication not valid");
	 } 
 }
 public static void multiplication(int[][] matrix1, int singleton) {
	 
		 
		 double res[][] = new double[matrix1.length][matrix1[0].length];
		 for(int i = 0; i <matrix1.length; i++) {
	            for (int j = 0; j < matrix1[0].length; j++) {
	                for (int k = 0; k <matrix1.length; k++)
	                    res[i][j] += matrix1[i][k] * singleton;
	            }
	        }for (int i = 0; i <res.length; i++){
				 for (int j = 0; j <res[0].length; j++) {
					 System.out.print(" " + res[i][j] + " ");
				 }System.out.println();
			 } 
 }
public static void division(int[][] m1, int[][] m2) {
	double res[][] = new double[m1.length][m1[0].length];
	for(int i = 0; i < m1.length; i++) {
		  for(int j = 0; j <= m1[0].length; j++) {
			 res[i][j] = m1[i][j]/m2[i][j];
			 System.out.println(res[i][j]);
		  
		  }
		  System.out.println(" ");
		  }

}
public static void division(int[][] m1, int singleton) {
	double res[][] = new double[m1.length][m1[0].length];
	for(int i = 0; i < m1.length; i++) {
		  for(int j = 0; j <= m1[0].length; j++) {
			 res[i][j] = m1[i][j]/singleton;
			 System.out.println(res[i][j]);
		  
		  }
		  System.out.println(" ");
		  }
	
	
}
public static void rowwisemean(int m , int n , int[][] matrix) {
	int sum;
	for(int i = 0; i <m; i++){    
        sum = 0;    
        for(int j = 0; j <n; j++){    
          sum = sum + matrix[i][j];    
        }    
        System.out.println(" "+sum/n+ " ");    
    } 
}
public static int[][] transpose(int[][] mt) {
	int[][] tran = new int[mt[0].length][mt.length];
    for (int i = 0; i <mt[0].length; i++) {
        for (int j = 0; j < mt.length; j++) {
            tran[i][j] = mt[j][i];
        }
    }return tran;
}
public static int determinant(int[][] matrix) {
if (matrix.length == 1)
    return (matrix[0][0]);
if (matrix.length == 2)
    return (matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1]);
if(matrix.length==3) {
	int x=(matrix[0][0] * (matrix[1][1] * matrix[2][2]
            - matrix[1][2] * matrix[2][1]));
int y=(matrix[0][1] * (matrix[1][0] * matrix[2][2]
            - matrix[1][2] * matrix[2][0]));
int z=(matrix[0][2] * (matrix[1][0] * matrix[2][1]
            - matrix[1][1] * matrix[2][0]));
return(x - y + z);
}
return 0;
}

public static int[][] inverse(int[][] matrix) {
	int[][] invres = new int[matrix.length][matrix.length];
	if (matrix.length == 1) {
		invres[0][0] = 1/matrix[0][0];
	    return (invres);
}else if (matrix.length == 2) {
	    int d = determinant(matrix);
		invres[0][0] = matrix[1][1]/d;
		invres[1][1] = matrix[0][0]/d;
		invres[0][1] = - matrix[0][1]/d;
		invres[1][0] = - invres[1][0]/d;
	    return (invres);
	}else if(matrix.length==3) {
		int d = determinant(matrix);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3;j++) {
				invres[i][j] = (((matrix[(j+1)%3][(i+1)%3] * matrix[(j+2)%3][(i+2)%3]) - 
						(matrix[(j+1)%3][(i+2)%3] * matrix[(j+2)%3][(i+1)%3]))/ d);
			}
		}
		
	return invres;
	}
	return invres;
	
}
public static void colwisemean(int m, int n, int[][] matrix) {
	int sum;
	for(int i=0; i<n; i++){    
        sum = 0;    
        for(int j=0; j<m; j++){    
          sum = sum + matrix[j][i];    
        }    
        System.out.println(" " + sum/m + " ");    
    }  
	
}
public static void overallmean(int m, int n, int[][] matrix) {
	int sum = 0;
	for(int i=0;i<m;i++){ 
     for(int j=0;j<n;j++){ 
       sum = sum + matrix[i][j];
    }
}
    float average=sum/(m*n);
    System.out.println("The overall mean of all the elements of the matrix is : ");
    System.out.println(average);
	
}
public static void Eigenvalue(int[][] matrix) {
	int a = matrix[0][0]+matrix[1][1];
	double b = Math.pow((matrix[0][0]-matrix[1][1]),2);
	int c = matrix[0][1]*matrix[1][0];
	double d = Math.sqrt( b + 4*c);
	double e1 = (a + d)/2;
	double e2 = (a - d)/2;
	System.out.println("Eigen values are: \n");
	System.out.println(e1 + "\n");
	System.out.println(e2);
}
public static void Eigenvector(int[][] matrix) {
	int a = matrix[0][0]+matrix[1][1];
	double b = Math.pow((matrix[0][0]-matrix[1][1]),2);
	int c = matrix[0][1]*matrix[1][0];
	double d = Math.sqrt( b + 4*c);
	double e1 = (a + d)/2;
	double e2 = (a - d)/2;
	System.out.println("Eigen vectors are: ");
	double tempx;
	double tempy;
	for (double y = -1000; y <= 1000; y++) {
        for (double x = -1000; x <= 1000; x++) {
            if ((((matrix[0][0]-e1)*x + matrix[0][1]*y) == 0) && 
            	((matrix[1][0]*x + (matrix[1][1]-e1)*y )== 0)) {
            	tempx = x;
                tempy = y;
                System.out.println( "\n ("+ x + "," + y + ")\n");
            }
        }
    }   
    for (double y = -10; y <= 10; y++) {
        for (double x = -10; x <= 10; x++) {
            if ((((matrix[0][0]-e2)*x + matrix[0][1]*y) == 0) && 
            	((matrix[1][0]*x + (matrix[1][1]-e2)*y) == 0)) {
            	tempx = x;
                tempy = y;
                System.out.println("\n (" + x + "," + y + ")\n");
            }
        }
    }
	
}
public static void solvelin(int[][] matrix, int[][] cons) {
	char []var = {'x', 'y', 'z'};
	for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix.length; j++){
            System.out.print(" "+matrix[i][j]);
        }
        System.out.print("  "+ var[i]);
        System.out.print("  =  "+ cons[i][0]);
        System.out.println();
    }
	int[][] minv = inverse(matrix);
	multiplication(minv,cons);
	
}

	
}
 
    
 
	



