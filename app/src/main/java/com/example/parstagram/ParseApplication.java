package com.example.parstagram;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("L89s9me81PsZS6RXoERDFNcOzwDmVjfUXCSCVZHB")
                .clientKey("pKtoEICJIinIDtbFUiy430jTw4YxxW9VOqEDAqt0")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
