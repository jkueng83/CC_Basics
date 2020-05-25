package cc.jku.ioWrite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeString {

        public String getDateTimeYYYYmmddHHmmssSSS() {
            String pattern = "yyyy.MM.dd - HH:mm:ss.SSS"; // Stunde:Minute:Sekunde:Millisekunde:
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateTime = simpleDateFormat.format(new Date());

            return dateTime;
        }



}
