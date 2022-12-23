package pro.sky.telegrambot.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NotificationTask {

    @Id
    @GeneratedValue
    private Long id;
    private Long chatId;
    private String notificationText;
    private String notificationDateAndTime;

    public NotificationTask(Long id, Long chatId, String notificationText, String notificationDateAndTime) {
        this.id = id;
        this.chatId = chatId;
        this.notificationText = notificationText;
        this.notificationDateAndTime = notificationDateAndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getDateAndTime() {
        return notificationDateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.notificationDateAndTime = dateAndTime;
    }
}
