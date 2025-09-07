package com.airline.model;

public class Aircraft {
    private final String id;
    private final String model;
    private final double maxTakeoffWeight;
    private final double operatingEmptyWeight;
    private final double availablePayload;

    public Aircraft(String id, String model, double maxTakeoffWeight, double operatingEmptyWeight, double availablePayload) {
        this.id = id;
        this.model = model;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.operatingEmptyWeight = operatingEmptyWeight;
        this.availablePayload = availablePayload;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public double getMaxTakeoffWeight() { return maxTakeoffWeight; }
    public double getOperatingEmptyWeight() { return operatingEmptyWeight; }
    public double getAvailablePayload() { return availablePayload; }

    @Override
    public String toString() {
        return String.format("Aircraft{id='%s', model='%s', maxTakeoffWeight=%.1f, operatingEmptyWeight=%.1f, availablePayload=%.1f}",
                id, model, maxTakeoffWeight, operatingEmptyWeight, availablePayload);
    }
}
