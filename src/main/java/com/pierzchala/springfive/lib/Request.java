package com.pierzchala.springfive.lib;

import com.google.gson.annotations.Expose;

public class Request {
    @Expose
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
