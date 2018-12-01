package helper;
public class ContactDBTable {

    public static String TABLE_NAME = "CONTACTS";

    public static String CONTACT_ID = "ID";
    public static String CONTACT_NAME = "NAME";
    public static String CONTACT_PHONE = "PHONE";

    public static String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CONTACT_NAME + " TEXT, "
            + CONTACT_PHONE + " TEXT);";

    public static String DELETE_CONTACTS_DATA = "DROP TABLE " + TABLE_NAME + ";";
}

