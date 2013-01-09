/*******************************************************************************
 * Copyright (C) 2013  Mirko Polato
 * 
 * This file is part of MKtomatoes.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 ******************************************************************************/

package mk.tomatoes.entity;

import java.net.MalformedURLException;
import java.net.URL;

import mk.tomatoes.core.RTConstants;
import mk.tomatoes.utils.Log;
import net.sf.json.JSONObject;

/**
 * Class that represents a movie clip.
 * 
 * @author Mirko Polato
 *
 */
public class RTClip extends RTEntity {

	/**
	 * The clip title.
	 */
	private String title;
	
	/**
	 * The clip duration.
	 */
	private int duration;
	
	/**
	 * The clip thumbnail.
	 */
	private URL thumbnail;
	
	/**
	 * Creates a new RTClip instance based on the origin JSON object.
	 * 
	 * @param json The origin JSON object
	 */
	public RTClip(JSONObject json) {
		super(json);
		parseJSON(json);
	}

	/**
	 * Gets the clip title.
	 * 
	 * @return The clip title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the clip title.
	 * 
	 * @param title The new clip title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the clip duration.
	 * 
	 * @return The clip duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * Sets the clip duration.
	 * 
	 * @param duration The clip duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * Gets the clip thumbnail.
	 * 
	 * @return The clip thumbnail
	 */
	public URL getThumbnail() {
		return thumbnail;
	}
	
	/**
	 * Sets the clip thumbnail.
	 * 
	 * @param thumbnail The new clip thumbnail
	 */
	public void setThumbnail(URL thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * Parses the origin JSON object.
	 * 
	 * @param json The origin JSON object
	 */
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
