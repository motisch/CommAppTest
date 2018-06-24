package com.example.moti.commapptest

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.BroadcastReceiver
import android.content.Context
import android.net.wifi.p2p.WifiP2pManager
import android.content.Context.WIFI_P2P_SERVICE
import android.net.wifi.p2p.WifiP2pManager.Channel
import android.widget.Toast
import android.content.IntentFilter




class MainActivity : AppCompatActivity() {

    var mManager: WifiP2pManager? = null
    var mChannel: Channel? = null
    var mReceiver: BroadcastReceiver? = null
    var mIntentFilter: IntentFilter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serv = getSystemService(WIFI_P2P_SERVICE)
        if (serv != null) {
            mManager = serv as WifiP2pManager
            mChannel = mManager!!.initialize(this, mainLooper, null)
            mReceiver = WiFiDirectBroadcastReceiver(mManager!!, mChannel!!, this)

            mIntentFilter = IntentFilter()
            mIntentFilter!!.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)

            mIntentFilter!!.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)
            mIntentFilter!!.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)
            mIntentFilter!!.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)
        }

        @Override
        fun onResume() {
            super.onResume()
            registerReceiver(mReceiver, mIntentFilter)
        }

        @Override
        fun onPause() {
            super.onPause()
            unregisterReceiver(mReceiver)
        }
    }
}