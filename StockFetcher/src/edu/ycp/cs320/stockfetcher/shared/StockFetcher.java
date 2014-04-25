package edu.ycp.cs320.stockfetcher.shared;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StockFetcher {

	public static void main(String[] args) {
		
		StockFetcher stockFetcher = new StockFetcher();
		stockFetcher.writing();
		
	}
	
	public void writing() {
		
		// Create new file
				try{
					FileWriter writer = new FileWriter( "stockPrices.csv", true );
					
					//Google
					String text = getData("GOOG");
					writer.append( text + "," + System.currentTimeMillis() + '\n' );
					
					//Yahoo
					text = getData("YHOO");
					writer.append( text + "," + System.currentTimeMillis() + '\n' );
					
					//Intel
					text = getData("INTL");
					writer.append( text + "," + System.currentTimeMillis() + '\n' );
					
					writer.flush();
					writer.close();
					
					System.out.println("\nWrite Success!");
					
				} catch ( IOException e ) {
					System.err.println("Problem writing to the file");
				}
	}
	
	public String getData( String symbol ) {
	
		String inputLine;
		String output= "error";
	try {
		URL url;
		
		String baseUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=%40%5EDJI," + symbol + "&f=snl1&e=.csv";
		
		url = new URL( baseUrl );
		URLConnection conn = url.openConnection();
		
		BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream()));
		
		while( (inputLine = br.readLine()) != null ) {
			System.out.println( inputLine );
			output = inputLine;
		}
	
		br.close();
		
		
		
	} catch ( MalformedURLException e) {
		e.printStackTrace();
	} catch ( IOException e ) {
		e.printStackTrace();
	}
	return output;
	}
}


