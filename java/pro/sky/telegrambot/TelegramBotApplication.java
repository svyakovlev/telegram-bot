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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String localMomentString = LocalDateTime.now().format(formatter);

        if (notificationTaskRepository.findNotificationTaskByNotificationMoment(localMomentString) != null) {
            Long chatId = notificationTaskRepository.findNotificationTaskByNotificationMoment(localMomentString).getChatId();
            String notificationMessage = notificationTaskRepository.findNotificationTaskByNotificationMoment(localMomentString).getNotificationMessage();

            SendMessage replyMessage = new SendMessage(chatId, notificationMessage);
            telegramBot.execute(replyMessage);
        }
    }
}
