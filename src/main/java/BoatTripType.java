import java.time.LocalDateTime;

public enum BoatTripType {
    RIVER_TRIP(30), LAKE_TRIP(0);

    private int offset;

    BoatTripType(int offset) {
        this.offset = offset;
    }

    public LocalDateTime getStartTime(final LocalDateTime baseTime) {
        return baseTime.plusMinutes(offset);
    }
}
