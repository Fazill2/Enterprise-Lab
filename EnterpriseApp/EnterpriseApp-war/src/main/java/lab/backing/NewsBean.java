package lab.backing;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.jms.*;
import lab.ejb.NewsItem;
import lab.ejb.NewsItemFacadeLocal;

import java.util.List;

@RequestScoped
@Named
public class NewsBean {
    @Inject
    private NewsItemFacadeLocal facade;

    @Inject
    private JMSContext context;
    @Resource(lookup="java:app/jms/NewsQueue")
    private Queue queue;

    private String heading;
    private String body;



    void sendNewsItem(String heading, String body) {
        try {
            TextMessage message = context.createTextMessage();
            NewsItem e = new NewsItem();
            e.setHeading(heading);
            e.setBody(body);
            message.setText(e.getHeading() + "|" + e.getBody());
            context.createProducer().send(queue, message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    public List<NewsItem> getNewsItems()
    {
        return facade.getAllNewsItems();
    }

    public String submitNews()
    {
        sendNewsItem(getHeading(), getBody());
        setHeading("");
        setBody("");
        return "news?faces-redirect=true";
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
