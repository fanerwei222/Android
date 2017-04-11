package ulyne.com.reservedforfanwei.Volley;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanwei on 2017/4/5.
 */

public class VolleyAct {
    /**
     * 利用volley 发送请求
     */
    public void volleySend() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "url", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }) {
            // 如何上传cookie
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if ("" != null && "".length() > 0) {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("cookie", "");

                    Log.d("调试", "headers----------------" + headers);
                    return headers;
                }
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //在这里设置需要post的参数
                Map<String, String> map = new HashMap<String, String>();
                map.put("name", "");
                map.put("address", "");
                return map;
            }


        };
        //SingleVolleyRequestQueue.getInstance(this).addToRequestQueue(stringRequest);
    }
}
