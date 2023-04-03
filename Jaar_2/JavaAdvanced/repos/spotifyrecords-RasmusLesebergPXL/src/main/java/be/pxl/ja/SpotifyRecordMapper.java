package be.pxl.ja;

public class SpotifyRecordMapper {

    public static SpotifyRecord mapDataToSpotifyRecord(String[] list) {
        SpotifyRecord record = new SpotifyRecord();

        record.setId(Integer.parseInt(list[0]));
        record.setTrackName(list[1]);
        record.setArtistName(list[2]);
        record.setGenre(Genre.valueOf(list[3].replace(" ", "_").replace("&", "N").toUpperCase()));
        record.setBpm(Integer.parseInt(list[4]));
        record.setEnergy(Integer.parseInt(list[5]));
        record.setDanceability(Integer.parseInt(list[6]));
        record.setLoudness(Integer.parseInt(list[7]));
        record.setLiveness(Integer.parseInt(list[8]));
        record.setValence(Integer.parseInt(list[9]));
        record.setLength(Integer.parseInt(list[10]));
        record.setAcousticness(Integer.parseInt(list[11]));
        record.setSpeechiness(Integer.parseInt(list[12]));
        record.setPopularity(Integer.parseInt(list[13]));

        return record;
    }
}

