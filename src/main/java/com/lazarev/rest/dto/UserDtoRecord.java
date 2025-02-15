//package com.lazarev.rest.dto;
//
//import java.util.Objects;
//
////Java 17
//public record UserDtoRecord(String username, String email) { }
//
//class UserDtoRecord {
//    private final String username;
//    private final String email;
//
//    UserDtoRecord(String username, String email) {
//        this.username = username;
//        this.email = email;
//    }
//
//    public String username() {
//        return username;
//    }
//
//    public String email() {
//        return email;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserDtoRecord that = (UserDtoRecord) o;
//        return Objects.equals(username, that.username) && Objects.equals(email, that.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, email);
//    }
//
//    @Override
//    public String toString() {
//        return "UserDtoRecord{" +
//                "username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
//}
