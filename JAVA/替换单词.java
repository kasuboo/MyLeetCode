/*
在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。

现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。

需要输出替换之后的句子。

示例 1：

输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
输出："the cat was rat by the bat"
示例 2：

输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
输出："a a b c"

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/UhWRSj
*/
/*
一直没有ac的问题是，只记录的单词是否，没有考虑到如“hm”和“mh”这种，数组一样，但是其实不是一个单词的情况;
*/
package p;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public boolean isR(String x,String y)
	{
		int[] a=new int[26];
		int[] b=new int[26];
		if(x.length()>=y.length())
			return false;
		for(int i=0;i<x.length();i++)
		{
			a[x.charAt(i)-'a']++;
			b[y.charAt(i)-'a']++;
		}
		String c=y.substring(0,x.length());
		if(Arrays.equals(a, b)==true && x.equals(c)==true) 
			return true;

		return false; //没查找到
	}
	public String replaceWords(List<String> dictionary, String sentence) 
	{
		String s="";
		String[] sens=sentence.split(" "); //按空格分割字符串
		String temp="";
		for(int i=0;i<sens.length;i++)
		{
			temp="";
			for(int j=0;j<dictionary.size();j++)
			{
				if(isR(dictionary.get(j),sens[i])==true) //找到了
				{
					if(temp=="")
						temp=dictionary.get(j);
					else if(temp!="")
					{
						if(temp.compareTo(dictionary.get(j))>=0)
							temp=dictionary.get(j);
					}
				}
			}
			if(temp!="")
				sens[i]=temp;
		}
		for(int k=0;k<sens.length;k++)
			s=s.concat(sens[k]+" ");
		s=s.trim();
				
		return s;
    } 
}
public class test 
{
	
	public static void main(String[] args)
	{
		Solution s=new Solution();
		String sentence = "the cattle was rattled by the battery";
		List<String> l=new ArrayList<String>();
		l.add("cat");
		l.add("bat");
		l.add("rat");
		
		System.out.println(s.replaceWords(l, sentence)); 
		
	}
	
}
