package com.softserveinc.ddob.defaultmethod;

import org.apache.log4j.Logger;

public interface Loggable {
    default Logger getLogger() {
        return Logger.getLogger(getClass());
    }
}
