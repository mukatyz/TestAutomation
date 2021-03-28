package com.certification.automation.models;

public enum Routes {

    CONSULT_USERS_LIST("/api/users?page="),
    USER("/api/users");

    private final String routeService;

    Routes(String routeService) {
        this.routeService = routeService;
    }

    public String getRouteService() {
        return routeService;
    }
}