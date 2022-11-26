/*
有一个特殊打字机，它由一个 圆盘 和一个 指针 组成， 圆盘上标有小写英文字母 'a' 到 'z'。只有 当指针指向某个字母时，它才能被键入。指针 初始时 指向字符 'a' 。
每一秒钟，你可以执行以下操作之一：
将指针 顺时针 或者 逆时针 移动一个字符。
键入指针 当前 指向的字符。
给你一个字符串 word ，请你返回键入 word 所表示单词的 最少 秒数 。

输入：word = "abc"
输出：5
解释：
单词按如下操作键入：
- 花 1 秒键入字符 'a' in 1 ，因为指针初始指向 'a' ，故不需移动指针。
- 花 1 秒将指针顺时针移到 'b' 。
- 花 1 秒键入字符 'b' 。
- 花 1 秒将指针顺时针移到 'c' 。
- 花 1 秒键入字符 'c' 。
*/
/*解题：利用圆盘上的字母的ascii码值来计算，从而通过比较得到指针的移动方向
*/
package p;
class Solution {
    public int minTimeToType(String word) 
    {
    	int s=0;
    	int p='a'; //当前指针的位置
    	for(int i=0;i<word.length();i++)
    	{
    		System.out.print(p+" ");
    		if(Math.abs(word.charAt(i)-p) <= 13) //在近的一侧
    		{
    			System.out.print("if ");
    			if(Math.abs(word.charAt(i)-p)==0)
    				s=s+1;
    			else
    				s=s+Math.abs(word.charAt(i)-p)+1; //且+1键入当前值
    		    p=word.charAt(i); //更新指针位置
    		}
    		else if(Math.abs(word.charAt(i)-p) > 13) //在远的一侧
    		{
    			System.out.print("else ");
    			if(p < word.charAt(i))
    				s=s+(122-word.charAt(i))+(p-97)+1+1;
    			else
    				s=s+(122-p)+(word.charAt(i)-97)+1+1;
    			p=word.charAt(i); //更新指针位置
    		}
    		System.out.println(s);
    	}    	    	
    	return s;
    }
}
public class test 
{
	
	public static void main(String[] args) 
	{
		Solution so=new Solution();
		int s=so.minTimeToType("zjpc");
		System.out.println(s);
				
	}
	
}
