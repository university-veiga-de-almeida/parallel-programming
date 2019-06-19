package thiago;

import java.io.IOException;

public class Console {
    private static final ProcessBuilder process = new ProcessBuilder("cmd", "/c", "cls");
    
    public static void clearScreen() {  
        try {
            process.inheritIO().start().waitFor();
        } catch(IOException | InterruptedException e) {}  
    } 
}
