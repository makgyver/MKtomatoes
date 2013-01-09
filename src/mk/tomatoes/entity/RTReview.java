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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mk.tomatoes.utils.Log;
import mk.tomatoes.core.RTConstants;
import net.sf.json.JSONObject;

/**
 * Class that represents a critic review.
 * 
 * @author Mirko Polato
 *
 */
public class RTReview extends RTEntity {

	/**
	 * The critic name.
	 */
	private String criticName;
	
	/**
	 * The date.
	 */
	private Date date;
	
	/**
	 * The Rottent Tomatoes freshness (fresh/rotten).
	 */
	private String freshness;
	
	/**
	 * The review publication.
	 */
	private String publication;
	
	/**
	 * The review text.
	 */
	private String quote;
	
	/**
	 * Creates a new instance of RTReview based on the origin JSON object.
	 * 
	 * @param json the origin JSON object
	 */
	public RTReview(JSONObject json) {
		super(json);
		parseJSON(json);
	}

	/**
	 * Gets the name of the critic.
	 * 
	 * @return The critic name
	 */
	public String getCriticName() {
		return criticName;
	}
	
	/**
	 * Sets the critic name.
	 * 
	 * @param criticName The new critic name
	 */
	public void setCriticName(String criticName) {
		this.criticName = criticName;
	}
	
	/**
	 * Gets the review date.
	 * 
	 * @return The review date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Sets the review date.
	 * 
	 * @param date The new review date
	 */
	public void setDate(String date) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = (Date)formatter.parse(date);
		} catch (ParseException e) {
			Log.print(e);
		}
	}
	
	/**
	 * Gets the review freshness.
	 * 
	 * @return The review freshness
	 */
	public String getFreshness() {
		return freshness;
	}
	
	/**
	 * Sets the Rotten Tomatoes review freshness.
	 * 
	 * @param freshness The new review freshness
	 */
	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}
	
	/**
	 * Gets the review publication.
	 * 
	 * @return The review publication
	 */
	public String getPublication() {
		return publication;
	}
	
	/**
	 * Sets the review publication.
	 * 
	 * @param publication The new review publication
	 */
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	/**
	 * Gets the review quote.
	 * 
	 * @return The review quote
	 */
	public String getQuote() {
		return quote;
	}
	
	/**
	 * Sets the review quote.
	 * 
	 * @param quote The new review quote
	 */
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	/**
	 * Parses the origin JSON object.
	 * 
	 * @param json The origin JSON object
	 */
	private void parseJSON(JSONObject json) {
		
		if (json.has(RTConstants.CRITIC)) setCriticName(json.getString(RTConstants.CRITIC));
		if (json.has(RTConstants.DATE)) setDate(json.getString(RTConstants.DATE));
		if (json.has(RTConstants.QUOTE)) setQuote(json.getString(RTConstants.QUOTE));
		if (json.has(RTConstants.PUBLICATION)) setPublication(json.getString(RTConstants.PUBLICATION));
		if (json.has(RTConstants.FRESHNESS)) setFreshness(json.getString(RTConstants.FRESHNESS));
		
	}

}
