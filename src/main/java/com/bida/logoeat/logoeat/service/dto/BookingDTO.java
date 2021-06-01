package com.bida.logoeat.logoeat.service.dto;


public class BookingDTO {

    private int restaurantId;

    private Long bookingDate;

    private String userName;

    private int peopleAmount;

    public BookingDTO(){}

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Long bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "restaurantId='" + restaurantId + '\'' +
                ", bookingDate=" + bookingDate +
                ", userName='" + userName + '\'' +
                ", peopleAmount=" + peopleAmount +
                '}';
    }
}
