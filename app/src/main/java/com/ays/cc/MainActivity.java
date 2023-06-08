package com.ays.cc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculateegp(View view) throws Exception {
        EditText egpfield = (EditText) findViewById(R.id.egpfield);
        EditText eurfield = (EditText) findViewById(R.id.eurfield);
        EditText usdfield = (EditText) findViewById(R.id.usdfield);
        if (egpfield.isFocused()) {
            String usdegpurl;
            String euregpurl;
            usdegpurl = String.valueOf(new URL("https://www.google.com/finance/quote/USD-EGP"));
            euregpurl = String.valueOf(new URL("https://www.google.com/finance/quote/EUR-EGP"));
/*error*/            Document documentusdegp = Jsoup.connect(usdegpurl).get();
/*error*/            Document documenteuregp = Jsoup.connect(euregpurl).get();

            eurfield.setText("999999999999");
            usdfield.setText("999999999999");

 /*loop crash*/           egpfield.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
/*error*/                    float valueusdegp = Float.parseFloat(documentusdegp.select("div[class=YMlKec fxKbKc]").text());
/*error*/                    float valueeuregp = Float.parseFloat(documenteuregp.select("div[class=YMlKec fxKbKc]").text());




                }

                public void afterTextChanged(Editable editable) {

                }


         });
            Toast.makeText(this, " Working 1", Toast.LENGTH_SHORT).show();

        }}

    public void calculateeur(View view) throws Exception {
        EditText egpfield = (EditText) findViewById(R.id.egpfield);
        EditText eurfield = (EditText) findViewById(R.id.eurfield);
        EditText usdfield = (EditText) findViewById(R.id.usdfield);
        if (eurfield.isFocused()) {
            String egpeururl;
            String usdeururl;
            egpeururl = String.valueOf(new URL("https://www.google.com/finance/quote/EGP-EUR"));
            usdeururl = String.valueOf(new URL("https://www.google.com/finance/quote/USD-EUR"));
/*error*/           Document documentegpeur = Jsoup.connect(egpeururl).get();
/*error*/           Document documentusdeur = Jsoup.connect(usdeururl).get();

            eurfield.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
/*error*/                   float valueegpeur = Float.parseFloat(documentegpeur.select("div[class=YMlKec fxKbKc]").text());
/*error*/                   float valueusdeur = Float.parseFloat(documentusdeur.select("div[class=YMlKec fxKbKc]").text());



                    egpfield.setText("999999999999");
                    usdfield.setText("999999999999");
                }

                public void afterTextChanged(Editable editable) {

                }});
            Toast.makeText(this, " Working 2", Toast.LENGTH_SHORT).show();

        }}

    public void calculateusd(View view) throws Exception {
                EditText egpfield = (EditText) findViewById(R.id.egpfield);
                EditText eurfield = (EditText) findViewById(R.id.eurfield);
                EditText usdfield = (EditText) findViewById(R.id.usdfield);
            if (usdfield.isFocused()) {
                String egpusdurl;
                String eurusdurl;
                egpusdurl = String.valueOf(new URL("https://www.google.com/finance/quote/EGP-USD"));
                eurusdurl = String.valueOf(new URL("https://www.google.com/finance/quote/EUR-USD"));
/*error*/              Document documentegpusd = Jsoup.connect(egpusdurl).get();
/*error*/              Document documenteurusd = Jsoup.connect(eurusdurl).get();

                usdfield.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
/*error*/                   float valueegpusd = Float.parseFloat(documentegpusd.select("div[class=YMlKec fxKbKc]").text());
/*error*/                   float valueeurusd = Float.parseFloat(documenteurusd.select("div[class=YMlKec fxKbKc]").text());

                    eurfield.setText("999999999999");
                    egpfield.setText("999999999999");
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
                Toast.makeText(this, " Working 3", Toast.LENGTH_SHORT).show();
    }}




}