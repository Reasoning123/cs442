package objComp.util;

public class First{

	private int IntValue;
	private String StringValue;
	
	public First(){}

	public void setIntValue(int in){
		IntValue = in;
		//System.out.println("int");
	}

	public void setStringValue(String in){
		StringValue = in;
		//System.out.println("String");
	}

	@Override
   	public boolean equals(Object other){
	       if(this == other) return true;
	      
	       if(other == null || (this.getClass() != other.getClass())){
		   return false;
	       }
	      
	       First a = (First) other;
	       return ((this.IntValue == a.IntValue) && (this.StringValue.equals(a.StringValue)));
		     
	}

	@Override
	public int hashCode() {
		int hash = 0;
		String str = StringValue;
		for(char c: str.toCharArray()) {
			hash += c;
		}
		hash += IntValue;
		return hash;
	}
}
