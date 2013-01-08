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

import mk.tomatoes.core.RTConstants;
import net.sf.json.JSONObject;

public abstract class RTResponse {

	/**
	 * The response status (default sets to NONE)
	 */
	protected String status = RTConstants.NONE;
	
	/**
	 * Whether the response status is an error or not
	 */
	protected boolean error = false;
	
	/**
	 * Initializes the response basic information based on the given JSON object.
	 *  
	 * @param json The JSON response
	 */
	public RTResponse(JSONObject json) {
		if (json.has(RTConstants.ERROR)) {
			setStatus(json.getString(RTConstants.ERROR));
			error = true;
		} else {
			status = RTConstants.SUCCESS;
		}
	}
	
	/**
	 * Initializes the response status with the given one.
	 * 
	 * @param status The response status
	 */
	public RTResponse(String status) {
		this.status = status;
	}
	
	/**
	 * Gets whether the response status is an error.
	 * 
	 * @return Whether the response status is an error.
	 */
	public boolean hasError() {
		return error;
	}
	
	/**
	 * Gets the response status.
	 * 
	 * @return The response status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the response status.
	 * 
	 * @param status The new response status
	 */
	protected void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return status;
	}

}
