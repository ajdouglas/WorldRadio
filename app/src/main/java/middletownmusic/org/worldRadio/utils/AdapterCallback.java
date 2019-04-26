package middletownmusic.org.worldRadio.utils;

import middletownmusic.org.worldRadio.models.Station;

public interface AdapterCallback {
    void openRadioCallback(Station station, int index);
}