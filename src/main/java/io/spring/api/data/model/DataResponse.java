package io.spring.api.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataResponse {

    private boolean success;
    private Result result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
