package com.ooteedemo.contactmanager.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ooteedemo.contactmanager.R;
import com.ooteedemo.contactmanager.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Contact contact = contactList.get(position);
        viewHolder.contactName.setText(contact.getName());
        viewHolder.phoneNumber.setText(contact.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView contactName;
        public TextView phoneNumber;
        public ImageView iconButton;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

//            itemView.setOnClickListener(this);

            contactName = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phone_number);
            iconButton = itemView.findViewById(R.id.icon_button);
            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Contact contact = contactList.get(position);

            switch (v.getId()) {
                case R.id.icon_button:
                    Log.d("OnClick", "onClick: "+contact.getPhoneNumber());
                    break;
                default:
                    Log.d("OnClick", "onClick: "+contact.getName());
                    break;
            }
        }
    }
}
