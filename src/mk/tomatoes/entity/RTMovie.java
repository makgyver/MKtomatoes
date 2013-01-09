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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import mk.tomatoes.core.RTAPI;
import mk.tomatoes.core.RTConstants;
import mk.tomatoes.core.RTReviewType;
import mk.tomatoes.response.RTResponseArray;
import mk.tomatoes.response.RTResponseException;
import mk.tomatoes.response.RTResponseObject;
import mk.tomatoes.utils.Log;
import mk.tomatoes.utils.Pair;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RTMovie extends RTEntity {

	//region Fields

	/**
	 * The movie critics score.
	 */
	private int criticsScore;
	
	/**
	 * The movie audience score.
	 */
	private int audienceScore;
	
	/**
	 * The movie MPAA rating.
	 */
	private String mpaa;
	
	/**
	 * The movie studio.
	 */
	private String studio = null;
	
	/**
	 * The movie title.
	 */
	private String title;
	
	/**
	 * The movie poster.
	 */
	private URL[] posters = new URL[4];
	
	/**
	 * The movie plot.
	 */
	private String plot;
	
	/**
	 * The movie IMDb (imdb.com) ID.
	 */
	private String imdbId;
	
	/**
	 * The movie Rotten Tomatoes ID.
	 */
	private int id;
	
	/**
	 *The movie release date.
	 */
	private Date release;
	
	/**
	 * The DVD release date.
	 */
	private Date dvdRelease;
	
	/**
	 * The movie critics consensus.
	 */
	private String criticsConsensus;
	
	/**
	 * The movie runtime.
	 */
	private int runtime;
	
	/**
	 * The movie year.
	 */
	private int year;

	/**
	 * The movie cast.
	 */
	private Set<Pair<String, Set<String>>> cast = Collections.synchronizedSet(new LinkedHashSet<Pair<String, Set<String>>>());
	
	/**
	 * The movie directors.
	 */
	private Set<String> directors = Collections.synchronizedSet(new LinkedHashSet<String>());
	
	/**
	 * The movie genres.
	 */
	private Set<String> genres = Collections.synchronizedSet(new LinkedHashSet<String>());
	
	/**
	 * The movie clips.
	 */
	private Set<RTClip> clips = Collections.synchronizedSet(new LinkedHashSet<RTClip>());
	
	/**
	 * The movie reviews.
	 */
	private Set<RTReview> reviews = Collections.synchronizedSet(new LinkedHashSet<RTReview>());
	
	//endregion
	
	/**
	 * Creates a new instance of IMDbMovie based on the origin JSON object.
	 *  
	 * @param json The origin JSON object
	 */
	public RTMovie(JSONObject json) {
		super(json);
		parseJSON(json);
	}

	//region Getters/Setters
	
	public int getCriticsScore() {
		return criticsScore;
	}

	public void setCriticsScore(int criticsScore) {
		this.criticsScore = criticsScore;
	}

	public int getAudienceScore() {
		return audienceScore;
	}

	public void setAudienceScore(int audienceScore) {
		this.audienceScore = audienceScore;
	}

	public String getMpaa() {
		return mpaa;
	}

	public void setMpaa(String mpaa) {
		this.mpaa = mpaa;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public boolean isStudioSet() {
		return studio != null;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public URL[] getPosters() {
		return posters;
	}

	public void setPosters(URL[] posters) {
		this.posters = posters;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(String release) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.release = (Date)formatter.parse(release);
		} catch (ParseException e) {
			Log.print(e);
		}
	}

	public Date getDvdRelease() {
		return dvdRelease;
	}

	public void setDvdRelease(String dvdRelease) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dvdRelease = (Date)formatter.parse(dvdRelease);
		} catch (ParseException e) {
			Log.print(e);
		}
	}

	public String getCriticsConsensus() {
		return criticsConsensus;
	}

	public void setCriticsConsensus(String criticsConsensus) {
		this.criticsConsensus = criticsConsensus;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public Set<Pair<String, Set<String>>> getCast() {
		return cast;
	}

	public void setCast(Set<Pair<String, Set<String>>> cast) {
		this.cast = cast;
	}

	public Set<String> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<String> directors) {
		this.directors = directors;
	}

	public Set<String> getGenres() {
		return genres;
	}

	public void setGenres(Set<String> genres) {
		this.genres = genres;
	}

	public Set<RTClip> getClips() {
		return clips;
	}

	public void setClips(Set<RTClip> clips) {
		this.clips = clips;
	}

	public Set<RTReview> getReviews() {
		return reviews;
	}

	public void setReviews(Set<RTReview> reviews) {
		this.reviews = reviews;
	}
	
	public URL getIMDBLink() {
		try {
			return new URL(RTConstants.IMDB_URL + getImdbId());
		} catch (MalformedURLException e) {
			return null;
		}
	}
	
	//endregion

	/**
	 * Parses the origin JSON object.
	 * 
	 * @param json The origin JSON object
	 */
	private void parseJSON(JSONObject json) {
		
		if (json.has(RTConstants.ID)) setId(json.getInt(RTConstants.ID));
		if (json.has(RTConstants.YEAR)) setYear(json.getInt(RTConstants.YEAR));
		if (json.has(RTConstants.TITLE)) setTitle(json.getString(RTConstants.TITLE));
		if (json.has(RTConstants.MPAA_RATING)) setMpaa(json.getString(RTConstants.MPAA_RATING));
		if (json.has(RTConstants.RUNTIME)) setRuntime(json.getInt(RTConstants.RUNTIME));
		if (json.has(RTConstants.CONSENSUS)) setCriticsConsensus(json.getString(RTConstants.CONSENSUS));
		if (json.has(RTConstants.SYNOPSIS)) setPlot(json.getString(RTConstants.SYNOPSIS));
		if (json.has(RTConstants.MOVIE_STUDIO)) setStudio(json.getString(RTConstants.MOVIE_STUDIO));
		
		if (json.has(RTConstants.GENRES)) {
			JSONArray array = json.getJSONArray(RTConstants.GENRES);
			for (Object obj : array) {
				genres.add((String) obj);
			}
		}
		
		if (json.has(RTConstants.RELEASE_DATES)) {
			JSONObject jobj = json.getJSONObject(RTConstants.RELEASE_DATES);
			if (jobj.has(RTConstants.DVD)) setDvdRelease(jobj.getString(RTConstants.DVD));
			if (jobj.has(RTConstants.THEATRE)) setRelease(jobj.getString(RTConstants.THEATRE));
		}
		
		if (json.has(RTConstants.RATINGS)) {
			JSONObject jobj = json.getJSONObject(RTConstants.RATINGS);
			if (jobj.has(RTConstants.CRITICS_SCORE)) setCriticsScore(jobj.getInt(RTConstants.CRITICS_SCORE));
			if (jobj.has(RTConstants.AUDIENCE_SCORE)) setAudienceScore(jobj.getInt(RTConstants.AUDIENCE_SCORE));
		}
		
		if (json.has(RTConstants.POSTERS)) {
			JSONObject jobj = json.getJSONObject(RTConstants.POSTERS);
			
			if (jobj.has(RTConstants.THUMBNAIL)) {
				try {
					posters[PosterType.THUMBNAIL.getValue()] = new URL(jobj.getString(RTConstants.THUMBNAIL));
				} catch (MalformedURLException e) {
					Log.print(e);
				}
			}
			
			if (jobj.has(RTConstants.PROFILE)) {
				try {
					posters[PosterType.PROFILE.getValue()] = new URL(jobj.getString(RTConstants.PROFILE));
				} catch (MalformedURLException e) {
					Log.print(e);
				}
			}
			
			if (jobj.has(RTConstants.DETAILED)) {
				try {
					posters[PosterType.DETAILED.getValue()] = new URL(jobj.getString(RTConstants.DETAILED));
				} catch (MalformedURLException e) {
					Log.print(e);
				}
			}
			
			if (jobj.has(RTConstants.ORIGINAL)) {
				try {
					posters[PosterType.ORIGINAL.getValue()] = new URL(jobj.getString(RTConstants.ORIGINAL));
				} catch (MalformedURLException e) {
					Log.print(e);
				}
			}
		}
		
		if (json.has(RTConstants.MOVIE_CAST)) {
			JSONArray array = json.getJSONArray(RTConstants.MOVIE_CAST);
			for (Object obj : array) {
				JSONObject jobj = (JSONObject) obj;
				
				String name =  jobj.getString(RTConstants.NAME);
				
				Set<String> chars = new LinkedHashSet<String>();
				if (jobj.has(RTConstants.CHARACTERS)) {
					JSONArray charsArray = jobj.getJSONArray(RTConstants.CHARACTERS);
					
					for (Object c : charsArray) {
						chars.add((String) c);
					}
				}
				
				cast.add(new Pair<String, Set<String>>(name, chars));
			}
		}
		
		if (json.has(RTConstants.MOVIE_DIRECTORS)) {
			JSONArray array = json.getJSONArray(RTConstants.MOVIE_DIRECTORS);
			for (Object obj : array) {
				directors.add(((JSONObject) obj).getString(RTConstants.NAME));
			}
		}
		
		if (json.has(RTConstants.ALTERNATE_IDS)) {
			setImdbId(json.getJSONObject(RTConstants.ALTERNATE_IDS).getString(RTConstants.IMDB));
		}
		
	}
	
	//region Static methods
	
	public static RTMovie getInformation(int movieID) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieInformation(movieID);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			return new RTMovie(response.getData());
		}
	}
	
	public static Set<Pair<String, Set<String>>> getFullCast(int movieID) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieCast(movieID);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			JSONArray array = response.getData().getJSONArray(RTConstants.CAST);
			Set<Pair<String, Set<String>>> result = new LinkedHashSet<Pair<String,Set<String>>>();
			
			for (Object obj : array) {
				
				JSONObject jobj = (JSONObject) obj;
				
				String name = jobj.getString(RTConstants.NAME);
				
				Set<String> charsArray = new LinkedHashSet<String>();
				if (jobj.has(RTConstants.CHARACTERS)) {
					JSONArray chars = jobj.getJSONArray(RTConstants.CHARACTERS);
					for(Object c : chars) {
						charsArray.add((String) c);
					}
				}
				result.add(new Pair<String, Set<String>>(name, charsArray));
			}
			
			return result;
		}
	}
	
	public static Set<RTClip> getClips(int movieID) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieClips(movieID);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTClip> result = new LinkedHashSet<RTClip>();
			JSONArray array = response.getData().getJSONArray(RTConstants.CLIPS);
			for (Object obj : array) {
				result.add(new RTClip((JSONObject) obj));
			}
			
			return result;
		}
	}
	
	public static Set<RTReview> getReviews(int movieID) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieReviews(movieID);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTReview> result = new LinkedHashSet<RTReview>();
			JSONArray array = response.getData().getJSONArray(RTConstants.REVIEWS);
			for (Object obj : array) {
				result.add(new RTReview((JSONObject) obj));
			}
			
			return result;
		}
	}
	
	public static Set<RTReview> getReviews(int movieID, int page) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieReviews(movieID, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTReview> result = new LinkedHashSet<RTReview>();
			JSONArray array = response.getData().getJSONArray(RTConstants.REVIEWS);
			for (Object obj : array) {
				result.add(new RTReview((JSONObject) obj));
			}
			
			return result;
		}
	}
	
	public static Set<RTReview> getReviews(int movieID, int pageLimit, int page) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieReviews(movieID, pageLimit, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTReview> result = new LinkedHashSet<RTReview>();
			JSONArray array = response.getData().getJSONArray(RTConstants.REVIEWS);
			for (Object obj : array) {
				result.add(new RTReview((JSONObject) obj));
			}
			
			return result;
		}
	}
	
	public static Set<RTReview> getReviews(int movieID, RTReviewType type) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieReviews(movieID, type);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTReview> result = new LinkedHashSet<RTReview>();
			JSONArray array = response.getData().getJSONArray(RTConstants.REVIEWS);
			for (Object obj : array) {
				result.add(new RTReview((JSONObject) obj));
			}
			
			return result;
		}
	}
	
	public static Set<RTReview> getReviews(int movieID, RTReviewType type, int page) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieReviews(movieID, type, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTReview> result = new LinkedHashSet<RTReview>();
			JSONArray array = response.getData().getJSONArray(RTConstants.REVIEWS);
			for (Object obj : array) {
				result.add(new RTReview((JSONObject) obj));
			}
			
			return result;
		}
	}
	
	public static Set<RTReview> getReviews(int movieID, RTReviewType type, int pageLimit, int page) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieReviews(movieID, type, pageLimit, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTReview> result = new LinkedHashSet<RTReview>();
			JSONArray array = response.getData().getJSONArray(RTConstants.REVIEWS);
			for (Object obj : array) {
				result.add(new RTReview((JSONObject) obj));
			}
			
			return result;
		}
	}
	
	public static Set<RTReview> getAllReviews(int movieID, RTReviewType type) throws RTResponseException {
		
		RTResponseObject response = RTAPI.getMovieReviews(movieID, type, 100, 1);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTReview> result = new LinkedHashSet<RTReview>();
			JSONArray array = response.getData().getJSONArray(RTConstants.REVIEWS);
			for (Object obj : array) {
				result.add(new RTReview((JSONObject) obj));
			}
			
			int total = response.getData().getInt(RTConstants.TOTAL);
			
			for (int p = 2; (p - 1) * 100 < total; p++) {
				result.addAll(getReviews(movieID, type, 100, p));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getSimilarMovies(int movieID) throws RTResponseException {

		RTResponseArray response = RTAPI.getSimilarMovies(movieID);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}

	public static Set<RTMovie> getSimilarMovies(int movieID, int limit) throws RTResponseException {

		RTResponseArray response = RTAPI.getSimilarMovies(movieID, limit);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getInTheatreMovies() throws RTResponseException {

		RTResponseArray response = RTAPI.getInTheatreMovies();
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getInTheatreMovies(int page) throws RTResponseException {

		RTResponseArray response = RTAPI.getInTheatreMovies(page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}

	public static Set<RTMovie> getInTheatreMovies(int pageLimit, int page) throws RTResponseException {

		RTResponseArray response = RTAPI.getInTheatreMovies(pageLimit, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getAllInTheatreMovies() throws RTResponseException {

		RTResponseArray response = RTAPI.getAllInTheatreMovies();
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getBoxOfficeMovies() throws RTResponseException {

		RTResponseArray response = RTAPI.getBoxOfficeMovies();
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}

	public static Set<RTMovie> getBoxOfficeMovies(int limit) throws RTResponseException {

		RTResponseArray response = RTAPI.getBoxOfficeMovies(limit);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getUpcomingMovies() throws RTResponseException {

		RTResponseArray response = RTAPI.getUpcomingMovies();
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getUpcomingMovies(int page) throws RTResponseException {

		RTResponseArray response = RTAPI.getUpcomingMovies(page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}

	public static Set<RTMovie> getUpcomingMovies(int pageLimit, int page) throws RTResponseException {

		RTResponseArray response = RTAPI.getUpcomingMovies(pageLimit, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getAllUpcomingMovies() throws RTResponseException {

		RTResponseArray response = RTAPI.getAllUpcomingMovies();
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> getOpeningMovies() throws RTResponseException {

		RTResponseArray response = RTAPI.getOpeningMovies();
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}

	public static Set<RTMovie> getOpeningMovies(int limit) throws RTResponseException {

		RTResponseArray response = RTAPI.getOpeningMovies(limit);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	//endregion
	
	//region Search methods
	
	public static Set<RTMovie> searchByTitle(String title) throws RTResponseException {
		
		RTResponseArray response = RTAPI.searchMovieByTitle(title);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> searchByTitle(String title, int page) throws RTResponseException {
		
		RTResponseArray response = RTAPI.searchMovieByTitle(title, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> searchByTitle(String title, int pageLimit, int page) throws RTResponseException {
		
		RTResponseArray response = RTAPI.searchMovieByTitle(title, pageLimit, page);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	
	public static Set<RTMovie> fullSearchByTitle(String title) throws RTResponseException {
		
		RTResponseArray response = RTAPI.fullSearchMovieByTitle(title);
		
		if (response.hasError()) {
			throw new RTResponseException(response.getStatus());
		} else {
			
			Set<RTMovie> result = new LinkedHashSet<RTMovie>();
			
			for (JSONObject json : response.getData()) {
				result.add(new RTMovie(json));
			}
			
			return result;
		}
	}
	//endregion

}
