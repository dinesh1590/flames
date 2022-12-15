package com.myproject.flames.service;

import com.myproject.flames.dto.FlamesModel;
import org.springframework.stereotype.Service;

@Service
public class FlamesService {

    public String flames(FlamesModel flamesModel) {

        String res = "";
        if (flamesModel != null) {

            res = getFlames(flamesNum(flamesModel.getBoy(), flamesModel.getGirl()) ,"flames");
        }

        System.out.println(res);

        switch (res.toLowerCase()) {

            case "f":
                res="Friend";
                break;
            case "l":
                res="Lover";
                break;
            case "a":
                res="Affection";
                break;
            case "m":
                res="Marriage";
                break;
            case "e":
                res="Enemy";
                break;
            case "s":
                res="Sister";
                break;
            default:res="Human Being";
        }
        System.out.println(res);
        return res;
    }

    public int flamesNum(String a, String b) {
        String[] boy = a.split("");
        String[] girl = b.split("");

        for (int i = 0; i < boy.length; i++) {
            for (int j = 0; j < girl.length; j++) {

                if (boy[i].equals(girl[j])) {
                    boy[i] = "0";
                    girl[j] = "0";
                    break;
                }
            }
        }

        String fin = "";

        for (int i = 0; i < boy.length; i++) {
            if (boy[i] != "0")
                fin = fin + boy[i];
        }
        for (int i = 0; i < girl.length; i++) {
            if (girl[i] != "0")
                fin = fin + girl[i];
        }

        System.out.println(fin);

        return fin.length();
    }

    public  String getFlames(int num,String ans) {

        System.out.println(num);
        if(num==0){
            return "f";
        }

        int jj=0;
        if(num>ans.length())
            jj = out(num,ans.length());
        else
            jj=num;

        String[] hh = ans.split("");
        String kk = "";

        for (int i = jj; i < ans.length(); i++) {
            kk = kk + hh[i];
        }

        for (int i = 0; i < jj - 1; i++) {
            kk = kk + hh[i];
        }

        ans = kk;


        if (kk.length() == 1) {
            return kk;
        }
        return getFlames(num,kk);
    }


    public  int out(int n, int s) {
        n = n - s;
        if (n > s)
            return out(n, s);
        else
            return n;
    }


}
