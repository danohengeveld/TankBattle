package nl.han.ica.oopdprocessingenginehan.logger;

/**
 * The LogFactory holds the current logger object.
 */
public class LogFactory {
	
    private static Logger logger;

    /**
     * Create a new LogFactory.
     */
    private LogFactory() {}

    /**
     * Gets the current logger.
     * @return
     */
    public static synchronized Logger getLogger() {
        
    	if (logger == null)
        {
            logger = new DefaultLogger();
        }
        
        return logger;
    }
}