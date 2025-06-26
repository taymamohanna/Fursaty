package com.kicklance.fursaty.models;


public class ResponseData<T> {
    private final boolean status;
    private final Message message;
    private final T data;

    public ResponseData(boolean status, Message message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public Message getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static class Message {
        private final String message;

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
