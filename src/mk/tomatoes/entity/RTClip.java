package mk.tomatoes.entity;

import java.net.MalformedURLException;
import java.net.URL;

import mk.tomatoes.core.RTConstants;
import mk.tomatoes.utils.Log;
import net.sf.json.JSONObject;

public class RTClip extends RTEntity {

	private String title;
	private int duration;
	private URL thumbnail;
	
	public RTClip(JSONObject json) {
		super(json);
		parseJSON(json);
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public URL getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(URL thumbnail) {
		this.thumbnail = thumbnail;
	}

	private void parseJSON(JSONObject json) {
		
		if (json.has(RTConstants.TITLE)) setTitle(json.getString(RTConstants.TITLE));
		if (json.has(RTConstants.DURATION)) setDuration(json.getInt(RTConstants.DURATION));
		if (json.has(RTConstants.THUMBNAIL))
		
			try {
			setThumbnail(new URL(json.getString(RTConstants.THUMBNAIL)));
		} catch (MalformedURLException e) {
			Log.print(e);
		}
		
	}
	
}
