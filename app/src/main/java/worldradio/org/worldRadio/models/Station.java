package worldradio.org.worldRadio.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Station implements Parcelable {

    // Unsupported: createFromParcel

    private String id;
    private String long_name;
    private String short_name;
    private String country;
    private String active;
    private String deleted;
    private String genre;
    private String stream;
    private String user_entered;
    private String first_station;
    private String website;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(country);
        dest.writeString(long_name);
        dest.writeString(short_name);
        dest.writeString(active);
        dest.writeString(deleted);
        dest.writeString(genre);
        dest.writeString(stream);
        dest.writeString(website);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Station> CREATOR = new Parcelable.Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
//            return new Station(in);
            return new Station();
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };

    /*
    * id
    * long_name
    * short_name
    * country
    * genre
    * active
    * deleted
    * stream
    * website
    * user_entered
    * first_station
    * */

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String frequency) {
        this.country = frequency;
    }

    public String getLong_name() {
        return long_name;
    }

    public void setLong_name(String long_name) {
        this.long_name = long_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getUser_entered() { return user_entered; }

    public void setUser_entered(String user_entered) { this.user_entered = user_entered; }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    public String getFirst_station() { return first_station; }

    public void setFirst_station(String first_station) { this.first_station = first_station; }
}


