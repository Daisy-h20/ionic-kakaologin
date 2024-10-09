package plugin.kakaologin.knc;

import android.app.Activity;
import android.util.Log;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;

@CapacitorPlugin(name = "kakaoLogin")
public class kakaoLoginPlugin extends Plugin {

    private Boolean initSwitch = false;

    @PluginMethod
    public void kakaoLogin(PluginCall call) {
        if (!initSwitch) {
            String appKey = call.getString("appKey");
            try {
                KakaoSdk.init(super.getActivity(), appKey);
            } catch (Exception e) {
                call.reject(e.getMessage());
            }
            initSwitch = true;
        }

        Activity activity = super.getActivity();
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(activity)) {
            UserApiClient
                .getInstance()
                .loginWithKakaoTalk(
                    activity,
                    (oAuthToken, error) -> {
                        if (error != null) {
                            call.reject(error.toString());
                        } else if (oAuthToken != null) {
                            UserApiClient
                                .getInstance()
                                .me(
                                    (user, meError) -> {
                                        Account kakaoAccount = user.getKakaoAccount();

                                        String email = kakaoAccount.getEmail();
                                        JSObject ret = new JSObject();
                                        ret.put("email", email);
                                        call.resolve(ret);
                                        return null;
                                    }
                                );
                        } else {
                            call.reject("no_data");
                        }
                        return null;
                    }
                );
        } else {
            UserApiClient
                .getInstance()
                .loginWithKakaoAccount(
                    activity,
                    (oAuthToken, error) -> {
                        if (error != null) {
                            call.reject("error::" + error.toString());
                        } else if (oAuthToken != null) {
                            UserApiClient
                                .getInstance()
                                .me(
                                    (user, meError) -> {
                                        Account kakaoAccount = user.getKakaoAccount();
                                        String email = kakaoAccount.getEmail();
                                        JSObject ret = new JSObject();
                                        ret.put("email", email);
                                        call.resolve(ret);
                                        return null;
                                    }
                                );
                        } else {
                            call.reject("no_data");
                        }
                        return null;
                    }
                );
        }
    }
}
