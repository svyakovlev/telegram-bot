package pro.sky.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.NotificationTaskRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NotificationTaskService {

    @Autowired
    private final NotificationTaskRepository notificationTaskRepository;


    public NotificationTaskService(NotificationTaskRepository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
    }

//    public void createNotification(Long chatId, String userMessage) {
//
//        String notificationText = userMessage.substring(17);
//        LocalDateTime notificationDateAndTime = LocalDateTime.parse(userMessage.substring(0, 16), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
//
//        NotificationTask notificationTask = new NotificationTask();
//        notificationTask.setChatId(chatId);
//        notificationTask.setDateAndTime(notificationDateAndTime);
//        notificationTask.setNotificationText(notificationText);
//
//        notificationTaskRepository.save(notificationTask);
//    }

    public String scanUserMessage(Long chatId, String userMessage) {

        Pattern pattern = Pattern.compile("([0-9\\.\\:\\s]{16})(\\s)(.+)");
        Matcher matcher = pattern.matcher(userMessage);

        if (userMessage.equals("/start")) {
            String scanMessage = "Введи сообщение в формате ДД.ММ.ГГГГ ЧЧ:ММ <текст сообщения>";
            return scanMessage;
        } else if (matcher.matches()) {
            NotificationTask notificationTask = new NotificationTask();
            notificationTask.setChatId(5000126412L);
            notificationTask.setNotificationText("Текст напоминания");
            notificationTask.setDateAndTime("01.01.2020 15:15");

            notificationTaskRepository.save(notificationTask);

            String scanMessage = "Напоминание сохранено.";
            return scanMessage;
        } else {
            String scanMessage = "Не верный запрос.";
            return scanMessage;
        }
    }
}
