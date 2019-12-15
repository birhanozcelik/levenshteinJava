package com.example.levenshtein;

import java.util.ArrayList;
import java.util.TreeMap;

public class SearchWorks {


   private  TreeMap<Double,String> userMap;
   private  String[] parcalanmisKelimeler;
   private  double ratio;
   private  int stringDistance;
   String sonKelime;
    final String[] markalar = {
            "ülker","nestle","eti","çokokrem","tadelle","nutella","pınar",
            "danone","içim","birşah","torku","aytaç","knor","marmarabirlik",
            "biryağ","çerezya","erişte","cheetos","doritos","lays","ruffles",
            "altınbaşak","lifalif","coca","cola","kola","pepsi","fanta","fruko",
            "yedigün","çamlıca","sprite","schweppes","powerade","lipton",
            "nescafe","dimes","cappy","doğuş","uludağ","doğanay","çaykur",
            "karadem","doğadan","deren","sırma","saka","beypazarı","kızılay",
            "fairy","finish","pril","perwoll","bingo","persil","dalin","vanish",
            "yumoş","vernel","dove","orkid","molped","kotex","komili","gillete",
            "clear","nivea","colgate","ipana","sensodyne","palmolive","elidor",
            "pantene","head","çikolata","süt","peynir","zeytin","gofret","piliç","yoğurt","reçel","pastörize","kaşar","tereyağ",
            "baharat","salça","turşu","şeker","ayçiçek","riviera","fiyonk","spagetti","şehriye","glutensiz",
            "pirinç","fasulye","mercimek","börülce","domates","biber","karışık","çorba","bisküvi","cips",
            "leblebi","fındık","fıstık","çay","kahve","şeftali","vişne","elma","kayısı","şalgam","acı","şerbet",
            "bulaşık","sünger","çamaşır","yumuşatıcı","sıvısabun","ped","bıçak","prezervatif","tıraş","diş",
            "fırça","fırçası","şampuan","saç","makarna","and","shoulders","çikolatalı"
    };

    public  String editSearchText(String kelime){
        sonKelime = "";
        userMap = new TreeMap<>();

        String girilenDeger = kelime;
        System.out.println("BBBBBBBBS"+girilenDeger);
        girilenDeger = girilenDeger.toLowerCase();
        girilenDeger = tekBoslugaCevir(girilenDeger); //tek bosluga dusurmek icin gonderdik
        System.out.println("TEK BOSLUK"+girilenDeger);
        parcalanmisKelimeler = girilenDeger.split(" ");
        System.out.println("SPLITLI"+parcalanmisKelimeler.toString());

        for(int j = 0 ; j<parcalanmisKelimeler.length; j++){
            System.out.println("MERHABAAAAA "+parcalanmisKelimeler[j]);
            for(int i = 0; i<markalar.length;i++){
                stringDistance = distance(markalar[i],parcalanmisKelimeler[j]);
                ratio = 1-((double) stringDistance) / (Math.max(parcalanmisKelimeler[j].length(), markalar[i].length()));
                if(ratio>=0.66){
                    userMap.put(ratio,markalar[i]);
                }
                else{
                    userMap.put(ratio,markalar[i]);
                }
            }
            System.out.println("Tum mapp: "+userMap);
            Double anahtar = userMap.lastKey(); // tree de ki en büyük elemanı bulur
            if( anahtar<0.66){
                parcalanmisKelimeler[j] = parcalanmisKelimeler[j];
            }
            else{
                System.out.println("ANAHTARRRR: "+anahtar);
                String son = userMap.get(anahtar); // en büyük orana sahip ürünü getirir
                parcalanmisKelimeler[j] = son;
                userMap.clear();
            }
        }

        for(int i = 0 ; i<parcalanmisKelimeler.length;i++){
            if(i%2 == 0){
                sonKelime += parcalanmisKelimeler[i];
            }else{
                sonKelime += " ";
                sonKelime += parcalanmisKelimeler[i];
                sonKelime += " ";
            }
        }
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA"+sonKelime);
        return sonKelime;

    }
    public  int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }// iki string arasında ki mesafeyi hesaplar
    public  String tekBoslugaCevir(String deger1){
        String[] degerler;
        String son = "";
        ArrayList<String> arr = new ArrayList();
        degerler = deger1.split(" ");
        for (String a : degerler) {
            a = a.replaceAll(" ", "");
            if(a.equals("")){
                continue;
            }
            else{
                arr.add(a);
            }
        }
        for (String s : arr) {
            son += " "+s;
        }
        return son;
    } //kelimeyi tek bosluga cevir
}
