package com.example.laicare;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MyDoctor extends Activity implements View.OnClickListener {
    TextSwitcher textSwitcher;
    Button btnPrevious, btnNext;
    String[] TIPS = {
            "An apple a day keeps the doctor away.",
            "To be a healthy flower nourish yourself with water everyday",
            "For a healthier you make a date with the doctor once every six months.",
            "Smile to keep the wrinkles away",
            "Brushing your teath everyday keeps the cavities at a bay ",
            "A carrot a day makes you see a mile further.",


    };
    int currentIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_doctor);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrevious.setOnClickListener((View.OnClickListener) this);
        btnNext.setOnClickListener((View.OnClickListener) this);
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                TextView text = new TextView(getApplicationContext());
                text.setTextSize(26);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
                text.setTextColor(getResources().getColor(R.color.white));
                return text;
            }
        });

    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                if (currentIndex < TIPS.length - 1) ;
            {
                currentIndex = currentIndex + 1;
                textSwitcher.setText(TIPS[currentIndex]);
            }
            break;
            case R.id.btnPrevious:
                if (currentIndex > 0) {
                    currentIndex = currentIndex - 1;
                    textSwitcher.setText(TIPS[currentIndex]);
                }
                break;
        }
    }
}
