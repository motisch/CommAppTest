package com.example.moti.commapptest

import android.net.wifi.p2p.WifiP2pManager
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.net.wifi.p2p.WifiP2pManager.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class WiFiDirectBroadcastReceiver(private val mManager: WifiP2pManager?, private val mChannel: Channel?,activity: MainActivity) : BroadcastReceiver() {
    private val mActivity: MainActivity

    init {
        this.mActivity = activity
    }


    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        Toast.makeText(context,action, Toast.LENGTH_LONG).show()
        /*if (WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            val state = intent.getIntExtra(EXTRA_WIFI_STATE, -1);
            if (state == WIFI_P2P_STATE_ENABLED) {
                Toast.makeText(context,"Wifi Is Good", Toast.LENGTH_LONG).show()
            } else {
                // Wi-Fi P2P is not enabled
                Toast.makeText(context,"Wifi Not Enabled", Toast.LENGTH_LONG).show()
            }
        }*/

        /* if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION == action) {
            // Check to see if Wi-Fi is enabled and notify appropriate activity
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION == action) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers
        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION == action) {
            // Respond to new connection or disconnections
        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION == action) {
            // Respond to this device's wifi state changing
        }*/
    }
}