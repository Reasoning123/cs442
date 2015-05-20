package objComp.manip;

public class Values{
	public static String[] getValue(String line){
		String split[] = line.split("=");
		return split;
	}
}
