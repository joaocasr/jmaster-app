package com.example.japaneseapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class newdicActivity extends AppCompatActivity {

    TextView word1;
    Button bt;


    private final String[] kanjis = {"日\n\nonyomi:ニチ(nichi),ジツ(jitsu)\nkunyomi:ひ(hi)\nMeaning:day,sun",
            "一\n\nonyomi:イチ(ichi)\nkunyomi:ひと(つ)(hitotsu)\nMeaning:one",
            "国\n\nonyomi:コク(koku)\nnkunyomi:くに(kuni)\nMeaning:country",
            "人\n\nonyomi:ジン(jin),ニン(nin)\nkunyomi:ひと(hito)\nMeaning:person",
            "年\n\nonyomi:ネン(nen)\nkunyomi:とし(toshi)\nMeaning:year",
            "大\n\nonyomi:ダイ(dai),タイ(tai)\nkunyomi:おお(きい)(oo(ki))\nMeaning:large,big",
            "十\n\nonyomi:ジュウ(juu)\nkuniyomi:とお(tou),と(to)\nMeaning:ten",
            "二\n\nonyomi:ニ(ni),ジ(ji)\nkuniyomi:ふた(つ)(futatsu),ふたたび(futabi)\nMeaning:two",
            "本\n\nonyomi:ホン(hon)\nkuniyomi:もと(moto)\nMeaning:book",
            "中\n\nonyomi:チュウ(chuu)\nkuniyomi:なか(naka),うち(uchi),あた(る)(ataru)\nMeaning:middle,center",
            "長\n\nonyomi:チョウ(chou)\nkuniyomi:なが(い)(nagai),おさ(osa)\nMeaning:long,leader",
            "出\n\nonyomi:シュツ(shutsu),スイ(sui)\nkuniyomi:で(る)(deru),だ(す)(dasu),い(でる)(ideru)\nMeaning:exit, leave, go out",
            "三\n\nonyomi:サン(san)\nkuniyomi:み(つ)(mitsu)\nMeaning:three","時\n\nonyomi:ジ(ji)\nkuniyomi:とき(toki),-どき(doki)\nMeaning:time,hour",
            "行\n\nonyomi:コウ(kou),ギョウ(gyou),アン(an)\nkuniyomi:い(く)(iku)、 ゆ(く)(yuku)、 おこな(う)(okonau)\nMeaning:going,journey,line,carry out",
            "見\n\nonyomi:ケン(ken)\nkuniyomi:み(る)(miru) み(せる)(miseru)\nMeaning:see,look at,hopes,chances,idea,opinion",
            "月\n\nonyomi:ゲツ(getsu),ガツ(gatsu)\nkuniyomi:つき(tsuki)\nMeaning:month,moon",
            "分\n\nonyomi:ブン(bun),フン(fun),ブ(bu)\nkuniyomi:わ(ける)(wakeru)\nMeaning:part,minute of time,understand",
            "後\n\nonyomi:ゴ(go),コウ(kou)\nkuniyomi:のち(nochi),うし(ushi),あと(ato)\nMeaning:behind,back,after",
            "前\n\nonyomi:ゼン(zen)\nkuniyomi:まえ(mae)\nMeaning:in front,before",
            "生\n\nonyomi:セイ(sei),ショウ(shou)\nkuniyomi:い(きる)(ikiru),う(む)(umu),お(う),(ou)は(える),なま(nama)\nMeaning:life,genuine,birth	",
            "五\n\nonyomi:ゴ(go)\nkuniyomi:いつ(つ)(itsutsu)\nMeaning:five",
            "間\n\nonyomi:カン(kan),ケン(ken)\nkuniyomi:あいだ(aida),ま(ma),あい(ai)\nMeaning:interval,space",
            "上\n\nonyomi:ジョウ(jou),ショウ(shou),シャン(shan)\nkuniyomi:うえ(ue)\nMeaning:Up",
            "東\n\nonyomi:トウ(tou)\nkuniyomi:ひがし(higashi)\nMeaning:East",
            "四\n\nonyomi:シ(shi)\nkuniyomi:よん(yon)\nMeaning:four",
            "今\n\nonyomi:コン(kon),キン(kin)\nkuniyomi:いま(ima)\nMeaning:now,the present",
            "金\n\nonyomi:キン(kin),コン(kon),ゴン(gon)\nkuniyomi:かね(kane),かな-(kana),-がね(gane)\nMeaning:gold",
            "九\n\nonyomi:キュウ(kiyuu),ク(ku)\nkuniyomi:ここの(つ)(kokonotsu)\nMeaning:nine",
            "入\n\nonyomi:ニュウ(nyuu)\nkuniyomi:い(る)(iru),はい(る)(hairu)\nMeaning:enter,insert",
            "学\n\nonyomi:ガク(gaku)\nkuniyomi:まな(ぶ)(manabu)\nMeaning:study,learning,science",
            "高\n\nonyomi:コウ(kou)\nkuniyomi:たか(い)(takai)\nMeaning:tall,high,expensive",
            "円\n\nonyomi:エン(en)\nkuniyomi:まる(い)(marui)\nMeaning:circle,yen,round",
            "子\n\nonyomi:シ(shi),ス(su),ツ(tsu)\nkuniyomi:こ(ko),ね(ne)\nMeaning:child",
            "外\n\nonyomi:ガイ(gai),ゲ(ge)\nkuniyomi:そと(soto),ほか(maka),はず(す)(hazu-),と-(to-)\nMeaning:outside",
            "八\n\nonyomi:ハチ(hachi)\nkuniyomi:や(つ)(yatsu),よう(you)\nMeaning:eight",
            "六\n\nonyomi:ロク(roku)\nkuniyomi:む(つ)(mutsu),むい(mui)\nMeaning:six",
            "下\n\nonyomi:カ(ga),ゲ(ge)\nkuniyomi:くる(kuru),きたる(kitaru),き(ki),こ(ko)\nMeaning:come,due,next,become",
            "来\n\nonyomi:ライ(rai),タイ(tai)\nkuniyomi:とき(toki),-どき(doki)\nMeaning:time,hour",
            "気\n\nonyomi:キ(ki),ケ(ke)\nkuniyomi:いき(iki)\nMeaning:spirit,mind,air,atmosphere,mood",
            "小\n\nonyomi:ショウ(shou)\nkuniyomi:ちい(さい)(chiisai),こ-(ko-),お-(o-),さ-(sa-)\nMeaning:little,small",
            "七\n\nonyomi:シチ(sichi)\nkuniyomi:なな(nana),なの(nano)\nMeaning:seven",
            "山\n\nonyomi:サン(san),セン(sen)\nkuniyomi:やま(yama)\nMeaning:mountain",
            "話\n\nonyomi:ワ(wa)\nkuniyomi:はな(す)(hanasu),はなし(hanashi)\nMeaning:talk,story",
            "女\n\nonyomi:ジョ(jo)\nkuniyomi:おんな(onna)\nMeaning:woman,female",
            "北\n\nonyomi:ホク(hoku)\nkuniyomi:きた(kita)\nMeaning:north",
            "午\n\nonyomi:ゴ(go)\nkuniyomi:うま(uma)\nMeaning:noon,horse",
            "百\n\nonyomi:ヒャク(hyaku),ビャク(byaku)\nkuniyomi:もも(momo)\nMeaning:hundred	",
            "書\n\nonyomi:ショ(sho)\nkuniyomi:か(く)(kaku)\nMeaning:write",
            "先\n\nonyomi:セン(sen)\nkuniyomi:さき(saki),ま(ず)(mazu)\nMeaning:before,ahead,previous",
            "名\n\nonyomi:メイ(mei),ミョウ(myou)\nkuniyomi:な(na)\nMeaning:name",
            "川\n\nonyomi:セン(sen)\nkuniyomi:かわ(kawa)\nMeaning:river,stream",
            "千\n\nonyomi:セン(sen)\nkuniyomi:ち(chi)\nMeaning:thousand",
            "水\n\nonyomi:スイ(sui)\nkuniyomi:みず(mizu)\nMeaning:water",
            "半\n\nonyomi:ハン(han)\nkuniyomi:なか(ば)(nakaba)\nMeaning:half",
            "男\n\nonyomi:ダン(dan),ナン(nan)\nkuniyomi:おとこ(otoko),お(o)\nMeaning:male,man",
            "西\n\nonyomi:セイ(sei),サイ(sai)\nkuniyomi:にし(nishi)\nMeaning:west",
            "電\n\nonyomi:デン(den)\nMeaning:electricity",
            "校\n\nonyomi:サン(san),セン(sen)\nkuniyomi:やま(yama)\nMeaning:mountain",
            "山\n\nonyomi:コウ(kou)\nMeaning:school,exam",
            "語\n\nonyomi:ゴ(go)\nkuniyomi:かた(る)(kataru)\nMeaning:word,speech,language",
            "土\n\nonyomi:ド(do),ト(to)\nkuniyomi:つち(tsuchi)\nMeaning:soil, earth, ground",
            "木\n\nonyomi:ボク(boku),モク(moku)\nkuniyomi:き(ki),こ-(ko-)\nMeaning:tree, wood",
            "聞\n\nonyomi:ブン(bun),モン(mon)\nkuniyomi:き(く)(kiku)\nMeaning:to hear,to listen,to ask",
            "食\n\nonyomi:ショク(shoku),ジキ(jiki)\nkuniyomi:た(べる)(taberu),く(う)(kuu),は(む)(hamu)\nMeaning:eat,food",
            "車\n\nonyomi:シャ(sha)\nkuniyomi:くるま(kuruma)\nMeaning:car,wheel",
            "何\n\nonyomi:カ(ka)\nkuniyomi:なに(nani),なん(nan)\nMeaning:what",
            "南\n\nonyomi:ナン(nan),ナ(na)\nkuniyomi:みなみ(minami)\nMeaning:south",
            "万\n\nonyomi:マン(man),バン(ban)\nMeaning:ten thousand",
            "毎\n\nonyomi:マイ(mai)\nkuniyomi:ごと(に)(goto ni)\nMeaning:every(time)",
            "白\n\nonyomi:ハク(haku),ビャク(byaku)\nkuniyomi:しろ(い)(shiroi)\nMeaning:white",
            "天\n\nonyomi:テン(ten)\nkuniyomi:あまつ(amatsu,mae,ama)\nMeaning:heavens, sky, imperial",
            "母\n\nonyomi:ボ(bo)\nkuniyomi:はは(haha),かあ(kaa)\nMeaning:mother",
            "火\n\nonyomi:カ(ka)\nkuniyomi:ひ(hi),-び(bi),ほ-(ho)\nMeaning:fire",
            "右\n\nonyomi:ウ(u),ユウ(yuu)\nkuniyomi:みぎ(migi)\nMeaning:right",
            "読\n\nonyomi:ドク(doku),トク(toku),トウ(tou)\nkuniyomi:よ(む)(yomu)\nMeaning:read",
            "友\n\nonyomi:ユウ(yuu)\nkuniyomi:とも(tomo)\nMeaning:friend	",
            "左\n\nonyomi:サ(sa),シャ(sha)\nkuniyomi:ひだり(hidari)\nMeaning:left",
            "休\n\nonyomi:キュウ(kyuu)\nkuniyomi:やす(む)(yasumu)\nMeaning:rest, day off",
            "父\n\nonyomi:フ(fu)\nkuniyomi:ちち(chichi),とう(tou)\nMeaning:father",
            "雨\n\nonyomi:ウ(u)\nkuniyomi:あめ(ame),あま(ama)\nMeaning:rain",
            "会\n\nonyomi:カイ(kai)\nkuniyomi:あ(う)(au)\nMeaning:meeting,meet",
            "同\n\nonyomi:ドウ(dou)\nkuniyomi:おな(じ)(onaji)\nMeaning:same,agree,equal",
            "事\n\nonyomi:ジ(ji)\nkuniyomi:こと(koto)\nMeaning:thing,business,matter,fact,reason",
            "自\n\nonyomi:ジ(ji),シ(shi)\nkuniyomi:みずか(ら)(mizukara)\nMeaning:meeting,meet",
            "社\n\nonyomi:シャ(sha)\nkuniyomi:やしろ(yashiro)\nMeaning:company,office,shrine",
            "発\n\nonyomi:ハツ(hatsu),ホツ(hotsu)\nMeaning:departure,discharge,emit,start from",
            "者\n\nonyomi:シャ(sha)\nkuniyomi:もの(mono)\nMeaning:someone,person",
            "地\n\nonyomi:チ(chi),ジ(ji)\nMeaning:ground,earth",
            "業\n\nonyomi:ギョウ(gyou)\nkuniyomi:わざ(waza)\nMeaning:business,vocation,arts,performance",
            "方\n\nonyomi:ホウ(hou)\nkuniyomi:かた(kata)\nMeaning:direction,person,alternative",
            "新\n\nonyomi:シン(shin)\nkuniyomi:あたら(しい)(atarashii),あら(た)(arata)\nMeaning:new",
            "場\n\nonyomi:ジョウ(jou)\nkuniyomi:ば(ba)\nMeaning:location,place",
            "員\n\nonyomi:イン(in)\nMeaning:employee,member,number,the one in charge",
            "立\n\nonyomi:リツ(ritsu)\nkuniyomi:た(つ)(tatsu)\nMeaning:stand up,rise",
            "開\n\nonyomi:カイ(kai)\nkuniyomi:ひら(く)(hiraku),あ(ける)(akeru)\nMeaning:open, unfold, unseal",
            "手\n\nonyomi:シュ(shu)\nkuniyomi:て(te)\nMeaning:hand",
            "力\n\nonyomi:リョク(ryoku),リキ(riki)\nkuniyomi:ちから(chikara)\nMeaning:power,strength,ability,energy",
            "問\n\nonyomi:モン(mon)\nkuniyomi:と(う)(tou)\nMeaning:question,ask,problem",
            "代\n\nonyomi:ダイ(dai)\nkuniyomi:か(わり)(kawari)\nMeaning:substitute,change,convert,replace,period",
            "明\n\nonyomi:メイ(mei),ミョウ(myou)\nkuniyomi:あか(るい)(akarui)\nMeaning:bright,light",
            "動\n\nonyomi:ドウ(dou)\nkuniyomi:うご(く)(ugoku)\nMeaning:move,motion,change",
            "京\n\nonyomi:キョウ(kyou),ケイ(kei),キン(kin)\nkuniyomi:みやこ(miyako)\nMeaning:capital",
            "目\n\nonyomi:モク(moku),ボク(boku)\nkuniyomi:め(me)\nMeaning:eye,class,look,insight,experience",
            "通\n\nonyomi:ツウ(tsuu)\nkuniyomi:とお(る)(tooru),かよ(う)(kayou)\nMeaning:traffic,pass through,avenue,commute",
            "言\n\nonyomi:ゲン(gen),ゴン(gon)\nkuniyomi:い（う）(iu),こと(koto)\nMeaning:say,word",
            "理\n\nonyomi:リ(ri)\nMeaning:logic,arrangement,reason,justice,truth",
            "体\n\nonyomi:タイ(tai)\nkuniyomi:からだ(karada)\nMeaning:body,substance,object,reality",
            "田\n\nonyomi:デン(den)\nkuniyomi:た(ta)\nMeaning:rice field,rice paddy",
            "主\n\nonyomi:シュ(shu)\nkuniyomi:ぬし(nushi),おも(omo)\nMeaning:lord,chief,master,main thing,principal",
            "題\n\nonyomi:ダイ(dai)\nMeaning:topic, subject",
            "意\n\nonyomi:イ(i)\nMeaning:idea,mind,heart,taste,thought",
            "不\n\nonyomi:フ(fu),ブ(bu)\nMeaning:negative,non-,bad",
            "作\n\nonyomi:サク(saku),サ(sa)\nkuniyomi:つく(る)(tsukuru)\nMeaning:make,production,prepare,build",
            "用\n\nonyomi:ヨウ(you)\nkuniyomi:もち(いる)(mochiiru)\nMeaning:use,utilize,business,service,employ",
            "度\n\nonyomi:ド(do),タク(taku)\nkuniyomi:たび(tabi),た(い)(tai)\nMeaning:degrees,occurrence,time,counter for occurrences",
            "強\n\nonyomi:キョウ(kyou),ゴウ(gou)\nkuniyomi:つよ(い)(tsuyoi)\nMeaning:strong",
            "公\n\nonyomi:コウ(kou)\nMeaning:public,prince,official,governmental",
            "持\n\nonyomi:ジ(ji)\nkuniyomi:も(つ)(motsu)\nMeaning:hold,have",
            "野\n\nonyomi:ヤ(ya)\nkuniyomi:の(no)\nMeaning:plains,field,rustic,civilian life",
            "以\n\nonyomi:イ(i)\nkuniyomi:もっ(て)(motte)\nMeaning:by means of,because,in view of,compared with",
            "思\n\nonyomi:シ(shi)\nkuniyomi:おも(う)(omou)\nMeaning:think",
            "家\n\nonyomi:カ(ka)\nkuniyomi:いえ(ie),や(ya),うち(uchi)\nMeaning:house,home,family,professional,expert",
            "世\n\nonyomi:セイ(sei),セ(se)\nkuniyomi:よ(yo)\nMeaning:generation,world,society,public",
            "多\n\nonyomi:タ(ta)\nkuniyomi:おお(い)(ooi)\nMeaning:many,frequent,much",
            "正\n\nonyomi:セイ(sei),ショウ(shou)\nkuniyomi:ただ(しい)(tadashii),まさ(に)(masani)\nMeaning:correct,justice,righteous",
            "安\n\nonyomi:アン(an)\nkuniyomi:やす(い)(yasui)\nMeaning:safe,peaceful,cheap",
            "院\n\nonyomi:イン(in)\nMeaning:institution,temple,mansion,school"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdic);

        word1 = (TextView) findViewById(R.id.word1);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num = random.nextInt(kanjis.length);
                word1.setText(kanjis[num]);
            }
        });
    }
}