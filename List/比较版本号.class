/*
给你两个版本号 version1 和 version2 ，请你比较它们。

版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。

比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。

返回规则如下：

如果 version1 > version2 返回 1，
如果 version1 < version2 返回 -1，
除此之外返回 0。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/compare-version-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
package p;
import java.util.ArrayList;
import java.util.List;
public class test 
{
	public static List<Integer> turn(String s1)
	{
		List<Integer> L=new ArrayList<Integer>();
		int x1=0,j=0;
		while(j<s1.length())
		{
			if(s1.charAt(j)!='.')
			{
				x1=x1*10+s1.charAt(j)-'0';
				//j++;
			}
			else
			{
				//System.out.println("x1="+x1);
				L.add(x1);
				x1=0;
			}
			j++;
		}
		
		return L;
	}
	public static int compareVersion(String version1, String version2) 
	{
		version1=version1+".";
		version2=version2+".";
		List<Integer> L1=new ArrayList<Integer>();
		List<Integer> L2=new ArrayList<Integer>();
		List<Integer> Ls;
		L1=turn(version1);
		L2=turn(version2);
		int flag=0;
		int length=L1.size()<L2.size()?L1.size():L2.size();
		int length1=L1.size()>=L2.size()?L1.size():L2.size();
		if(L1.size()>L2.size())
		{
			Ls=new ArrayList<Integer>(L1);
			flag=1;
		}
		else
		{
			Ls=new ArrayList<Integer>(L2);
			flag=-1;
		}
		int i=0;
		for(i=0;i<length;i++)
		{
			if(L1.get(i)<L2.get(i))
				return -1;
			else if((L1.get(i)>L2.get(i)))
				return 1;
		}
		for(int k=i;k<length1;k++)
		{
			if(Ls.get(k)>0)
			{
				return flag;
			}
		}
		return 0;
    }
	
	public static void main(String[] args) 
	{
		System.out.println(compareVersion("1.100","1.0002"));
		
	}
	
}
