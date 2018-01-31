package com.belatrix.kotlintemplate;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.belatrix.kotlintemplate.fragments.ContactDetailFragment;
import com.belatrix.kotlintemplate.fragments.ContactsFragment;
import com.belatrix.kotlintemplate.listeners.OnContactListener;
import com.belatrix.kotlintemplate.model.ContactEntity;


public class ContactsActivity extends AppCompatActivity implements OnContactListener {

    private static final String TAG = "Contacts";

    private ContactsFragment contactsFragment;
    private ContactDetailFragment contactDetailFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        app();
    }

    private void app() {
        fragmentManager= getSupportFragmentManager();
        contactsFragment= (ContactsFragment)fragmentManager.findFragmentById(R.id.fragContacts);
        contactDetailFragment= (ContactDetailFragment) fragmentManager.findFragmentById(R.id.fragContactDetail);

    }


    @Override
    public void onSendMessage(String msg) {

    }

    @Override
    public void selectedItemContact(ContactEntity contactEntity) {
        contactDetailFragment.renderContact(contactEntity);
    }

    @Override
    public void renderFirst(ContactEntity contactEntity) {
        selectedItemContact(contactEntity);
    }
}
