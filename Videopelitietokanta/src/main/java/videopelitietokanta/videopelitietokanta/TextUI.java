/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videopelitietokanta.videopelitietokanta;

import java.util.Scanner;

/**
 *
 * @author tkelomak
 */
public class TextUI {

    public TextUI() {
        
    }
    
    
    
    
        public void start(){
        Scanner reader =new Scanner(System.in);
        
        while(true){
            System.out.println("1 syötä peli, 2 tulosta pelejä, q lopeta");
            
            String input=reader.nextLine();
            
            if(input.equals("1")){
                System.out.println("nyt syötetään peli");
            } else if(input.equals("2")){
                System.out.println("nyt tulostetaan pelejä");
            } else if(input.equals("q")){
                break;
            }
            
            
            
        }
        System.out.println("heihei");
        
        
    }
    
}
