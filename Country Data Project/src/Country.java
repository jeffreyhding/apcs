/**
 * Class for Country objects
 * Contains their name and a data set using ArrayLists
 * @author Jeffrey Ding
 * @version 01/26/2022
 */

import java.util.ArrayList;

public class Country {
	private String name;
	private String series;
	private ArrayList<Integer> years;
	private ArrayList<Double> data;
	
	public Country(String countryName, String series, ArrayList<Integer> years, ArrayList<Double> data) {
	// constructor for Country objects
		this.name = countryName;
		this.series = series;
		this.years = years;
		this.data = data;
	}
	
	public void setSeries(String series) {
	// sets the series name to passed value
		this.series = series;
	}
	
	public void setData(ArrayList<Double> data) {
	// sets the data values to passed values
		this.data = data;
	}
	
	public String getCountry() {
	// returns the country name
		return name;
	}
	
	public String getSeries() {
	// returns the series name (without units)
		return series.substring(0, this.series.indexOf("("));
	}
	
	public ArrayList<Integer> getYears() {
	// returns the set of years
		return years;
	}
	
	public ArrayList<Double> getData() {
	// returns the set of data values
		return data;
	}
	
	public void addDataPoint (int year, double newDatum) {
	// adds new data points to the ArrayLists years and data
		years.add(year);
		data.add(newDatum);
	}
	
	public void editDataPoint (int year, double newDatum) {
	// replaces the data value associated with the given year with a given data value
		data.set(years.indexOf(year), newDatum);
	}
	
	public String getUnits() {
	// returns the units for the stored data
		if (series.indexOf("(") == -1) return "";
		return series.substring(series.indexOf("(") + 1, series.indexOf(")"));
	}
	
	public String getAcronym() {
	// returns an acronym made of the first letter in each of the words in the series name
	// excludes: of, in, the, at, to, by, per, on, a, an
		String str = "";
		if (series.indexOf("(") == -1) str = series;
		else str = series.substring(0, series.indexOf("(") - 1);
		String[] filterList = {"of", "in", "the", "at", "to", "by", "per", "on", "a", "an"};
		String[] arr = str.split(" ");		
		String acronym = "";
		
		for (int i = 0; i < arr.length; i++) {
			boolean filter = true;
			for (int j = 0; j < filterList.length; j++) if (arr[i].equalsIgnoreCase(filterList[j])) filter = false;
			if (filter) acronym += arr[i].charAt(0);
		}
		return acronym.toUpperCase();
	}
	
	public String getTrend() {
	// returns up, down, or no trend depending on which direction the data is trending
		if (trendsUp() == true) return "up";
		else if (trendsDown() == true) return "down";
		else return "no trend";
	}
	
	private boolean trendsUp() {
	// returns a boolean representing whether each successive data point is higher than the previous one
		for (int i = 1; i < data.size(); i++) if (data.get(i) <= data.get(i - 1)) return false;
		return true;
	}
	
	private boolean trendsDown() {
	// returns a boolean representing whether each successive data point is lower than the previous one
		for (int i = 1; i < data.size(); i++) if (data.get(i) >= data.get(i - 1)) return false;
		return true;
	}

	public String toString() {
	// returns a summary of the country
		String summary = "";
		for (Integer year : years) summary += year + "\t\t";
		summary += "\n";
		for (Double datum : data) summary += ((double) Math.round(datum * 100) / 100) + "\t\t";
		summary += "\nThis is the \"" + series + "\" for " + name;
		summary += "\nMaximum: " + ((double) Math.round(max() * 100) / 100);
		summary += "\nMinimum: " + ((double) Math.round(min() * 100) / 100);
		summary += "\nTrending: " + getTrend();
		return summary;
	}
	
	public double max() {
	// returns the highest value in the data stored for the country
		double max = data.get(0);
		for (Double datum : data) if (datum > max) max = datum;
		return max;
	}
	
	public double min() {
	// returns the lowest value in the data stored for the country
		double min = data.get(0);
		for (Double datum : data) if (datum < min) min = datum;
		return min;
	}
}