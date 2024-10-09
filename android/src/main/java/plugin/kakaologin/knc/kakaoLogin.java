package plugin.kakaologin.knc;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class kakaoLogin extends BridgeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        registerPlugin(kakaoLoginPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
