package dev.rubio.util;

import io.javalin.http.Context;

public class SecurityUtil {
    public void attachResponseHeaders(Context ctx){
        ctx.header("Access-Control-Expose-Headers", "Authorization");
    }
}
