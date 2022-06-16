package com.example.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.activity.R;
import com.example.chat.entitys.Contact;

import java.util.List;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactViewHolder> {
    private ListenerOnClick listenerOnClick;

    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView name_of_contact;
        private final ImageView imageOfContact;


        private ContactViewHolder(View itemView) {
            super(itemView);
            name_of_contact = itemView.findViewById(R.id.name_of_contact);
            imageOfContact = itemView.findViewById(R.id.imageOfContact);
        }

        @Override
        public void onClick(View v) {
            if (listenerOnClick != null)
                listenerOnClick.onItemClick(v, getAdapterPosition());
        }
    }

    private final LayoutInflater mInflater;
    private List<Contact> contacts;

    public ContactsListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.contact_layout, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        if (contacts != null) {
            final Contact current = contacts.get(position);
//            holder.name_of_contact.setText(current.getContent());
//            holder.imageOfContact.setImageResource(current.getPic());
        }
    }

    public void setContacts(List<Contact> s) {
        contacts = s;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (contacts != null)
            return contacts.size();
        else
            return 0;
    }

//    public List<Contact> getContacts() {
//        return contacts;
//    }

    public interface ListenerOnClick {
        void onItemClick(View v, int position);
    }
}
