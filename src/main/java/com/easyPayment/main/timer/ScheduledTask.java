package com.easyPayment.main.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("testTask")
public class ScheduledTask {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public void reportCurrentTime() {
        log.info("The System Bank Balance Has Been cleared ", dateFormat.format(new Date()));
    }

}
