package com.example.popovgym.pojo;

public class ServerResponce {
    private Notice notice;
    public class Notice{
        private String answer;
        private int token;

        private String text;

        public Notice(String answer) {
            this.answer = answer;
            this.text = answer;
        }

        public Notice(int token) {
            this.token = token;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public int getToken() {
            return token;
        }

        public void setToken(int token) {
            this.token = token;
        }
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }
}
