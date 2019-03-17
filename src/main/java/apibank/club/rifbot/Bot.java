package apibank.club.rifbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Bot {
  private Logger log = LoggerFactory.getLogger(getClass());

  public String process(String message) {
    if (message == null)
      return null;
    log.info("Received message: {}", message);
    return message.replace("\"", "-") + "\"?";
  }
}
