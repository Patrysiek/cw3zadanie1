package calculators;

public class ProgrammerCalculator {
	
	
	
	//////////////////TO DECIMAL////////////////////////////////////////////
	public String hexToDec(String s) {
		
		return String.valueOf(Integer.parseInt(s,16));
	}
	
	public String binToDec(String s) {
		return String.valueOf(Integer.parseInt(s,2));
	}
	public String octToDec(String s) {
		
		return String.valueOf(Integer.parseInt(s,8));
	}
	
	////////////////////////////TO OCTAL///////////////////////////////////////////
	public String hexToOct(String s) {
		
		return decToOct(Integer.parseInt(hexToDec(s)));
	}
	
	public String binToOct(String s) {
		return decToOct(Integer.parseInt(binToDec(s)));
	}
	
	//////////////////////TO HEX////////////////////////////////////////////////////
	public String binToHex(String s) {
		return decToHex(Integer.parseInt(binToDec(s)));
	}
	public String octToHex(String s) {
		return decToHex(Integer.parseInt(octToDec(s)));
	}
	
	////////////////TO BIN////////////////////////////////////////////////////////
	public String hexToBin(String s) {
		return decToBin(Integer.parseInt(hexToDec(s)));
	}
	public String octToBin(String s) {
		return decToBin(Integer.parseInt(octToDec(s)));
	}
	
	/////////////////////////////////DECIMAL TO/////////////////////////////////////////////////
	public String decToOct(int decValue) {
		return Integer.toOctalString(decValue);
	}
	
	public String decToBin(int decValue) {
		return Integer.toBinaryString(decValue);
	}
	
	public String decToHex(int decValue) {
		return Integer.toHexString(decValue);
	}
	

}
