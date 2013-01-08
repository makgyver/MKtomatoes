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

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class provides methods for creating well formed query URL.
 * 
 * @author Mirko Polato
 *
 */
public final class RTURLCreator {
	
	//region API Key
	
	/**
	 * The API Key.
	 */
	private static String apiKey = "";
	
	/**
	 * Gets the API Key.
	 * 
	 * @return The query URL The API Key
	 */
	public static String getApiKey() {
		return apiKey;
	}

	/**
	 * Sets the API Key.
	 * 
	 * @param key The new API Key
	 */
	public static void setApiKey(String key) {
		apiKey = key;
	}

	//endregion
	
	//region Utilities
	
	/**
	 * Forms a pair 'property=value'.
	 * 
	 * @param prop The property
	 * @param value The value
	 * @return The string 'prop=value'
	 */
	private static String pair(String prop, String value) {
		return prop + "=" + value;
	}
	
	/**
	 * Adds to the head of the given string a "&".
	 * 
	 * @param par The string
	 * @return The string with "&" symbol as first character
	 */
	private static String param(String par) {
		return "&" + par;
	}
	
	//endregion

	//region Movies
	
	public static URL getMovieInformation(int movieID) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));
	}
	
	public static URL getMovieCast(int movieID) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.CAST + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));
	}
	
	public static URL getMovieClips(int movieID) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.CLIPS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));
	}
	
	public static URL getMovieReviews(int movieID) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.REVIEWS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));
	}
	
	public static URL getMovieReviews(int movieID, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.REVIEWS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) + 
				param(pair(RTConstants.PAGE, String.valueOf(page))));
	}
	
	public static URL getMovieReviews(int movieID, int pageLimit, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.REVIEWS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) + 
				param(pair(RTConstants.PAGE, String.valueOf(page))) +
				param(pair(RTConstants.PAGE_LIMIT, String.valueOf(pageLimit))));
	}
	
	public static URL getMovieReviews(int movieID, RTReviewType type) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.REVIEWS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) + 
				param(pair(RTConstants.REVIEW_TYPE, type.getValue())));
	}
	
	public static URL getMovieReviews(int movieID, RTReviewType type, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.REVIEWS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) + 
				param(pair(RTConstants.REVIEW_TYPE, type.getValue())) + 
				param(pair(RTConstants.PAGE, String.valueOf(page))));
	}
	
	public static URL getMovieReviews(int movieID, RTReviewType type, int pageLimit, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.REVIEWS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) + 
				param(pair(RTConstants.REVIEW_TYPE, type.getValue())) + 
				param(pair(RTConstants.PAGE, String.valueOf(page))) +
				param(pair(RTConstants.PAGE_LIMIT, String.valueOf(pageLimit))));
	}
	
	public static URL getSimilarMovies(int movieID) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.SIMILAR + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));
	}
	
	public static URL getSimilarMovies(int movieID, int limit) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIES + RTConstants.SLASH +
				String.valueOf(movieID) + RTConstants.SLASH +
				RTConstants.SIMILAR + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.LIMIT, String.valueOf(limit))));
	}
	
	public static URL getMovieByIMDbID(String imdbID) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.MOVIE_ALIAS + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.TYPE, RTConstants.IMDB)) +
				param(pair(RTConstants.ID, String.valueOf(imdbID))));	
	}
	
	public static URL getInTheatreMovies() throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.IN_THEATRES + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));	
	}
	
	public static URL getInTheatreMovies(int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.IN_THEATRES + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.PAGE, String.valueOf(page))));	
	}
	
	public static URL getInTheatreMovies(int pageLimit, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.IN_THEATRES + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.PAGE, String.valueOf(page))) + 
				param(pair(RTConstants.PAGE_LIMIT, String.valueOf(pageLimit))));	
	}
	
	public static URL getUpcomingMovies() throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.UPCOMING + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));	
	}
	
	public static URL getUpcomingMovies(int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.UPCOMING + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.PAGE, String.valueOf(page))));	
	}
	
	public static URL getUpcomingMovies(int pageLimit, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.UPCOMING + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.PAGE, String.valueOf(page))) + 
				param(pair(RTConstants.PAGE_LIMIT, String.valueOf(pageLimit))));	
	}
	
	public static URL getBoxOfficeMovies() throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.BOX_OFFICE + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));	
	}
	
	public static URL getBoxOfficeMovies(int limit) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.BOX_OFFICE + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.LIMIT, String.valueOf(limit))));	
	}
	
	public static URL getOpeningMovies() throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.OPENING + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()));	
	}
	
	public static URL getOpeningMovies(int limit) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
				RTConstants.LISTS + RTConstants.SLASH +
				RTConstants.MOVIES + RTConstants.SLASH +
				RTConstants.OPENING + RTConstants.JSON + 
				pair(RTConstants.API_KEY, getApiKey()) +
				param(pair(RTConstants.LIMIT, String.valueOf(limit))));	
	}
	
	//endregion
	
	//region Search Movies
	
	public static URL searchMoviesByTitle(String title) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL + 
					RTConstants.MOVIES +
				   	RTConstants.JSON +
					pair(RTConstants.API_KEY, getApiKey()) + 
					param(pair(RTConstants.QUERY, title)));
	}
	
	public static URL searchMoviesByTitle(String title, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL +
					RTConstants.MOVIES +
					RTConstants.JSON +
					pair(RTConstants.API_KEY, getApiKey()) + 
					param(pair(RTConstants.QUERY, title)) + 
					param(pair(RTConstants.PAGE, String.valueOf(page))));
	}
	
	public static URL searchMoviesByTitle(String title, int pageLimit, int page) throws MalformedURLException {
		return new URL(RTConstants.BASE_URL + 
					RTConstants.MOVIES +
					RTConstants.JSON +
					pair(RTConstants.API_KEY, getApiKey()) + 
					param(pair(RTConstants.QUERY, title)) + 
					param(pair(RTConstants.PAGE_LIMIT, String.valueOf(pageLimit))) +
					param(pair(RTConstants.PAGE, String.valueOf(page))));
	}
	
	//endregion
}
