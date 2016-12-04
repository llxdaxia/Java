package cn.lemon.okhttp;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by linlongxin on 2016/3/23.
 */
public class LoggingInterceptors {

    private static final Logger logger = Logger.getLogger(LoggingInterceptors.class.getName());
    private static OkHttpClient okHttpClient;

    public LoggingInterceptors() throws IOException{
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        logger.info(String.format("send request: %s on %s%n%s",
                                request.url(),chain.connection(),request.headers()));

                        Response response = chain.proceed(request);
                        logger.info(String.format("Received response for %s in %n%s",
                                request.url(), response.headers()));
                        return response;
                    }
                }).build();
    }

    public void run() throws IOException {
        Request request = new Request.Builder()
                .url("http://baidu.com")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        response.body().close();
    }

    public static void main(String[] args) {
        try {
            new LoggingInterceptors().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
