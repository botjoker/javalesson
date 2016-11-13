package oata;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException; 
import java.util.ArrayList;
import java.lang.Object;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Catalog {	

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("-----");
        System.out.println("- Type 'exit' to exit");
        System.out.println("- Type 'list' to show all catalog");
        System.out.println("- Type 'delete -- sku [number]' to delete item from catalog");
       

        Database db = new Database(); // Read from database
        


        Scanner scanner = new Scanner(System.in);		
		while(scanner.hasNext()) {
		    String commandLine = scanner.nextLine();
		    commandLine = commandLine.trim();		    
            String command = commandLine.split(" ")[0];
		    if(command.equals("exit")) {
		        break;
		    }
		    if(command.equals("delete")) {
		    	if(commandLine.contains("--sku ")) {
		    		db.deleteItem(commandLine.split("--sku ")[1].trim());
	    		} else {
	    			System.out.println("Не указан инвентарный номер, - вы действительно хотите очистить всю БД? (y или yes): ");
	    			String deleteCommandLine = scanner.nextLine();
					if(deleteCommandLine.equals("y") || deleteCommandLine.equals("yes")) {
						db.deleteAll();
						System.out.println("База данных очищена");
					}

	    		}
	    		// System.out.println(commandLine);
	    		// System.out.println(commandLine.contains("--sku"));
		    	// db.deleteItem("1001");		    	
		    }		    
		    if(command.equals("list")) {
		        for(Device dev : db.getBase()){
					switch (dev.typ) {
			        	case "Printer":	
			        		System.out.println(((Printer)dev).print());	
			        	break;
			        	case "Monitor":	
			        		System.out.println(((Monitor)dev).print());	
			        	break;
			        	case "Scanner":	
			        		System.out.println(((Scan)dev).print());	
			        	break;		        	
					}        	                    
		        }  
		    }		    
		}		
        
    }
      
}



	
