package com.alatheer.anwaralfyaha.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.alatheer.anwaralfyaha.Adapters.ViewPagerAdapter;
import com.alatheer.anwaralfyaha.Fragments.CallsFragment;
import com.alatheer.anwaralfyaha.Fragments.ChatFragment;
import com.alatheer.anwaralfyaha.Fragments.ContactsFragment;
import com.alatheer.anwaralfyaha.R;

public class Anshta extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;


    //Fragments

    ChatFragment chatFragment;
    CallsFragment callsFragment;
    ContactsFragment contactsFragment;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anshta);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_call:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_chat:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_contact:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        callsFragment=new CallsFragment();
        chatFragment=new ChatFragment();
        contactsFragment=new ContactsFragment();
        adapter.addFragment(callsFragment);
        adapter.addFragment(chatFragment);
        adapter.addFragment(contactsFragment);
        viewPager.setAdapter(adapter);
    }
}

  /*  ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anshta);

        MixedArray a = Pherialize.unserialize("a:2:{i:0;s:36:\"914cc8df6869c78731fbf47f3ff95c68.jpg\";i:1;s:36:\"1650ebae7f1b701df152240e70a4d161.jpg\";}").toArray();
        Toast.makeText(Anshta.this,a.getString(0)+"\n"+a.getString(1), Toast.LENGTH_SHORT).show();

        img1= (ImageView) findViewById(R.id.img1);
        img2= (ImageView) findViewById(R.id.img2);

        Picasso.with(this).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(0)).into(img1);
        Picasso.with(this).load("http://wefakhail.org/fihaa/uploads/thumbs/" +a.getString(1)).into(img2);

    }
*/
  

