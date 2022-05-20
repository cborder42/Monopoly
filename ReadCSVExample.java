//Java reading CSV demo

import java.io.*;

import java.util.Scanner;

public class ReadCSVExample{

   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(new File("CSVDemo.csv"));
      
      sc.useDelimiter(",");
      
      while (sc.hasNext()){
         System.out.print(sc.next() + " ");
      }
      
      sc.close();
   }
}
