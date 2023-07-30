package com.example.spring_course.exception;

public class ErrorObject {
    private String massage;
    private int id;

    public ErrorObject(String massage, int id) {
        this.massage = massage;
        this.id = id;
    }

    public String getMassage() {
        return this.massage;
    }

    public int getId() {
        return this.id;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ErrorObject)) return false;
        final ErrorObject other = (ErrorObject) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$massage = this.getMassage();
        final Object other$massage = other.getMassage();
        if (this$massage == null ? other$massage != null : !this$massage.equals(other$massage)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorObject;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $massage = this.getMassage();
        result = result * PRIME + ($massage == null ? 43 : $massage.hashCode());
        result = result * PRIME + this.getId();
        return result;
    }

    public String toString() {
        return "ErrorObject(massage=" + this.getMassage() + ", id=" + this.getId() + ")";
    }
}
