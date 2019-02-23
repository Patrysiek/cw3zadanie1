package calculators;

public class StandardCalculator {

	public String adding(float a, float b) {
		return String.valueOf(a + b);
	}

	public String substraction(float a, float b) {
		return String.valueOf(a - b);
	}

	public String division(float a, float b) {

		if (b == 0)
			return "Nie dziel /0";

		return String.valueOf(a / b);
	}

	public String multiplying(float a, float b) {
		return String.valueOf(a * b);
	}

	public String modulo(float a, float b) {
		return String.valueOf(a % b);
	}
	public String power(float a, float b) {
		
		return String.valueOf(Math.pow(a, b));
	}

	public String factorial(String text) {
		int x = Integer.parseInt(text);
		if(x==0)
			return "1";
		
		int result = 1;

        for (int factor = 2; factor <= x; factor++) {
            result *= factor;
        }

        return String.valueOf(result);
	}

	public String sqrt(String text) {
		
		return String.valueOf(Math.sqrt(Double.parseDouble(text)));
	}

	public String logarithm(String text) {
		return String.valueOf(Math.log(Double.parseDouble(text)));
	}
	

}
