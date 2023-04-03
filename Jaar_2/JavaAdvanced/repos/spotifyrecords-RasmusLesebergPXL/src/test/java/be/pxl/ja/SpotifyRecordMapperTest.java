package be.pxl.ja;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpotifyRecordMapperTest {

    @Test
    public void it_should_map_data_to_record_correctly() {
        SpotifyRecord spotifyRecord = new SpotifyRecord();
        String data = "28;It's You;Ali Gatie;canadian hip hop;96;46;73;-7;19;40;213;37;3;89";
        String[] testList = data.split(";");

        spotifyRecord.setId(28);
        spotifyRecord.setTrackName("It's You");
        spotifyRecord.setArtistName("Ali Gatie");
        spotifyRecord.setGenre(Genre.valueOf("canadian hip hop".replace(" ", "_").toUpperCase()));
        spotifyRecord.setBpm(96);
        spotifyRecord.setEnergy(46);
        spotifyRecord.setDanceability(73);
        spotifyRecord.setLoudness(-7);
        spotifyRecord.setLiveness(19);
        spotifyRecord.setValence(40);
        spotifyRecord.setLength(213);
        spotifyRecord.setAcousticness(37);
        spotifyRecord.setSpeechiness(3);
        spotifyRecord.setPopularity(89);

        SpotifyRecord record = SpotifyRecordMapper.mapDataToSpotifyRecord(testList);
        assertEquals(spotifyRecord.getId(), record.getId());
        assertEquals(spotifyRecord.getTrackName(), record.getTrackName());
        assertEquals(spotifyRecord.getArtistName(), record.getArtistName());
        assertEquals(spotifyRecord.getGenre(), record.getGenre());
        assertEquals(spotifyRecord.getBpm(), record.getBpm());
        assertEquals(spotifyRecord.getEnergy(), record.getEnergy());
        assertEquals(spotifyRecord.getDanceability(), record.getDanceability());
        assertEquals(spotifyRecord.getLoudness(), record.getLoudness());
        assertEquals(spotifyRecord.getLiveness(), record.getLiveness());
        assertEquals(spotifyRecord.getValence(), record.getValence());
        assertEquals(spotifyRecord.getLength(), record.getLength());
        assertEquals(spotifyRecord.getAcousticness(), record.getAcousticness());
        assertEquals(spotifyRecord.getSpeechiness(), record.getSpeechiness());
        assertEquals(spotifyRecord.getPopularity(), record.getPopularity());

//        assertEquals(spotifyRecord, SpotifyRecordMapper.mapDataToSpotifyRecord(testList));
    }
}
