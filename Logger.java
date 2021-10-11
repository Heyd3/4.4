package Market;

public class Logger {
    protected int num = 1;
    void log(){
        System.out.println("День " + num++ );
    }

    private static Logger logger;
    private Logger() {}
    public static Logger getInstance() {
        if (logger==null) logger = new Logger();
        return logger;
    }
}
