package net.sghill.rescuebuddies.acceptance.libraries;

import retrofit.Endpoint;
import retrofit.client.Header;
import retrofit.client.Response;

import javax.inject.Inject;

public class ResponseLibrary extends InjectableLibrary {
    @Inject
    Endpoint endpoint;

    public String getLocationHeaderValue(Response response) {
        for (Header header : response.getHeaders()) {
            if ("Location".equals(header.getName())) {
                return header.getValue();
            }
        }
        return "[NOT FOUND]";
    }

    public String resolveUrl(String path) {
        return endpoint.getUrl().concat(path);
    }
}
