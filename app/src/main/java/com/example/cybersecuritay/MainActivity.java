package com.example.cybersecuritay;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int fakeCounter = 0;
    int realCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ImageView mainImage = findViewById(R.id.mainImage);
        Button nextRound = findViewById(R.id.nextRound);
        ImageView dislike = findViewById(R.id.dislike);
        ImageView like = findViewById(R.id.like);
        Drawable dislikeImg = getDrawable(R.drawable.dislike);
        Drawable likeImg = getDrawable(R.drawable.like);
        ArrayList<Drawable> fakes = new ArrayList<>();
        fakes.add(getDrawable(R.drawable.fake1));
        fakes.add(getDrawable(R.drawable.fake2));
        fakes.add(getDrawable(R.drawable.fake3));
        fakes.add(getDrawable(R.drawable.fake4));
        fakes.add(getDrawable(R.drawable.fake5));
        fakes.add(getDrawable(R.drawable.fake6));
        fakes.add(getDrawable(R.drawable.fake7));
        fakes.add(getDrawable(R.drawable.fake8));
        fakes.add(getDrawable(R.drawable.fake9));
        fakes.add(getDrawable(R.drawable.fake10));

        ArrayList<Drawable> reals = new ArrayList<>();
        reals.add(getDrawable(R.drawable.real1));
        reals.add(getDrawable(R.drawable.real2));
        mainImage.setImageDrawable(fakes.get(0));
        nextRound.setEnabled(false);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reals.contains(mainImage.getDrawable()))
                {
                    mainImage.setImageDrawable(likeImg);
                }
                else
                {
                    mainImage.setImageDrawable(dislikeImg);
                }
                nextRound.setEnabled(true);
                nextRound.setEnabled(true);
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fakes.contains(mainImage.getDrawable()))
                {
                    mainImage.setImageDrawable(likeImg);
                }
                else
                {
                    mainImage.setImageDrawable(dislikeImg);
                }
                nextRound.setEnabled(true);
            }
        });
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextRound.setEnabled(false);
                if(realCounter == reals.size())
                {
                    realCounter = 0;
                }
                if(fakeCounter == fakes.size())
                {
                    fakeCounter = 0;
                }
                if ((int)(Math.random() * 2) == 0)
                {
                    mainImage.setImageDrawable(fakes.get(fakeCounter));
                    fakeCounter++;
                }
                else
                {
                    mainImage.setImageDrawable(reals.get(realCounter));
                    realCounter++;
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}