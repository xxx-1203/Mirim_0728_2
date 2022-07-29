package kr.hs.emirim.mirim_0728_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgName = {"가넷", "애머시스트", "펄", "오팔", "루비", "사파이어", "로즈쿼츠", "비스무트", "라피스 라줄리"};
    ImageView[] imgv = new ImageView[imgName.length];
    int[] voteCount = new int[imgName.length];
    int[] imgId = {R.id.imgv1, R.id.imgv2, R.id.imgv3, R.id.imgv4, R.id.imgv5, R.id.imgv6, R.id.imgv7, R.id.imgv8, R.id.imgv9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("익명 보석 투표");
        Button btnFinish = findViewById(R.id.btn_vote_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("imgName", imgName);
                intent.putExtra("voteCount", voteCount);
                startActivity(intent);
            }
        });

        for(int i=0; i<voteCount.length; i++)
            voteCount[i]=0;
        for(int i =0; i<imgv.length; i++){
            final  int index;
            index = i;
            imgv[index] = findViewById(imgId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index]+": 총"+voteCount[index]+"표", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}