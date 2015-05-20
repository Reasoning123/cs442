package objComp.util;

import java.util.*;
import java.lang.reflect.*;

import objComp.fileOperations.FileProcessor;
import objComp.manip.Values;

public class PopulateObjects{
	
	private HashMap<Object, Integer> first;
	private HashMap<Object, Integer> second;

	FileProcessor fp;

	public PopulateObjects(FileProcessor fpIn) {
		first = new HashMap<Object, Integer>();
		second = new HashMap<Object, Integer>();
		fp = fpIn;
	}

	public void deserObjects() {
		String line, clsName, methodName;
		String[] varInfo;
		String[] delims = {", ", "[=]"};
		Class cls;
		Class[] signature;
		Method meth;
		Object obj, result;
		Object[] params;
		while((line = fp.readLineFromFile()) != null) {
			if(line.contains("fqn")) {
				try {
					clsName = getClassName(line);
					cls = Class.forName(clsName);
					obj = cls.newInstance();
					for(int i=0; i<2; i++) {
						varInfo = getVariableInfo(fp.readLineFromFile());
						signature = new Class[1];
						if(varInfo[0].equals("int")) {
							signature[0] = Integer.TYPE;
						}
						else if(varInfo[0].equals("double")) {
							signature[0] = Double.TYPE;	
						}
						else {
							signature[0] = String.class;
						}
						methodName = "set" + varInfo[1];
						meth = cls.getMethod(methodName, signature);
						//obj = cls.newInstance();
						params = new Object[1];
						if(varInfo[0].equals("int")) {
							params[0] = new Integer(Integer.parseInt(varInfo[2]));
						}
						else if(varInfo[0].equals("double")) {
							params[0] = new Double(Double.parseDouble(varInfo[2]));	
						}
						else {
							params[0] = new String(varInfo[2]);
						}
						result = meth.invoke(obj, params);
					}
					meth = cls.getMethod("hashCode");
					params = new Object[0];
					result = meth.invoke(obj, params);
					if(line.contains("First")) {
						if(first.containsKey(obj)){
							first.put(obj, (int)first.get(obj)+1);
						}
						else {
							first.put(obj, 1);
						}
					}
					else {
						if(second.containsKey(obj)){
							second.put(obj, (int)(second.get(obj))+1);
						}
						else {
							second.put(obj, 1);
						}
					}
				} catch(Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
		//System.out.println("There are " + first.size() + " items in first");
		System.out.println(first.size());
		System.out.println(second.size());
	}

	public String getClassName(String s) {
		String delim = "[:]";
		String[] tokens = s.split(delim);
		return tokens[1]; 
	}

	public String[] getVariableInfo(String s) {
		String[] temp = new String[3];
		String delim = ", |=";
		String[] tokens = s.split(delim);
		if(tokens[1].equals("int")) {
			temp[0] = "int";
		}
		else if(tokens[1].equals("double")) {
			temp[0] = "double";
		}
		else {
			temp[0] = "string";
		}
		temp[1] = tokens[3];
		temp[2] = tokens[5];
		return temp;
	}/*
	public int returnTotalFirst(){
		int total=0;
		for(int i=0; i<first.size();i++){
			total += first.get(
		}
	}
	public int returnTotalSecond(){
		return secondHolder.size();
	}
	public int returnNonDuplicateFirst(){
		return first.size();
	}
	public int returnNonDuplicateSecond(){
		 Ssecond.size();
	}*/
}
