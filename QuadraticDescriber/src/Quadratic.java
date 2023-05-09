/**
 * Processes user input from QuadraticClient
 * @author Jeffrey Ding
 * @version 09/19/2022
 */

public class Quadratic {

public static String quadrDescriber(double a, double b, double c) {
		String equation = "\nDescription of the graph of:\ny = " + a + " x^2 + " + b + " x + " + c + "\n\n";		
		
		// the direction the graph of the function opens
		String opens;
		if (a > 0) {
			opens = "Opens: Up\n";
		} else {
			opens = "Opens: Down\n";
		}
		
		// the axis of symmetry of the graph of the function
		double h = (-b / (2 * a));
		String axis = "Axis of Symmetry: " + round2(h) + "\n";
		
		// the vertex of the graph of the function
		double k = (a * (h * h)) + (b * h) + c;
		String vertex = "Vertex: (" + round2(h) + ", " + round2(k) + ")\n";
		
		// the x-intercept(s) of the graph of the function
		String xint = quadForm(a, b, c) + "\n";
		
		// the y-intercept of the graph of the function
		String yint = "y-intercept: " + c;

		return equation + opens + axis + vertex + xint + yint;
	}
	
	
	// below are methods copied from the Calculate class
	public static double discriminant(double a, double b, double c) {
		// returns the discriminant of a quadratic equation using the inputted coefficients of a quadratic equation
		double disc = (b * b) - 4 * (a * c);
		return disc;
	}
	
	public static String quadForm(double a, double b, double c) {
		// returns the real roots, if any, of a quadratic equation using the inputted coefficients of a quadratic equation
		String answer;
		double disc = discriminant(a, b, c);
		if (disc < 0) {
			answer = "x-intercept(s): none";
		} else if (disc == 0) {
			double temp = (-b / (2 * a));
			answer = "x-intercept(s): " + round2(temp);
		} else {
			double temp1 = ((-b + sqrt(disc)) / (2 * a));
			double temp2 = ((-b - sqrt(disc)) / (2 * a));
			double temp3 = min(temp1, temp2);
			double temp4 = max(temp1, temp2);
			answer = "x-intercept(s): " + round2(temp3) + " and " + round2(temp4);
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
	
	public static double max(double num1, double num2) {
		// returns the maximum value of the two inputs
		if (num1 >= num2) {
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
}