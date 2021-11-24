package ApA3;

public class squarematrix {

	protected int m;
	protected int n;
	protected String name;
	protected int[][] matrix;

	public squarematrix(int m,int n, String name, int[][] matrix) {
		this.m=m;
		this.n=m;
		this.name=name;
		this.matrix=matrix;
	}

}
class SymmetricM extends squarematrix{

	int[][] transpose;
	

	public SymmetricM(int m,int n, String name, int[][] matrix,int[][] transpose) {
		super(m,n, name, matrix);
		this.transpose=transpose;
		for(int i=0;i<m;i++){    
			for(int j=0;j<m;j++){    
			transpose[i][j]=matrix[j][i];  
			}    
			}
		
	}
	
}
class SkewsymmetricM extends squarematrix{

	int[][] sksem;

	public SkewsymmetricM(int m,int n, String name, int[][] matrix,int[][] sksem) {
		super(m,n, name, matrix);
		this.sksem=sksem;
		for(int i=0;i<m;i++){    
			for(int j=0;j<m;j++){    
			sksem[i][j]=-(matrix[j][i]);  
			}    
		}
	}
	
}
class UppertriM extends squarematrix{

	public UppertriM(int m,int n, String name, int[][] matrix) {
		super(m, n, name, matrix);
	}
	
}
class LowertriM extends squarematrix{

	public LowertriM(int m,int n, String name, int[][] matrix) {
		super(m,n, name, matrix);
	}
	
}
class SingularM extends squarematrix{

	public SingularM(int m,int n, String name, int[][] matrix) {
		super(m,n, name, matrix);
	}
	
}
class DiagonalM extends squarematrix{

	public DiagonalM(int m,int n, String name, int[][] matrix) {
		super(m,n, name, matrix);
		// TODO Auto-generated constructor stub
	}
	
}
class ScalarM extends DiagonalM{

	public ScalarM(int m,int n, String name, int[][] matrix) {
		super(m,n, name, matrix);
		// TODO Auto-generated constructor stub
	}
	
}
class IdentityM extends ScalarM{

	public IdentityM(int m,int n, String name, int[][] matrix) {
		super(m,n, name, matrix);
		// TODO Auto-generated constructor stub
	}
	
}
class SingletonM extends squarematrix{

	public SingletonM(int m,int n, String name, int[][] matrix) {
		super(m,n, name, matrix);
		this.m=1;
	}
	
}

