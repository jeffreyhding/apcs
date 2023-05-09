/**
 * library of math methods
 * @author Jeffrey Ding
 * @version 08/25/2022
 */

public class Calculate {
	
	public static int square(int num) {
		// returns the square of the input
		int answer = num * num;
		return answer;
	}
	
	public static int cube(int num) {
		// returns the cube of the input
		int answer = num * num * num;
		return answer;
	}
	
	public static double average(double num1, double num2) {
		// returns the average of two inputs
		double average = (num1 + num2)/2;
		return average;
	}
	
	public static double average(double num1, double num2, double num3) {
		// returns the average of three inputs
		double average = (num1 + num2 + num3)/3;
		return average;
	}
	
	public static double toDegrees(double radians) {
		// converts radians to degrees and returns the latter value
		double degrees = radians * (180/3.14159);
		return degrees;
	}
	
	public static double toRadians(double degrees) {
		// converts degrees to radians and returns the latter value
		double radians = degrees * (3.14159/180);
		return radians;
	}
	
	public static double discriminant(double a, double b, double c) {
		// returns the discriminant of a quadratic equation using the inputted coefficients of a quadratic equation
		double disc = (b * b) - 4 * (a * c);
		return disc;
	}
	
	public static String toImproperFrac(int wholeNum, int num, int denom) {
		// converts mixed numbers to improper fractions
		int tempInt = wholeNum * denom;
		int numerator;
		if (wholeNum >= 0) {
			numerator = tempInt + num;
		} else {
			numerator = tempInt - num;
		}
		String improperFrac = numerator + "/" + denom;
		return improperFrac;
	}
	
	public static String toMixedNum(int num, int denom) {
		// converts improper fractions to mixed numbers
		int wholeNum = num / denom;
		int numerator = num % denom;
		String mixedNum = wholeNum + "_" + numerator + "/" + denom;
		return mixedNum;
	}
	
	public static String foil(int num1, int num2, int num3, int num4, String var) {
		// converts binomial multiplication of form (ax+b)(cx+d) to quadratic equation of form ax^2+bx+c
		String a = (num1 * num3) + var + "^2";
		String b = (num1 * num4 + num2 * num3) + var;
		int c = (num2 * num4);
		String quadratic = a + " + " + b + " + " + c;
		return quadratic;
	}
	
	public static boolean isDivisibleBy(int num1, int num2) {
		// checks if the first input is divisible by the second input
		if (num2 == 0) {
			throw new IllegalArgumentException("denominator argument cannot be 0");
		}
		boolean test = false;
		if (num1 % num2 == 0) {
			test = true;
		}
		return test;
	}
	
	public static double absValue(double num) {
		// returns the absolute value of the input
		double answer;
		if (num < 0) {
			answer = num * (-1);
			return answer;
		} else {
			return num;
		}
	}
	
	public static double max(double num1, double num2) {
		// returns the maximum value of the two inputs
		if (num1 >= num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double max(double num1, double num2, double num3) {
		// returns the maximum value of the three inputs
		if (num1 >= num2 && num1 >= num3) {
			return num1;
		} else if (num2 >= num1 && num2 >= num3) {
			return num2;
		} else {
			return num3;
		}
	}
	
	public static int min(int num1, int num2) {
		// returns the minimum value of the three inputs
		if (num1 <= num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double min(double num1, double num2) {
		// returns the minimum value of the three inputs
		if (num1 <= num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double round2(double num) {
		// rounds input to two decimal places
	    if (num >= 0) {
            double temp1 = (num * 100) + 0.5;
            int temp2 = (int) temp1;
            double temp3 = (double) temp2;
            double temp4 = temp3 / 100;
            return temp4;
        } else {
            double temp1 = (num * 100) - 0.5;
            int temp2 = (int) temp1;
            double temp3 = (double) temp2;
            double temp4 = temp3 / 100;
            return temp4;
        }
	}
	
	public static double exponent(double num, int exp) {
		// raises the first input to the power of the second input
		if (exp <= 0) {
			throw new IllegalArgumentException("exponent argument must be greater than 0");
		}
		double answer = num;
		for (int i = 1; i != exp; i++) {
			answer *= num;
		}
		return answer;
	}
	
	
	public static int factorial(int num) {
		// calculates the factorial of the input
		if (num < 0) {
			throw new IllegalArgumentException("argument cannot be negative");
		}
		int answer = 1;
		if (num == 0) {
			answer = 1;
			return answer;
		} else {
			for (int i = 1; i != (num+1); i++) {
				answer *= i;
			}
			return answer;
		}
	}
	
	public static boolean isPrime(int num) {
		// checks if the input is a prime number
		boolean answer = true;
		if (num <= 1) {
			answer = false;
			return answer;
		} else if (num > 0) {
			for (int i = num; i != 1; i--) {
				boolean test = isDivisibleBy(num, i);
				if (test == true && i != 1 && i != num) {
					answer = false;
					return answer;
				} else {
					answer = true;
				}
			}
		} 
		return answer;
	}
	
	public static int gcf(int tempInt1, int tempInt2) {
		// returns the greatest common factor of the two integer inputs
		int answer = 1;
		int tempInt3 = (int) absValue((double) tempInt1);
		int tempInt4 = (int) absValue((double) tempInt2);
		int num1;
		int num2;
		
		if (tempInt3 >= tempInt4) {
			num1 = tempInt3;
			num2 = tempInt4;
		} else {
			num1 = tempInt4;
			num2 = tempInt3;
		}
		
		for (int i = num1; i != 1; i--) {
			if (isDivisibleBy(num1, i) == true) {
				if (isDivisibleBy(num2, i) == true) {
					return i;
				}
			}
		}
		return answer;
	}
	
	public static double sqrt(double num) {
		// returns the approximate square root of the input, rounded to two decimal places
		if (num < 0) {
			throw new IllegalArgumentException("argument cannot be negative");
		}
		double temp1;
		double temp2 = num / 2;
		
		do {
			temp1 = temp2;
			temp2 = (temp1 + (num / temp1)) / 2;
		} while (absValue(temp1 * temp1 - num) >= 0.005);
		
		return round2(temp1);
	}
	
	public static String quadForm(int a, int b, int c) {
		// returns the real roots, if any, of a quadratic equation using the inputted coefficients of a quadratic equation
		String answer;
		double disc = discriminant(a, b, c);
		if (disc < 0) {
			answer = "no real roots";
		} else if (disc == 0) {
			double temp = (-b / (2 * a));
			answer = round2(temp) + " ";
		} else {
			double temp1 = ((-b + sqrt(disc)) / (2 * a));
			double temp2 = ((-b - sqrt(disc)) / (2 * a));
			double temp3 = min(temp1, temp2);
			double temp4 = max(temp1, temp2);
			answer = round2(temp3) + " and " + round2(temp4);
		}
		return answer;
	}
}
