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

/**
 * Signals that the server response is not a success. For more information 
 * about the error check the status response by calling {@link #getStatus() getStatus} method.
 * 
 * @author Mirko Polato
 *
 */
public class RTResponseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The response status.
	 */
	private String status;
	
	/**
	 * Default constructor: creates a new instance of ResponseException with the status FAILED.
	 */
	public RTResponseException() {
		super("Failed.");
		this.status = "Failed.";  
	}
	
	/**
	 * Creates a new instance of ImageSizeNotSupportedException with the given status.
	 * 
	 * @param status The response status.
	 */
	public RTResponseException(String status) {
		super(status);
		this.status = status;
	}
	
	/**
	 * Gets the mistake message.
	 * 
	 * @return The mistake message.
	 */
	public String getError() {
		return status;
	}
	
	/**
	 * Gets the response status.
	 * 
	 * @return The response status
	 */
	public String getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "ResponseException: " + status;
	}
}
