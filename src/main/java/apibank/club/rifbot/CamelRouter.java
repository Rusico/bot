package apibank.club.rifbot;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

  @Autowired
  private Bot bot;


  @Override
  public void configure() throws Exception {
    from("telegram:bots")
            .bean(bot)
            .to("telegram:bots");

  }
}
