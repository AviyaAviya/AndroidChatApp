package com.example.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.activity.R;
import com.example.chat.entitys.Message;

import java.util.List;

public class MessagesListAdapter extends RecyclerView.Adapter<MessagesListAdapter.MessageViewHolder> {
    private ContactsListAdapter.ListenerOnClick listenerOnClick;

    class MessageViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvMessage;


        private MessageViewHolder(View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.message_text);
        }


    }

    private final LayoutInflater mInflater;

    private List<Message> messages;


    public MessagesListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MessagesListAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.message_layout, parent, false);
        return new MessagesListAdapter.MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessagesListAdapter.MessageViewHolder holder, int position) {
        if (messages != null) {
            final Message current = messages.get(position);
//            holder.tvMessage.setText(current.getContent());
        }
    }

    public void setMessages(List<Message> s) {
        messages = s;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (messages != null)
            return messages.size();
        else
            return 0;
    }

    public List<Message> getMessages() {
        return messages;
    }


}
