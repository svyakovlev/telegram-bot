package pro.sky.telegrambot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pro.sky.telegrambot.repository.NotificationTaskRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableScheduling
public class TelegramBotApplication {
    @Autowired
    private TelegramBot telegramBot;

    @Autowired
    private final NotificationTaskRepository notificationTaskRepository;

    public TelegramBotApplication(NotificationTaskRepository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class, args);
    }

    @Scheduled(fixedDelay = 60_000L)
    public void run() {

        LocalDateTime notificationDateAndTime = LocalDateTime.parse("26.12.2022 23:28", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime localDateAndTime = LocalDateTime.parse(LocalDateTime.now().format(formatter), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

        if (notificationDateAndTime.equals(localDateAndTime)) {
            SendMessage replyMessage = new SendMessage(5000126412L, "UserMessage");
            telegramBot.execute(replyMessage);
        }

    }
}
