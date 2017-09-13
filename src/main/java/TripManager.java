import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class TripManager {

    private List<BoatTrip> trips = new ArrayList<BoatTrip>();

    public void createTrip() {
        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier);
        trips.add(boatTrip);

    }

}