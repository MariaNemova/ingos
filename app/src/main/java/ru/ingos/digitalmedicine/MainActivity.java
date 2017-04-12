package ru.ingos.digitalmedicine;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import ru.ingos.digitalmedicine.menu.*;

/**
 * Экран является точкой входа в приложение, содержит меню. Все экраны, которые могут быть вызваны из меню,
 * представляют собой фрагменты, которые заплняют FrameLayout на этом экране. Каждый фрагмент представляет собой
 * обособленную сущность и имеет свой собтвенный жизненый цикл.
 * Такой подход выбран из-за того, что меню должно присутствовать на всех экранах. Избегаем дубликатов кода, используем
 * DRY концепцию.
 *
 * TODO: реализовать на этом экране проверку входа. Если пользователь не авторизован, то выбрасывать его на экран входа
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Теги для фргментов, чтобы определять, храняться ли они в FragmentManager и не создавать дополнительных сущностей.
    private static String TAG_MAIN = "MAIN_FRAGMENT";
    private static String TAG_HISTORY = "HOSTORY_FRAGMENT";
    private static String TAG_CLINICS = "CLINICS_FRAGMENT";
    private static String TAG_SETTINGS = "SETTINGS_FRAGMENT";
    private static String TAG_REGISTRY = "REGISTRY_FRAGMENT";
    private static String TAG_PRIVATE_ROOM = "ROOM_FRAGMENT";

    //НЕ ЗАБЫВАТЬ! Освобождать все ссылки при остановке активности! Необходимо для сборки мусора.
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();

        //Cразу после запуска, показываю главный фргмент, делая его активным
        //TODO: Добавить проверку авторизации
        this.fragmentManager = getFragmentManager();
        this.bindFragment(TAG_MAIN, FragmentMain.class);
    }

    private void bindFragment(String fragmentTag, Class<? extends FragmentBase> fragmentClass){
        Fragment frag = this.fragmentManager.findFragmentByTag(fragmentTag);

        if(frag == null){
            try {
                this.fragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentClass.newInstance(), fragmentTag).commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_clinics) {
            this.bindFragment(TAG_CLINICS, FragmentList.class);
        } else if (id == R.id.nav_main) {
            this.bindFragment(TAG_MAIN, FragmentMain.class);
        } else if (id == R.id.nav_history) {
            this.bindFragment(TAG_HISTORY, FragmentHistory.class);
        } else if (id == R.id.nav_registry) {
            this.bindFragment(TAG_REGISTRY, FragmentRegistry.class);
        } else if (id == R.id.nav_settings) {
            this.bindFragment(TAG_SETTINGS, FragmentSettings.class);
        } /*else if (id == R.id.nav_view){
            this.bindFragment(TAG_PRIVATE_ROOM, FragmentPrivateRoom.class);
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop(){
        super.onStop();
        this.fragmentManager = null;
    }

}
