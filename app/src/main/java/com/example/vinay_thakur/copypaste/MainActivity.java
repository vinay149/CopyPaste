package com.example.vinay_thakur.copypaste;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback{
    TextView textView;
    TextView textView2;
    ClipboardManager clipboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text1);
        textView.setTextIsSelectable(true);




    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {

        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.copypaste, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {



        switch (menuItem.getItemId())
        {
            case R.id.copy:
                clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                CharSequence ch=textView.getText().subSequence(textView.getSelectionStart(),textView.getSelectionEnd());
                ClipData clipData=ClipData.newPlainText("texthere",ch);
                clipboard.setPrimaryClip(clipData);
                break;
            case R.id.paste:
                clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                String pastedata= (String)item.getText();
                Log.d("vinay123",pastedata);
                break;
        }
        return false;
    }
    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        Log.d("vinay123","hey");


    }


}
