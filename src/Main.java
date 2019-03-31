import http.HttpUtils;
import parse.HtmlParser;

public class Main {
    public static void main(String[] args) {
        HtmlParser.parseMovie(HttpUtils.getHtml("https://movie.douban.com/subject/26374197/"),1);
    }
}
