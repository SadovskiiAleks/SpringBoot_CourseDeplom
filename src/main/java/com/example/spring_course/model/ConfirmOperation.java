package com.example.spring_course.model;

public class ConfirmOperation {

    String operationId;
    String code;

    public ConfirmOperation() {
    }

    public int getOperationId() {
        return Integer.parseInt(operationId);
    }

    public String getCode() {
        return this.code;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ConfirmOperation)) return false;
        final ConfirmOperation other = (ConfirmOperation) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$operationId = this.getOperationId();
        final Object other$operationId = other.getOperationId();
        if (this$operationId == null ? other$operationId != null : !this$operationId.equals(other$operationId))
            return false;
        final Object this$code = this.getCode();
        final Object other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ConfirmOperation;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $operationId = this.getOperationId();
        result = result * PRIME + ($operationId == null ? 43 : $operationId.hashCode());
        final Object $code = this.getCode();
        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
        return result;
    }

    public String toString() {
        return "ConfirmOperation(operationId=" + this.getOperationId() + ", code=" + this.getCode() + ")";
    }
}
