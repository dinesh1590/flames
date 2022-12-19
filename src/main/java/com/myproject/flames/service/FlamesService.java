package com.myproject.flames.service;

import com.myproject.flames.dto.FlamesModel;
import com.myproject.flames.dto.Response;
import org.springframework.stereotype.Service;

@Service
public class FlamesService {

    public Response flames(FlamesModel flamesModel) {

        Response r=new Response();

        String res = "";
        if (flamesModel != null) {

            res = getFlames(flamesNum(flamesModel.getBoy(), flamesModel.getGirl()) ,"flames");
        }


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

        r.setFlames(res);

        return r;
    }

    public int flamesNum(String a, String b) {
        String[] boy = a.split("");
        String[] girl = b.split("");

        if(a.length()==0 || b.length()==0) {
            return -1;
        }

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


        return fin.length();
    }

    public  String getFlames(int num,String ans) {

        if(num==0){
            return "f";
        }

        if(num==-1) {
            return "0";
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
