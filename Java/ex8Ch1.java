
public class ex8Ch1{
	public static void main(String[] args){
	
	}
	
	public void MakeZero(int [][] m){
		int colZ = 1;
		int rowZ = 1;
		int i, j;
		for(i = 0; i < m.length; i++)
			if(m[i][0] == 0){
				colZ = 0;
				break;
			}
		for(j = 0; j < m[0].length; j++)
			if(m[0][j] == 0){
				rowZ = 0;
				break;
			}
		for(i = 1; i < m.length; i++)
			for(j = 1; j < m[0].length; j++)
				if(m[i][j] == 0){
					m[i][0] = 0;
					m[0][j] = 0;
				}
		for(i = 1; i < m.length; i++){
			if(m[i][0] == 0) // zero the rowZ
				for(j = 0; j < m[0].length; j++)
					m[i][j] = 0;
		}
		for(j = 1; j < m[0].length; j++){
			if(m[0][j] == 0)// zero the row
				for(i = 0; i < m.length; i++)
					m[i][j] = 0;
		}
		if(colZ == 0) // 0 was on the first col, zero the row
			for(i = 0; i < m.length; i++)
				m[i][0] = 0;
		if(rowZ == 0)// 0 was on the first row, zero the row
			for(j = 0; j < m[0].length; j++)
				m[0][j] = 0;
	}
}