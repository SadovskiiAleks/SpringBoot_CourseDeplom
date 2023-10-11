package com.example.spring_course.model.transfer;


public record Transfer(String cardFromNumber,
                       String cardFromValidTill, String cardFromCVV,
                       String cardToNumber, Amount amount) {
    public int[] getCardFromValidTill() {
        String month = this.cardFromValidTill.substring(0, 2);
        String year = this.cardFromValidTill.substring(3, 5);
        int[] validDate = new int[2];
        validDate[0] = Integer.parseInt(month);
        validDate[1] = Integer.parseInt(year);
        return validDate;
    }
}
