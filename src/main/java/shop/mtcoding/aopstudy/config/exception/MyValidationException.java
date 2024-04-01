package shop.mtcoding.aopstudy.config.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class MyValidationException extends Throwable {
    private Map<String, String> errorMap;

    public MyValidationException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}
