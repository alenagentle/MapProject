package com.simbirsoft.javacourse.service;

import com.simbirsoft.javacourse.data.DataKeys;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class HtmlServiceImpl implements HtmlService {
    private String content;

    @Override
    public void createHtml(Map<String, String> map) {
        this.content = "<!DOCTYPE html>\n"
                + "<html lang=\"ru\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "    <title>Резюме</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <h2 class=\"text-center\"><strong>Резюме</strong></h2>\n"
                + "        <dt>ФИО:</dt><dd>" + map.get(DataKeys.FIO) + "</dd>\n"
                + "        <dt>Дата рождения:</dt><dd>" + map.get(DataKeys.DOB) + "</dd>\n"
                + "        <dt>Телефон:</dt><dd>" + map.get(DataKeys.PHONE) + "</dd>\n"
                + "        <dt>e-mail:</dt><dd>" + map.get(DataKeys.EMAIL) + "</dd>\n"
                + "        <dt>Skype:</dt><dd>" + map.get(DataKeys.SKYPE) + "</dd>\n"
                + "        <h4 class=\"card-title\"><strong>Цель:</strong></h4>\n"
                + "        <p class=\"card-text\">" + map.get(DataKeys.TARGET) + "</p>\n"
                + "        <h4 class=\"card-title\"><strong>Опыт работы:</strong></h4>\n"
                + "        <p class=\"card-text\">" + map.get(DataKeys.EXPERIENCES) + "</p>\n"
                + "        <h4 class=\"card-title\"><strong>Образование:</strong></h4>\n"
                + "        <p class=\"card-text\">" + map.get(DataKeys.EDUCATIONS) + "</p>\n"
                + "    </div>\n"
                + "</body>"
                + "</html>";
    }

    @Override
    public void write(String Path){
        try {
            File file = new File(Path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter (Path, false);
            writer.write(this.content);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
