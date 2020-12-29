package data;
import org.apache.http.client.methods.HttpGet;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilmInfo
{
	private String rating_;
	private String year_;
	private String title_;
	private ArrayList<String> genre_;
	private String numberOfEpisodes;
	private ArrayList<String> directors_;
	private String duration_;
	private String posterURL_;
	private ArrayList<String>  countries_;
	private ArrayList<String> mainCast_;
	private String description_;
	private Integer downloadedPostersNumber_;
	//private static final String savedPosterPath_ = "D:\\IdeaProjects\\KinopoiskParser\\cwebp_tmp\\";

	public String getOriginalTitle_() {
		return originalTitle_;
	}

	public void setOriginalTitle_(String originalTitle_) {
		this.originalTitle_ = originalTitle_;
	}

	private String originalTitle_;

	public String getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	public void setNumberOfEpisodes(String numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}



	public String getPosterPath(){
		return posterURL_;
	}

	public void setPosterPath(String posterPath_) {
		this.posterURL_ = posterPath_;
	}



	public String getAgeCategory() {
		return ageCategory_;
	}

	public void setAgeCategory(String ageCategory_) {
		this.ageCategory_ = ageCategory_;
	}

	private String ageCategory_;

	public ArrayList<String>  getCountry() {
		return countries_;
	}

	public void setCountry(ArrayList<String>  country_) {
		this.countries_ = country_;
	}



	public ArrayList<String> getGenre() {
		return genre_;
	}

	public void setGenre(ArrayList<String> genre_) {
		this.genre_ = genre_;
	}


	public ArrayList<String> getDirector() {
		return directors_;
	}

	public void setDirectors_(ArrayList<String> directors_) {
		this.directors_ = directors_;
	}

	public String getDuration_() {
		return duration_;
	}

	public void setDuration_(String duration_) {
		this.duration_ = duration_;
	}


	public FilmInfo(String title)
	{
		title_ = title;
	}

	public String getRating() {
		return rating_;
	}

	public void setRating(String rating_)
	{
		this.rating_ = rating_;
	}

	public String getYear()
	{
		return year_;
	}

	public void setYear(String year_)
	{
		this.year_ = year_;
	}

	public String getTitle()
	{
		return title_;
	}

	public void setTitle(String title_)
	{
		this.title_ = title_;
	}

	public ArrayList<String> getMainCast()
	{
		return mainCast_;
	}

	public void setMainCast(ArrayList<String> mainCast_)
	{
		this.mainCast_ = mainCast_;
	}

	public String getDescription() {
		return description_;
	}

	public void setDescription(String description_) {
		this.description_ = description_;
	}

	@Override
	public String toString() {
		return "Рэйтинг: " + prepareData(rating_) + '\n' +'\n' +
				"Год: " + prepareData(year_) + '\n' +'\n' +
				"Жанр: " + arrayListToString(genre_) + '\n' +'\n' +
				"Количество эпизодов: " + prepareData(numberOfEpisodes) + '\n' + '\n' +
				"Режиссер(ы): " + arrayListToString(directors_) + '\n' +
				"Длительность (одного эпизода): " + prepareData(duration_) + " мин" + '\n' + '\n' +
				//"posterPath_=" + prepareData(posterURL_) + '\n' +
				"Страна: " + arrayListToString(countries_) + '\n' + '\n' +
				"В главных ролях: " + arrayListToString(mainCast_) + '\n' + '\n' +
				"Краткое описание: " + prepareData(description_) + '\n' + '\n' +
				"Оригинальное название: " + prepareData(originalTitle_) + '\n';
		//"ageCategory_='" + ageCategory_ + + '\n';
	}

	private String prepareData(Object data)
	{
		if(data == null)
		{
			return "no data found...";
		}
		else
		{
			return data.toString();
		}
	}

	private String arrayListToString(ArrayList<String> array)
	{
		if (array.size() == 0)
		{
			return "no data found...";
		}
		String result = array.get(0);
		for(int i = 1; i < array.size(); i++)
		{
			result += ", ";
			result += array.get(i);
		}
		return result;
	}
/*	public void downloadPoster()
	{
		try {
			downloadedPostersNumber_ = Files.list(Paths.get(savedPosterPath_)).collect(Collectors.toList()).size();
			String urlFile  = posterURL_.replace("\\", "%5C");
			String yourURLStr = "http://host.com?param=" + java.net.URLEncoder.encode(urlFile, "UTF-8");
			URL website = new URL(yourURLStr);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			String fileName = "poster_" + (downloadedPostersNumber_+1);
			String webpImage = fileName;
			FileOutputStream fos = new FileOutputStream(savedPosterPath_ + webpImage);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			String pngImage = fileName + "_png" + ".png";
            *//*String src  = "a.webp";
            String dest = "a.png";*//*
			//WebpIO.create().toNormalImage(webpImage, pngImage);
			File newImageFile = new File(savedPosterPath_ + pngImage);
			newImageFile.createNewFile();
			//WebpIO.create().toNormalImage(webpImage, pngImage);
			//JDeli.convert(File inFile, File outFile);

			//System.out.println(posterURL_);
			fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}*/
}
