package com.aia.aiaedownload.services.case360;

import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Base64;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Case360MessageSenderAuth extends HttpUrlConnectionMessageSender {

    private String username;
    private String password;
    
    @Override
    protected void prepareConnection(HttpURLConnection connection)
            throws IOException {
        String userpassword = username + ":" + password;
        String encodedAuthorization = Base64.getEncoder().encodeToString(userpassword.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);
        super.prepareConnection(connection);
    }
}
