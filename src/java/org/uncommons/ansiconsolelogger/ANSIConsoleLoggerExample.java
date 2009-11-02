// ============================================================================
//   Copyright 2002-2009 Daniel W. Dyer
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
// ============================================================================
package org.uncommons.ansiconsolelogger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import java.util.Properties;

/**
 * Simple test/demo program for Log4J colour-coded console appender.
 * @author Daniel Dyer
 */
public class ANSIConsoleLoggerExample
{
    private static final Logger logger = Logger.getLogger(ANSIConsoleLoggerExample.class);

    public static void main(String[] args)
    {
        // Basic Log4J configuration.
        Properties properties = new Properties();
        properties.setProperty("log4j.rootLogger", "TRACE,stdout");
        properties.setProperty("log4j.appender.stdout", "org.uncommons.ansiconsolelogger.ANSIConsoleAppender");
        properties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        properties.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");
        PropertyConfigurator.configure(properties);

        logger.fatal("This is a FATAL message.");
        logger.error("This is an ERROR message.");
        logger.warn("This is a WARN message.");
        logger.info("This is an INFO message.");
        logger.debug("This is a DEBUG message.");
        // Allow this to work with old versions of Log4J that don't have trace.
        try
        {
            logger.trace("This is a TRACE message.");
        }
        catch (NoSuchMethodError err)
        {
            System.out.println("Trace messages not supported by this version of Log4J.");
        }
    }
}
