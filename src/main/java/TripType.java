import java.time.LocalDateTime;

public enum TripType {
    RIVER_TRIP(30), LAKE_TRIP(0);

    private int offset;

    TripType(int offset) {
        this.offset = offset;
    }

    public LocalDateTime getStartTime(final LocalDateTime baseTime) {
        return baseTime.plusMinutes(offset);
    }
}
