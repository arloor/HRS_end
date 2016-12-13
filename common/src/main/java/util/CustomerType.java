package util;

/**
 * Created by njulgh on 16-12-5.
 */
public enum CustomerType {
    PERSONAL,COMPANY;

    public String toString(){
        switch (this){
            case PERSONAL:return "personal";
            case COMPANY:return  "company";
            default:return null;
        }
    }
}
