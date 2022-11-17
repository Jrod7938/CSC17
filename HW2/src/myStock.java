import java.io.*;
import java.math.*;
import java.util.*;

import yahoofinance.*;

// to store the stock name and price
class stockInfo {
	private String name;
	private BigDecimal price;
	public stockInfo(String nameIn, BigDecimal priceIn) {
		name = nameIn; price = priceIn;
	}
	public String toString() {return name + " " + price.toString();}

	public String getName(){ return name; }
	public BigDecimal getPrice(){ return price; }
	public void setPrice(BigDecimal price){ this.price = price; }
}

public class myStock {
	static HashMap<String, stockInfo> map = null;
	
	public myStock() {
		map = new HashMap<String, stockInfo>();
	}

	public void insertOrUpdate(String symbol, stockInfo stock) {
		/* 
		 * implemented this method to insert or update the records
		 */

		// if map contains symbol, update symbol
		if(symbol!=null && map.containsKey(symbol)){
			map.replace(symbol, stock);
		}else{
			// put symbol in map if map does not contain symbol
			map.put(symbol, stock);
		}
	}

	public stockInfo get(String symbol) {
		/* 
		 * implemented this method to retrive record from database in O(1) time
		 */
		return map.get(symbol);
	}

	public List<Map.Entry<String, stockInfo>> top(int k) {
		/* 
		 * implemented this method to return the stock records with top k prices in O(k) time
		 */
		// initialized a new list with the entry set of our map
		List<Map.Entry<String, stockInfo>> list = new LinkedList<Map.Entry<String, stockInfo>>(map.entrySet());

		// sorting our map by overriding the compare meathod
		Collections.sort(list, new Comparator<Map.Entry<String, stockInfo>>(){
			@Override
			// compairing bigDecimals
			public int compare(java.util.Map.Entry<String, stockInfo> stock1, java.util.Map.Entry<String, stockInfo> stock2){
				return (stock2.getValue().getPrice()).compareTo(stock1.getValue().getPrice());
			}
		});

		// return the sorted list from 0 to the kth value
		return list.subList(0, k);
	}

	public static void main(String[] args) throws IOException {
		// testing code
		myStock techStock = new myStock();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./US-Tech-Symbols.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] var = line.split(":");
				
				// YahooFinance API is used and make sure the lib files are included in the project build path
				Stock stock = null;
				try {
					stock = YahooFinance.get(var[0]);
				} catch (IOException e) {
					System.out.println("do nothing and skip the invalid stock");
				}
				
				// test the insertOrUpdate method when initializing the database
				if (stock != null && stock.getQuote().getPrice() != null) {
					techStock.insertOrUpdate(var[0], new stockInfo(var[1], stock.getQuote().getPrice()));
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 1;
		System.out.println("===========Top 10 stocks===========");

		// test the top method
		for (Map.Entry<String, stockInfo> element : techStock.top(10)) {
			System.out.println("[" + i + "]" + element.getKey() + " " + element.getValue());
			i++;
		}

		// test the get method
		System.out.println("===========Stock info retrieval===========");
		System.out.println("VMW" + " " + techStock.get("VMW"));
		System.out.println("BIDU" + " " + techStock.get("BIDU"));
	}
}
