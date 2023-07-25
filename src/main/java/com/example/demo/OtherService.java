package com.example.demo;

public class OtherService {
    @MyInject
    private OtherRepository otherRepository;

    public OtherRepository getOtherRepository() {
        return this.otherRepository;
    }

}
