package keyCount.visitors;

import java.util.*;
public class wordCountVisitor{

	public int[] visit(TreeMap tree, String key){
		int[] counts = new int[3];
		int count =0;
		int uniqueCount =0;
		int numChar = 0;
	      	Set set = tree.entrySet();
	      	Iterator i = set.iterator();
	      	while(i.hasNext()) {
		 	Map.Entry me = (Map.Entry)i.next();
		 	uniqueCount++;
			count += (int)me.getValue();
			numChar += (count + ((String)me.getKey()).length());
	      	}
		counts[0] = uniqueCount;
		counts [1] = count;
		counts[2] = numChar;
		return counts;
	}


}
