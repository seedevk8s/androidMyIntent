package kr.co.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("명화 선호도 투표 결과");

        // 앞 화면에서 보낸 투표 결과 값을 받음
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");


        Integer[] imageFileId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        // 1등 그림이름과 그리파일을 보여줌
        TextView textViewTop = findViewById(R.id.tvTop);
        ImageView imageViewTop = findViewById(R.id.ivTop);
        int maxEntry = 0;
        for (int i = 1; i < voteResult.length; i++) {
            if (voteResult[maxEntry] < voteResult[i])
                maxEntry = i;
        }

        textViewTop.setText(imageName[maxEntry]);
        imageViewTop.setImageResource(imageFileId[maxEntry]);







        // 9개의 TextView, RationBar 객체배열 생성
        TextView[] textViews = new TextView[imageName.length];
        RatingBar[] ratingBars = new RatingBar[imageName.length];

        // 9개의 TextView, RationBar ID 배열 생성
        Integer[] tvID = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                        R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer[] rbarID = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
                            R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        // 9개의 TextView, RationBar 개체 연결하기
        for (int i = 0; i < voteResult.length; i++) {
            textViews[i] = findViewById(tvID[i]);
            ratingBars[i] = findViewById(rbarID[i]);
        }

        // 각 TextView 및 RationBar에 넘겨 받은 값을 반영하기
        for (int i = 0; i < voteResult.length; i++) {
            textViews[i].setText(imageName[i]);
            ratingBars[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}















