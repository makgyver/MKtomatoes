package mk.tomatoes.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mk.tomatoes.utils.Log;
import mk.tomatoes.core.RTConstants;
import net.sf.json.JSONObject;

public class RTReview extends RTEntity {

	private String criticName;
	private Date date;
	private String freshness;
	private String publication;
	private String quote;
	
	public RTReview(JSONObject json) {
		super(json);
		parseJSON(json);
	}

	public String getCriticName() {
		return criticName;
	}
	
	public void setCriticName(String criticName) {
		this.criticName = criticName;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(String date) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = (Date)formatter.parse(date);
		} catch (ParseException e) {
			Log.print(e);
		}
	}
	
	public String getFreshness() {
		return freshness;
	}
	
	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}
	
	public String getPublication() {
		return publication;
	}
	
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	private void parseJSON(JSONObject json) {
		
		if (json.has(RTConstants.CRITIC)) setCriticName(json.getString(RTConstants.CRITIC));
		if (json.has(RTConstants.DATE)) setDate(json.getString(RTConstants.DATE));
		if (json.has(RTConstants.QUOTE)) setQuote(json.getString(RTConstants.QUOTE));
		if (json.has(RTConstants.PUBLICATION)) setPublication(json.getString(RTConstants.PUBLICATION));
		if (json.has(RTConstants.FRESHNESS)) setFreshness(json.getString(RTConstants.FRESHNESS));
		
	}

}
