package ru.ingos.digitalmedicine.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.models.ChatMessageModel;
import ru.ingos.digitalmedicine.ui.adapters.ChatMessageAdapter;

public class ChatActivity extends MvpAppCompatActivity {

    @BindView(R.id.activity_chat_recycler_view) RecyclerView rvChat;
    @BindView(R.id.activity_chat_btn_send) Button btnSendMessage;
    @BindView(R.id.activity_chat_edit_text_message) EditText etTextMessage;

    private ChatMessageAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.chat_with_doctor);
        }



        rvChat.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessageModel>());
        rvChat.setAdapter(mAdapter);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = etTextMessage.getText().toString();
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                sendMessage(message);
                etTextMessage.setText("");
            }
        });
    }

    private void sendMessage(String message) {
        ChatMessageModel chatMessage = new ChatMessageModel(message, true, false);
        mAdapter.add(chatMessage);

        mimicOtherMessage(message);
    }

    private void mimicOtherMessage(String message) {
        ChatMessageModel chatMessage = new ChatMessageModel(message, false, false);
        mAdapter.add(chatMessage);

        rvChat.scrollToPosition(mAdapter.getItemCount() - 1);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
