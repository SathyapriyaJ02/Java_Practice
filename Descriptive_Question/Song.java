import java.util.*;
import java.text.*;
import java.io.*;

class Song  implements Serializable
{
	private String title;
	private String genre;
	private Date duration;
	private Double rating;

	Song(){}

	Song(String title,String genre,Date duration,Double rating)
	{
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return title;
	}
	public void setGenre (String genre)
	{
		this.genre = genre;
	}
	public String getGenre()
	{
		return genre;
	}
	public void setDuration(Date duration)
	{
		this.duration = duration;
	}
	public Date getDuration()
	{
		return duration;
	}
	public void setRating(Double rating)
	{
		this.rating = rating;
	}
	public Double getRating()
	{
		return rating;
	}
	public String toString()
	{
		return title+" "+genre+" "+duration.getMinutes()+":"+duration.getSeconds()+" "+rating;
	}
	
	public static Song createSong(String songDetails) throws Exception
	{
		String songD[] = songDetails.split(","); 
		String title = songD[0];
		String genre = songD[1];
		DateFormat df = new SimpleDateFormat("mm:ss");
		Date d = df.parse(songD[2]);
		Double rating = Double.parseDouble(songD[3]);
		return new Song(title,genre,d,rating);
	}
}
	
	