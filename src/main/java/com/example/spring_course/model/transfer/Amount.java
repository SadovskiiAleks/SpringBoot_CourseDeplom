package com.example.spring_course.model.transfer;

public class Amount {
    int value;
    String currency;

    public Amount(String currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Amount)) return false;
        final Amount other = (Amount) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getValue() != other.getValue()) return false;
        final Object this$currency = this.getCurrency();
        final Object other$currency = other.getCurrency();
        if (this$currency == null ? other$currency != null : !this$currency.equals(other$currency)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Amount;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getValue();
        final Object $currency = this.getCurrency();
        result = result * PRIME + ($currency == null ? 43 : $currency.hashCode());
        return result;
    }

    public String toString() {
        return "Amount(value=" + this.getValue() + ", currency=" + this.getCurrency() + ")";
    }
}
