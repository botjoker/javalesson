package ru.prgmt.warehouse;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException; 
import java.util.ArrayList;
import java.lang.Object;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Map;
import java.util.HashMap;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import ru.prgmt.warehouse.application.*;

import ru.prgmt.warehouse.application.result.CommandResult;
import ru.prgmt.warehouse.application.result.ErrorResult;
import ru.prgmt.warehouse.application.result.PagedResult;
import ru.prgmt.warehouse.application.result.PromptResult;



public class Catalog {		

    public static void main(String[] args) {
        MainCommand mainCommand = new MainCommand();    	

        Scanner scanner = new Scanner(System.in);		
		while(scanner.hasNext()) {
		    String commandLine = scanner.nextLine();
		    for (String s: args) {
	            System.out.println(s);
	        }
		    commandLine = commandLine.trim();		    
            String command = commandLine.split(" ")[0];
		    if(command.equals("exit")) {
		    	// db.rewriteBase();
		        break;
		    }
		    if(command.equals("delete")) {
		    	if(commandLine.contains("--sku ")) {		    		
		    		// db.deleteItem(commandLine.split("--sku ")[1].trim());
	    		} else {
	    			System.out.println("Не указан инвентарный номер, - вы действительно хотите очистить всю БД? (y или yes): ");
	    			String deleteCommandLine = scanner.nextLine();
					if(deleteCommandLine.equals("y") || deleteCommandLine.equals("yes")) {
						// db.deleteAll();
						System.out.println("База данных очищена");
					}

	    		}	    		
		    }	
		    if(command.equals("add")) {		    	
		    	
		    }		    
		    if(command.equals("list")) {
		    	Map parameters = new HashMap<String, String>();                 
        		parameters.put("", ""); 
		    	Paging dummyPaging = new Paging(0, 0, null, false);		    	
		    	CommandResult commandResult;
		    	Page page;
		    	try {
	    			commandResult = mainCommand.executeCommand("list", parameters, dummyPaging);	    		
	    			if(commandResult instanceof PromptResult) { 
	    				System.out.println("Введите Старницу, Размер страницы, Поле сортировки и признак сортировки");
	    				String commandListLine1 = scanner.nextLine();
	    				String commandListLine2 = scanner.nextLine();
	    				String commandListLine3 = scanner.nextLine();
	    				String commandListLine4 = scanner.nextLine();
	    				Paging paging = new Paging(Integer.parseInt(commandListLine1), Integer.parseInt(commandListLine2), commandListLine3, true);
	    				commandResult = mainCommand.executeCommand("list", parameters, paging);	    		
	    				if(commandResult instanceof PagedResult) { 
	    					// page = commandResult.getResult();
	    					System.out.println("Вывод базы");
	    				}

					}
    			} catch (CommandNotFoundException e) {

    			}    					        
    					       		       
		    }		    
		}		
        
    }
      
}



	
