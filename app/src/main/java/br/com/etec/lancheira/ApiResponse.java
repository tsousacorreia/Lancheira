package br.com.etec.lancheira;

public class ApiResponse<T> {
    private boolean error;
    private String message;
    private T data;

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}