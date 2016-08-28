package com.example.enterprise.robot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.aldebaran.qi.QiCallback;
import com.aldebaran.qi.sdk.object.actuation.Actuation;
import com.aldebaran.qi.sdk.object.actuation.Frame;
import com.aldebaran.qi.sdk.object.actuation.GoTo;
import com.aldebaran.qi.sdk.object.geometry.Quaternion;
import com.aldebaran.qi.sdk.object.geometry.Transform;
import com.aldebaran.qi.sdk.object.geometry.Vector3;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GoToActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Quaternion r = new Quaternion(0, 0, 0, 1);
        Vector3 t = new Vector3(1, 0, 0);
        Transform tf = new Transform(r, t);
        Frame robotFrame = Actuation.get(this).robotFrame();
        Frame robotAtStart = robotFrame.makeDetachedFrame(System.currentTimeMillis());
        Frame targetFrame = robotAtStart.makeStaticChildFrame(tf);

    }
}
