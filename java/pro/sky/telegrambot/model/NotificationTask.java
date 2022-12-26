package pro.sky.telegrambot.model;

import javax.persistence.*;

@Entity
public class NotificationTask {

    @Id
    @GeneratedValue
    private Long id;
    private Long chatId;
    private String notificationMessage;
    private String notificationMoment;

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

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public String  getNotificationMoment() {
        return notificationMoment;
    }

    public void setNotificationMoment(String notificationMoment) {
        this.notificationMoment = notificationMoment;
    }
}
