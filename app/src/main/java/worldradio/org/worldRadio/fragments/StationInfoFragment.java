package worldradio.org.worldRadio.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import worldradio.org.midwestradio.R;
import worldradio.org.worldRadio.models.Station;
import worldradio.org.worldRadio.utils.AdapterCallback;


public class StationInfoFragment extends DialogFragment {

    ArrayList<Station> currentStations;
    int index;
    TextView longName;
    TextView shortName;
    TextView genre;
    TextView country;
    TextView website;
    Button playButton;
    private AdapterCallback changeStationCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentStations = getArguments().getParcelableArrayList("data");
        index = getArguments().getInt("index");

        // get the display dimensions
        Rect displayRectangle = new Rect();
        Window window = getActivity().getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        // adjust to 90% width
        inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.station_info_fragment, container);
        layout.setMinimumWidth((int)(displayRectangle.width() * 0.9f));

        return  layout;
    }

    @Override
    public void onStart(){
        super.onStart();
        Station station = currentStations.get(index);

        longName = getView().findViewById(R.id.long_name);
        longName.setText(station.getLong_name());

        shortName = getView().findViewById(R.id.short_name);

        country = getView().findViewById(R.id.country);
        country.setText(String.format("Country: %s", station.getCountry()));



        genre = getView().findViewById(R.id.genre);
        genre.setText(String.format("Genre: %s", station.getGenre()));

        website = getView().findViewById(R.id.website);
        website.setText(String.format("Website: %s", station.getWebsite()));

        playButton = getView().findViewById(R.id.playButton);
        playButton.setOnClickListener(view -> {
            changeStationCallback.openRadioCallback(station, index);
        });

    }

    public void setStationChangeCallback(AdapterCallback callback) {
        this.changeStationCallback = callback;
    }
}

