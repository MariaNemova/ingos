package ru.ingos.digitalmedicine.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import me.himanshusoni.chatmessageview.ChatMessageView;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.ChatMessageModel;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.MessageHolder>{


    private static final int MY_MESSAGE = 0, OTHER_MESSAGE = 1;

    private List<ChatMessageModel> mMessages;
    private Context mContext;

    public ChatMessageAdapter(Context context, List<ChatMessageModel> data) {
        mContext = context;
        mMessages = data;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessageModel item = mMessages.get(position);

        if (item.isMine()) return MY_MESSAGE;
        else return OTHER_MESSAGE;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == MY_MESSAGE) {
            return new MessageHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mine_message, parent, false));
        } else {
            return new MessageHolder(LayoutInflater.from(mContext).inflate(R.layout.item_other_message, parent, false));
        }
    }

    public void add(ChatMessageModel message) {
        mMessages.add(message);
        notifyItemInserted(mMessages.size() - 1);
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        ChatMessageModel chatMessage = mMessages.get(position);
        if (chatMessage.isImage()) {
            holder.tvMessage.setVisibility(View.GONE);

        } else {
            holder.tvMessage.setVisibility(View.VISIBLE);

            holder.tvMessage.setText(chatMessage.getContent());
        }

        String date = new SimpleDateFormat("hh:mm aa", Locale.getDefault()).format(new Date());
        holder.tvTime.setText(date);

        holder.chatMessageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return mMessages == null ? 0 : mMessages.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {

        TextView tvMessage, tvTime;
        ChatMessageView chatMessageView;

        public MessageHolder(View itemView) {
            super(itemView);

            chatMessageView = (ChatMessageView) itemView.findViewById(R.id.chatMessageView);
            tvMessage = (TextView) itemView.findViewById(R.id.item_message_text_view_text);
            tvTime = (TextView) itemView.findViewById(R.id.item_message_text_view_time);
        }
    }
}
