package com.lq.login.exception;

import java.util.HashMap;
import java.util.Map;

public class ParamException extends Exception{
    private static final long serialVersionUID = -8242541159389928728L;
    Map<String, String> errorFileds = new HashMap<String, String>();

    public Map<String, String> getErrorFileds() {
        return errorFileds;
    }
    public void setErrorFileds(Map<String, String> errorFileds) {
        this.errorFileds = errorFileds;
    }
    public void addErrorFileds(String filedName, String message) {
        errorFileds.put(filedName, message);
    }
    public boolean isErrorFileds() {
        return !errorFileds.isEmpty();
    }
}
