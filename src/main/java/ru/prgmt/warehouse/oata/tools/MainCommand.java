package ru.prgmt.warehouse;

import ru.prgmt.warehouse.application.ApplicationController;
import ru.prgmt.warehouse.application.result.CommandResult;
import ru.prgmt.warehouse.application.result.ErrorResult;
import ru.prgmt.warehouse.application.result.PagedResult;
import ru.prgmt.warehouse.application.result.PromptResult;
import ru.prgmt.warehouse.application.*;


import java.util.Map;
import java.util.HashMap;

public class MainCommand implements ApplicationController {

    public Map<String, String> getAvailableCommands() {
        Map staff = new HashMap<String, String>();                 
        staff.put("delete", "delete all"); 
        staff.put("list", "show all"); 
        return staff;
    }

    /**
     * Выполнить команду, применяя постраницную навигацию с сортировкой, если это применимо
     * @param name Название команды
     * @param parameters Параметры команды
     * @param paging Запрос постраничной навигации и сортировки
     * @return Результат выполнения команды
     * @see ErrorResult
     * @see PromptResult
     * @see PagedResult
     */
    public CommandResult executeCommand(String name, Map<String, String> parameters, Paging paging) throws CommandNotFoundException {        
        CommandResult promt;            
        if(paging.getPageNumber() == 0) { 
            promt = new PromptResult("list", "Пожалуйста введите параметры сортировки", "Число");           
        } else {
            DatabaseXml db = new DatabaseXml();
            Page page = new Page(db.getBase(),paging,0);
            promt = new PagedResult(null);                        
        }               
        return promt;   
    }

}
