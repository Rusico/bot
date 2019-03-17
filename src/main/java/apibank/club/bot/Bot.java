package apibank.club.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Bot extends TelegramLongPollingBot {

  private String token = "833516765:AAEqVBbecQ1gYgJb8TcfGxPrOSjrjdj_DB8";

  public void onUpdateReceived(Update update) {
    try {
      //проверяем есть ли сообщение и текстовое ли оно
      if (update.hasMessage() && update.getMessage().hasText()) {
        //Извлекаем объект входящего сообщения
        Message inMessage = update.getMessage();
        //Создаем исходящее сообщение
        SendMessage outMessage = new SendMessage();
        //Указываем в какой чат будем отправлять сообщение
        //(в тот же чат, откуда пришло входящее сообщение)
        outMessage.setChatId(inMessage.getChatId());
        //Указываем текст сообщения
        outMessage.setText(inMessage.getText());
        //Отправляем сообщение
        execute(outMessage);
      }
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

  public String getBotUsername() {
    return "RusicoBot";
  }

  public String getBotToken() {
    return token;
  }

  public static void main(String[] argv) {
    TelegramBotsApi botsApi = new TelegramBotsApi();
    try {
      botsApi.registerBot(new Bot());
    } catch (TelegramApiRequestException e) {
      e.printStackTrace();
    }
  }
}
