import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import solution.SortFromFiles;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String lURL = "https://square.github.io/okhttp/";
        System.out.println(run(lURL));
        //Solution
        SortFromFiles.sort();
    }

    /**
     * get response of http url
     * @param url URL
     * @return HTML response
     * @throws IOException IO exception
     */
    private static String run(String url) throws IOException {
        OkHttpClient lClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = lClient.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
