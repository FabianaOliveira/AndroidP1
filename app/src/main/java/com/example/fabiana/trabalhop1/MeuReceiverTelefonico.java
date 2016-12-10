package com.example.fabiana.trabalhop1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by casa on 10/12/2016.
 */
public class MeuReceiverTelefonico extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        try{
            TelephonyManager tmgr = (TelephonyManager) context .getSystemService(Context.TELECOM_SERVICE);

            MyPhoneStateListener PhoneListener = new MyPhoneStateListener();

            tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        }catch (Exception e){
            Log.e("Phone Receive Error",""+e);
        }

    }
}
