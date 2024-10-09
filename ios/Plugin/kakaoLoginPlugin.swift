import Foundation
import Capacitor
import KakaoSDKUser
import KakaoSDKCommon

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(kakaoLoginPlugin)
public class kakaoLoginPlugin: CAPPlugin {
    
    var initSwitch: Bool = false
    

        @objc public func kakaoLogin(_ call: CAPPluginCall) -> Void {
            
            guard let appKey = call.getString("appKey") else {
                call.reject("appKey not provided")
                return
            }
            
            if !initSwitch {
                KakaoSDK.initSDK(appKey:appKey, loggingEnable:true)
                initSwitch = true;
            }
            
    

            
            //카카오톡 설치 여부 확인
            if (UserApi.isKakaoTalkLoginAvailable()) {
                UserApi.shared.loginWithKakaoTalk {(oauthToken, error) in
                    if let error = error {
                        call.reject("error")
                    }
                    else {
                        self.kakaoUserInfo(call)
                    }
                }}
            else{
                // 앱이 설치되어 있지 않아서
                UserApi.shared.loginWithKakaoAccount {(oauthToken, error) in
                    if let error = error {
                        let errorString = String(describing: error)
                        call.reject( errorString)
                    }
                    else {
                        self.kakaoUserInfo(call)
                    }
                }
            }
        }

                public func kakaoUserInfo(_ call: CAPPluginCall) {
            UserApi.shared.me() { (user, error) in
                if let error = error {
                    let errorString = String(describing: error)
                    call.reject( errorString)
                }
                else {
                    call.resolve([
                        "email": user?.kakaoAccount?.email ?? ""
                    ])
                }
            }
        }
}
