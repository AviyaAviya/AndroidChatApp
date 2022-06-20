package com.example.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.activity.R;
import com.example.chat.entitys.Contact;

import java.util.List;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactViewHolder> {
    private ListenerOnClick listenerOnClick;

    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView nickname_of_contact;


        ListenerOnClick listenerOnClick;


        private ContactViewHolder(View itemView, ListenerOnClick listenerOnClick) {
            super(itemView);
            nickname_of_contact = itemView.findViewById(R.id.nickname_of_contact);

            this.listenerOnClick = listenerOnClick;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listenerOnClick.onItemClick(v, getAdapterPosition());
        }
    }

    private final LayoutInflater mInflater;
    private List<Contact> contacts;

    public ContactsListAdapter(Context context, ListenerOnClick listenerOnClick) {
        mInflater = LayoutInflater.from(context);
        this.listenerOnClick = listenerOnClick;

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.contact_layout, parent, false);
        return new ContactViewHolder(itemView, listenerOnClick);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        if (contacts != null) {
            final Contact current = contacts.get(position);
            holder.nickname_of_contact.setText(current.getNickName());


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

    public List<Contact> getContacts() {
        return contacts;
    }

    public interface ListenerOnClick {
        void onItemClick(View v, int position);
    }
}
