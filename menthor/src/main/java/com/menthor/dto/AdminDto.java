package com.menthor.dto;

public class AdminDto {

    public static class MatchResp{
        private Long matchId;
        private String mentor;
        private String mentee;

        public Long getMatchId() {
            return matchId;
        }

        public void setMatchId(Long matchId) {
            this.matchId = matchId;
        }

        public String getMentor() {
            return mentor;
        }

        public void setMentor(String mentor) {
            this.mentor = mentor;
        }

        public String getMentee() {
            return mentee;
        }

        public void setMentee(String mentee) {
            this.mentee = mentee;
        }
    }
}
