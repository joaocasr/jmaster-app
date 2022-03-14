package com.example.japaneseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class KatakanaquizActivity extends AppCompatActivity {
    private Button confirmkata_bt;
    private EditText answerkata_txt;
    private TextView questionkata_txt;
    ProgressBar progressBarkata;
int x=0,wrong=0,cicles=0;


    private final String[] kata ={"バ","レ","デ","テ","コ","ギ","ピョ","ニャ",
            "ロ","ミャ","イ","モ","ゾ","ド","カ","ピュ","ズ","ギュ","ジャ",
            "ミョ","ム","キャ","ユ","ワ","フ","ノ","プ","キ","ク","ザ","ミ",
            "ボ","ツ","ペ","エ","オ","メ","ヂ","リュ","ヒャ","セ","チョ","ヘ",
            "パ","ビ","ジョ","シュ","ギャ","ケ","キョ","ソ","ル","ミュ","ン",
            "ビャ","ラ","ニ","ピャ","ギョ","リャ","ホ","ヌ","ア","チャ","ビョ",
            "チ","タ","ナ","マ","キュ","ゴ","ヤ","サ","ヂョ","ショ","ゼ","ニュ",
            "シ","ヲ","リョ","ブ","ハ","グ","ピ","ガ","シャ","ヅ","ポ","ニョ","ヒ",
            "ネ","ヒュ","リ","ス","ウ","ヂャ","ヂュ","ゲ","ビュ","ト","ジュ","ヨ",
            "ベ","チュ","ダ","ジ","ヒョ"};

    private final String[] romaj ={"ba","re","de","te","ko","gi","pyo","nya",
            "ro","mya","i","mo","zo","do","ka","pyu","zu","gyu","jya",
            "myo","mu","kya","yu","wa","fu","no","pu","ki","ku","za","mi",
            "bo","tsu","pe","e","o","me","di","ryu","hya","se","cho","he",
            "pa","bi","jyo","jyu","gya","ke","kyo","so","ru","myu","n",
            "bya","ra","ni","pya","gyo","rya","ho","nu","a","cha","byo",
            "chi","ta","na","ma","kyu","go","ya","sa","dyo","sho","ze","nyu",
            "shi","wo","ryo","bu","ha","gu","pi","ga","sha","du","po","nyo","hi",
            "ne","hyu","ri","su","u","dya","dyu","ge","byu","to","jyu","yo",
            "be","chu","da","ji","hyo"};

    private String changeKata(int x) {
        return romaj[x];
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakanaquiz);

        confirmkata_bt = findViewById(R.id.cofirmkata_text);
        answerkata_txt = findViewById(R.id.answerkata);
        questionkata_txt = findViewById(R.id.questionkata_txt);
        progressBarkata = findViewById(R.id.progressBarkata);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast_layout));
        View wronglayout = inflater.inflate(R.layout.toast_wrong, (ViewGroup)findViewById(R.id.toast_wrong));


        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.TOP,0,150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        final Toast wrongtoast = new Toast(getApplicationContext());
        wrongtoast.setGravity(Gravity.CENTER_VERTICAL | Gravity.TOP,0,150);
        wrongtoast.setDuration(Toast.LENGTH_SHORT);
        wrongtoast.setView(wronglayout);

        final int PROGRESS =(int) Math.ceil(100f/50);

        confirmkata_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(changeKata(x).equals(answerkata_txt.getText().toString())) {
                    toast.show();
                    Random random = new Random();
                    x = random.nextInt(kata.length);
                    questionkata_txt.setText(kata[x]);
                    progressBarkata.incrementProgressBy(PROGRESS);
                    cicles++;
                    if(cicles==50){
                        AlertDialog.Builder alert = new AlertDialog.Builder(KatakanaquizActivity.this);
                        alert.setTitle("Quiz finished");
                        alert.setMessage("Wrong Answers:"+wrong+"\nOverall Correct:"+((50-wrong)/0.5)+"%\nGo to menu to generate a different quiz.");
                        alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        alert.show();
                    }
                }else{
                    wrongtoast.show();
                    wrong++;
                }
            }
        });
    }
}
