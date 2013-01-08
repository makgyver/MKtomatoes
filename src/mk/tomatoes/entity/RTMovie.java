package mk.tomatoes.entity;

import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import mk.tomatoes.utils.Pair;
import net.sf.json.JSONObject;

public class RTMovie extends RTEntity {

	//region Fields

	/**
	 * The movie critics rating.
	 */
	private int criticsRating;
	
	/**
	 * The movie audiance score.
	 */
	private int audianceScore;
	
	/**
	 * The movie MPAA rating.
	 */
	private String mpaa;
	
	/**
	 * The movie studio.
	 */
	private String studio;
	
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
	private String imdbDd;
	
	/**
	 * The movie Rotten Tomatoes ID.
	 */
	private String id;
	
	/**
	 * The movie vote count.
	 */
	private Integer count;
	
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
	 * The movie cast.
	 */
	private Set<Pair<String, String>> cast = Collections.synchronizedSet(new LinkedHashSet<Pair<String, String>>());
	
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

	private void parseJSON(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

}
