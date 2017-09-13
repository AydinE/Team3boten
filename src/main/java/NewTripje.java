import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class NewTripje {

    private List<BoatTrip> trips = new ArrayList<BoatTrip>();

    private void createTrip() {

        if (trips.isEmpty()) {

            BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), 1);

            trips.add(boatTrip);

        } else {

            BoatTrip lastTrip = trips.get(trips.size() - 1);

            BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), lastTrip.getTripNumber() + 1);

            trips.add(boatTrip);

        }

    }



}
