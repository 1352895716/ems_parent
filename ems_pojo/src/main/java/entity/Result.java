package entity;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/1/9 19:43
 * @Version 1.0
 **/
public class Result implements Serializable{
    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
