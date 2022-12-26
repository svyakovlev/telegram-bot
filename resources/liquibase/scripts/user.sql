-- liquibase formatted sql

--changeset svyakovlev:1
CREATE TABLE notificationTask (
                       id bigint,
                       chatId bigint,
                       notificationMessage text,
                       notificationMoment text
)