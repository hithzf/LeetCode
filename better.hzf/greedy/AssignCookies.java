package greedy;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 455. Assign Cookies
 * @author hzf
 * @see https://leetcode.com/problems/assign-cookies/
 * 这道题审题失误，不能多块饼干分给一个熊孩子
 */
public class AssignCookies {
	
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
        	if(g[i] <= s[j]){
        		i++;
        		j++;
        	}else{
        		j++;
        	}
        }
        return i;
    }
	
	public int findContentChildrenWrong(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
        	if(g[i] <= s[j]){
        		System.out.print("孩子" + i + "：" + g[i] + "\t");
        		System.out.println("饼：" + s[j]);
        		i++;
        		j++;
        	}else{
        		int k = j, sum = 0;
        		while(k < s.length && g[i] > sum){
        			sum += s[k];
        			k++;
        		}
        		if(g[i] <= sum){
        			System.out.print("孩子" + i + "：" + g[i] + "\t");
            		System.out.println("饼(" + j + "," + (k-1) + ")：" + sum);
        			i++;
        			j = k;
        		}else{
        			return i;
        		}
        	}
        }
        return i;
    }

	public static void main(String[] args) {
		AssignCookies ins = new AssignCookies();
		String str = null;
		try {
			str = getTemplateContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] split = str.split(",");
		int[] g = new int[split.length];
		for(int i = 0; i < split.length; i++){
			g[i] = Integer.parseInt(split[i]);
		}

		int[] s = {29,310,236,441,200,267,115,59,277,42,361,112,483,104,338,69,438,55,318,470,20,490,455,119,259,51,492,50,160,414,38,289,429,446,350,412,12,515,367,397,122,35,522,355,448,266,333,500,211,226,203,366,240,324,111,280,520,321,211,360,437,292,512,161,85,139,12,211,236,213,377,85,494};
		System.out.println(ins.findContentChildren(g, s));
	}
	

private static String getTemplateContent() throws Exception{
    File file = new File("E:\\test.txt");
    if(!file.exists()){
        return null;
    }
    FileInputStream inputStream = new FileInputStream(file);
    int length = inputStream.available();
    byte bytes[] = new byte[length];
    inputStream.read(bytes);
    inputStream.close();
    String str = new String(bytes, StandardCharsets.UTF_8);
    return str ;
}

}
