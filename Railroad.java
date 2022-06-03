//Anya
//5/17/2022



import java.io.*;

import java.util.Scanner;

public class Railroad{
   private String roadName;
   private int rent;
   private static boolean owned;
   private int cost;
   private int mortgageV;

   public Railroad(String name){
      cost = 200;
      rent = 25;
      owned = false;
      mortgageV = 100;
   }
   
   
   public int getCost(){
      return cost;
   
   }
   public int getCost(int n){//n is number of properties owned
      return cost*n;
   
   }
   public static boolean alrOwned(){
      return owned;
   }
   

   public static void bought(){
      owned = true; 
   }
   public static void sell(){
      owned = false;
   }
   
}







    /*   boolean alrOwned = false; 
       boolean ifproperty;
   public static String getCard(String color, int index){
      String result;
      int rent = 2;
      int oH = 10;
      int twoH =  30;
      int threeH = 60;
      int fH = 90;
      int Hotel = 150;
      int mortgage = 50;
      
      
      if (color.equals("Brown")){
         if (index == 0){
            result = "1 house: " + oH + "/n2 houses: " + twoH + "/nThree Houses " + threeH + "/nFour Houses" + fH + "/nWith Hotel " + Hotel + "/nMortgage " + mortgage + "/nRent " + rent + "/nProperty? " + ;
         }
         else{
            rent= rent*2; oH = oH*2; twoH *= 2; threeH *= 2; fH *= 2; Hotel *= 3; mortgage += 10;
             result = "1 house: " + oH + "/n2 houses: " + twoH + "/nThree Houses " + threeH + "/nFour Houses" + fH + "/nWith Hotel " + Hotel + "/nMortgage " + mortgage + "/nRent " + rent;
         }
      }
      else if (color.equals("LightBlue")){
         if (index != 2){
            result = "1 house: " + oH + "/n2 houses: " + twoH + "/nThree Houses " + threeH + "/nFour Houses" + fH + "/nWith Hotel " + Hotel + "/nMortgage " + mortgage + "/nRent " + rent;
         }
         else{
            rent= rent*2; oH = oH*2; twoH *= 2; threeH *= 2; fH *= 2; Hotel *= 3; mortgage += 10;
             result = "1 house: " + oH + "/n2 houses: " + twoH + "/nThree Houses " + threeH + "/nFour Houses" + fH + "/nWith Hotel " + Hotel + "/nMortgage " + mortgage + "/nRent " + rent;
         }
      }
      else if (color.equals("Pink")){
      
      }
      else if (color.equals("Orange")){
      
      }
      else if (color.equals("Red")){
      
      }
      else if (color.equals("Yellow")){
      
      }
      else if (color.equals("Green")){
      
      }
      else if (color.equals("DarkBlue")){
      
      }
   
      return result; 
   
   }

   /*public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(new File("MonopolyBoardCards.csv"));
      
      sc.useDelimiter(",");
      
      while (sc.hasNext()){
         System.out.print(sc.next() + " ");
      }
      
      sc.close();
      
   }}
}*/
/*//ALL THIS STUFF IS COPIED RN BC IM JUST TRYING TO MAKE IT WORK
import java.io.File;
import java.io.FileInputStream;  
import java.io.IOException;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  

public class Cards{
   //Going to link with an excel sheet to access info 
   //Excel sheet has different charts for different types of cards
   // it will randomize between the cards of that type and then the information from that card will be printed (maybe graphically)

//obtaining input bytes from a file  
FileInputStream fis=new FileInputStream(new File("C:\Users\ANYAN\OneDrive\Documents\MonopolyBoardCards.xls"));  

HSSFWorkbook wb=new HSSFWorkbook(fis);   
//creating a Sheet object to retrieve the object  
HSSFSheet sheet=wb.getSheetAt(0);  
//evaluating cell type   
FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();  
for(Row row: sheet)     //iteration over row using for each loop  
{  
for(Cell cell: row)    //iteration over cell using for each loop  
{  
switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
{  
case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type  
//getting the value of the cell as a number  
System.out.print(cell.getNumericCellValue()+ "\t\t");   
break;  
case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
//getting the value of the cell as a string  
System.out.print(cell.getStringCellValue()+ "\t\t");  
break;  
}  
}  
System.out.println();  
}  
}  
*/
