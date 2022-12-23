package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Service
public class TimeService {

    public boolean compareWithLocalDateAndTime(LocalDateTime notificationDateAndTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime localDateAndTime = LocalDateTime.parse(LocalDateTime.now().format(formatter), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

        if (notificationDateAndTime.equals(localDateAndTime)) {
            return true;
        } else {
            return false;
        }
    }
}
