/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author NobleSoft
 */
public class ReadFile {
    public void readData(BufferedReader csvBR) throws IOException {
        // we declare and initialise variables...
        String csvLine;//A string for storing each read csv Line
        String csvSplitBy = ",";//A string that tells the reader how to splint the csv entries.
        //using (,) makes it read column by column while using (\n) make is read row by row
        int noOfRows = 10;//Integer that indicates number of Rows in a column in the csv file

        //here we will try to map the contents of the csv file
        //we will do this by storing the contents in an array list so we can easily make reference to the index we need...
        ArrayList<String[]> csvArray = new ArrayList<String[]>(); //A String ArrayList for storing the read data...
        //this while loop populates our array list with every entry in the csv file
        while ((csvLine = csvBR.readLine()) != null) { // Read and store a single Line from the file until there are no more lines to read...

            String[] colEntry = new String[noOfRows]; // Each column has 10 entries, so we declare a string array that can take 10 strings.

            for (int i = 0; i < noOfRows; i++) { // For each entry in the csv that we've read:
                String[] content = csvLine.split(csvSplitBy);
                colEntry[i] = content[i]; // Place the entry into the 'i'th "column"
            }

            csvArray.add(colEntry); // Add the column entry into to the Array list.
        }
        //now our entire csv file is in an Array list...
        //we then use a for loop to loop through the Array list which is an EXACT replica of our csv and get our desired indexes...
        for (int i = 0; i < csvArray.size(); i++) {
            System.out.print(csvArray.get(i)[i] + " ");

        }
        //close the buffered reader...
        csvBR.close();
        //return carriage...
        System.out.println();

    }

    
}
