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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import mk.tomatoes.response.RTResponseArray;
import mk.tomatoes.response.RTResponseObject;
import mk.tomatoes.utils.Log;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Static class that offers methods for calling the Rotten Tomatoes API.
 * 
 * @author Mirko Polato
 *
 */
public final class RTAPI {

	//region Timeout
	
	/**
	 * Timeout in milliseconds.
	 */
	private static int timeout = 20000; // 20 seconds
	
	/**
	 * Sets the timeout to the given value (milliseconds).
	 * @param limit The timeout in milliseconds.
	 */
	public static void setTimeout(int limit) {
		if (limit < 0) limit = 0;
		timeout = limit;
	}
	
	//endregion

	//region Utilities
	
	/**
	 * Makes an HTTP request (GET) and gets back the result as a string.
	 * 
	 * @param url The query URL
	 * @return The result string
	 */
	public static String makeApiCallGet(URL url) {
		StringBuilder result = new StringBuilder();
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(timeout);
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			for (String line = null; (line = reader.readLine()) != null;) {
			    result.append(line).append("\n");
			}
			reader.close();
			
		} catch (SocketTimeoutException ste) {
			Log.print(ste);
			
			JSONObject json = new JSONObject();
			json.put(RTConstants.ERROR, RTConstants.TIMEOUT);
			
			result.setLength(0);
			result.append(json.toString());
			
		} catch (Exception e) {
			Log.print(e);
			
			JSONObject json = new JSONObject();
			json.put(RTConstants.ERROR, RTConstants.TIMEOUT);
			
			result.setLength(0);
			result.append(json.toString());
		}
		
		return result.toString();
	}

	/**
	 * Converts a string to a JSONObject.
	 * 
	 * @param strJson The JSON string
	 * @return The JSONObject
	 */
	private static JSONObject toJSON(String strJson) {
		strJson = strJson.substring(strJson.indexOf('{'));
		return (JSONObject) JSONSerializer.toJSON(strJson);
	}
	
	//endregion

	//region Movie
	
	/**
	 * Gets the movie information.
	 * 
	 * @param movieID The movie ID
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieInformation(int movieID) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieInformationUrl(movieID))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie cast.
	 * 
	 * @param movieID The movie ID
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieCast(int movieID) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieCastUrl(movieID))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie clips.
	 * 
	 * @param movieID The movie ID
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieClips(int movieID) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieClipsUrl(movieID))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie reviews.
	 * 
	 * @param movieID The movie reviews
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieReviews(int movieID) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieReviewsUrl(movieID))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie reviews.
	 * 
	 * @param movieID The movie ID
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieReviews(int movieID, int page) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieReviewsUrl(movieID, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie reviews.
	 * 
	 * @param movieID The movie ID
	 * @param pageLimit The maximum number of results in a page
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieReviews(int movieID, int pageLimit, int page) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieReviewsUrl(movieID, pageLimit, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie reviews.
	 * 
	 * @param movieID The movie ID
	 * @param type The review type
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieReviews(int movieID, RTReviewType type) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieReviewsUrl(movieID, type))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie reviews.
	 * 
	 * @param movieID The movie ID
	 * @param type The review type
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieReviews(int movieID, RTReviewType type, int page) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieReviewsUrl(movieID, type, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the movie reviews.
	 * 
	 * @param movieID The movie ID
	 * @param type The review type
	 * @param pageLimit The maximum number of results in a page
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseObject getMovieReviews(int movieID, RTReviewType type, int pageLimit, int page) {
		try {
			return new RTResponseObject(toJSON(makeApiCallGet(RTURLCreator.getMovieReviewsUrl(movieID, type, pageLimit, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseObject(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of similar movies.
	 * 
	 * @param movieID The movie ID
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getSimilarMovies(int movieID) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getSimilarMoviesUrl(movieID))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of similar movies.
	 * 
	 * @param movieID The movie ID
	 * @param limit The maximum number of results
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getSimilarMovies(int movieID, int limit) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getSimilarMoviesUrl(movieID, limit))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of movies playing in theatres.
	 * 
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getInTheatreMovies() {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getInTheatreMoviesUrl())));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of movies playing in theatres.
	 * 
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getInTheatreMovies(int page) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getInTheatreMoviesUrl(page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of movies playing in theatres.
	 * 
	 * @param pageLimit The maximum number of results in a page
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getInTheatreMovies(int pageLimit, int page) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getInTheatreMoviesUrl(pageLimit, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the entire list of movies playing in theatres.
	 * 
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getAllInTheatreMovies() {
		try {
			RTResponseArray result = new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getInTheatreMoviesUrl(100, 1))));
			
			for (int p = 2; (p - 1) * 100 < result.getResults(); p++) {
				RTResponseArray page = new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getInTheatreMoviesUrl(100, p))));
				for (Object obj : page.getData()) {
					result.addData((JSONObject) obj);
				}
			}
			
			return result;
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	
	/**
	 * Gets the list of upcoming movies.
	 * 
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getUpcomingMovies() {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getUpcomingMoviesUrl())));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of upcoming movies.
	 * 
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getUpcomingMovies(int page) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getUpcomingMoviesUrl(page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of upcoming movies.
	 *
	 * @param pageLimit The maximum number of results in a page
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getUpcomingMovies(int pageLimit, int page) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getUpcomingMoviesUrl(pageLimit, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the entire list of upcoming movies.
	 * 
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getAllUpcomingMovies() {
		try {
			RTResponseArray result = new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getUpcomingMoviesUrl(100, 1))));
			
			for (int p = 2; (p - 1) * 100 < result.getResults(); p++) {
				RTResponseArray page = new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getUpcomingMoviesUrl(100, p))));
				for (Object obj : page.getData()) {
					result.addData((JSONObject) obj);
				}
			}
			
			return result;
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of box office movies.
	 *  
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getBoxOfficeMovies() {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getBoxOfficeMoviesUrl())));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of box office movies.
	 * 
	 * @param limit The maximum number of results
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getBoxOfficeMovies(int limit) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getBoxOfficeMoviesUrl(limit))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of opening movies.
	 * 
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getOpeningMovies() {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getOpeningMoviesUrl())));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Gets the list of opening movies.
	 * 
	 * @param limit The maximum number of results
	 * @return The Rotten Tomatoes API response object
	 */
	public static RTResponseArray getOpeningMovies(int limit) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.getOpeningMoviesUrl(limit))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	//endregion
	
	//region Search
	
	/**
	 * Searches for movies by title.
	 * 
	 * @param title The movie title
	 * @return The Rotten Tomatoes response object.
	 */
	public static RTResponseArray searchMovieByTitle(String title) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.searchMoviesByTitleUrl(title))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Searches for movies by title.
	 * 
	 * @param title The movie title
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes response object.
	 */
	public static RTResponseArray searchMovieByTitle(String title, int page) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.searchMoviesByTitleUrl(title, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Searches for movies by title.
	 * 
	 * @param title The movie title
	 * @param pageLimit The maximum number of movies in a page
	 * @param page The page number to retrieve
	 * @return The Rotten Tomatoes response object.
	 */
	public static RTResponseArray searchMovieByTitle(String title, int pageLimit, int page) {
		try {
			return new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.searchMoviesByTitleUrl(title, pageLimit, page))));
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	/**
	 * Searches for movies by title. Gets all the results.
	 * 
	 * @param title The movie title
	 * @return The Rotten Tomatoes response object.
	 */
	public static RTResponseArray fullSearchMovieByTitle(String title) {
		try {
			
			RTResponseArray result = new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.searchMoviesByTitleUrl(title, 100, 1))));
			
			for (int p = 2; (p - 1) * 100 < result.getResults(); p++) {
				RTResponseArray page = new RTResponseArray(toJSON(makeApiCallGet(RTURLCreator.searchMoviesByTitleUrl(title, 100, p))));
				for (Object obj : page.getData()) {
					result.addData((JSONObject) obj);
				}
			}
			
			return result;
			
		} catch (MalformedURLException e) {
			Log.print(e);
			
			return new RTResponseArray(RTConstants.MALFORMED_URL);
		}
	}
	
	//endregion
	
}
