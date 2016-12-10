package com.example.fabiana.trabalhop1;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by casa on 10/12/2016.
 */
public class MyPhoneStateListener extends PhoneStateListener {
    private Context pcontext;

    public void onCallStateChanged(int state, String incomingNumber){
        Log.d("MyPhoneListener", state+" incoming no:"+incomingNumber);

        if(state ==1){
            String msg = "Nova Chamada :"+incomingNumber;
            int duration = Toast.LENGTH_LONG;
            
            Toast toast = Toast.makeText(pcontext,msg,duration);
            toast.show();
        }
    }

}
