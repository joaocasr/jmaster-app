package com.jmaster.japaneseapp;

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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private Button confirm_bt;
    private EditText answer_txt;
    private TextView question_txt;
    ProgressBar progressBar;
    int erros =0,num=0,ciclos = 0;


    private String changeString(int x) {
        return romaji[x];
    }
    private final String[] romaji={"nyu","shu","ko","tsu","he","gi","ka","yu","do",
            "dyo","ryu","pyo","byu","ba","sha","ru","hyu",
            "ha","nya","ga","mya","me","re","no","nu",
            "myu","cha", "ge","bya","bo","rya","pyu","pa",
            "ya","fu","sa","i","jya","te","de","ne",
            "ro","kya","yo","byo","gya","ku","ra","kyu",
            "gyu","go","se","ya","hya","hi","bi","ji",
            "nyo","kyo","o","ryo","ri","hyo","pu","ni",
            "ke","ta","za","so","jyu","wa","e","be",
            "po","sho","a","to","su","mi","da","zo",
            "jyo","bu","ma","pi","shi","dya","dyu","gu",
            "myo","chi","zu","ho","u", "gyo","n","ki",
            "ze","cho","pe","mu","di","na","chu",
            "wo","du","mo"};

    private final String[] kana={"にゅ","しゅ","こ","つ","へ","ぎ","か","ゆ","ど",
            "ぢょ","りゅ","ぴょ","びゅ","ば","しゃ","る","ひゅ",
            "は","にゃ","が","みゃ","め","れ","の","ぬ",
            "みゅ","ちゃ", "げ","びゃ","ぼ","りゃ","ぴゅ","ぱ",
            "や","ふ","さ","い","じゃ","て","で","ね",
            "ろ","きゃ","よ","びょ","ぎゃ","く","ら","きゅ",
            "ぎゅ","ご","せ","ゃ","ひゃ","ひ","び","じ",
            "にょ","きょ","お","りょ","り","ひょ","ぷ","に",
            "け","た","ざ","そ","じゅ","わ","え","べ",
            "ぽ","しょ","あ","と","す","み","だ","ぞ",
            "じょ","ぶ","ま","ぴ","し","ぢゃ","ぢゅ","ぐ",
            "みょ","ち","ず","ほ","う", "ぎょ","ん","き",
            "ぜ","ちょ","ぺ","む","ぢ","な","ちゅ",
            "を","づ","も"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        confirm_bt = findViewById(R.id.cofirm_text);
        answer_txt = findViewById(R.id.answer);
        question_txt = findViewById(R.id.question_txt);
        progressBar = findViewById(R.id.progressBar);

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

        final int USER_PROGRESS =(int) Math.ceil(100f/25);

        confirm_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(changeString(num).equals(answer_txt.getText().toString())) {
                    toast.show();
                    Random random = new Random();
                    num = random.nextInt(kana.length);
                    question_txt.setText(kana[num]);
                    progressBar.incrementProgressBy(USER_PROGRESS);
                    ciclos++;
                    if(ciclos==25){
                        AlertDialog.Builder alert = new AlertDialog.Builder(QuizActivity.this);
                        alert.setTitle("Quiz finished");
                        alert.setMessage("Overall Correct:"+((50-erros)/0.5)+"\nWrong Answers:"+erros+"%\nGo to menu to generate a different quiz.");
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
                    Random random = new Random();
                    num = random.nextInt(kana.length);
                    question_txt.setText(kana[num]);
                    erros++;
                }
                answer_txt.getText().clear();
            }
        });
    }
}
