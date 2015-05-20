package keyCount.visitors;

import java.util.*;
public class PopulateTreeVisitor{

	public void visit(TreeMap tree, String key){
			if(tree.containsKey(key)){
				tree.put(key, (int)tree.get(key)+1);
			}else{
				tree.put(key, 1);
			}

	}


}
