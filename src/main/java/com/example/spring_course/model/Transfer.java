package com.example.spring_course.model;


public class Transfer {
    String cardFromNumber;
    String cardFromValidTill;
    String cardFromCVV;
    String cardToNumber;
    Amount amount;

    public Transfer() {
    }


    public Long getCardFromNumber() {

        return Long.parseLong(this.cardFromNumber);
    }

    public int[] getCardFromValidTill() {
        String month = this.cardFromValidTill.substring(0,2);
        String year = this.cardFromValidTill.substring(3,5);

        int[] validDate = new int[2];
        validDate[0] = Integer.parseInt(month);
        validDate[1] = Integer.parseInt(year);

        return validDate;
    }

    public Integer getCardFromCVV() {
        return Integer.parseInt(this.cardFromCVV) ;
    }

    public Long getCardToNumber() {
        return Long.parseLong(this.cardToNumber);
    }

    public Amount getAmount() {
        return this.amount;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Transfer)) return false;
        final Transfer other = (Transfer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$cardFromNumber = this.getCardFromNumber();
        final Object other$cardFromNumber = other.getCardFromNumber();
        if (this$cardFromNumber == null ? other$cardFromNumber != null : !this$cardFromNumber.equals(other$cardFromNumber))
            return false;
        final Object this$cardFromValidTill = this.getCardFromValidTill();
        final Object other$cardFromValidTill = other.getCardFromValidTill();
        if (this$cardFromValidTill == null ? other$cardFromValidTill != null : !this$cardFromValidTill.equals(other$cardFromValidTill))
            return false;
        final Object this$cardFromCVV = this.getCardFromCVV();
        final Object other$cardFromCVV = other.getCardFromCVV();
        if (this$cardFromCVV == null ? other$cardFromCVV != null : !this$cardFromCVV.equals(other$cardFromCVV))
            return false;
        final Object this$cardToNumber = this.getCardToNumber();
        final Object other$cardToNumber = other.getCardToNumber();
        if (this$cardToNumber == null ? other$cardToNumber != null : !this$cardToNumber.equals(other$cardToNumber))
            return false;
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Transfer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $cardFromNumber = this.getCardFromNumber();
        result = result * PRIME + ($cardFromNumber == null ? 43 : $cardFromNumber.hashCode());
        final Object $cardFromValidTill = this.getCardFromValidTill();
        result = result * PRIME + ($cardFromValidTill == null ? 43 : $cardFromValidTill.hashCode());
        final Object $cardFromCVV = this.getCardFromCVV();
        result = result * PRIME + ($cardFromCVV == null ? 43 : $cardFromCVV.hashCode());
        final Object $cardToNumber = this.getCardToNumber();
        result = result * PRIME + ($cardToNumber == null ? 43 : $cardToNumber.hashCode());
        final Object $amount = this.getAmount();
        result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
        return result;
    }

    public String toString() {
        return "Transfer(cardFromNumber=" + this.getCardFromNumber() + ", cardFromValidTill=" + this.getCardFromValidTill() + ", cardFromCVV=" + this.getCardFromCVV() + ", cardToNumber=" + this.getCardToNumber() + ", amount=" + this.getAmount() + ")";
    }
}
