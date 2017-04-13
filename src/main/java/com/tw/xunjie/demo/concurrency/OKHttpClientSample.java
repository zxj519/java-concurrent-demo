package com.tw.xunjie.demo.concurrency;

import okhttp3.*;

import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * Created by xjzhou on 10/04/2017.
 */
public class OKHttpClientSample {

    public static void main(String[] args) throws Exception {
        out.println("Main thread started");
        new OKHttpClientSample().run();
        out.println("Main thread finished");
    }

    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    out.println(responseBody.string());
                }
            }
        });
    }
}
