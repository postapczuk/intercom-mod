package postapczuk.github.com.hodor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Hodor extends Activity {

    private static final String S_HODOR = "http://%s/hodor";

    URL hodorEndpoint;

    // UI references.
    private AutoCompleteTextView mUrl;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setContentView(R.layout.activity_hodor);
        mUrl = findViewById(R.id.url);
        mUrl.setText("192.168.1.117");
        try {
            hodorEndpoint = new URL(String.format(S_HODOR, mUrl.getText().toString()));
        } catch (MalformedURLException e) {
            Toast.makeText(
                    Hodor.this,
                    String.format("Error: %s", e.getMessage()),
                    Toast.LENGTH_LONG
            ).show();
        }
        mUrl.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable editableText) {
                try {
                    hodorEndpoint = new URL(String.format(S_HODOR, editableText.toString()));
                } catch (MalformedURLException e) {
                    Toast.makeText(
                            Hodor.this,
                            String.format("Error: %s", e.getMessage()),
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });

        Button mOpenButton = findViewById(R.id.open_button);
        mOpenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    HttpURLConnection myConnection = (HttpURLConnection) hodorEndpoint.openConnection();
                    if (myConnection.getResponseCode() == 200) {
                        Toast.makeText(
                                Hodor.this,
                                myConnection.getResponseMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    } else {
                        Toast.makeText(
                                Hodor.this,
                                "Couldn't get any response.",
                                Toast.LENGTH_LONG
                        ).show();
                    }
                } catch (IOException e) {
                    Toast.makeText(
                            Hodor.this,
                            String.format("Error: %s", e.getMessage()),
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });

    }
}

