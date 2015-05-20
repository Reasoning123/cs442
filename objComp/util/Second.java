package objComp.util;

public class Second {

	private int IntValue;
	private double DoubleValue;
	
	public Second(){}

	public void setIntValue(int in){
		IntValue = in;
		//System.out.println("int2");
	}

	public void setDoubleValue(double in){
		DoubleValue = in;
		//System.out.println("double");
	}

	@Override
   	public boolean equals(Object other){
	       if(this == other) return true;
	      
	       if(other == null || (this.getClass() != other.getClass())){
		   return false;
	       }
	      
	       Second a = (Second) other;
	       return ((this.IntValue == a.IntValue) && (this.DoubleValue == a.DoubleValue));
		     
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int)(DoubleValue * 7);
		hash += IntValue;
		return hash;
	}
}
