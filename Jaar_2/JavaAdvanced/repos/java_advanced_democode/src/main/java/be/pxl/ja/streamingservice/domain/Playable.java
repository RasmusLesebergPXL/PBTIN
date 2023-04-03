package be.pxl.ja.streamingservice.domain;

public interface Playable {

	int getDuration();
	void play();
	void pause();

}