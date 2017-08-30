package cn.javass.spring.bean;

import java.util.List;

public class ListTestBean {
	private List<String> values;  
    public List<String> getValues() {  
        return values;  
    }  
    public void setValues(List<String> values) {  
        this.values = values;  
    }  
    public void printValues() {  
    		for (String value : values) {
    			System.out.println(value); 
    		}
    } 
    
}
