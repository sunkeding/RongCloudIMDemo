package com.imdemo.skd.imdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

public class MainActivity extends AppCompatActivity {   // TODO: 2018/1/17 demo中的key  n19jmcy59f1q9
    String token1="ywn2jyBu0nBafLuMoxadasgxKjMgOfV4n3Bi/1FhjQMO44WIMLr0o48PCK/PViF6VmbUy8s7+EulduY82Iccxg==";   //userId=123456
    String token2="cIcATKhGfwt3K88vJ7ue01B27HJdgd5usNCu8PDhIriwzQD804dcYAH+iuCFuqfAJGLaYGS/DQFG+PsDJaTEcw=="; //userId=9999

    // TODO: 2018/1/17 demo上的两个账号的token 孙科丁小号userId=B3aE6Sj5H   大号：gaKPNtBsY
    String demo_userId1="B3aE6Sj5H";
    String demo_userId2="gaKPNtBsY";
    String demo_token1="7VzNcSX3iQ7w3mUpZl2/n3xpRjANxKgfakOnYLFljI+8sl3hCWS/kOPT03xo9y6pQTT5vJH9Z0KIF+F2blaeDQ=="; //小号的
    String demo_token2="HzRIitfhFY4DKwRLcTKOMqE4ovwvabHEXU8xDrUJSvHwGIJoS4kz3uL5PlArhqh3IbRJvAmF19s63SM8quVF4/8aey1Q+HN9"; //大号的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RongIM.init(this);
        connect(demo_token1);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,ConversationListActivity.class));
                HashMap<String, Boolean> map = new HashMap<>();
                map.put(Conversation.ConversationType.PRIVATE.getName(), false); // 会话列表需要显示私聊会话, 第二个参数 true 代表私聊会话需要聚合显示
//                map.put(Conversation.ConversationType.GROUP.getName(), false);  // 会话列表需要显示群组会话, 第二个参数 false 代表群组会话不需要聚合显示
                RongIM.getInstance().startConversationList(MainActivity.this,map);
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                RongIM.getInstance().startPrivateChat(MainActivity.this,demo_userId2,"单聊标题");
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });
    }


    /**
     * <p>连接服务器，在整个应用程序全局，只需要调用一次，需在 {@link #init(Context)} 之后调用。</p>
     * <p>如果调用此接口遇到连接失败，SDK 会自动启动重连机制进行最多10次重连，分别是1, 2, 4, 8, 16, 32, 64, 128, 256, 512秒后。
     * 在这之后如果仍没有连接成功，还会在当检测到设备网络状态变化时再次进行重连。</p>
     *
     * @param token    从服务端获取的用户身份令牌（Token）。
     * @param callback 连接回调。
     * @return RongIM  客户端核心类的实例。
     */
    private void connect(String token) {

        if (getApplicationInfo().packageName.equals(App.getCurProcessName(getApplicationContext()))) {

            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                @Override
                public void onTokenIncorrect() {
                    Log.d("MainActivity", "onTokenIncorrect");
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                @Override
                public void onSuccess(String userid) {
                    Toast.makeText(MainActivity.this, "userid:"+userid, Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    finish();
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    Log.d("MainActivity", "errorCode:" + errorCode);
                }
            });
        }
    }

}
