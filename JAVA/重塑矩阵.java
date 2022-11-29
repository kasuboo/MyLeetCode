/*
在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

输入：mat = [[1,2],[3,4]], r = 1, c = 4
输出：[[1,2,3,4]]
输入：mat = [[1,2],[3,4]], r = 2, c = 4
输出：[[1,2],[3,4]]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/reshape-the-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
package p;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) 
    {
    	int[][] s=new int[r][c];
    	int nums=mat.length*mat[0].length; //得到二维数组元素个数
	//先检测数组中的元素是否足够满足构成新数组
    	if(nums!=r*c) //不满足，返回原来二维数组
    		return mat;
    	
    	int x=0,y=0; //记录mat的下标
    	for(int i=0;i<r;i++)
    	{
    		for(int j=0;j<c;j++)
    		{
    			if(x<mat.length && y<mat[x].length)
    			{
    				s[i][j]=mat[x][y];
    				y++;
    			}
    			else if(y>=mat[x].length)
    			{
    				x++; //取下一行
    				y=0; //从第一列开始
    				s[i][j]=mat[x][y];
    				y++;
    			}
    			else if(x>=mat.length)
    				break;
    		}
    	}
    	
    	return s;
    }
}
public class test 
{
	
	public static void main(String[] args)
	{
		Solution s=new Solution();
		int[][] mat = {{1,2},{3,4}};
		int[][] x=s.matrixReshape(mat,2,4);
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[i].length;j++)
			{
				System.out.print(x[i][j]+" ");
			}
			System.out.println(" ");
		}
		
	}
	
}
