package ApA3;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static HashMap<String,int[][]> all =new HashMap<>();
	static HashMap<String,int[][]> Rectangular =new HashMap<>();
	static HashMap<String,int[][]> Row =new HashMap<>();
	static HashMap<String,int[][]> Column =new HashMap<>();
	static HashMap< String,int[][]> Square =new HashMap<>();
	static HashMap<String,int[][]> Symmetric =new HashMap<>();
	static HashMap<String,int[][]> Skewsymmetric =new HashMap<>();
	static HashMap<String,int[][]> Uppertri =new HashMap<>();
	static HashMap<String,int[][]> Lowertri =new HashMap<>();
	static HashMap<String,int[][]> Singular =new HashMap<>();
	static HashMap<String,int[][]> Diagonal =new HashMap<>();
	static HashMap<String,int[][]> Scalar =new HashMap<>();
	static HashMap<String,int[][]> Identity =new HashMap<>();
	static HashMap<String,int[][]> Singleton =new HashMap<>();
	static HashMap<String,Integer> Singscalar =new HashMap<>();
	static HashMap<String,int[][]> Ones =new HashMap<>();
	static HashMap<String,int[][]> Null =new HashMap<>();
	
	
	public static void main(String[] args) {
		while(true) {
		System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\r\n"
				+ "2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\r\n"
				+ "3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\r\n"
				+ "4. Display all the matrix-type labels of a requested matrix. \r\n"
				+ "5. Perform addition, subtraction, multiplication & division.\r\n"
				+ "6. Perform element-wise operations.\r\n"
				+ "7. Transpose matrices.\r\n"
				+ "8. Inverse matrices.\r\n"
				+ "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\r\n"
				+ "10. Compute determinants.\r\n"
				+ "11. Use singleton matrices as scalars, if requested.\r\n"
				+ "12. Compute A+AT\r\n"
				+ "for a matrix A.\r\n"
				+ "13. Compute Eigen vectors and values.\r\n"
				+ "14. Solve sets of linear equations using matrices.\r\n"
				+ "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\r\n"
				+ "");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if(input==1) {
			System.out.println("Enter name of matrix(Eg. Add an alphabet 'a' as name) : ");
			String name = sc.next();
			System.out.println("Enter The Number Of Rows in Matrix: ");
	        int m = sc.nextInt();
	        System.out.println("Enter The Number Of Columns in Matrix: ");
	        int n = sc.nextInt();
	        int[][] matrix = new int[m][n];
	        System.out.println("Enter Matrix Data");
	          
	          for (int i = 0; i < m; i++)
	          {
	              for (int j = 0; j < n; j++)
	              {
	                  matrix[i][j] = sc.nextInt();
	              }
	          }
	        all.put(name,matrix);
	        if(m!=n) {
	        	int rn = -1;
	        	int ro = -1;
	        	Rectangular.put(name, matrix);
	        	if(m==1) {
	        		Row.put(name, matrix);
	        	}if(n==1)Column.put(name, matrix);
	        	
	        }
	        else if(m==n){
	        	Square.put(name, matrix);
	        	//check symmetric
	        	int[][] transpose = new int[m][m];
				SymmetricM sm = new SymmetricM(m,m,name,matrix,transpose);
				int flag = 1;
			    for (int i = 0; i < m; i++)
			         for (int j = 0; j < m; j++)
			            if (sm.transpose[i][j] != sm.matrix[i][j])flag = 0;
			            if (flag == 1) {
			            	Symmetric.put(name, sm.matrix);
			            }
			    //check skew sym
	            int[][] sksem = new int[m][m];
				SkewsymmetricM ssm = new SkewsymmetricM(m,m,name,matrix,sksem);
				int fl = 1;
			    for (int i = 0; i < m; i++)
			         for (int j = 0; j < m; j++)
			            if (ssm.sksem[i][j] != -(ssm.matrix[i][j]))fl = 0;
			            if (fl == 1) {
			            	Skewsymmetric.put(name, ssm.matrix);
			            }
			   //check upper-tri
	            for (int i = 1; i < m; i++)
					for (int j = 0; j < i; j++)
						if (matrix[i][j] != 0)
							flag = 0;
						else		
							flag = 1;
		
				if (flag == 1)
					Uppertri.put(name, matrix);
				
			 //check lower-tri
			  for (int i = 0; i < m; i++)
				for (int j = i + 1; j < m; j++)
					if (matrix[i][j] != 0)
						flag = 0;
					else		
						flag = 1;
						
			  if (flag == 1)
					Lowertri.put(name, matrix);
			  
			  //check diagonal
			  int c=0;
			    for(int i=0;i<m;i++){
			        for(int j=0;j<m;j++){
			        if(i!=j && matrix[i][j]!=0){
			            c=1;
			            break;
			        }
			        }
			    }
			    if(c==0) {
			        Diagonal.put(name, matrix);
			        Uppertri.put(name, matrix);
			        Lowertri.put(name, matrix);
			    }   
			    
			    // check singular
			    if(Operations.determinant(matrix)==0) {
			    	Singular.put(name, matrix);
			    }
			    //check scalar
			    int point=0;
			    for(int i=0;i<m;i++){
			        for(int j=0;j<m;j++){
			        if(i!=j && matrix[i][j]!=0){
			            point=1;
			            break;
			        }
			        if(i==j && matrix[i][j]!=matrix[i][j]){
			            point=1;
			            break;
			        }
			        }
			    }
			    if(point!=1)
			    	Scalar.put(name, matrix);
			        Diagonal.put(name, matrix);
			   
			   //check identity
			    int f = 1;
		        for(int i = 0; i <m; i++){    
	                for(int j = 0; j <m; j++){    
	                  if(i == j && matrix[i][j] != 1){    
	                      f = 0;    
	                      break;    
	                  }    
	                  if(i != j && matrix[i][j] != 0){    
	                      f = 0;    
	                      break;    
	                  }    
	                }    
	            }if(f==1) {   
	                Identity.put(name, matrix);
	            }
	            
	            if(m==1&&n==1) {
	            	Singleton.put(name, matrix);
	            }
	        }
	        else {
	        	//check null
	        	int ch=0;
	            for(int i=0;i<m;i++){
	                for(int j=0;j<n;j++){
	                    if(matrix[i][j]!=0){
	                        ch=1;
	                        break;
	                    }
	                }
	                if(ch==1)
	                    break;
	            }
	            if(ch!=1&&(m!=n)) {
	            	Rectangular.put(name, matrix);
	            	Null.put(name, matrix);
	        }else if(ch!=1 && m==n) {
	        	Square.put(name, matrix);
	        	Null.put(name, matrix);
	    }
	       //check ones
            int on=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]!=1){
                        on=1;
                        break;
                    }
                }
                if(on==1)
                    break;
            }
            if(on!=1&&(m!=n)) {
            	Rectangular.put(name, matrix);
            	Ones.put(name, matrix);
        }else if(on!=1 && m==n) {
        	Square.put(name, matrix);
        	Ones.put(name, matrix);
    } 

	    
	        }

	        
		}if(input==2) {
			System.out.println("1. Rectangular Matrix\r\n"
					+ "2. Row Matrix\r\n"
					+ "3. Column Matrix\r\n"
					+ "4. Square Matrix\r\n"
					+ "5. Symmetric Matrix\r\n"
					+ "6. Skew-symmetric Matrix\r\n"
					+ "7. Upper-triangular Matrix\r\n"
					+ "8. Lower-triangular Matrix\r\n"
					+ "9. Singular Matrix\r\n"
					+ "10. Diagonal Matrix\r\n"
					+ "11. Scalar Matrix\r\n"
					+ "12. Identity Matrix\r\n"
					+ "13. Singleton Matrix\r\n"
					+ "14. Ones Matrix\r\n"
					+ "15. Null Matrix");
			System.out.println("Enter Type of matrix you want to create: ");
			int type = sc.nextInt();
			System.out.println("Enter name of matrix(Eg. Add an alphabet 'a' as name) : ");
			String name = sc.next();
			System.out.println("Enter The Number Of Rows in Matrix: ");
	        int m = sc.nextInt();
	        System.out.println("Enter The Number Of Columns in Matrix: ");
	        int n = sc.nextInt();
	        int[][] matrix = new int[m][n];
	        System.out.println("Enter Matrix Data");
	          
	          for (int i = 0; i < m; i++)
	          {
	              for (int j = 0; j < n; j++)
	              {
	                  matrix[i][j] = sc.nextInt();
	              }
	          }
	        all.put(name,matrix);
			if(type==1||type==2||type==3) {
				rectangularmatrix r = new rectangularmatrix(m,n,name,matrix);
				Rectangular.put(name,r.matrix);
				if(type==2) {
					RowM row = new RowM(1,n,name,matrix);
					Row.put(name,row.matrix);
				}if(type==3) {
					ColumnM cm = new ColumnM(m,1,name,matrix);
					Column.put(name,cm.matrix);
				}
			}if(type==4||type==5||type==6||type==7||type==8||type==9
					||type==10||type==11||type==12||type==13) {
				squarematrix s = new squarematrix(m,m,name,matrix);
				Square.put(name,s.matrix);
				if(type==5) {
					int[][] transpose = new int[m][m];
					SymmetricM sm = new SymmetricM(m,m,name,matrix,transpose);
					int flag = 1;
				    for (int i = 0; i < m; i++)
				         for (int j = 0; j < m; j++)
				            if (sm.transpose[i][j] != sm.matrix[i][j])flag = 0;
				            if (flag == 1) {
				            	Symmetric.put(name, sm.matrix);
				            }
				}if(type==6) {
					int[][] sksem = new int[m][m];
					SkewsymmetricM ssm = new SkewsymmetricM(m,m,name,matrix,sksem);
					int fl = 1;
				    for (int i = 0; i < m; i++)
				         for (int j = 0; j < m; j++)
				            if (ssm.sksem[i][j] != -(ssm.matrix[i][j]))fl = 0;
				            if (fl == 1) {
				            	Skewsymmetric.put(name, ssm.matrix);
				            }
			  }if(type==7){
				  for (int i = 0; i <m; i++) {
		                for (int j = 0; j < m; j++) {
		                    if (i > j) {
		                        matrix[i][j] = 0;
		                    }
		                }
		            }UppertriM utri = new UppertriM(m,m,name,matrix);
		            Uppertri.put(name,utri.matrix);  
			  }if(type==8) {
				  for (int i = 0; i <m; i++) {
		                for (int j = 0; j < m; j++) {
		                    if (i < j) {
		                        matrix[i][j] = 0;
		                    }
		                }
		            }LowertriM ltri = new LowertriM(m,m,name,matrix);
		            Lowertri.put(name,matrix);
			  }if(type==9) {
				  SingularM sing = new SingularM(m,m,name,matrix);
				  Singular.put(name,matrix);
			  }if(type==10||type==11||type==12){
				  DiagonalM d = new DiagonalM(m,m,name,matrix);
				  Diagonal.put(name, d.matrix);
				  if(type==11||type==12) {
					  ScalarM scl = new ScalarM(m,m,name,matrix);
					  Scalar.put(name, scl.matrix);
					  if(type==12) {
						  IdentityM im = new IdentityM(m,m,name,matrix);
						  Identity.put(name, im.matrix);
					  }  
				  } 
			  }if(type==13) {
				  SingletonM sim = new SingletonM(1,1,name,matrix);
				  Singleton.put(name,sim.matrix);
			  }
			}if(type==14) {
				 Ones.put(name, matrix);
				  if(m==n)Square.put(name, matrix);
				  else Rectangular.put(name, matrix);
			  }if(type==15) {
				  Null.put(name, matrix);
				  if(m==n)Square.put(name, matrix);
				  else Rectangular.put(name, matrix);
				  
			  }	
		}if(input==3) {
			System.out.println("Enter name of matrix you want to change values of : ");
			String mat = sc.next();
			if(all.containsKey(mat)) {
				int[][] change = all.get(mat);
				System.out.println("Enter New Matrix Data");
		          for (int i = 0; i <change.length; i++){
		              for (int j = 0; j <change[0].length; j++){
		                  change[i][j] = sc.nextInt();
		              }
		          }
		        all.replace(mat,change);
		        if(Rectangular.containsKey(mat)) {
		        	Rectangular.replace(mat, change);
		        	if(Row.containsKey(mat)) Row.replace(mat, change);
		        	if(Column.containsKey(mat)) Column.replace(mat, change);
		        	if(Ones.containsKey(mat)) Ones.replace(mat, change);
		        	if(Null.containsKey(mat)) Null.replace(mat, change);
		        }if(Square.containsKey(mat)) {
		        	Square.replace(mat, change);
		        	if(Symmetric.containsKey(mat)) Symmetric.replace(mat, change);
		        	if(Skewsymmetric.containsKey(mat)) Skewsymmetric.replace(mat, change);
		        	if(Uppertri.containsKey(mat)) Uppertri.replace(mat, change);
		        	if(Lowertri.containsKey(mat)) Lowertri.replace(mat, change);
		        	if(Singular.containsKey(mat)) Singular.replace(mat, change);
		        	if(Diagonal.containsKey(mat)) Diagonal.replace(mat, change);
		        	if(Scalar.containsKey(mat)) Scalar.replace(mat, change);
		        	if(Identity.containsKey(mat)) Identity.replace(mat, change);
		        	if(Ones.containsKey(mat)) Ones.replace(mat, change);
		        	if(Null.containsKey(mat)) Null.replace(mat, change);
		        }
		        
			}
		}if(input==4) {
			System.out.println("Enter the name of matrix for which you want to know "
					+ "all the matrix-type labels");
			String name = sc.next();
			if(Rectangular.containsKey(name)) {
				System.out.println("Rectangualr-matrix");
				if(Row.containsKey(name)) {
					System.out.println("Row-matrix");
				}if(Column.containsKey(name)) {
					System.out.println("Column-matrix");
				}if(Ones.containsKey(name)) {
					System.out.println("Ones-matrix");
				}if(Null.containsKey(name)) {
					System.out.println("Null-matrix");
				}
			}if(Square.containsKey(name)) {
				System.out.println("Square-matrix");
				if(Symmetric.containsKey(name)) {
					System.out.println("Symmetric-matrix");
				}if(Skewsymmetric.containsKey(name)) {
					System.out.println("Skew-symmetric-matrix");
				}if(Uppertri.containsKey(name)) {
					System.out.println("Upper-Triangular-matrix");
				}if(Lowertri.containsKey(name)) {
					System.out.println("Lower-Triangular-matrix");
				}if(Singular.containsKey(name)) {
					System.out.println("Singular-matrix");
				}if(Diagonal.containsKey(name)) {
					System.out.println("Diagonal-matrix");
					if(Scalar.containsKey(name)) {
						System.out.println("Scalar-matrix");
						if(Identity.containsKey(name)) {
							System.out.println("Identity-matrix");
						}
					}
				}if(Singleton.containsKey(name)) {
					System.out.println("Singleton-matrix");
				}if(Ones.containsKey(name)) {
					System.out.println("Ones-matrix");
				}if(Null.containsKey(name)) {
					System.out.println("Null-matrix");
				}
			}
		}if(input==5) {
			System.out.println("1. Addition\n 2. Subtraction/n 3. Multiplication\n 4.Division\n");
			System.out.println("Choose which operation to perform: ");
			int c = sc.nextInt();
			System.out.println("Enter name of 1st matrix: ");
			String a = sc.next();
			int[][] m1 = all.get(a);
			System.out.println("Enter name of 2nd matrix: ");
			String b = sc.next();
			int[][] m2 = all.get(b);
			if(c==1) {
				System.out.println("Sum of the two matrices is : ");
				Operations.addition(m1,m2);				
			}
			if(c==2)Operations.subtraction(m1,m2);
			if(c==3) {
				System.out.println("Result after multipling the two matrices : ");
				Operations.multiplication(m1,m2);
			}
			if(c==4)Operations.division(m1,m2);
		}if(input==6) {
			System.out.println("Enter name of 1st matrix to perform elementwise operations : ");
			String t = sc.next();
			int[][] m1 = all.get(t);
			System.out.println("Enter name of 1st matrix to perform elementwise operations : ");
			System.out.println("(make sure dimensions are same)");
			String u = sc.next();
			int[][] m2 = all.get(u);
			System.out.println("Choose operation : ");
			System.out.println("1. Element wise multiplication \n2.Element wise division");
			int el = sc.nextInt();
			if(el==1) {
			float[][] res = new float[m1.length][m1[0].length];
            for(int i = 0; i <m1.length; i++){
                for(int j = 0; j <m1[0].length; j++){
                    res[i][j] = m1[i][j] * m2[i][j];
                    System.out.println(res[i][j]);
                }System.out.println();
            }
        }
	    if(el==2) {
	    	float[][] res = new float[m1.length][m1.length];
	        for(int i = 0; i <m1.length; i++){
	            for(int j = 0; j <m1.length; j++){
	                if(m2[i][j] == 0){
	                    System.out.println("error: division by zero : means zero is present in second matrix ");
	                    break;
	                }
	                else{
	                    res[i][j] = (float)m1[i][j] / (float)m2[i][j];
	                }
	            }
	        }
	        for(int i = 0; i <m1.length; i++){
                for(int j = 0; j <m1[0].length; j++){
                    System.out.println(res[i][j]);
                }System.out.println();
            }
	    }
	
			
		}if(input==7) {
			System.out.println("Enter name of matrix to transpose : ");
			String t = sc.next();
			int[][] mt = all.get(t);
			int tran[][] = Operations.transpose(mt);
			for (int i = 0; i <tran.length; i++){
				 for (int j = 0; j <tran[0].length; j++) {
					 System.out.print(" " + tran[i][j] + " ");
				 }System.out.println();
			 }
		}if(input==8) {
			System.out.println("Enter name of matrix to inverse : ");
			String t = sc.next();
			int[][] matrix = all.get(t);
			if(matrix.length!=matrix[0].length){
				System.out.println("Inverse doesn't exist for non-square matrices");
			}
			else {
			int[][] invres = Operations.inverse(matrix);
			for (int i = 0; i <invres.length; i++){
				 for (int j = 0; j <invres[0].length; j++) {
					 System.out.print(" " + invres[i][j] + " ");
				 }System.out.println();
			 }
			
			}
			
		}if(input==9) {
			System.out.println("Compute-means :\n"
					+ " 1.Row-wise mean\n 2.Column-wise mean \n 3.Mean of all the elements : ");
			int o = sc.nextInt();
			System.out.println("Enter name of matrix to do the requested operation : ");
			String t = sc.next();
			int[][] matrix = all.get(t);
			if(o==1) Operations.rowwisemean(matrix.length,matrix[0].length,matrix);
			if(o==2) Operations.colwisemean(matrix.length,matrix[0].length,matrix);
			if(o==3) Operations.overallmean(matrix.length,matrix[0].length,matrix);
			
		}if(input==10) {
			System.out.println("Enter name of matrix to find determinant : ");
			String t = sc.next();
			int[][] md = all.get(t);
			if(md.length!=md[0].length){
				System.out.println("Determinant doesn't exist for non-square matrices");
			}
			else {
			int a = Operations.determinant(md);
			System.out.println(a);
			}
		}if(input==11){
			System.out.println(" Do you allow using singleton matrices as a scalar value?(yes/no)");
			String yn = sc.next();
			if(yn=="yes") {
				System.out.println("Choose a singleton matrix:");
				String t = sc.next();
				int[][] sm = Singleton.get(t);
				Singscalar.put(t,sm[0][0]);
				System.out.println("1. Addition\n 2. Subtraction/n 3. Multiplication\n 4.Division\n");
				System.out.println("Choose which operation to perform: ");
				int c = sc.nextInt();
				System.out.println("Enter name of 1st matrix: ");
				String a = sc.next();
				int[][] m1 = all.get(a);
				System.out.println("2nd value is the singleton matrix you are using as scalar value");
				if(c==1) {
					System.out.println("Sum of the two matrices is : ");
					Operations.addition(m1,sm[0][0]);				
				}
				if(c==2)Operations.subtraction(m1,sm[0][0]);
				if(c==3) {
					System.out.println("Result after multipling the two matrices : ");
					Operations.multiplication(m1,sm[0][0]);
				}
				if(c==4)Operations.division(m1,sm[0][0]);
			}
			
		}if(input==12) {
			System.out.println("Enter name of matrix to find its A+At : ");
			String t = sc.next();
			int[][] mt = all.get(t);
			int tr[][] = Operations.transpose(mt);
			Operations.addition(mt, tr);
		}if(input==13) {
			System.out.println("1.Find Eigen value of matrix\n 2.Find Eigenvectors of matrix");
			int e = sc.nextInt();
			System.out.println("Enter name of matrix : ");
			String nm = sc.next();
			int[][] matrix = all.get(nm);
			if(e==1) {
				if(matrix.length==1 && matrix[0].length==1)System.out.println("Eigenvalue = "+ matrix[0][0]);
				else {
					Operations.Eigenvalue(matrix);
				}
			}if(e==2) {
				if(matrix.length==1 && matrix[0].length==1)System.out.println("Eigenvector = 1");
				else {
					Operations.Eigenvector(matrix);
				}
			}
			
		}if(input==14) {
			System.out.println("Choose a square matrix: ");
			String a = sc.next();
			System.out.println("Choose a column matrix. Note: this should have same number of rows as the one you \r\n"
					+ "entered just now");
			String b = sc.next();
			int[][] matrix = all.get(a);
			int[][] cons = all.get(b);
			if(matrix[0].length==cons.length) {
				Operations.solvelin(matrix,cons);
			}
			
			
		}if(input==15) {
			System.out.println("1. Rectangular Matrix\r\n"
					+ "2. Row Matrix\r\n"
					+ "3. Column Matrix\r\n"
					+ "4. Square Matrix\r\n"
					+ "5. Symmetric Matrix\r\n"
					+ "6. Skew-symmetric Matrix\r\n"
					+ "7. Upper-triangular Matrix\r\n"
					+ "8. Lower-triangular Matrix\r\n"
					+ "9. Singular Matrix\r\n"
					+ "10. Diagonal Matrix\r\n"
					+ "11. Scalar Matrix\r\n"
					+ "12. Identity Matrix\r\n"
					+ "13. Singleton Matrix\r\n"
					+ "14. Ones Matrix\r\n"
					+ "15. Null Matrix");
			System.out.println("Enter the type of matrices you want to retrieve: ");
			int r = sc.nextInt();
			if(r==1) {
				 Rectangular.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==2) {
				Row.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==3) {
				Column.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==4) {
				Square.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==5) {
				Symmetric.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });	
			}if(r==6) {Skewsymmetric.forEach((k, v) -> {
				 int[][] print = v;
				 System.out.println("Matrix "+ k );
				 for (int i = 0; i < print.length; i++){
			              for (int j = 0; j < print[0].length; j++){
			                   System.out.print(" " +print[i][j] + " ");
			              }
			              System.out.println();
			          } 
	    });
				
			}if(r==7) {
				Skewsymmetric.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==8) {
				Uppertri.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==9) {
				Lowertri.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==10) {
				Diagonal.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==11) {
				Scalar.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==12) {
				Identity.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==13) {
				Singleton.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==14) {
				Ones.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}if(r==15) {
				Null.forEach((k, v) -> {
					 int[][] print = v;
					 System.out.println("Matrix "+ k );
					 for (int i = 0; i < print.length; i++){
				              for (int j = 0; j < print[0].length; j++){
				                   System.out.print(" " +print[i][j] + " ");
				              }
				              System.out.println();
				          } 
		    });
			}
			
		}
	}
}



}
