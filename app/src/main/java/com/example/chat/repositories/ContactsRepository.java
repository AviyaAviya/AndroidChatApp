//package com.example.chat.repositories;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.room.Room;
//
//import com.example.chat.activity.MyApplication;
//import com.example.chat.api.ContactsAPI;
//import com.example.chat.entitys.Contact;
//import com.example.chat.room.AppDB;
//import com.example.chat.room.ContactDao;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class ContactsRepository {
//    private ContactDao dao;
//    private ContactListData contactListData;
//    private ContactsAPI api;
//    SharedPreferences sharedPreferences;
//
//
//    public ContactsRepository() {
//        AppDB db = Room.databaseBuilder(MyApplication.context, AppDB.class, "ContactsDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();
//
//        dao = db.contactDao();
//        contactListData = new ContactListData();
//        api = new ContactsAPI(contactListData, dao);
//    }
//
//    public class ContactListData extends MutableLiveData<List<Contact>> {
//        public ContactListData() {
//            super();
//
//            List<Contact> contacts = new LinkedList<>();
//
//            contacts = dao.index();
//            setValue(contacts);
//
//
//        }
//
//        @Override
//        protected void onActive() {
//            SharedPreferences prefs;
//            SharedPreferences.Editor edit;
//            prefs = MyApplication.context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
//            String token = prefs.getString("token", "");
//      new Thread(()->{
//          contactListData.postValue(dao.index());
////          try{Thread.sleep(10000);}
////          catch (InterruptedException e){
////              e.printStackTrace();
////          }
//         // ContactsAPI api = new ContactsAPI();
//          api.getContacts(token,this);
//      }).start();
//        }
//        }
//
//        public LiveData<List<Contact>> getAll() {
//            return contactListData;
//        }
//    public void add(final  Contact contact){
//        SharedPreferences prefs;
//        SharedPreferences.Editor edit;
//        prefs = MyApplication.context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
//        String token = prefs.getString("token", "");
//        api.CreateContact(token,contact);}
//    //public void delete(final Contact contact ){api.delete(contact);}
//    //public  void reload(){api.get();}
//    }
//
