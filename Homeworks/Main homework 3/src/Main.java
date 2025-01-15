import java.util.Objects;

public class Main {
    public static void main(String[] args) {


        class Plane {

            private String flightId;
            private String destination;
            private String airlines;


            public Plane(String flightId, String destination, String airlines) {
                this.flightId = flightId;
                this.destination = destination;
                this.airlines = airlines;
            }

            public String getFlightId() {
                return flightId;
            }

            public void setFlightId(String flightId) {
                this.flightId = flightId;
            }

            public String getDestination() {
                return destination;
            }

            public void setDestination(String destination) {
                this.destination = destination;
            }

            public String getAirlines() {
                return airlines;
            }

            public void setAirlines(String airlines) {
                this.airlines = airlines;
            }


            @Override
            public int hashCode() {
                return Objects.hash(flightId, destination, airlines);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Plane plane = (Plane) obj;
                return Objects.equals(flightId, plane.flightId) &&
                        Objects.equals(destination, plane.destination) &&
                        Objects.equals(airlines, plane.airlines);
            }

            public static void main(String[] args) {
                try {

                    Plane plane = new Plane(null, "New York", "Delta");


                    if (plane.getFlightId() == null) {
                        throw new NullPointerException("flightId is missing");
                    }
                } catch (NullPointerException e) {
                    System.out.println("flight id is missing");
                } finally {

                    System.out.println("works anyway");
                }
            }
        }

    }
}