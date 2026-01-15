package com.eapl.excellence.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.TimeZone;

@WebListener
public class TimeZoneInitializer implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Force UTC timezone on startup
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("[ServletContext] Timezone set to UTC");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cleanup if needed
    }
}