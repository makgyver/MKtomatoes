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

/**
 * Enumertion with the possible poster types.
 * 
 * @author Mirko Polato
 *
 */
public enum PosterType {

	/**
	 * Thumbnail poster.
	 */
	THUMBNAIL(0),
	
	/**
	 * Profile poster.
	 */
	PROFILE(1),
	
	/**
	 * Detailed poster.
	 */
	DETAILED(2),
	
	/**
	 * Original poster.
	 */
	ORIGINAL(3);
	
	/**
	 * Poster type integer value
	 */
	private int value;
	
	/**
	 * Get the type value.
	 * 
	 * @return The type value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Poster type constructor.
	 * 
	 * @param value The type value
	 */
	private PosterType(int value) {
		this.value = value;
	}
	
}
