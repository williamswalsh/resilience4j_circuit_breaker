package ie.williamswalsh.resilience4j_circuit_breaker.model;

public record Activity(String activity, String type, int participants, int price, String link, String key, int accessibility) {}
