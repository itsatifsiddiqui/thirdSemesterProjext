package extras;

public class Regex {

    public final static String NAME = "^[a-zA-Z]+(\\s[a-zA-Z]+)?$";
    public final static String PHONE = "^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$";
    public final static String CNIC = "^[0-9+]{5}[0-9+]{7}[0-9]{1}$";
    public final static String DOUBLE = "^[+]?[0-9]*\\.?[0-9]+$";
    public final static String INTEGER = "^[0-9]+";
}