package com.example;

public class MyService {
    private ExternalApi externalApi;

    // Constructor Injection (Important for Mocking)
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        // This method calls the external API
        return externalApi.getData();
    }
}