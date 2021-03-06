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

package mk.tomatoes.core;

/**
 * Enumeration with the possible review types.
 * 
 * @author Mirko Polato
 *
 */
public enum RTReviewType {

	/**
	 * All the reviews.
	 */
	ALL("all"),
	
	/**
	 * The DVD reviews.
	 */
	DVD("dvd"),
	
	/**
	 * The top crtics reviews.
	 */
	TOP_CRITIC("top_critic");
	
	/**
	 * The enumeration value.
	 */
	private String value = "";
	
	public String getValue() {
		return value;
	}
	
	/**
	 * The enumeration constructor.
	 * 
	 * @param value The enum value
	 */
	private RTReviewType(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the review type by its value.
	 * 
	 * @param value The enum value
	 * @return The RTReviewType enumeration
	 */
	public static RTReviewType getReviewType(String value) {
	    
	    for (RTReviewType s : values()) {
	    	if (s.getValue() == value) return s;
	    }
	    
	    return RTReviewType.ALL;
	}
}
