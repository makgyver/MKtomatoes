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

package mk.tomatoes.response;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import mk.tomatoes.core.RTConstants;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RTResponseArray extends RTResponse {
	
	/**
	 * The JSON objects list contained in the response.
	 */
	private Set<JSONObject> data = Collections.synchronizedSet(new LinkedHashSet<JSONObject>());
	
	/**
	 * The total number of the retrieved results.
	 */
	private int results = 0;
	
	/**
	 * Creates a new ResponseArray instance based on the given JSON object.
	 * 
	 * @param json The JSON response
	 */
	public RTResponseArray(JSONObject json) {
		super(json);
		
		if (!hasError()) {
			
			if (json.has(RTConstants.TOTAL)) {
				setResults(json.getInt(RTConstants.TOTAL));
			} else {
				setResults(1);
			}
		
			if (json.has(RTConstants.MOVIES)) {
				setData(json.getJSONArray(RTConstants.MOVIES));
			} else {
				setData(json.toJSONArray(null));
			}
		}
	}
	
	/**
	 * Initializes the response status to the given one.
	 * 
	 * @param status The response status
	 */
	public RTResponseArray(String status) {
		super(status);
	}
	
	/**
	 * Gets the list of retrieved JSON object.
	 * 
	 * @return the list of JSON object
	 */
	public Set<JSONObject> getData() {
		return data;
	}
	
	/**
	 * Sets the list of the retrieved JSON object.
	 * 
	 * @param array The list of JSON object
	 */
	private void setData(JSONArray array) {
		for(Object obj : array) {
			data.add((JSONObject) obj);
		}
	}
	
	/**
	 * Adds a JSON object to the data.
	 * 
	 * @param json The JSON object to add
	 * @return Whether the operation succeeded or not
	 */
	public boolean addData(JSONObject json) {
		return data.add(json);
	}

	/**
	 * Gets the total number of the retrieved results.
	 * 
	 * @return The total number of the retrieved results
	 */
	public int getResults() {
		return results;
	}
	
	/**
	 * Sets the total number of the retrieved results.
	 * 
	 * @param results The new total number of the retrieved results
	 */
	private void setResults(int results) {
		this.results = results;
	}
	
}
