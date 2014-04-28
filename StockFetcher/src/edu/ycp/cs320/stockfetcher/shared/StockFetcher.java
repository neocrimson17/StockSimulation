package edu.ycp.cs320.stockfetcher.shared;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;

public class StockFetcher {

	public static void main(String[] args) throws IOException {
		
		StockFetcher stockFetcher = new StockFetcher();
		stockFetcher.writing();
		
	}
	
	public void writing() throws IOException {
		
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
				
				// Copy file from StockFetcher directory into StockSimulationPersistence directory
				File source = new File("stockPrices.csv");
				File dest = new File("H://CS 320 Software Engineering and Design//StockSimulation//StockSimulationPersistence//bin//edu//ycp//cs320//stocksimulation//server//model//persist//res//stockPrices.csv");
				copyFile( source, dest );
				
	}
	
	// Gets data from Yahoo API
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
	
	
	// Copy file from StockFetcher directory into StockSimulationPersistence directory
	public static void copyFile( File source, File dest ) throws IOException {
		if(!dest.exists()) {
			dest.createNewFile();
		}
		
		FileChannel sourceFile = null;
		FileChannel destFile = null;
		
		try {
			sourceFile = new FileInputStream( source ).getChannel();
			destFile = new FileOutputStream( dest ).getChannel();
			destFile.transferFrom( sourceFile, 0, sourceFile.size());
			System.out.println("Copy success!");
		}
		finally {
			if( sourceFile != null ) {
				sourceFile.close();
			}
			if( destFile != null ) {
				destFile.close();
			}
		}
	}
}


