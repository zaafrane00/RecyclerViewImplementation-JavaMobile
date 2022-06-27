package com.example.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
    private SQLiteDatabase db;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE contacts(id" +
                " INTEGER PRIMARY KEY AUTOINCREMENT,nom TEXT,telephone TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS contacts ");
      // Create tables again
        onCreate(db);
    }
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    // Adding new contact
    void addContact(Contact contact) {
        if(contact!=null){
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nom", contact.nom==null?"": contact.nom); // Contact Name
            values.put("telephone", contact.telephone==null?"": contact.telephone);
            values.put("img", contact.img==null?null: contact.img);
            db.insert("contacts", null, values);
            db.close(); // Closing database connection
        }
    }

    // Getting single contact
    Contact getContact(Integer id) {
        if(id!=null){
            db = this.getReadableDatabase();
            Cursor cursor = db.query("contacts", new String[] {"id",
                            "nom", "telephone" }, "id=?" ,
                    new String[] { String.valueOf(id) }, null, null,
                    null, null);
            if (cursor != null)
                cursor.moveToFirst();
            Contact contact = new Contact(Integer.parseInt(cursor.getString(0)
            ), cursor.getString(1), cursor.getString(2));
            // return contact
            return contact;
        }
        return null;
    }

    // Getting All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM contacts ";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNom(cursor.getString(1));
                contact.setTelephone(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
        // return contact list
    }

    public void deleteContact(Integer id){
        if(id!=null){
            db=this.getWritableDatabase();
            String tabArgs[]={String.valueOf(id)};
            db.delete("contact","id=?",tabArgs);
            db.close();
        }
    }

    public void updateContact(Contact contact){
        if(contact!=null){
            db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("nom", contact.nom==null?null: contact.nom);
            values.put("telephone", contact.telephone==null?null: contact.telephone);
            values.put("img", contact.img==null?null: contact.img);
            String tabArgs[]={String.valueOf(contact.id)};
            db.delete("contact","id=?",tabArgs);
            db.close();
        }
    }
}

