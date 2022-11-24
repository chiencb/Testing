package com.example.soap;

import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Base64;

public class WebServiceMessageSenderWithAuth extends HttpUrlConnectionMessageSender {

    @Override
    protected void prepareConnection(HttpURLConnection connection)
            throws IOException {
        System.out.println("prepareConnection");
        String userpassword = "Fptuseruat:Fptuseruat";
        String encodedAuthorization = Base64.getEncoder().encodeToString(userpassword.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);

        super.prepareConnection(connection);
    }
}
