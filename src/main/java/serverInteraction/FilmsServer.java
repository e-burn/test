package serverInteraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import data.FilmInfo;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilmsServer implements IFilmsServer
{
    private FilmInfo filmDesc_;
    private WebClient client_;
    @Override
    public boolean searchFilm(String filmTitle) throws IOException {
        client_ = new WebClient();
        client_.getOptions().setCssEnabled(false);
        client_.getOptions().setJavaScriptEnabled(false);
        filmDesc_ = new FilmInfo(filmTitle);
        List<HtmlElement> items = searchForMostWantedFilm(filmTitle);
        if (items.isEmpty()) {
            //System.out.println("Film is not found!");
            return false;
        }
        else
        {
            HtmlElement newestFilm = items.get(0);
            HtmlDivision divRating = ((HtmlDivision) newestFilm.getFirstByXPath("//div[@class='rating  ratingGreenBG']"));
            if (divRating == null) {
                //System.out.println("Film is not found");
                return false;
            }
            filmDesc_.setRating(divRating.asText());
            HtmlUnorderedList links = (HtmlUnorderedList) divRating.getNextSibling().getNextSibling();
            HtmlAnchor itemAnchor = ((HtmlAnchor)links.getFirstByXPath(".//a"));
            String dataID = itemAnchor.getAttribute("data-id");
            String dataType = itemAnchor.getAttribute("data-type");
            fillFilmDesc(dataID, dataType);
        }

        return true;
    }

    @Override
    public FilmInfo getFilmDesc()
    {
        return filmDesc_;
    }

    private void fillFilmDesc(String dataID, String dataType) throws IOException
    {
        String searchUrl = "https://www.kinopoisk.ru/" + dataType + "/" + URLEncoder.encode(dataID, "UTF-8");
        HtmlPage page = client_.getPage(searchUrl);
        DomNode filmDesc = page.getFirstChild()
                .getNextSibling()
                .getFirstChild()
                .getNextSibling()
                .getFirstChild()
                .getNextSibling()
                .getNextSibling()
                .getFirstChild();
        String info  = filmDesc.getTextContent();
        //System.out.println(filmDesc);
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(info, Map.class);
        //System.out.println(map);
        String originalName = (String)map.get("alternateName");
        String description = (String)map.get("description");
        //String rating = map.get("aggregateRating")
        String posterPath = (String)map.get("image");
        ArrayList genre = (ArrayList)map.get("genre");
        ArrayList directorsInfo = (ArrayList)map.get("director");
        ArrayList directors = new ArrayList();
        for(int i = 0; i < directorsInfo.size(); i++)
        {
            LinkedHashMap<String, String> director = (LinkedHashMap<String, String>)directorsInfo.get(i);
            directors.add(director.get("name"));
        }
        ArrayList actorsInfo = (ArrayList)map.get("actor");
        ArrayList actors = new ArrayList();
        for(int i = 0; i < actorsInfo.size(); i++)
        {
            LinkedHashMap<String, String> director = (LinkedHashMap<String, String>)actorsInfo.get(i);
            actors.add(director.get("name"));
        }
        String numberOfEpisodes = String.valueOf((Integer)map.get("numberOfEpisodes"));
        ArrayList countries = (ArrayList)map.get("countryOfOrigin");
        String duration =(String)map.get("timeRequired");
        String year = (String)map.get("datePublished");

        filmDesc_.setOriginalTitle_(originalName);
        filmDesc_.setDescription(description);
        filmDesc_.setPosterPath(posterPath);
        filmDesc_.setGenre(genre);
        filmDesc_.setDirectors_(directors);
        filmDesc_.setMainCast(actors);
        filmDesc_.setNumberOfEpisodes(numberOfEpisodes);
        filmDesc_.setCountry(countries);
        filmDesc_.setDuration_(duration);
        filmDesc_.setYear(year);
        //filmInfo_.downloadPoster();
    }

    private List<HtmlElement> searchForMostWantedFilm(String filmTitle) throws IOException
    {
        String searchUrl = "https://www.kinopoisk.ru/index.php?kp_query=" + URLEncoder.encode(filmTitle, "UTF-8");
        HtmlPage page = client_.getPage(searchUrl);
        List<HtmlElement> items = page.getByXPath("//div[@class='element most_wanted']");
        return items;
    }
}