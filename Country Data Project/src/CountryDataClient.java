/**
 * Client code for constructing Country objects
 * @author Jeffrey Ding
 * @version 01/26/2022
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryDataClient {
	
	public static void main(String[] args) throws FileNotFoundException{
		File inputFile =new File("CountryDataSet.csv");
		Scanner in = new Scanner(inputFile);

		String str = in.nextLine();
		String[] split = str.split(",");
		String series = split[0].substring(1, split[0].length() - 1);
		
		str = in.nextLine();
		split = str.split(",");
		int count = split.length - 1;
		ArrayList<Integer> years = new ArrayList<>();
		for (int i = 0; i < count; i++) years.add(Integer.parseInt(split[i+1]));
		
		String countryName;
		ArrayList<Country> countries = new ArrayList<>();
		do {
			str = in.nextLine();
			if (str.charAt(0) == '"') {
				String temp = str.substring(1, str.lastIndexOf('"'));
				str = temp.substring(temp.indexOf(',') + 2) + " " + temp.substring(0, temp.indexOf(',')) + str.substring(str.lastIndexOf('"') + 1);
			}
			split = str.split(",");
			countryName = split[0];
			ArrayList<Double> data = new ArrayList<>();
			for (int j = 0; j < count; j++) data.add(Double.parseDouble(split[j+1]));
			
			Country country = new Country(countryName, series, years, data);
			countries.add(country);
		} while (in.hasNextLine());
		
		System.out.println(countries.get(0).getAcronym() + " for " + years.get(0) + "-" + years.get(years.size() - 1) + "\n");
		for (Country country : countries) System.out.println(country + "\n");
		in.close();
	}
	
	public static void removeByName(ArrayList<Country> countries, String name) {
	// removes the Country object with the given name
		int index = 0;
		for (Country country : countries) if (country.getCountry().equals(name)) index = countries.indexOf(country);
		countries.remove(index);
	}
	
	public static void removeNoTrend(ArrayList<Country> countries) {
	// removes the Country objects whose data has no trend
		for (int i = countries.size() -1; i >= 0; i--) if (countries.get(i).getTrend().equals("no trend")) countries.remove(i);
	}
	
	public static ArrayList<String> getListBasedOnTrend(ArrayList<Country> countries, String trendType) {
	// returns an ArrayList of Strings containing the names of the countries with the given trend type
		if (!trendType.equalsIgnoreCase("up") && !trendType.equalsIgnoreCase("down") && !trendType.equalsIgnoreCase("no trend")) throw new IllegalArgumentException("enter \"up,\" \"down,\" or \"no trend\"");
		ArrayList<String> countryNames = new ArrayList<>();
		for (Country country : countries) if (country.getTrend().equalsIgnoreCase(trendType)) countryNames.add(country.getCountry());
		return countryNames;
	}
}
