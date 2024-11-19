package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripServiceTest {

    @Test
    public void should_throw_exception_when_user_is_not_log() {

        TripServiceForTest tripServiceForTest = new TripServiceForTest(Collections.EMPTY_LIST, null);
        assertThrows(UserNotLoggedInException.class, ()-> tripServiceForTest.getTripsByUser(null));
    }

    @Test
    public void toto(){
        User user = new User();
        User user1 = new User();
        user1.addFriend(user);
        TripServiceForTest tripServiceForTest = new TripServiceForTest(Collections.EMPTY_LIST, user);
        assertEquals(Collections.EMPTY_LIST, tripServiceForTest.getTripsByUser(user1));
    }

    @Test
    public void toto2(){
        ArrayList<Trip> trips= new ArrayList<>();
        trips.add(new Trip());

        User user = new User();
        User user1 = new User();
        user1.addFriend(user);

        TripServiceForTest tripServiceForTest = new TripServiceForTest(trips, user);

        assertEquals(trips, tripServiceForTest.getTripsByUser(user1));
    }



    class TripServiceForTest extends TripService {
        private List<Trip> trips;
        private User user;
        public TripServiceForTest(List<Trip> trips, User user) {
            this.trips=trips;
            this.user = user;
        }

        @Override
        protected List<Trip> getByUser(User user) {
            return trips;
        }

        @Override
        protected User getLoggedUser() {

            return user;
        }
    }
}
