/**
 * Performs operations on array objects
 * @author Jeffrey Ding
 * @version 10/25/2022
 */
import java.util.Arrays;

public class ArraysLab {
	public static void main (String[] args) {
	// main method to test static methods
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		rotateRight(a1);
	}
	
	public static int[] sum(int[] a1, int[] a2) {
	// adds the integer values at the matching indexes and returns a new array containing the sums
	// precondition: a1 and a2 are of equal length
		int[] temp = new int[a1.length];
		for(int i = 0; i < a1.length; i++) {
			temp[i] = a1[i] + a2[i];
		}
		return temp;
	}
	
	public static int[] append(int[] arr, int num) {
	// appends a value to the end of the passed array
		int[] temp = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[arr.length] = num;
		return temp;
	}
	
	public static int[] remove(int[] arr, int idx) {
	// removes the value at the given index from the passed array
		int[] temp = new int[arr.length - 1];
		for (int i = 0; i < idx - 1; i++) {
			temp[i] = arr[i];
		}
		for (int j = idx - 1; j < arr.length - 1; j++) {
			temp[j] = arr[j + 1];
		}
		return temp;
	}
	
	public static int sumEven(int[] arr) {
	// calculates the sum of the even indexes of the passed array
		int sum = 0;
		for (int i = 0; i < arr.length; i +=2) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void rotateRight(int[] arr) {
	// shifts each value in the passed array one index up
	// last value in the array shifts to the zero index
		int lastNum = arr[arr.length - 1];
		int[] temp = new int[arr.length];
		temp[0] = lastNum;
		for (int i = 0; i < arr.length - 1; i++) {
			temp[i + 1] = arr[i];
		}
		System.out.println(Arrays.toString(temp));
	}
}
