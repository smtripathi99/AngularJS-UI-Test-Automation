package com.ig.automation.utility;

import java.text.ParseException;

public class Sorting {

 
    public static String verifySortingForColumn(String columnData1,String columnData2) throws InterruptedException, ParseException {
 
        String col1 = columnData1; //First data in the specific column AN-324 
        String col2 = columnData2; //Second data in the same specific column AN-123        
 
        try {
 
            if (col1.compareTo(col2)>0) { 
                return "Pass: " + "List sorted in ascending order by"; 
            } 
        }
 
        catch (Exception e) {
 
            Log.debug("Error " + e); 
            return "Fail"; 
        }
 
        return "Fail: "+ "List not sorted in ascending order by";       
 
   	}
    
    public static String isSorted(String[] arrayS) {
        int n = arrayS.length;
        for (int i = 0; i < n - 1; ++i)
            if (arrayS[i].compareTo(arrayS[i+1]) > 0)
                return "not ascending";
        return "ascending";
    }
    
  }
 
