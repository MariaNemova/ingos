package ru.ingos.digitalmedicine.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {

    private byte[] hash;

    public Sha256(String data){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        try {
            if(md != null)md.update(data.getBytes("UTF-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        if(md!=null)this.hash = md.digest();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Sha256){
            Sha256 oth = (Sha256) other;
            if(this.hash.length == oth.hash.length){
                for (int i = 0; i<oth.hash.length; i++){
                    if(this.hash[i] != oth.hash[i]) return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean equals(byte[] otherHash){
        if(hash != null){
            if(this.hash.length == otherHash.length){
                for(int i = 0; i<this.hash.length; i++){
                    if(this.hash[i]!= otherHash[i]) return false;
                }
                return true;
            }
        }
        return false;
    }

}
