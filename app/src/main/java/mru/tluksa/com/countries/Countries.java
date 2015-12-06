package mru.tluksa.com.countries;

import java.util.ArrayList;
import java.util.List;


public class Countries {

    private List<Geoname> geonames = new ArrayList<>();

    public List<Geoname> getGeonames() {
        return geonames;
    }

    class Geoname {
        private String countryName;
        private String capital;

        public String getCountryName() {
            return countryName;
        }

        public String getCapital() {
            return capital;
        }

    }
}


