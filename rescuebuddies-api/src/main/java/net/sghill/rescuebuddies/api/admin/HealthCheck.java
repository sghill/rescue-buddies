package net.sghill.rescuebuddies.api.admin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthCheck {
    private final boolean healthy;

    @JsonCreator
    public HealthCheck(@JsonProperty("healthy") boolean healthy) {
        this.healthy = healthy;
    }

    public boolean isHealthy() {
        return healthy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HealthCheck that = (HealthCheck) o;

        if (healthy != that.healthy) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (healthy ? 1 : 0);
    }

    @Override
    public String toString() {
        return "HealthCheck{" +
                "healthy=" + healthy +
                '}';
    }
}
