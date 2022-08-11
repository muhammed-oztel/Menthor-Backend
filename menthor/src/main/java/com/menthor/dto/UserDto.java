package com.menthor.dto;

public class UserDto {
    public static class Response{
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class RatingResp{
        private Double userRating;
        private String nameSurname;
        private String picture;

        public Double getUserRating() {
            return userRating;
        }

        public void setUserRating(Double userRating) {
            this.userRating = userRating;
        }

        public String getNameSurname() {
            return nameSurname;
        }

        public void setNameSurname(String nameSurname) {
            this.nameSurname = nameSurname;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
