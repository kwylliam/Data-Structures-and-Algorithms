public class ConsoleColors {
    
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";    
    
    public static final String BG_ANSI_BLACK = "\u001B[40m";
    public static final String BG_ANSI_RED = "\u001B[41m";
    public static final String BG_ANSI_GREEN = "\u001B[42m";
    public static final String BG_ANSI_YELLOW = "\u001B[43m";
    public static final String BG_ANSI_BLUE = "\u001B[44m";
    public static final String BG_ANSI_PURPLE = "\u001B[45m";
    public static final String BG_ANSI_CYAN = "\u001B[46m";
    public static final String BG_ANSI_WHITE = "\u001B[47m";    
    
    
    public static void main(String[] args)
    {
        System.out.println(ANSI_WHITE + BG_ANSI_BLUE + "This text is WHITE on a BLUE background" + ANSI_RESET); 
        
        System.out.println("THIS IS " + ANSI_YELLOW + "YELLOW ON DIFFERENT BACKGROUNDS " 
                            + BG_ANSI_RED + " RED "  
                            + BG_ANSI_GREEN + " GREEN "
                            + BG_ANSI_PURPLE + " PURPLE "
                            + BG_ANSI_CYAN + " CYAN "
                            + ANSI_RESET
                            );
    }
    }