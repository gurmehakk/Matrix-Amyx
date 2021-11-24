package ApA3;

import java.util.HashMap;

public class rectangularmatrix {
	public rectangularmatrix(int m, int n, String name, int[][] matrix) {
		this.m=m;
		this.n=n;
		this.name=name;
		this.matrix=matrix;
	}
	protected int m;
	protected int n;
	protected String name;
	protected int[][] matrix;

}
class RowM extends rectangularmatrix{
	public RowM(int m,int n,String name,int[][] matrix) {
		super(m,n,name,matrix);
			this.m=1;
		}
		
	

}
class ColumnM extends rectangularmatrix{
	public ColumnM(int m,int n,String name,int[][] matrix) {
		super(m,n,name,matrix);
		this.n=1;
			
			
		}
		
	
	
	
}
